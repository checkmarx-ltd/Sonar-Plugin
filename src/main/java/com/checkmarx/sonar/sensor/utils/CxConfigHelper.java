package com.checkmarx.sonar.sensor.utils;

import com.checkmarx.sonar.cxrules.CxSonarConstants;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.dto.CxSensorSettings;
import com.checkmarx.sonar.dto.RestEndpointContext;
import com.checkmarx.sonar.sensor.dto.ProjectDetails;
import com.checkmarx.sonar.sensor.encryption.AesUtil;
import com.checkmarx.sonar.sensor.encryption.SecretKeyStore;
import com.checkmarx.sonar.sensor.version.PluginVersionProvider;
import com.checkmarx.sonar.settings.CredentialMigration;
import com.checkmarx.sonar.settings.CxProperties;
import com.checkmarx.sonar.settings.PropertyApiClient;
import com.checkmarx.sonar.web.HttpHelper;
import com.checkmarx.sonar.web.ProxyParams;
import com.cx.restclient.CxShragaClient;
import com.cx.restclient.configuration.CxScanConfig;
import com.cx.restclient.exception.CxClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.config.Configuration;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.checkmarx.sonar.web.HttpHelper.SONAR_URL_PARAM;

public class CxConfigHelper {

    public static final String SONAR_HOST_URL = "sonar.host.url";
    public static final String SONAR_PROJECT_KEY = "sonar.projectKey";
    public static final String SONAR_LOGIN_KEY = "sonar.login";
    public static final String SONAR_PASSWORD_KEY = "sonar.password";

    private static final String VALUE = "value";

    private static final String ENCODING = StandardCharsets.UTF_8.name();

    public static final String SETTINGS_API_PATH = "api/settings";
    public static final String SETTINGS_API_SET_PATH = SETTINGS_API_PATH + "/set";
    public static final String SETTINGS_API_GET_PATH = SETTINGS_API_PATH + "/values";
    public static final String SETTINGS_API_RESET_PATH = SETTINGS_API_PATH + "/reset";

    private Logger log;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private PluginVersionProvider versionProvider = new PluginVersionProvider();

    public CxConfigHelper(Logger log) {
        this.log = log;
    }

    public CxFullCredentials getCxFullCredentials(SensorContext context) {
        try {
            PropertyApiClient client = new PropertyApiClient(context, log);

            CredentialMigration migration = new CredentialMigration(client, log);
            migration.ensureLatestFormat();

            CxFullCredentials credentials = null;
            String credentialsJson = client.getProperty(CxProperties.CREDENTIALS_KEY);

            if (StringUtils.isNotEmpty(credentialsJson)) {
                credentials = objectMapper.readValue(credentialsJson, CxFullCredentials.class);
                String plaintextPassword = decrypt(credentials.getCxPassword());
                credentials.setCxPassword(plaintextPassword);
            } else {
                logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while retrieving Checkmarx settings from Sonar database.\n" +
                        "Please make sure Checkmarx credentials are configured. Can be configured by admin at: " +
                        "Project Page > Administration > Checkmarx\n", context);
            }

            return credentials;
        } catch (IOException e) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while getting credentials: " + e.getMessage(), context);
            return null;
        }
    }

    public CxFullCredentials getCredentialsWithoutPassword(RestEndpointContext context) throws IOException {
        PropertyApiClient client = new PropertyApiClient(context, log);
        CredentialMigration migration = new CredentialMigration(client, log);
        migration.ensureLatestFormat();

        CxFullCredentials result = getStoredCredentials(client);
        result.setCxPassword(null);

        return result;
    }

    private CxFullCredentials getStoredCredentials(PropertyApiClient client) throws IOException {
        CxFullCredentials result;
        String credentialsJson = client.getProperty(CxProperties.CREDENTIALS_KEY);
        log.info("Stored credentials json returned.");
        if (StringUtils.isNotEmpty(credentialsJson)) {
            result = objectMapper.readValue(credentialsJson, CxFullCredentials.class);
        } else {
            result = new CxFullCredentials();
        }
        log.info("Stored credentials username: " + result.getCxUsername() + ", encrypted password: " + result.getCxPassword());
        return result;
    }

    public String getSonarProperty(SensorContext context, String propertyName) {
        log.info("Resolving Cx setting: {}", propertyName);

        Configuration config = context.config();
        String propertyValue = getSonarPropertyHttp(propertyName, config);

        if (propertyValue == null) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while retrieving Checkmarx settings from sonar Database.\n" + "" +
                    "Please make sure Checkmarx credentials are configured.", context);
            return null;
        }
        if (StringUtils.isEmpty(propertyValue)) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Checkmarx settings were not configured.\n Can be configured by admin at: " +
                    "Project Page > Administration > Checkmarx\n", context);
            return null;
        }

        propertyValue = getPropertyValue(propertyValue);
        return propertyValue;
    }

    public CxScanConfig getScanConfig(CxFullCredentials cxFullCredentials, SensorContext context) {
        CxScanConfig scanConfig = new CxScanConfig();
        scanConfig.setCxOrigin(CxSonarConstants.CX_SONAR_ORIGIN);
        scanConfig.setSastEnabled(true);
        scanConfig.setOsaEnabled(false);
        scanConfig.setSynchronous(true);
        scanConfig.setDisableCertificateValidation(true);
        scanConfig.setUrl(cxFullCredentials.getCxServerUrl());
        scanConfig.setUsername(cxFullCredentials.getCxUsername());
        scanConfig.setPassword(cxFullCredentials.getCxPassword());
        scanConfig.setPresetId(1);
        String cxProject = getSonarProperty(context, CxProperties.CXPROJECT_KEY);
        try {
            ProjectDetails projectDetails = getProjectAndTeamDetails(cxProject, cxFullCredentials);
            scanConfig.setProjectName(projectDetails.getProjectName());
            scanConfig.setTeamId(projectDetails.getTeamId());
            scanConfig.setTeamPath(projectDetails.getTeamName());
        } catch (IOException e) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while retrieving team ID for project:" + cxProject, context);
            return scanConfig;
        }
        return scanConfig;
    }

    private String getPropertyValue(String responseJson) {
    	
    	CxSensorSettings settings = null;
    	try {
            if (StringUtils.isNotEmpty(responseJson)) {
            	settings = objectMapper.readValue(responseJson, CxSensorSettings.class);
            	return settings.getFirstSettingValue();
            }    		
    	}catch(Exception tryNextLogic) {
    		   log.debug("Fail to retrieve property value using Json");
    	}    	
    	
        String value = null;
        try {
            int valueIdx = responseJson.indexOf(VALUE);
            if (valueIdx >= 0) {
                value = responseJson.substring(valueIdx + 8, responseJson.length() - 4);
            }
        } catch (StringIndexOutOfBoundsException e) {
            log.debug("Fail to retrieve property value");
        }
        return value;
    }
       
    private ProjectDetails getProjectAndTeamDetails(String cxProject, CxFullCredentials cxFullCredentials) throws IOException {
		
		  String teamName =  cxProject.substring(cxProject.indexOf("\\") + 1, cxProject.lastIndexOf("\\"));
		  teamName = "/" + teamName ;
		 
        log.info("Team name parsed from the projectName: "+teamName);
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTeamName(teamName);
        projectDetails.setTeamId(getTeamId(teamName, cxFullCredentials));
        projectDetails.setProjectName(cxProject.substring(cxProject.lastIndexOf("\\") + 1));
        return projectDetails;
    }

    private void logErrorAndNotifyContext(String message, SensorContext context) {
        log.error(versionProvider.appendVersionToMsg(message));
        context.newAnalysisError().message(versionProvider.appendVersionToMsg(message)).save();
    }

    private String getSonarPropertyHttp(String propertyName, Configuration config) {
        String sonarURL = config.get(SONAR_HOST_URL).get();
        String projectName = config.get(SONAR_PROJECT_KEY).get();

        String propertyHttpURL = getPropertyUrl(sonarURL, propertyName, projectName);

        HttpResponse response = null;
        HttpClient client = HttpClientBuilder.create().build();

        try {
            HttpGet request = new HttpGet(propertyHttpURL);
            response = client.execute(request);

            if (isOk(response)) {
                return createStringFromResponse(response);
            } else if (response.getStatusLine().getStatusCode() == 401 ||
                    response.getStatusLine().getStatusCode() == 403) {
                log.info("Forced authentication is enabled: Sonar credentials must be provided");
                HttpResponse retResponse;

                String auth = null;
                String token;
                String user;
                String pass;
                if (config.get(SONAR_LOGIN_KEY).isPresent() &&
                        !config.get(SONAR_PASSWORD_KEY).isPresent()) {
                    token = config.get(SONAR_LOGIN_KEY).get();
                    auth = token + ":";
                    auth = new String(Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1)));
                } else if (config.get(SONAR_LOGIN_KEY).isPresent() && config.get(SONAR_PASSWORD_KEY).isPresent()) {
                    user = config.get(SONAR_LOGIN_KEY).get();
                    pass = config.get(SONAR_PASSWORD_KEY).get();
                    auth = user + ":" + pass;
                    auth = new String(Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1)));
                }
                if (StringUtils.isEmpty(auth)) {
                    log.error("No authentication input was provided.");
                    return "";
                }

                HttpGet retRequest = new HttpGet(propertyHttpURL);
                String authHeader = "Basic " + auth;
                retRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

                log.debug("Executing Sonar auth-request, URL: " + propertyHttpURL);
                retResponse = client.execute(retRequest);
                if (isOk(retResponse)) {
                    return createStringFromResponse(retResponse);
                }
            }
            return "";
        } catch (IOException e) {
        	log.warn("Error occured while retrieving property value for property: "+propertyName);
            return null;
        } finally {
            if (response != null) {
                HttpClientUtils.closeQuietly(response);
            }
        }
    }

    private boolean isOk(HttpResponse response) {
        try {
            int code = response.getStatusLine().getStatusCode();
            if (code != 200) {
                HttpEntity entity = response.getEntity();
                String resStr = EntityUtils.toString(entity, "UTF-8");
                log.debug("Failed request, Code: '" + code + "', Body: '" + resStr + "'.");
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private static String createStringFromResponse(org.apache.http.HttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        
        
        return result.toString();
    }

    private String getTeamId(String teamName, CxFullCredentials cxFullCredentials) throws IOException {
        String teamId;
        try {
            CxShragaClient shraga;
            ProxyParams proxyParam = HttpHelper.getProxyParam();
            if (proxyParam == null) {
                shraga = new CxShragaClient(
                        cxFullCredentials.getCxServerUrl().trim(),
                        cxFullCredentials.getCxUsername(),
                        cxFullCredentials.getCxPassword(),
                        CxSonarConstants.CX_SONAR_ORIGIN,
                        true,
                        false,
                        log);
            } else {
                shraga = new CxShragaClient(
                        cxFullCredentials.getCxServerUrl().trim(),
                        cxFullCredentials.getCxUsername(),
                        cxFullCredentials.getCxPassword(),
                        CxSonarConstants.CX_SONAR_ORIGIN,
                        true,
                        log,
                        true,
                        proxyParam.getHost(),
                        proxyParam.getPort(),
                        proxyParam.getUser(),
                        proxyParam.getPssd());
            }

            shraga.login();

            teamId = shraga.getTeamIdByName(teamName);
        } catch (CxClientException | IOException e) {
            throw new IOException("Error in getTeamIdByName, teamName:" + teamName);
        }
        return teamId;
    }

    public String getPassword(RestEndpointContext context) throws IOException {
        PropertyApiClient client = new PropertyApiClient(context, log);
        CxFullCredentials credentials = getStoredCredentials(client);

        String plaintextPassword = null;
        String encryptedPassword = credentials.getCxPassword();
        if (StringUtils.isNotEmpty(encryptedPassword)) {
            plaintextPassword = decrypt(encryptedPassword);
        }
        return plaintextPassword;
    }

    public void updateCredentials(RestEndpointContext context, CxFullCredentials credentials) throws IOException {
        PropertyApiClient client = new PropertyApiClient(context, log);
        CxFullCredentials storedCredentials = getStoredCredentials(client);
        storedCredentials.setCxServerUrl(credentials.getCxServerUrl());
        storedCredentials.setCxUsername(credentials.getCxUsername());
        log.info("Updating username: " + credentials.getCxUsername());

        if (StringUtils.isNotEmpty(credentials.getCxPassword())) {
            String encryptedPassword = encrypt(credentials.getCxPassword());
            log.debug("Updating encrypted password: " + encryptedPassword);
            storedCredentials.setCxPassword(encryptedPassword);
        }

        String credentialsJson = objectMapper.writeValueAsString(storedCredentials);

        client.setProperty(CxProperties.CREDENTIALS_KEY, credentialsJson);
    }

    public static String resetPropertyUrl(String sonarBaseUrl, String propertyName, String componentKey) {
        String result = null;
        try {
            result = String.format("%s/%s?keys=%s&component=%s",
                    resolveSonarUrl(sonarBaseUrl),
                    SETTINGS_API_RESET_PATH,
                    URLEncoder.encode(propertyName, ENCODING),
                    URLEncoder.encode(componentKey, ENCODING));
        } catch (UnsupportedEncodingException ignored) {
        }
        return result;
    }

    public static String getPropertyUrl(String sonarBaseUrl, String propertyName, String componentKey) {
        String result = null;
        try {
            result = String.format("%s/%s?keys=%s&component=%s",
                    resolveSonarUrl(sonarBaseUrl),
                    SETTINGS_API_GET_PATH,
                    URLEncoder.encode(propertyName, ENCODING),
                    URLEncoder.encode(componentKey, ENCODING));
        } catch (UnsupportedEncodingException ignored) {
        }
        return result;
    }

    private static String resolveSonarUrl(String sonarBaseUrl) {
        String url = StringUtils.isNotEmpty(System.getenv(SONAR_URL_PARAM)) ?
                System.getenv(SONAR_URL_PARAM) : System.getProperty(SONAR_URL_PARAM);

        return StringUtils.isNotEmpty(url) ? url.trim() : sonarBaseUrl;
    }

    public static String encrypt(String plaintext) throws IOException {
        SecretKeyStore keyStore = new SecretKeyStore();
        SecretKey key = keyStore.getSecretKey();
        AesUtil util = new AesUtil();
        String iv = AesUtil.random(AesUtil.IV_LENGTH_IN_BYTES);
        return iv + util.encrypt(key, iv, plaintext);
    }

    private String decrypt(String cryptoText) throws IOException {
        final int IV_LENGTH_IN_CHARS = AesUtil.IV_LENGTH_IN_BYTES * 2;

        try {
            SecretKeyStore keyStore = new SecretKeyStore();
            SecretKey key = keyStore.getSecretKey();

            String iv = cryptoText.substring(0, IV_LENGTH_IN_CHARS);
            String workload = cryptoText.substring(IV_LENGTH_IN_CHARS);
            AesUtil util = new AesUtil();
            return util.decrypt(key, iv, workload);
        } catch (Exception e) {
            throw new IOException("Decryption error.", e);
        }
    }
}