package com.checkmarx.sonar.cxportalservice.sast.exception;

public class CxRestClientException extends Exception {
    public CxRestClientException() {
    }

    public CxRestClientException(String message) {
        super(message);
    }

    public CxRestClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public CxRestClientException(Throwable cause) {
        super(cause);
    }

    public CxRestClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}