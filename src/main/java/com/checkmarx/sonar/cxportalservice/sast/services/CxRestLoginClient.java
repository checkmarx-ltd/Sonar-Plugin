package com.checkmarx.sonar.cxportalservice.sast.services;

import com.checkmarx.sonar.cxportalservice.sast.exception.CxRestLoginException;
import com.checkmarx.sonar.dto.CxFullCredentials;

public interface CxRestLoginClient {

    String login(CxFullCredentials cxFullCredentials) throws CxRestLoginException;
}