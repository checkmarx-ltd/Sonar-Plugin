package com.checkmarx.sonar.cxportalservice.osa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.logging.Logger;

/**
 * Created by: zoharby.
 * Date: 18/06/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OsaScan {

    @JsonIgnore
    private
    Logger logger = Logger.getLogger(OsaScan.class.getName());

    @JsonProperty("id")
    private String id;

    @JsonProperty("startAnalyzeTime")
    private String startAnalyzeTime;

    @JsonProperty("endAnalyzeTime")
    private String endAnalyzeTime;

    @JsonProperty("state")
    private ScanState state;

    public OsaScan() {
        logger.info(" OsaScan empty constructor");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartAnalyzeTime() {
        return startAnalyzeTime;
    }

    public void setStartAnalyzeTime(String startAnalyzeTime) {
        this.startAnalyzeTime = startAnalyzeTime;
    }

    public String getEndAnalyzeTime() {
        return endAnalyzeTime;
    }

    public void setEndAnalyzeTime(String endAnalyzeTime) {
        this.endAnalyzeTime = endAnalyzeTime;
    }

    public ScanState getState() {
        return state;
    }

    public void setState(ScanState state) {
        this.state = state;
    }

}
