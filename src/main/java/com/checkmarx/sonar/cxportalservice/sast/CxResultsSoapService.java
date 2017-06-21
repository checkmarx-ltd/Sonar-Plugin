package com.checkmarx.sonar.cxportalservice.sast;

import com.checkmarx.soap.client.*;
import com.checkmarx.sonar.cxportalservice.sast.exception.ConnectionException;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.dto.SastScanData;
import org.apache.commons.lang.StringUtils;
import org.sonar.api.utils.log.Loggers;

import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by: zoharby.
 * Date: 20/04/2017.
 */
public class CxResultsSoapService extends CxSoapService {

    private String sessionId;

    public CxResultsSoapService() {
        logger = Loggers.get(CxResultsSoapService.class);
    }

    public SastScanData getQueriesOfLastScanForProject(CxFullCredentials cxCredentials, String cxProjectName) throws ConnectionException {
        try {
            sessionId = login(cxCredentials);

            ProjectDisplayData projectDisplayData = getProjectDisplayData(cxProjectName);

            CxWSResponseBasicScanData scanData = getLastScanForProject(projectDisplayData.getProjectID());

            QueriesSummeryAndResults queriesAndResults = getQueriesSummeryAndResults(scanData.getID());
            Map<CxWSQueryVulnerabilityData, Integer> queriesSummery = queriesAndResults.getQueriesSummery();
            List<CxWSSingleResultData> results = queriesAndResults.getResults();

            CxWSResponseScanSummary scanSummary = getScanSummery(scanData.getID());

            ScanDisplayData scanDisplayData = getScanDisplayData(projectDisplayData.getProjectID(), scanData.getID());

            return new SastScanData(projectDisplayData, scanData, scanSummary,  queriesSummery, results, scanDisplayData);

        } finally {
            try {
                closeConnection(sessionId);
            }catch (Exception ignored){}
        }
    }

    private ProjectDisplayData getProjectDisplayData(String cxProjectName) throws ConnectionException {
        CxWSResponseProjectsDisplayData projectsDisplayData = getProjectsDisplayData();
        ProjectDisplayData[] projectsDisplayDatas = projectsDisplayData.getProjectList().getProjectDisplayData();
        List<ProjectDisplayData> dataList = Arrays.asList(projectsDisplayDatas);

        return findProject(cxProjectName, dataList);
    }

    private CxWSResponseProjectsDisplayData getProjectsDisplayData() throws ConnectionException {
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

    private CxWSResponseBasicScanData getLastScanForProject(final long projectId) throws ConnectionException {
        logger.info("Retrieving last scan for project");

        CxWSResponseProjectsScansList cxWSResponseProjectsScansList;
        String errMsg = "Failed to retrieve projects list from server: ";
        try {
            cxWSResponseProjectsScansList = webServiceSoap.getProjectsWithScans(sessionId);
        } catch (javax.xml.ws.WebServiceException | RemoteException e) {
            throw new ConnectionException(errMsg + e.getLocalizedMessage(), e);
        }
        if (!cxWSResponseProjectsScansList.isIsSuccesfull()) {
            throw new ConnectionException(errMsg + cxWSResponseProjectsScansList.getErrorMessage());
        }
        CxWSResponseBasicProjectData[] projects = cxWSResponseProjectsScansList.getProjects().getCxWSResponseBasicProjectData();

        CxWSResponseBasicProjectData project = null;
        for (CxWSResponseBasicProjectData p : projects) {
            if (p.getID() == projectId) {
                project = p;
                break;
            }
        }
        if (project == null) {
            String message = "Project with id \"" + projectId + "\" was not found on Checkmarx server. This may be because the project contains no scans.";
            logger.warn(message);
            if (logger.isDebugEnabled()) {
                logger.debug("Following projects were found on server:");
                for (CxWSResponseBasicProjectData p : projects) {
                    logger.debug("name: \"" + p.getName() + "\", id: " + p.getID());
                }
            }
            throw new ConnectionException("Project with id: " + projectId + " contains no scans");
        }

        CxWSResponseBasicScanData[] scans = project.getScans().getCxWSResponseBasicScanData();
        logger.info("Found project " + project.getName() + " with " + scans.length + " scans");
        if (scans.length == 0) {
            String message = "Project " + project.getName() + " contains no scans";
            logger.warn(message);
            throw new ConnectionException(message);
        }

        return scans[0];
    }

    private List<CxWSQueryVulnerabilityData> getQueriesForScan(long scanId) throws ConnectionException {
        logger.info("Retrieving queries for scan");
        CxWSResponceQuerisForScan cxWSResponceQuerisForScan;
        String errMsg = "Failed to retrieve queries for scan (id=" + scanId + ")";
        try {
            cxWSResponceQuerisForScan = webServiceSoap.getQueriesForScan(sessionId, scanId);
        } catch (javax.xml.ws.WebServiceException | RemoteException e) {
            throw new ConnectionException(errMsg +": "+ e.getLocalizedMessage(),e);
        }
        if (!cxWSResponceQuerisForScan.isIsSuccesfull()) {
            throw new ConnectionException(errMsg);
        }
        return Arrays.asList(cxWSResponceQuerisForScan.getQueries().getCxWSQueryVulnerabilityData());
    }

    private class QueriesSummeryAndResults {
        Map<CxWSQueryVulnerabilityData, Integer> queriesSummery;
        List<CxWSSingleResultData> results;

        QueriesSummeryAndResults(Map<CxWSQueryVulnerabilityData, Integer> queriesSummery, List<CxWSSingleResultData> results) {
            this.queriesSummery = queriesSummery;
            this.results = results;
        }
        Map<CxWSQueryVulnerabilityData, Integer> getQueriesSummery() {
            return queriesSummery;
        }

        List<CxWSSingleResultData> getResults() {
            return results;
        }

    }
    private QueriesSummeryAndResults getQueriesSummeryAndResults(long scanId) throws ConnectionException {

        List<CxWSQueryVulnerabilityData> queries = getQueriesForScan(scanId);

        logger.info("Retrieving results for scan");
        List<CxWSSingleResultData> results = new LinkedList<CxWSSingleResultData>();
        Map<CxWSQueryVulnerabilityData, Integer> queriesSummery = new HashMap<>();
        for (CxWSQueryVulnerabilityData q : queries) {

            CxWSResponceScanResults cxWSResponceScanResults;
            String errMsg = "Failed to retrieve results for query (scanId=" + scanId + " queryId=" + q.getQueryId() + ")";
            try {
                cxWSResponceScanResults = webServiceSoap.getResultsForQuery(sessionId, scanId, q.getQueryId());
            } catch (javax.xml.ws.WebServiceException | RemoteException e) {
                throw new ConnectionException(errMsg+" :"+e.getLocalizedMessage(), e);
            }
            if (!cxWSResponceScanResults.isIsSuccesfull()) {
                throw new ConnectionException(errMsg);
            }

            queriesSummery.put(q, cxWSResponceScanResults.getResults().getCxWSSingleResultData().length);
            results.addAll(Arrays.asList(cxWSResponceScanResults.getResults().getCxWSSingleResultData()));
        }
        return new QueriesSummeryAndResults(queriesSummery, results);
    }

    private CxWSResponseScanSummary getScanSummery(long scanId) throws ConnectionException {
        logger.info("Retrieving scan summery");
        CxWSResponseScanSummary scanSummary;
        try {
            scanSummary = webServiceSoap.getScanSummary(sessionId, scanId);
        } catch (RemoteException e) {
            throw new ConnectionException("Failed to retrieve scan summery: "+e.getMessage(), e);
        }
        return  scanSummary;
    }

    private ScanDisplayData getScanDisplayData(long projectId, long scanId) throws ConnectionException {
        logger.info("Retrieving scan display data");
        CxWSResponseScansDisplayData allScansDisplayData;
        allScansDisplayData = getScansDisplayData(projectId);
        return getRelevantScanDisplayData(allScansDisplayData, scanId);
    }

    private CxWSResponseScansDisplayData getScansDisplayData(long projectId) throws ConnectionException {
        try {
            return webServiceSoap.getScansDisplayData(sessionId, projectId);
        } catch (RemoteException e) {
            throw new ConnectionException("Failed to retrieve scan display data :"+e.getMessage(), e);
        }
    }

    private ScanDisplayData getRelevantScanDisplayData(CxWSResponseScansDisplayData allScansDisplayData, long currScanId) throws ConnectionException {
        ScanDisplayData[] scanDisplayDataArray = allScansDisplayData.getScanList().getScanDisplayData();
        for (ScanDisplayData scan : scanDisplayDataArray){
            if(scan.getScanID() == currScanId){
                return scan;
            }
        }
        throw new ConnectionException("Scan with id "+ currScanId +" was not found in scan display data list");
    }
}
