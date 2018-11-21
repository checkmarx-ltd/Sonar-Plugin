package com.checkmarx.sonar.cxportalservice.sast.services;

import com.checkmarx.sonar.cxportalservice.sast.exception.CxRestLoginException;
import com.checkmarx.sonar.cxportalservice.sast.exception.CxValidateResponseException;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.logger.CxLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.sonar.api.internal.apachecommons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CxRestLoginClientImpl implements CxRestLoginClient {

    public static final String SCOPE_KEY = "scope";
    private static CxLogger logger = new CxLogger(CxRestLoginClientImpl.class);
    private static HttpClient client;
    private static List<Header> headers = new ArrayList<>();
    private static final String APPLICATION_NAME = "cxrestapi";
    private static final String IDENTITY_CONNECT_RESOURCE = "auth/identity/connect";
    private static final String TOKEN_LOGIN_RESOURCE = "token";
    private static final String CLIENT_ID_KEY = "client_id";
    private static final String CLIENT_VALUE = "resource_owner_client";
    private static final String CLIENT_SECRET_KEY = "client_secret";
    private static final String CLIENT_SECRET_VALUE = "014DF517-39D1-4453-B7B3-9930C563627C";
    private static final String PASS_KEY = "password";
    private static final String USERNAME_KEY = "username";
    private static final String ERROR_MESSAGE_PREFIX = "Failed to create body entity, due to: ";
    private static final String GRANT_TYPE_KEY = "grant_type";
    private static final String FAIL_TO_VALIDATE_TOKEN_RESPONSE_ERROR = " User authentication failed";

    public CxRestLoginClientImpl() {
        client = HttpClientBuilder.create().setDefaultHeaders(headers).build();
    }

    @Override
    public  String login(CxFullCredentials cxFullCredentials) throws CxRestLoginException {
        HttpUriRequest postRequest;
        HttpResponse loginResponse = null;
        try {
            postRequest = RequestBuilder.post()
                    .setUri(String.valueOf(getAccessTokenURL(new URL(cxFullCredentials.getCxServerUrl()))))
                    .setHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.toString())
                    .setEntity(createGetAccessTokenFromCredentialsParamsEntity(cxFullCredentials.getCxUsername(), cxFullCredentials.getCxPassword()))
                    .build();
            loginResponse = client.execute(postRequest);

            validateTokenResponse(loginResponse, 200, FAIL_TO_VALIDATE_TOKEN_RESPONSE_ERROR);
            RestGetAccessTokenDTO jsonResponse = parseJsonFromResponse(loginResponse, RestGetAccessTokenDTO.class);
            return jsonResponse.getAccessToken();
        } catch (IOException | CxValidateResponseException e) {
            logger.error("Fail to login with credentials: " + e.getMessage());
            throw new CxRestLoginException("Fail to login with credentials: " + e.getMessage());
        } finally {
            HttpClientUtils.closeQuietly(loginResponse);
        }
    }

    private static URL getAccessTokenURL(URL serverUrl) {
        try {
            return new URL(serverUrl, APPLICATION_NAME + "/" + IDENTITY_CONNECT_RESOURCE + "/" + TOKEN_LOGIN_RESOURCE);
        } catch (MalformedURLException e) {
            return serverUrl;
        }
    }

    private static StringEntity createGetAccessTokenFromCredentialsParamsEntity(String userName, String password) throws CxRestLoginException {
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(USERNAME_KEY, userName));
        urlParameters.add(new BasicNameValuePair(PASS_KEY, password));
        urlParameters.add(new BasicNameValuePair(GRANT_TYPE_KEY, PASS_KEY));
        urlParameters.add(new BasicNameValuePair(SCOPE_KEY, "sast_rest_api"));
        urlParameters.add(new BasicNameValuePair(CLIENT_ID_KEY, CLIENT_VALUE));
        urlParameters.add(new BasicNameValuePair(CLIENT_SECRET_KEY, CLIENT_SECRET_VALUE));

        try {
            return new UrlEncodedFormEntity(urlParameters, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new CxRestLoginException(ERROR_MESSAGE_PREFIX + e.getMessage());
        }
    }

    public static void validateTokenResponse(HttpResponse response, int status, String message) throws CxValidateResponseException {
        try {
            if (response.getStatusLine().getStatusCode() != status) {
                String responseBody = IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset());
                responseBody = responseBody.replace("{", "").replace("}", "").replace(System.getProperty("line.separator"), " ").replace("  ", "");
                if (responseBody.contains("<!DOCTYPE html>")) {
                    throw new CxValidateResponseException(message + ": " + "status code: 500. Error message: Internal Server Error");
                } else if (responseBody.contains("\"error\":\"invalid_grant\"")) {
                    throw new CxValidateResponseException(message);
                } else {
                    throw new CxValidateResponseException(message + ": " + "status code: " + response.getStatusLine() + ". Error message:" + responseBody);
                }
            }
        } catch (IOException e) {
            throw new CxValidateResponseException("Error parse REST response body: " + e.getMessage());
        }
    }

    public static <ResponseObj> ResponseObj parseJsonFromResponse(HttpResponse response, Class<ResponseObj> dtoClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(createStringFromResponse(response).toString(), dtoClass);
    }

    private static StringBuilder createStringFromResponse(HttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result;
    }
}