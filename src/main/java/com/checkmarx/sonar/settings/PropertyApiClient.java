package com.checkmarx.sonar.settings;

import com.checkmarx.sonar.dto.RestEndpointContext;
import com.checkmarx.sonar.sensor.utils.CxConfigHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.sonar.api.batch.sensor.SensorContext;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Performs operations on Sonar properties using HTTP calls.
 */
// TODO: use for all the requests in CxConfigHelper.
public class PropertyApiClient {

    private SensorContext sensorContext;
    private RestEndpointContext endpointContext;
    private final Logger logger;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PropertyApiClient(SensorContext sensorContext, Logger logger) {
        this.sensorContext = sensorContext;
        this.logger = logger;
    }

    public PropertyApiClient(RestEndpointContext endpointContext, Logger logger) {
        this.endpointContext = endpointContext;
        this.logger = logger;
    }

    public String getProperty(String name) throws IOException {
        String requestUrl = CxConfigHelper.getPropertyUrl(getSonarBaseUrl(), name, getComponentKey());
        logger.debug("Getting property: {}", requestUrl);

        HttpUriRequest request = new HttpGet(requestUrl);

        String value;
        JsonNode root = null;
        try {
            HttpResponse response = getResponse(request);
            root = objectMapper.readTree(response.getEntity().getContent());
            value = root.at("/0/value").textValue();
        } catch (Exception e) {
            String msgVal = "";
            if (root != null && StringUtils.isEmpty(root.toString())) {
                msgVal = root.toString();
            }
            logger.error("Fail to get property from: " + requestUrl + ", Response value: " + msgVal);
            logger.debug("Fail to get property from: " + requestUrl + ", Response value: " + msgVal, e);
            return null;
        }
        return value;
    }

    public void setProperty(String name, String value) throws IOException {
        String requestUrl = String.format("%s/%s", getSonarBaseUrl(), CxConfigHelper.PROPERTIES_API_PATH);
        logger.info("Setting property: {} at {}", name, requestUrl);

        HttpPost request = new HttpPost(requestUrl);
        NameValuePair[] params = new NameValuePair[]{
                new BasicNameValuePair("id", name),
                new BasicNameValuePair("resource", getComponentKey()),
                new BasicNameValuePair("value", value),
        };
        UrlEncodedFormEntity body = new UrlEncodedFormEntity(Arrays.asList(params));
        request.setEntity(body);

        HttpResponse response = getResponse(request);
        throwOnFailure(response, name);
    }

    public void deleteProperty(String name) throws IOException {
        String requestUrl = CxConfigHelper.getPropertyUrl(getSonarBaseUrl(), name, getComponentKey());
        logger.info("Deleting property: {}", requestUrl);

        HttpUriRequest request = new HttpDelete(requestUrl);

        HttpResponse response = getResponse(request);
        throwOnFailure(response, name);
    }

    private String getComponentKey() {
        if (sensorContext != null) {
            return sensorContext.config().get(CxConfigHelper.SONAR_PROJECT_KEY).get();
        } else {
            return endpointContext.getComponentKey();
        }
    }

    private String getSonarBaseUrl() {
        if (sensorContext != null) {
            return sensorContext.config().get(CxConfigHelper.SONAR_HOST_URL).get();
        } else {
            return endpointContext.getSonarBaseUrl();
        }
    }

    private HttpResponse getResponse(HttpUriRequest request) throws IOException {
        CookieStore cookieStore = new BasicCookieStore();
        addAuthHeaders(request, cookieStore);

        HttpClient client = HttpClientBuilder.create()
                .setDefaultCookieStore(cookieStore)
                .build();

        return client.execute(request);
    }

    private void addAuthHeaders(HttpUriRequest request, CookieStore cookieStore) {
        try {
            if (sensorContext != null) {
                if (sensorContext.config().get(CxConfigHelper.SONAR_LOGIN_KEY).isPresent() &&
                        !sensorContext.config().get(CxConfigHelper.SONAR_PASSWORD_KEY).isPresent()) {
                    logger.info("Sonar server token is provided");
                    String auth = sensorContext.config().get(CxConfigHelper.SONAR_LOGIN_KEY).get() + ":";
                    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
                    String authHeader = "Basic " + new String(encodedAuth);
                    request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
                } else if (sensorContext.config().get(CxConfigHelper.SONAR_LOGIN_KEY).isPresent() &&
                        sensorContext.config().get(CxConfigHelper.SONAR_PASSWORD_KEY).isPresent()) {
                    logger.info("Sonar server credentials are provided");
                    String auth = sensorContext.config().get(CxConfigHelper.SONAR_LOGIN_KEY).get() + ":" + sensorContext.config().get(CxConfigHelper.SONAR_PASSWORD_KEY).get();
                    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
                    String authHeader = "Basic " + new String(encodedAuth);
                    request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
                }
            } else {
                if (endpointContext != null) {
                    request.setHeaders(endpointContext.getRequiredHeaders());
                    for (Cookie cookie : endpointContext.getRequiredCookies()) {
                        cookieStore.addCookie(cookie);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Fail to add authentication headers", e);
        }
    }

    private void throwOnFailure(HttpResponse response, String propertyName) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != Response.Status.NO_CONTENT.getStatusCode()) {
            throw new IOException(String.format("Error setting property: %s, HTTP status code: %d", propertyName, statusCode));
        }
    }

}
