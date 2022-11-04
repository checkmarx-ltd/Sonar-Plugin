package com.checkmarx.sonar.sensor.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.logging.Logger;

/**
 * Created by: Zoharby.
 * Date: 14/06/2017.
 */
public class SastReportData {

    @JsonIgnore
    private
    Logger logger = Logger.getLogger(SastReportData.class.getName());

    @JsonProperty("scanStart")
    private String scanStart;
    @JsonProperty("scanFinish")
    private String scanFinish;

    @JsonProperty("numOfFiles")
    private long numOfFiles;
    @JsonProperty("numOfCodeLines")
    private long numOfCodeLines;

    @JsonProperty("viewerUri")
    private String viewerUri;

    public SastReportData() {
    }

    public String getScanStart() {
        return scanStart;
    }

    public void setScanStart(String scanStart) {
        this.scanStart = scanStart;
    }

    public String getScanFinish() {
        return scanFinish;
    }

    public void setScanFinish(String scanFinish) {
        this.scanFinish = scanFinish;
    }

    public long getNumOfFiles() {
        return numOfFiles;
    }

    public void setNumOfFiles(long numOfFiles) {
        this.numOfFiles = numOfFiles;
    }

    public long getNumOfCodeLines() {
        return numOfCodeLines;
    }

    public void setNumOfCodeLines(long numOfCodeLines) {
        this.numOfCodeLines = numOfCodeLines;
    }

    public String getViewerUri() {
        return viewerUri;
    }

    public void setViewerUri(String viewerUri) {
        this.viewerUri = viewerUri;
    }
}
