package com.checkmarx.sonar.cxportalservice.sast.services;

import com.checkmarx.soap.client.CxWSResponseProjectsDisplayData;
import com.checkmarx.soap.client.ProjectDisplayData;
import com.checkmarx.sonar.cxportalservice.sast.exception.ConnectionException;
import com.checkmarx.sonar.logger.CxLogger;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 20/04/2017.
 */
public class CxConfigSoapService extends CxSDKSonarSoapService {

    public CxConfigSoapService() {
        super();
        logger = new CxLogger(CxConfigSoapService.class);
    }

    public List<ProjectDisplayData> getProjectsDisplayData(String sessionId) throws ConnectionException {
        logger.info("Extracting projects list from Checkmarx server.");
        if(webServiceSoap == null){
            throw new ConnectionException("User is not logged in.");
        }

        String errMsg = "Failed to retrieve projects display data from server, check the server and retry.\n Error: ";
        CxWSResponseProjectsDisplayData projectsDisplayData;
        try {
            projectsDisplayData = webServiceSoap.getProjectsDisplayData(sessionId);
            if (!projectsDisplayData.isIsSuccesfull()) {
                throw logErrorAndCreateConnectionException(errMsg + projectsDisplayData.getErrorMessage());
            }
            if (projectsDisplayData.getProjectList() != null && projectsDisplayData.getProjectList().getProjectDisplayData() != null){
                return Arrays.asList(projectsDisplayData.getProjectList().getProjectDisplayData());
            }
        } catch (RemoteException e) {
            throw logErrorAndCreateConnectionException(errMsg + e.getMessage(), e);
        }

        return new LinkedList<>();
    }
}
