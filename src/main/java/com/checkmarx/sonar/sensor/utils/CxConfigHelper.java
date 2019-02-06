package com.checkmarx.sonar.sensor.utils;

import com.checkmarx.sonar.cxrules.CxSonarConstants;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.dto.ProjectDetails;
import com.checkmarx.sonar.sensor.version.PluginVersionProvider;
import com.checkmarx.sonar.settings.CxProperties;
import com.checkmarx.sonar.web.CxConfigRestEndPoint;
import com.cx.restclient.configuration.CxScanConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.sonar.api.batch.sensor.SensorContext;
import java.io.IOException;

public class CxConfigHelper {

    private Logger log;
    private CxScanConfig scanConfig;
    private PluginVersionProvider versionProvider = new PluginVersionProvider();
    private ProjectDetails projectDetails = new ProjectDetails();
    private CxConfigRestEndPoint restEndPoint = new CxConfigRestEndPoint();

    public CxConfigHelper(Logger log) {
        this.log = log;
    }

    public CxScanConfig resolveSettings(SensorContext context){
        log.info("Resolving Cx settings");
        CxFullCredentials cxFullCredentials = null;
        String cxCredentialsJson = context.settings().getString(CxProperties.CX_CREDENTIALS_KEY);
        String cxProject = context.settings().getString(CxProperties.CXPROJECT_KEY);
        if (cxCredentialsJson == null || cxProject == null) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while retrieving Checkmarx settings from sonar Database.\n" + "" +
                    "Please make sure Checkmarx credentials are configured.", context);
            return scanConfig;
        }
        if (StringUtils.isEmpty(cxCredentialsJson) || StringUtils.isEmpty(cxProject)) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Checkmarx settings were not configured.\n Can be configured by admin at: " +
                    "Project Page > Administration > Checkmarx\n", context);
            return scanConfig;
        }
        try {
            cxFullCredentials = CxFullCredentials.getCxFullCredentials(context);
        } catch (IOException e) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while parsing credentials: " + e.getMessage(), context);
            return scanConfig;
        }
        scanConfig = new CxScanConfig();
        scanConfig.setCxOrigin(CxSonarConstants.CX_SONAR_ORIGIN);
        scanConfig.setSastEnabled(true);
        scanConfig.setOsaEnabled(false);
        scanConfig.setSynchronous(true);
        scanConfig.setUrl(cxFullCredentials.getCxServerUrl());
        scanConfig.setUsername(cxFullCredentials.getCxUsername());
        scanConfig.setPassword(cxFullCredentials.getCxPassword());
        scanConfig.setPresetId(1);
        try {
            getProjectAndTeamDetails(cxProject, cxFullCredentials);
        } catch (IOException e) {
            logErrorAndNotifyContext(CxSonarConstants.CANCEL_MESSAGE + "Error while retrieving team ID for project:" + cxProject, context);
            return scanConfig;
        }
        scanConfig.setProjectName(projectDetails.getProjectName());
        scanConfig.setTeamId(projectDetails.getTeamId());
        scanConfig.setTeamPath(projectDetails.getTeamName());

        return scanConfig;
    }

    private void getProjectAndTeamDetails(String cxProject, CxFullCredentials cxFullCredentials) throws IOException {
        String teamName = StringUtils.substringBeforeLast(cxProject, "\\");
        projectDetails.setTeamName(teamName);
        projectDetails.setTeamId(restEndPoint.getTeamId(teamName, cxFullCredentials));
        projectDetails.setProjectName(StringUtils.substringAfterLast(cxProject, "\\"));
    }

    public void logErrorAndNotifyContext(String massage, SensorContext context){
        log.error(versionProvider.appendVersionToMsg(massage));
        context.newAnalysisError().message(versionProvider.appendVersionToMsg(massage)).save();
    }

}