package com.checkmarx.sonar.cxservice;

import com.checkmarx.sonar.cxservice.exception.ConnectionException;
import com.raps.code.generate.ws.CxWSResponseProjectsDisplayData;
import com.raps.code.generate.ws.ProjectDisplayData;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 20/04/2017.
 */
public class CxConfigSoapService extends CxSoapService {

    public CxConfigSoapService() {
        super(LoggerFactory.getLogger(CxConfigSoapService.class));
    }

    public List<ProjectDisplayData> getProjectsDisplayData(String sessionId) throws ConnectionException {

        if(webServiceSoap == null || sessionId == null || sessionId.equals("")){
            throw new ConnectionException("User is not logged in.");
        }

        CxWSResponseProjectsDisplayData projectsDisplayData;
        try {
            projectsDisplayData = webServiceSoap.getProjectsDisplayData(sessionId);
        } catch (javax.xml.ws.WebServiceException e) {
            throw new ConnectionException(e.getMessage(), e);
        }

        if (!projectsDisplayData.isIsSuccesfull()) {
            logger.warn("Failed to retrieve project display data with GetProjectsDisplayData web service: \n" + projectsDisplayData.getErrorMessage());
            throw new ConnectionException("Failed to retrieve projects display data from server, check the server and retry.\n" +
                    projectsDisplayData.getErrorMessage());
        }

        if (projectsDisplayData.getProjectList() != null){
            return projectsDisplayData.getProjectList().getProjectDisplayData();
        }else {
            return new LinkedList<>();
        }
    }
}
