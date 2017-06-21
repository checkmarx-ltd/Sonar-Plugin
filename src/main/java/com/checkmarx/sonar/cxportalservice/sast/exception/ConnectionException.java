package com.checkmarx.sonar.cxportalservice.sast.exception;

import java.io.IOException;

/**
 * Created by: zoharby.
 * Date: 25/04/2017.
 */
public class ConnectionException extends IOException {

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(String userVisibleMessage) {
        super(userVisibleMessage);
    }

    public ConnectionException(Exception e){
        super(e);
    }

}
