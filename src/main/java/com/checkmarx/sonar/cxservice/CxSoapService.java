package com.checkmarx.sonar.cxservice;

import com.checkmarx.sonar.cxservice.dto.CxFullCredentials;
import com.checkmarx.sonar.cxservice.exception.ConnectionException;
import com.raps.code.generate.ws.*;
import org.slf4j.Logger;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by: zoharby.
 * Date: 20/04/2017.
 */
abstract class CxSoapService {

    // Static constants
    private final static int WEBSERVICE_API_VERSION = 1;
    private final static String CXWSRESOLVER_PATH = "/cxwebinterface/cxwsresolver.asmx";
    private final static int LCID = 1033; // English


    CxSonarWebServiceSoap webServiceSoap;
    private volatile String currServerUrl;

    Logger logger;

    public CxSoapService(Logger logger) {
        this.logger = logger;
    }

    public String login(CxFullCredentials cxFullCredentials) throws ConnectionException {

        if( webServiceSoap == null || !cxFullCredentials.getServerUrl().equals(currServerUrl) ){
            currServerUrl = cxFullCredentials.getServerUrl();
            connect(currServerUrl);
        }

        Credentials credentials = new Credentials();
        credentials.setUser(cxFullCredentials.getUsername());
        credentials.setPass(cxFullCredentials.getPassword());
        CxWSResponseLoginData cxWSResponseLoginData;
        try {
            cxWSResponseLoginData = webServiceSoap.login(credentials, LCID);
        } catch (javax.xml.ws.WebServiceException e) {
            throw new ConnectionException(e);
        }
        if (!cxWSResponseLoginData.isIsSuccesfull()) {
            logger.error("Checkmarx server login error: " + cxWSResponseLoginData.getErrorMessage() + "\nuser: " + cxFullCredentials.getUsername());
            throw new ConnectionException(cxWSResponseLoginData.getErrorMessage());
        }
        String sessionId = cxWSResponseLoginData.getSessionId();
         if(sessionId == null){
             throw new ConnectionException("Web service did not return session id");
         }
        logger.info("Login successful, username: " + cxFullCredentials.getUsername());

        return sessionId;
    }


    private void connect(String serverUrl) throws ConnectionException {
        CxSSLUtility.disableSSLCertificateVerification();
        URL url = validateServerUrl(serverUrl);
        logger.info("Checkmarx server URL validated successfully: " + url);
        try {
            url = new URL(url.toString() + CXWSRESOLVER_PATH);
        } catch (MalformedURLException e) {
            logger.error(e.getLocalizedMessage(), e);
            throw new Error(e);
        }

        try {
            logger.info("sending url: "+ url + " to CxResolver.");
            CxWSResolver cxWSResolver = new CxWSResolver(url,  new QName("http://Checkmarx.com", "CxWSResolver"));
            CxWSResponseDiscovery cxWSResponseDiscovery = cxWSResolver.getCxWSResolverSoap().getWebServiceUrl(CxClientType.SONAR, WEBSERVICE_API_VERSION);
            if (!cxWSResponseDiscovery.isIsSuccesfull()) {
                logger.error("Resolver failed to resolve web service url. Resolver url: " + url + " message: \n" + cxWSResponseDiscovery.getErrorMessage());
                String errorMessage = cxWSResponseDiscovery.getErrorMessage();
                if (errorMessage.contains("SDLC"))
                    throw new ConnectionException(errorMessage);
                throw new ConnectionException("Checkmarx server did not respond properly. Make sure you have the latest version." + "\n" + errorMessage );
            }
            logger.info("Checkmarx Web Service URL resolved to: " + cxWSResponseDiscovery.getServiceURL());

            URL webServiceURL;
            try {
                webServiceURL = new URL(cxWSResponseDiscovery.getServiceURL());
            } catch (MalformedURLException e) {
                logger.error(e.getLocalizedMessage(), e);
                throw new Error(e);
            }

            CxSonarWebService cxPortalWebService = new CxSonarWebService(webServiceURL, new QName("http://Checkmarx.com", "CxSonarWebService"));
            webServiceSoap = cxPortalWebService.getCxSonarWebServiceSoap();

            if(webServiceSoap == null){
                throw new ConnectionException("Sonar Cx Soap service failed to initiate.");
            }
            logger.info("Connected to Checkmarx server at url: " + serverUrl);
        } catch (javax.xml.ws.WebServiceException e) {
            throw new ConnectionException(e.getMessage());
        }
    }


    private URL validateServerUrl(String serverUrl) throws ConnectionException {
        try {
            URL url = new URL(serverUrl);
            if (url.getPath().length() > 1) {
                String message = "Checkmarx server url must not contain path: " + serverUrl;
                logger.warn(message);
                throw new ConnectionException(message);
            }
            HttpURLConnection huc = null;
            try {
                huc = (HttpURLConnection) url.openConnection();
                //HEAD minimize loaded data
                huc.setRequestMethod("HEAD");
                huc.setConnectTimeout(7000);
                int responseCode = huc.getResponseCode();
                if (responseCode != 200) {
                    throw new ConnectionException("Could not connect to Server URL, response code: "+responseCode);
                }
            } catch (IOException e) {
                throw new ConnectionException("Could not access Server URL", e);
            }
            return url;

        } catch (MalformedURLException e) {
            if (e.getMessage().startsWith("no protocol:")) {
                String message = e.getLocalizedMessage() + ". Server URL syntax is: http(s)://servername/";
                logger.error(message);
                throw new ConnectionException(message, e);
            } else {
                logger.error(e.getLocalizedMessage());
                throw new ConnectionException(e);
            }
        }
    }

    public void closeConnection(String sessionId) throws ConnectionException {
        if(webServiceSoap != null && sessionId != null) {
            try {
                webServiceSoap.logout(sessionId);
            } catch (javax.xml.ws.WebServiceException e) {
                throw new ConnectionException(e);
            }
        }
        webServiceSoap = null;
    }
}
