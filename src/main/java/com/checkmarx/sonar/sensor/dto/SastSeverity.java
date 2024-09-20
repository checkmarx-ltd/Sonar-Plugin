package com.checkmarx.sonar.sensor.dto;

//import org.sonar.api.batch.rule.Severity;
import org.sonar.api.*;
//import org.sonar.api.issue.impact.Severity;

import com.cx.restclient.dto.scansummary.Severity;
//import org.sonar.api.issue.impact.Severity;
//import org.sonar.api.issue.impact.Severity;

/**
 * Created by: zoharby.
 * Date: 20/06/2017.
 */
public enum SastSeverity {

    SAST_HIGH(3, "High", Severity.CRITICAL),
    SAST_MEDIUM(2, "Medium", Severity.MEDIUM),
    SAST_LOW(1, "Low", Severity.LOW),
    SAST_INFO(0, "Info", Severity.NONE);

    int value;
    String cxName;
    Severity severity;

    SastSeverity(int value, String cxName, Severity severity) {
        this.value = value;
        this.cxName = cxName;
        this.severity = severity;
    }

    public int getValue() {
        return value;
    }

    public String getCxName() {
        return cxName;
    }

    public Severity getSonarSeverity() {
        return severity;
    }

    public static SastSeverity fromId(int id){
        for (SastSeverity type : SastSeverity.values()) {
            if (type.getValue() == id) {
                return type;
            }
        }
        return null;
    }

    public static SastSeverity fromName(String name){
        for (SastSeverity type : SastSeverity.values()) {
            if (type.getCxName().equals(name)) {
                return type;
            }
        }
        return null;
    }

}
