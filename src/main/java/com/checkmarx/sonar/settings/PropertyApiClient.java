package com.checkmarx.sonar.settings;

import com.checkmarx.sonar.dto.RestEndpointContext;
import com.checkmarx.sonar.sensor.utils.CxConfigHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
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
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.sonar.api.batch.sensor.SensorContext;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.checkmarx.sonar.web.HttpHelper.SONAR_URL_PARAM;

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

        String msgVal = "";
        JsonNode root = null;
        String value = null;
        try {
            HttpResponse response = getResponse(request);
            msgVal = IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset());

            root = objectMapper.readTree(msgVal);
            value = root.at("/settings/0/value").textValue();
        } catch (Exception e) {
            logger.error("Fail to get property from: " + requestUrl + ", Response value: " + msgVal, e);
        }
        return value;
    }

    private String getSonarUrl() {
        String url = StringUtils.isNotEmpty(System.getenv(SONAR_URL_PARAM)) ?
                System.getenv(SONAR_URL_PARAM) : System.getProperty(SONAR_URL_PARAM);

        return StringUtils.isNotEmpty(url) ? url.trim() : getSonarBaseUrl();
    }

    public void setProperty(String name, String value) throws IOException {
        String requestUrl = String.format("%s/%s", getSonarUrl(), CxConfigHelper.SETTINGS_API_SET_PATH);
        logger.info("Setting property: {} at {}", name, requestUrl);

        HttpPost request = new HttpPost(requestUrl);
        NameValuePair[] params = new NameValuePair[]{
                new BasicNameValuePair("component", getComponentKey()),
                new BasicNameValuePair("key", name),
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
        if (response.getStatusLine().getStatusCode() != Response.Status.NO_CONTENT.getStatusCode()) {
            requestUrl = CxConfigHelper.resetPropertyUrl(getSonarBaseUrl(), name, getComponentKey());
            response = getResponse(new HttpPost(requestUrl));
        }
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
            	if (sensorContext.config().get(CxConfigHelper.SONAR_TOKEN_KEY).isPresent()) {
                    logger.info("Sonar server token is provided in sonar.token");
                    String auth = sensorContext.config().get(CxConfigHelper.SONAR_TOKEN_KEY).get() + ":";
                    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
                    String authHeader = "Basic " + new String(encodedAuth);
                    request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
                }else if (sensorContext.config().get(CxConfigHelper.SONAR_LOGIN_KEY).isPresent() &&
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
                    String host = getSonarUrl();
                    try {
                        if (StringUtils.isNotEmpty(host)) {
                            host = new URL(getSonarUrl()).getHost();
                        }
                    } catch (Exception e) {
                        logger.error("Fail to set cookies host for override URL: " + host, e);
                    }

                    request.setHeaders(endpointContext.getRequiredHeaders());
                    for (Cookie cookie : endpointContext.getRequiredCookies()) {
                        if (StringUtils.isNotEmpty(host)) {
                            ((BasicClientCookie) cookie).setDomain(host);
                            logger.info("Updated cookie domain to: " + host);
                        }
                        cookieStore.addCookie(cookie);
                    }
                }
            }
            Map<String, String> userAgentHeader = getUserAgentHeader();
            for (Map.Entry<String, String> entry : userAgentHeader.entrySet()) {
                request.setHeader(entry.getKey(), entry.getValue());
            }
            
        } catch (Exception e) {
            logger.error("Fail to add authentication headers", e);
        }
    }
    
    private String getUserAgentValue() {
    	   return "plugin_name=" + cxOrigin + ";plugin_version=" + cxVersion.getVersion();
    	}
    	private Map<String, String> getUserAgentHeader() {
    	   Map<String, String> headers = new HashMap<>();
    	   if (this.cxOrigin != null && !this.cxOrigin.isEmpty() && this.cxVersion != null) {
    	       headers.put("User-Agent", getUserAgentValue());
    	   }
    	   return headers;
    	}

    private void throwOnFailure(HttpResponse response, String propertyName) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        logger.info("Response code for '" + propertyName + "': " + statusCode);
        if (statusCode != Response.Status.NO_CONTENT.getStatusCode()) {
            throw new IOException(String.format("Error setting property: %s, HTTP status code: %d", propertyName, statusCode));
        }
    }

}
