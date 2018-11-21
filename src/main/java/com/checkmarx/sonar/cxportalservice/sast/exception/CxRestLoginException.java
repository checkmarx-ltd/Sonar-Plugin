package com.checkmarx.sonar.cxportalservice.sast.exception;

public class CxRestLoginException extends  CxRestClientException{
    public CxRestLoginException() {
        super();
    }

    public CxRestLoginException(String message) {
        super(message);
    }

    public CxRestLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public CxRestLoginException(Throwable cause) {
        super(cause);
    }
}