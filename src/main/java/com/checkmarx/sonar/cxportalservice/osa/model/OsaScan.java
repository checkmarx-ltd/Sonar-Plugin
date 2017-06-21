package com.checkmarx.sonar.cxportalservice.osa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by: zoharby.
 * Date: 18/06/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OsaScan {

    public OsaScan() {
    }

    @JsonProperty("id")
    private String id;

    @JsonProperty("startAnalyzeTime")
    private String startAnalyzeTime;

    @JsonProperty("endAnalyzeTime")
    private String endAnalyzeTime;

    @JsonProperty("state")
    private ScanState state;

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
