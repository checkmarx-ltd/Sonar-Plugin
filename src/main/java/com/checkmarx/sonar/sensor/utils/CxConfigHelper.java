package com.checkmarx.sonar.sensor.utils;

import com.checkmarx.sonar.cxrules.CxSonarConstants;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.dto.RestEndpointContext;
import com.checkmarx.sonar.sensor.dto.ProjectDetails;
import com.checkmarx.sonar.sensor.encryption.AesUtil;
import com.checkmarx.sonar.sensor.encryption.SecretKeyStore;
import com.checkmarx.sonar.sensor.version.PluginVersionProvider;
import com.checkmarx.sonar.settings.CxProperties;
import com.cx.restclient.CxShragaClient;
import com.cx.restclient.configuration.CxScanConfig;
import com.cx.restclient.exception.CxClientException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.config.Configuration;

import javax.crypto.SecretKey;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CxConfigHelper {
    private static final String SONAR_HOST_URL = "sonar.host.url";
    private static final String SONAR_PROJECT_KEY = "sonar.projectKey";
    private static final String SONAR_LOGIN_KEY = "sonarLogin";
    private static final String SONAR_PASSWORD_KEY = "sonarPassword";

    private static final String VALUE = "value";

    private static final String ENCODING = StandardCharsets.UTF_8.name();
    private static final String PROPERTIES_API_PATH = "api/properties";

    private Logger log;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private PluginVersionProvider versionProvider = new PluginVersionProvider();

    public CxConfigHelper(Logger log) {
        this.log = log;
    }

    public CxFullCredentials getCxFullCredentials(SensorContext context) {
        try {
            String serverUrl = getSonarProperty(context, CxProperties.SERVER_URL_KEY);

            String username = getSonarProperty(context, CxProperties.USERNAME_KEY);

            String encryptedPassword = getSonarProperty(context, CxProperties.PASSWORD_KEY);
            String password = decrypt(encryptedPassword);

            return new CxFullCredentials(serverUrl, username, password);
        } catch (IOException e) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while parsing credentials: " + e.getMessage(), context);
            return null;
        }
    }

    private String getSonarProperty(SensorContext context, String propertyName) {
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

    private String getPropertyValue(String cxProject) {
        return cxProject.substring(cxProject.indexOf(VALUE) + 8, cxProject.length() - 3);
    }

    private ProjectDetails getProjectAndTeamDetails(String cxProject, CxFullCredentials cxFullCredentials) throws IOException {
        String teamName = cxProject.substring(cxProject.indexOf("\\") + 1, cxProject.lastIndexOf("\\") - 1);
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTeamName(teamName);
        projectDetails.setTeamId(getTeamId(teamName, cxFullCredentials));
        projectDetails.setProjectName(cxProject.substring(cxProject.lastIndexOf("\\") + 1));
        return projectDetails;
    }

    private void logErrorAndNotifyContext(String massage, SensorContext context) {
        log.error(versionProvider.appendVersionToMsg(massage));
        context.newAnalysisError().message(versionProvider.appendVersionToMsg(massage)).save();
    }

    private String getSonarPropertyHttp(String propertyName, Configuration config) {
        String sonarURL = config.get(SONAR_HOST_URL).get();
        String projectName = config.get(SONAR_PROJECT_KEY).get();

        String propertyHttpURL = getPropertyUrl(sonarURL, propertyName, projectName);

        HttpResponse generateTokenResponse = null;
        HttpClient client = HttpClientBuilder.create().build();

        try {
            String user = config.get(SONAR_LOGIN_KEY).get();
            String pass = config.get(SONAR_PASSWORD_KEY).get();

            HttpGet request = new HttpGet(propertyHttpURL);
            String auth = user + ":" + pass;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            generateTokenResponse = client.execute(request);

            if (isOk(generateTokenResponse)) {
                return createStringFromResponse(generateTokenResponse);
            } else {
                return "";
            }
        } catch (IOException e) {
            return null;
        } finally {
            if (generateTokenResponse != null) {
                HttpClientUtils.closeQuietly(generateTokenResponse);
            }
        }
    }

    private boolean isOk(HttpResponse response) {
        try {
            if (response.getStatusLine().getStatusCode() != 200) {
                HttpEntity entity = response.getEntity();
                String responseString = EntityUtils.toString(entity, "UTF-8");
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
            CxShragaClient shraga = new CxShragaClient(
                    cxFullCredentials.getCxServerUrl().trim(),
                    cxFullCredentials.getCxUsername(),
                    cxFullCredentials.getCxPassword(),
                    CxSonarConstants.CX_SONAR_ORIGIN,
                    false,
                    log);

            teamId = shraga.getTeamIdByName(teamName);
        } catch (CxClientException | IOException e) {
            throw new IOException("Error in getTeamIdByName, teamName:" + teamName);
        }
        return teamId;
    }

    public String getPassword(RestEndpointContext context) throws IOException {
        String requestUrl = getPropertyUrl(context.getSonarBaseUrl(), CxProperties.PASSWORD_KEY, context.getComponentKey());
        HttpUriRequest request = new HttpGet(requestUrl);
        HttpResponse response = getResponse(context, request);

        JsonNode root = objectMapper.readTree(response.getEntity().getContent());
        String encryptedPassword = root.at("/0/value").textValue();

        return decrypt(encryptedPassword);
    }

    public void updatePassword(RestEndpointContext context, String newValue) throws IOException {
        String requestUrl = String.format("%s/%s", context.getSonarBaseUrl(), PROPERTIES_API_PATH);
        HttpPost request = new HttpPost(requestUrl);

        String encryptedPassword = encrypt(newValue);
        NameValuePair[] params = new NameValuePair[]{
                new BasicNameValuePair("id", CxProperties.PASSWORD_KEY),
                new BasicNameValuePair("resource", context.getComponentKey()),
                new BasicNameValuePair("value", encryptedPassword),
        };
        UrlEncodedFormEntity body = new UrlEncodedFormEntity(Arrays.asList(params));
        request.setEntity(body);

        HttpResponse response = getResponse(context, request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != Response.Status.NO_CONTENT.getStatusCode()) {
            String responseString = createStringFromResponse(response);
            throw new IOException(String.format("Error updating password. Response status: %d, response: %s",
                    statusCode, responseString));
        }
    }

    private String getPropertyUrl(String sonarBaseUrl, String propertyName, String componentKey) {
        String result = null;
        try {
            result = String.format("%s/%s?id=%s&resource=%s",
                    sonarBaseUrl,
                    PROPERTIES_API_PATH,
                    URLEncoder.encode(propertyName, ENCODING),
                    URLEncoder.encode(componentKey, ENCODING));
        } catch (UnsupportedEncodingException e) {
            log.error("Error getting property URL.", e);
        }
        return result;
    }

    private HttpResponse getResponse(RestEndpointContext context, HttpUriRequest request) throws IOException {
        request.setHeaders(context.getRequiredHeaders());

        CookieStore cookieStore = new BasicCookieStore();
        for (Cookie cookie : context.getRequiredCookies()) {
            cookieStore.addCookie(cookie);
        }

        HttpClient client = HttpClientBuilder.create()
                .setDefaultCookieStore(cookieStore)
                .build();

        return client.execute(request);
    }

    private String encrypt(String plaintext) throws IOException {
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