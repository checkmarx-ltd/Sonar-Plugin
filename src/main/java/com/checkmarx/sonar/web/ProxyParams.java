package com.checkmarx.sonar.web;

public class ProxyParams {

    private String host;
    private int port;
    private String user;
    private String pssd;


    public ProxyParams(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public ProxyParams(String host, int port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pssd = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPssd() {
        return pssd;
    }

    public void setPssd(String pssd) {
        this.pssd = pssd;
    }

}
