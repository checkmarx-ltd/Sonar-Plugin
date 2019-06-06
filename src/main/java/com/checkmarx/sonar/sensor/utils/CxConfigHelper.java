package com.checkmarx.sonar.sensor.utils;

import com.checkmarx.sonar.cxrules.CxSonarConstants;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.dto.ProjectDetails;
import com.checkmarx.sonar.sensor.version.PluginVersionProvider;
import com.checkmarx.sonar.settings.CxProperties;
import com.checkmarx.sonar.web.CxConfigRestEndPoint;
import com.cx.restclient.configuration.CxScanConfig;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CxConfigHelper {

    public static final String API_PROPERTIES_URL = "/api/properties";
    public static final String ID_PARAM = "?id=";
    public static final String RESOURCE_PARAM = "&resource=";

    public static final String SONAR_HOST_URL = "sonar.host.url";
    public static final String SONAR_PROJECT_KEY = "sonar.projectKey";
    public static final String  VALUE = "value";
    public static final String SONAR_LOGIN_KEY = "sonarLogin";
    public static final String SONAR_PASSWORD_PASSWORD = "sonarPassword";

    private Logger log;

    private PluginVersionProvider versionProvider = new PluginVersionProvider();

    private CxConfigRestEndPoint restEndPoint = new CxConfigRestEndPoint();

    public CxConfigHelper(Logger log) {
        this.log = log;
    }


    public CxFullCredentials getCxFullCredentials( SensorContext context) throws IOException {

        try {
            String cxCredentialsEnc = getSonarProperty(context, CxProperties.CX_CREDENTIALS_KEY);
            CxFullCredentials cxFullCredentials = CxFullCredentials.getCxFullCredentials(cxCredentialsEnc);
            return cxFullCredentials;
        } catch (IOException e) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while parsing credentials: " + e.getMessage(), context);
            return null;
        }

    }

    public String getCxProject(SensorContext context) {
        return getSonarProperty(context, CxProperties.CXPROJECT_KEY);
    }

    public String getSonarProperty(SensorContext context, String propertyName) {

        log.info("Resolving Cx settings");

        CxFullCredentials cxFullCredentials = null;
        String sonarURL = context.config().get((SONAR_HOST_URL)).get();
        String projectName = context.config().get((SONAR_PROJECT_KEY)).get();

        String propertyHttpURL = sonarURL + API_PROPERTIES_URL + ID_PARAM + propertyName + RESOURCE_PARAM + projectName;
        String propertyValue = getSonarPropertyHttp(propertyHttpURL, context);


        if (propertyValue == null ) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while retrieving Checkmarx settings from sonar Database.\n" + "" +
                    "Please make sure Checkmarx credentials are configured.", context);
            return null;
        }
        if (StringUtils.isEmpty(propertyValue) ) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Checkmarx settings were not configured.\n Can be configured by admin at: " +
                    "Project Page > Administration > Checkmarx\n", context);
            return null;
        }

        propertyValue = getPropertyValue(propertyValue);
        return propertyValue;
    }

    public CxScanConfig getScanConfig(CxFullCredentials cxFullCredentials, SensorContext context){

        CxScanConfig scanConfig = new CxScanConfig();
        scanConfig.setCxOrigin(CxSonarConstants.CX_SONAR_ORIGIN);
        scanConfig.setSastEnabled(true);
        scanConfig.setOsaEnabled(false);
        scanConfig.setSynchronous(true);
        scanConfig.setUrl(cxFullCredentials.getCxServerUrl());
        scanConfig.setUsername(cxFullCredentials.getCxUsername());
        scanConfig.setPassword(cxFullCredentials.getCxPassword());
        scanConfig.setPresetId(1);
        String cxProject = getCxProject(context);
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
        return cxProject.substring(cxProject.indexOf(VALUE)+8,cxProject.length()-3);
    }

    private ProjectDetails getProjectAndTeamDetails(String cxProject, CxFullCredentials cxFullCredentials) throws IOException {

        String teamName = cxProject.substring(cxProject.indexOf("\\")+1,cxProject.lastIndexOf("\\")-1);
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTeamName(teamName);
        projectDetails.setTeamId(restEndPoint.getTeamId(teamName, cxFullCredentials));
        projectDetails.setProjectName(cxProject.substring(cxProject.lastIndexOf("\\")+1));
        return projectDetails;
    }

    public void logErrorAndNotifyContext(String massage, SensorContext context){
        log.error(versionProvider.appendVersionToMsg(massage));
        context.newAnalysisError().message(versionProvider.appendVersionToMsg(massage)).save();
    }

    public String getSonarPropertyHttp(String serverUrl, SensorContext context) {


        HttpResponse generateTokenResponse = null;
        HttpClient client = HttpClientBuilder.create().build();

        try {

            String user = context.config().get(SONAR_LOGIN_KEY).get();
            String pass = context.config().get(SONAR_PASSWORD_PASSWORD).get();

            HttpGet request = new HttpGet(serverUrl);
            String auth = user + ":" + pass;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            generateTokenResponse = client.execute(request);

            if(isOk(generateTokenResponse)) {
                return createStringFromResponse(generateTokenResponse);
            }else{
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


    public boolean isOk(HttpResponse response){
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

}