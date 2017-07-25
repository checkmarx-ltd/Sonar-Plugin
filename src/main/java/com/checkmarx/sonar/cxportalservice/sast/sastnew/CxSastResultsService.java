package com.checkmarx.sonar.cxportalservice.sast.sastnew;

import com.checkmarx.soap.client.*;
import com.checkmarx.sonar.cxportalservice.sast.exception.ConnectionException;
import com.checkmarx.sonar.cxportalservice.sast.sastnew.model.AllSastResults;
import com.checkmarx.sonar.cxportalservice.sast.sastnew.model.CxXMLResults;
import com.checkmarx.sonar.cxportalservice.sast.sastnew.model.ScanResults;
import com.checkmarx.sonar.dto.CxFullCredentials;
import org.apache.commons.lang.StringUtils;
import org.sonar.api.internal.apachecommons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by: Zoharby.
 * Date: 20/07/2017.
 */
public class CxSastResultsService extends CxSDKSonarSoapService {

    private static final int RETRY_ATTEMPTS = 10;

    private String sessionId;


   public AllSastResults retrieveScan(CxFullCredentials cxFullCredentials, String cxProjectName) throws IOException, InterruptedException, JAXBException {

       sessionId = login(cxFullCredentials);

       ProjectDisplayData projectDisplayData = getProjectDisplayData(cxProjectName);
       ProjectScannedDisplayData projectScannedDisplayData = getLastScanForProject(cxProjectName, projectDisplayData.getProjectID());

       CxWSCreateReportResponse reportResponse = generateScanReport(projectScannedDisplayData.getLastScanID(), CxWSReportType.XML);
       CxXMLResults cxXMLResults = getScanReport(reportResponse.getID());

       ScanResults scanResults = genScanResponse(projectScannedDisplayData, cxXMLResults);

       return new AllSastResults(cxXMLResults, scanResults);
   }


    public CxWSCreateReportResponse generateScanReport(long scanId, CxWSReportType reportType) throws ConnectionException, RemoteException {
        assert sessionId != null : "Trying to retrieve scan report before login";

        CxWSReportRequest cxWSReportRequest = new CxWSReportRequest();
        cxWSReportRequest.setScanID(scanId);
        cxWSReportRequest.setType(reportType);
        logger.info("Requesting " + reportType.toString().toUpperCase() + " Scan Report Generation");

        int retryAttempts = RETRY_ATTEMPTS;
        CxWSCreateReportResponse cxWSCreateReportResponse;
        do {
            cxWSCreateReportResponse = webServiceSoap.createScanReport(sessionId, cxWSReportRequest);
            if (!cxWSCreateReportResponse.isIsSuccesfull()) {
                retryAttempts--;
                logger.error("Error requesting scan report generation: " + cxWSCreateReportResponse.getErrorMessage());
            }
        } while (!cxWSCreateReportResponse.isIsSuccesfull() && retryAttempts > 0);

        if (!cxWSCreateReportResponse.isIsSuccesfull()) {
            String message = "Error requesting scan report generation: " + cxWSCreateReportResponse.getErrorMessage();
            logger.error(message);
            throw new ConnectionException(message);
        }

        return cxWSCreateReportResponse;
    }

    private CxXMLResults getScanReport(long reportId) throws IOException,
            InterruptedException, JAXBException {
        // Wait for the report to become ready

        String previousMessage = "";
        while (true) {
            CxWSReportStatusResponse cxWSReportStatusResponse = webServiceSoap.getScanReportStatus(sessionId, reportId);
            if (!cxWSReportStatusResponse.isIsSuccesfull()) {
                String message = "Error retrieving scan report status: " + cxWSReportStatusResponse.getErrorMessage();
                logger.error(message);
                throw new ConnectionException(message);
            }
            if (cxWSReportStatusResponse.isIsFailed()) {
                String message = "Failed to create scan report";
                logger.error("Web method getScanReportStatus returned status response with isFailed field set to true");
                logger.error(message);
                throw new ConnectionException(message);
            }

            if (cxWSReportStatusResponse.isIsReady()) {
                logger.info("Scan report generated on Checkmarx server");
                break;
            }

            //previousMessage = cleanLogger(previousMessage, reportType.toString().toUpperCase() + " Report generation in progress");
            Thread.sleep(5L * 1000);

        }
            CxWSResponseScanResults cxWSResponseScanResults = webServiceSoap.getScanReport(sessionId, reportId);
            if (!cxWSResponseScanResults.isIsSuccesfull()) {
                String message = "Error retrieving scan report: " + cxWSResponseScanResults.getErrorMessage();
                logger.error(message);
                throw new ConnectionException(message);
            }

            // Save results on disk
            return convertToXMLResult(cxWSResponseScanResults.getScanResults());
    }

    private ProjectDisplayData getProjectDisplayData(String cxProjectName) throws ConnectionException {
        CxWSResponseProjectsDisplayData projectsDisplayData = getAllProjectsDisplayData();
        List<ProjectDisplayData> dataList = Arrays.asList(projectsDisplayData.getProjectList().getProjectDisplayData());

        return findProject(cxProjectName, dataList);
    }

    private CxWSResponseProjectsDisplayData getAllProjectsDisplayData() throws ConnectionException {
        logger.info("Retrieving projects from server.");
        CxWSResponseProjectsDisplayData projectsDisplayData;
        String errMsg = "Failed to retrieve projects from server :";
        try {
            projectsDisplayData = webServiceSoap.getProjectsDisplayData(sessionId);

            if (!projectsDisplayData.isIsSuccesfull()) {
                throw new ConnectionException(errMsg + projectsDisplayData.getErrorMessage());
            }

        } catch (javax.xml.ws.WebServiceException | RemoteException e) {
            throw new ConnectionException(errMsg, e);
        }
        return projectsDisplayData;
    }

    private ProjectDisplayData findProject(String cxProjectName, List<ProjectDisplayData> projectsDisplayData) throws ConnectionException {
        logger.info("Looking for configured Checkmarx project.");
        final String[] components = splitProjectNameAndGroup(cxProjectName);
        final String projectName = components[0];
        final String groupName = components[1];
        ProjectDisplayData projectDisplayData = null;
        for (ProjectDisplayData d : projectsDisplayData) {
            if (projectName.equals(d.getProjectName()) &&
                    (groupName == null || groupName.equals(d.getGroup()))) {
                projectDisplayData = d;
                break;
            }
        }

        if (projectDisplayData == null) {
            throw new ConnectionException("Can not find project " + cxProjectName + " among projects located on server");
        } else {
            return projectDisplayData;
        }
    }

    private static String[] splitProjectNameAndGroup(String cxProjectName) {
        final String[] components = cxProjectName.split("\\\\");
        assert components.length > 0;
        if (components.length == 1) {
            return new String[]{cxProjectName, null};
        } else {
            return new String[]{
                    components[components.length - 1],
                    StringUtils.join(Arrays.copyOfRange(components, 0, components.length - 1), "\\")
            };
        }
    }

    private ProjectScannedDisplayData getLastScanForProject(String projectName, final long projectId) throws ConnectionException, RemoteException {
        logger.info("Retrieving last scan for project");

        CxWSResponseScansDisplayData cxWSResponseProjectsScansList;

        CxWSResponseScansDisplayData cxWSResponseScansDisplayData;
        String errMsg = "Failed to retrieve projects list from server: ";
        try {
            //cxWSResponseProjectsScansList = webServiceSoap.getProjectsWithScans(sessionId);
            cxWSResponseProjectsScansList = webServiceSoap.getScansDisplayDataForAllProjects(sessionId);
        } catch (javax.xml.ws.WebServiceException e) {
            throw new ConnectionException(errMsg + e.getLocalizedMessage(), e);
        }
        if (!cxWSResponseProjectsScansList.isIsSuccesfull()) {
            throw new ConnectionException(errMsg + cxWSResponseProjectsScansList.getErrorMessage());
        }
        List<ProjectScannedDisplayData> projects = Arrays.asList(webServiceSoap.getProjectScannedDisplayData(sessionId).getProjectScannedList().getProjectScannedDisplayData());

        ProjectScannedDisplayData project = null;
        for (ProjectScannedDisplayData p : projects) {
            if (p.getProjectID() == projectId) {
                project = p;
                break;
            }
        }

        if (project == null) {
            String message = "Project \"" + projectName + "\" was not found on Checkmarx server. This may be because the project contains no scans.";
            logger.warn(message);
            /*if (logger.isDebugEnabled()) {
                logger.debug("Following projects were found on server:");
                for (ProjectScannedDisplayData p : projects) {
                    logger.debug("name: \"" + p.getProjectName() + "\", id: " + p.getProjectID());
                }
            }*/
            throw new ConnectionException(message);
        }

        return project;
    }


    private CxXMLResults convertToXMLResult(byte[] cxReport) throws IOException, JAXBException {

        CxXMLResults reportObj = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cxReport);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CxXMLResults.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            reportObj = (CxXMLResults) unmarshaller.unmarshal(byteArrayInputStream);

        } finally {
            IOUtils.closeQuietly(byteArrayInputStream);
        }
        return reportObj;
    }


    public static ScanResults genScanResponse(ProjectScannedDisplayData scanDisplayData, CxXMLResults cxXMLResults) {
        ScanResults ret = new ScanResults();
        ret.setProjectId(scanDisplayData.getProjectID());
        ret.setScanID(scanDisplayData.getLastScanID());
        ret.setHighSeverityResults(scanDisplayData.getHighVulnerabilities());
        ret.setMediumSeverityResults(scanDisplayData.getMediumVulnerabilities());
        ret.setLowSeverityResults(scanDisplayData.getLowVulnerabilities());
        ret.setInfoSeverityResults(scanDisplayData.getInfoVulnerabilities());
        ret.setRiskLevelScore(scanDisplayData.getRiskLevelScore());

        ret.setScanDetailedReport(cxXMLResults);

        return ret;
    }
}

