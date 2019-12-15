package com.checkmarx.sonar.dto;

import org.apache.http.Header;
import org.apache.http.cookie.Cookie;

/**
 * Contains the data that is necessary to call Sonar Properties API in the context of the plugin webservice.
 */
public class RestEndpointContext {
    private String componentKey;
    private String sonarBaseUrl;

    // Required for authentication/authorization.
    private Cookie[] requiredCookies;
    private Header[] requiredHeaders;

    public String getComponentKey() {
        return componentKey;
    }

    public void setComponentKey(String componentKey) {
        this.componentKey = componentKey;
    }

    public String getSonarBaseUrl() {
        return sonarBaseUrl;
    }

    public void setSonarBaseUrl(String sonarBaseUrl) {
        this.sonarBaseUrl = sonarBaseUrl;
    }

    public Cookie[] getRequiredCookies() {
        return requiredCookies;
    }

    public void setRequiredCookies(Cookie[] requiredCookies) {
        this.requiredCookies = requiredCookies;
    }

    public Header[] getRequiredHeaders() {
        return requiredHeaders;
    }

    public void setRequiredHeaders(Header[] requiredHeaders) {
        this.requiredHeaders = requiredHeaders;
    }
}
