package com.checkmarx.sonar.cxportalservice.osa;

import com.checkmarx.sonar.cxportalservice.osa.model.*;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.io.Closeable;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zoharby on 09/01/2017.
 */
public class OsaScanClient implements Closeable {

    private static final String ROOT_PATH = "CxRestAPI/";
    private static final String AUTHENTICATION_PATH = "auth/login";
    private static final String ANALYZE_SUMMARY_PATH = "osa/reports";
    private static final String LIBRARIES_PATH = "osa/libraries";
    private static final String CVEs_PATH = "osa/vulnerabilities";
    private static final String FAILED_TO_CONNECT_CX_SERVER_ERROR = "connection to checkmarx server failed";
    private static final String CX_COOKIE = "cxCookie";
    private static final String CSRF_COOKIE = "CXCSRFToken";
    private static final String ACCEPT_HEADER = "Accept";
    private static final String CX_ORIGIN_HEADER = "cxOrigin";
    private static final String CX_ORIGIN_VALUE = "Sonar";
    private static final String OSA_SCANS_PATH = "osa/scans";

    private static final int ITEMS_PER_PAGE = 10;

    private Logger logger = Loggers.get(OsaScanClient.class);

    private AuthenticationRequest authenticationRequest;
    private Client client;
    private WebTarget root;

    private ObjectMapper mapper = new ObjectMapper();

    private Map<String, NewCookie> cookies;

    public OsaScanClient(CxFullCredentials cxFullCredentials) {
        this.authenticationRequest = new AuthenticationRequest(cxFullCredentials.getCxUsername(), cxFullCredentials.getCxPassword());
        client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
        root = client.target(cxFullCredentials.getCxServerUrl().trim()).path(ROOT_PATH);
        cookies = login();
    }

    public Map<String, NewCookie> login() {
        Invocation invocation = root.path(AUTHENTICATION_PATH)
                .request()
                 .header(CX_ORIGIN_HEADER, CX_ORIGIN_VALUE)
                .buildPost(Entity.entity(authenticationRequest, MediaType.APPLICATION_JSON));
        logger.info("Authenticating client");
        Response response = invokeRequest(invocation);
        validateResponse(response, Response.Status.OK, "fail to perform login");

        return response.getCookies();
    }


    //returns the last finished scan, even if it failed todo ask liran
    public OsaScan getLastOsaScan(long projectId){
        logger.info("Sending request to get last osa scan.");
        Invocation invocation = getOsaScansInvocation(String.valueOf(projectId));
        Response response = invokeRequest(invocation);

        validateResponse(response, Response.Status.OK, "fail to get last osa scan data");

        CollectionType responseType = mapper.getTypeFactory().constructCollectionType(List.class, OsaScan.class);
        try {
            List<OsaScan> osaScanList = mapper.readValue(response.readEntity(String.class), responseType);
            for (OsaScan osaScan: osaScanList){
                //avoid from returning running scans
                if(isScanHaveDataToReturn(osaScan)){
                    return osaScan;
                }
            }
        } catch (IOException e) {
            throw new WebApplicationException(e.getMessage());
        }
        throw new WebApplicationException("No Osa scan to show");
    }


    public GetOpenSourceSummaryResponse getOpenSourceSummary(String scanId) throws WebApplicationException {
        logger.info("Sending request for open source summery.");
        Invocation invocation = getOsaSummeryRequestInvocation(scanId);
        Response response = invokeRequest(invocation);
        validateResponse(response, Response.Status.OK, "fail get OSA scan summary results");
        return response.readEntity(GetOpenSourceSummaryResponse.class);
    }

    public List<Library> getScanResultLibraries(String scanId) {
        List<Library> libraryList = new LinkedList<>();
        int lastListSize = ITEMS_PER_PAGE;
        int currentPage = 1;
        while (lastListSize == ITEMS_PER_PAGE) {
            Invocation invocation = getPageRequestInvocation(LIBRARIES_PATH, currentPage, scanId);
            logger.info("sending request for libraries page number " + currentPage);
            Response response = invokeRequest(invocation);
            validateResponse(response, Response.Status.OK, "fail get OSA scan libraries");
            try {
                List<Library> libraryPage = mapper.readValue(response.readEntity(String.class), new TypeReference<List<Library>>() {
                });
                if (libraryPage != null) {
                    libraryList.addAll(libraryPage);
                    lastListSize = libraryPage.size();
                } else {
                    break;
                }
            } catch (IOException e) {
                logger.error("failed to parse Libraries: "+e.getMessage(), e);
                lastListSize = 0;
            }
            ++currentPage;
        }
        return libraryList;
    }

    public List<CVE> getScanResultCVEs(String scanId) {
        List<CVE> cvesList = new LinkedList<>();
        int lastListSize = ITEMS_PER_PAGE;
        int currentPage = 1;
        while (lastListSize == ITEMS_PER_PAGE) {
            Invocation invocation = getPageRequestInvocation(CVEs_PATH, currentPage, scanId);
            logger.info("sending request for CVE's page number " + currentPage);
            Response response = invokeRequest(invocation);
            validateResponse(response, Response.Status.OK, "fail get OSA scan CVE's");
            try {
                List<CVE> cvePage = mapper.readValue(response.readEntity(String.class), new TypeReference<List<CVE>>() {
                });
                if (cvePage != null) {
                    lastListSize = cvePage.size();
                    cvesList.addAll(cvePage);
                } else {
                    break;
                }
            } catch (IOException e) {
                logger.error("failed to parse CVE's", e);
                lastListSize = 0;
            }
            ++currentPage;
        }
        return cvesList;
    }


    private Invocation getOsaSummeryRequestInvocation(String scanId) {
        return root.path(ANALYZE_SUMMARY_PATH).queryParam("scanId", scanId).request()
                .header(CX_ORIGIN_HEADER, CX_ORIGIN_VALUE)
                .cookie(cookies.get(CX_COOKIE))
                .header(ACCEPT_HEADER, MediaType.APPLICATION_JSON)
                .cookie(CSRF_COOKIE, cookies.get(CSRF_COOKIE).getValue())
                .header(CSRF_COOKIE, cookies.get(CSRF_COOKIE).getValue()).buildGet();
    }


    private Invocation getOsaScansInvocation(String projectId) {
        return root.path(OSA_SCANS_PATH).queryParam("projectId", projectId)
                .queryParam("page",1)
                .queryParam("itemPerPage",20)
                .request()
                .header(CX_ORIGIN_HEADER, CX_ORIGIN_VALUE)
                .cookie(cookies.get(CX_COOKIE))
                .header(ACCEPT_HEADER, MediaType.APPLICATION_JSON)
                .cookie(CSRF_COOKIE, cookies.get(CSRF_COOKIE).getValue())
                .header(CSRF_COOKIE, cookies.get(CSRF_COOKIE).getValue()).buildGet();
    }

    private Invocation getPageRequestInvocation(String path, int pageNumber, String scanId) {
        return root.path(path).queryParam("scanId", scanId)
                .queryParam("page", pageNumber).queryParam("itemsPerPage", 10).request()
                .header(CX_ORIGIN_HEADER, CX_ORIGIN_VALUE)
                .cookie(cookies.get(CX_COOKIE))
                .cookie(CSRF_COOKIE, cookies.get(CSRF_COOKIE).getValue())
                .header(CSRF_COOKIE, cookies.get(CSRF_COOKIE).getValue()).buildGet();
    }

    private Response invokeRequest(Invocation invocation) {
        try {
            return invocation.invoke();
        } catch (ProcessingException exc) {
            return ThrowFailedToConnectCxServerError();
        }
    }

    private boolean isScanHaveDataToReturn(OsaScan OsaScan) {
        ScanStatus scanStatus = ScanStatus.fromId(OsaScan.getState().getId());
        if(scanStatus == null){
            return false;
        }
        switch (scanStatus) {
            case NotStarted:
                return false;
            case InProgress:
                return false;
            case Finished:
                return true;
            case Failed:
                return true;
            default:
                return false;
        }
    }

    private void validateResponse(Response response, Response.Status expectedStatus, String message) throws WebApplicationException {
        if (response.getStatus() == Response.Status.SERVICE_UNAVAILABLE.getStatusCode())
            ThrowFailedToConnectCxServerError();
        if (response.getStatus() != expectedStatus.getStatusCode()) {
            throw new WebApplicationException(message + ": " + response.getStatusInfo().toString());
        }
    }

    private Response ThrowFailedToConnectCxServerError() {
        throw new WebApplicationException(FAILED_TO_CONNECT_CX_SERVER_ERROR);
    }

    @Override
    public void close() {
        client.close();
    }
}
