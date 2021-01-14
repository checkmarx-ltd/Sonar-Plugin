package com.checkmarx.sonar.web;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class HttpHelper {

    public static final String CX_PROXY_BYPASS = System.getProperty("  ");
    public static final String CX_HTTP_HOST = System.getProperty("cx.proxyHost");
    public static final String CX_HTTP_PORT = System.getProperty("cx.proxyPort");
    public static final String CX_HTTP_USERNAME = System.getProperty("cx.proxyUser");
    public static final String CX_HTTP_PASSWORD = System.getProperty("cx.proxyPassword");

    public static final String HTTP_HOST = System.getProperty("http.proxyHost");
    public static final String HTTP_PORT = System.getProperty("http.proxyPort");
    public static final String HTTP_USERNAME = System.getProperty("http.proxyUser");
    public static final String HTTP_PASSWORD = System.getProperty("http.proxyPassword");

    public static final String HTTPS_HOST = System.getProperty("https.proxyHost");
    public static final String HTTPS_PORT = System.getProperty("https.proxyPort");
    public static final String HTTPS_USERNAME = System.getProperty("https.proxyUser");
    public static final String HTTPS_PASSWORD = System.getProperty("https.proxyPassword");

    private static ProxyParams getCustomProxyParam() {
        ProxyParams params = null;
        if (isNotEmpty(CX_HTTP_HOST) && isNotEmpty(CX_HTTP_PORT)) {
            params = new ProxyParams(CX_HTTP_HOST, Integer.parseInt(CX_HTTP_PORT));
            if (isNotEmpty(CX_HTTP_USERNAME) && isNotEmpty(CX_HTTP_PASSWORD)) {
                params.setUser(CX_HTTP_USERNAME);
                params.setPssd(CX_HTTP_PASSWORD);
            }
        }

        return params;
    }

    private static ProxyParams getHttpProxyParam() {
        ProxyParams params = null;
        if (isNotEmpty(HTTPS_HOST) && isNotEmpty(HTTPS_PORT)) {
            params = new ProxyParams(HTTPS_HOST, Integer.parseInt(HTTPS_PORT));
            if (isNotEmpty(HTTPS_USERNAME) && isNotEmpty(HTTPS_PASSWORD)) {
                params.setUser(HTTPS_USERNAME);
                params.setPssd(HTTPS_PASSWORD);
            }
        } else if (isNotEmpty(HTTP_HOST) && isNotEmpty(HTTP_PORT)) {
            params = new ProxyParams(HTTP_HOST, Integer.parseInt(HTTP_PORT));
            if (isNotEmpty(HTTP_USERNAME) && isNotEmpty(HTTP_PASSWORD)) {
                params.setUser(HTTP_USERNAME);
                params.setPssd(HTTP_PASSWORD);
            }
        }

        return params;
    }

    public static ProxyParams getProxyParam() {
        if (CX_PROXY_BYPASS != null) {
            return null;
        }
        ProxyParams params = getCustomProxyParam();
        if (params == null) {
            params = getHttpProxyParam();
        }
        return params;
    }

    private static Proxy getCustomProxy() {
        Proxy proxy = null;
        Authenticator authenticator;
        if (isNotEmpty(CX_HTTP_HOST) && isNotEmpty(CX_HTTP_PORT)) {
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(CX_HTTP_HOST, Integer.parseInt(CX_HTTP_PORT)));
            if (isNotEmpty(CX_HTTP_USERNAME) && isNotEmpty(CX_HTTP_PASSWORD)) {
                authenticator = new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return (new PasswordAuthentication(CX_HTTP_USERNAME, CX_HTTP_PASSWORD.toCharArray()));
                    }
                };
                Authenticator.setDefault(authenticator);
            }
        }

        return proxy;
    }

    private static Proxy getHttpProxy() {
        Proxy proxy = null;
        Authenticator authenticator;
        if (isNotEmpty(HTTPS_HOST) && isNotEmpty(HTTPS_PORT)) {
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(HTTPS_HOST, Integer.parseInt(HTTPS_PORT)));
            if (isNotEmpty(HTTPS_USERNAME) && isNotEmpty(HTTPS_PASSWORD)) {
                authenticator = new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return (new PasswordAuthentication(HTTPS_USERNAME, HTTPS_PASSWORD.toCharArray()));
                    }
                };
                Authenticator.setDefault(authenticator);
            }
        } else if (isNotEmpty(HTTP_HOST) && isNotEmpty(HTTP_PORT)) {
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(HTTP_HOST, Integer.parseInt(HTTP_PORT)));
            if (isNotEmpty(HTTP_USERNAME) && isNotEmpty(HTTP_PASSWORD)) {
                authenticator = new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return (new PasswordAuthentication(HTTP_USERNAME, HTTP_PASSWORD.toCharArray()));
                    }
                };
                Authenticator.setDefault(authenticator);
            }
        }

        return proxy;
    }

    public static Proxy getProxy() {
        if (CX_PROXY_BYPASS != null) {
            return null;
        }
        Proxy proxy = getCustomProxy();
        if (proxy == null) {
            proxy = getHttpProxy();
        }
        return proxy;
    }

}
