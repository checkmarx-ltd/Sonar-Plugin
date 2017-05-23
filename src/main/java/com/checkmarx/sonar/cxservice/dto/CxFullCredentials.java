package com.checkmarx.sonar.cxservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by: zoharby.
 * Date: 24/04/2017.
 */
public class CxFullCredentials {

    @JsonProperty("cxServerUrl")
    private String serverUrl;
    @JsonProperty("cxUsername")
    private String username;
    @JsonProperty("cxPassword")
    private String password;


    public CxFullCredentials() {
    }

    public CxFullCredentials(String cxServerUrl, String cxUser, String password) {
        this.serverUrl = cxServerUrl;
        this.username = cxUser;
        this.password = password;

    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CxFullCredentials)) return false;

        CxFullCredentials that = (CxFullCredentials) o;

        if (!getServerUrl().equals(that.getServerUrl())) return false;
        if (!getUsername().equals(that.getUsername())) return false;
        return getPassword().equals(that.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getServerUrl().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}

