package com.checkmarx.sonar.sensor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by: Zoharby.
 * Date: 14/06/2017.
 */
public class SastReportData {

    @JsonProperty("scanStart")
    private String scanStart;
    @JsonProperty("scanFinish")
    private String scanFinish;

    @JsonProperty("numOfFiles")
    private long numOfFiles;
    @JsonProperty("numOfCodeLines")
    private long numOfCodeLines;

    @JsonProperty("highVulnerabilityQueries")
    private List<QueryData> highVulnerabilityQueries;

    @JsonProperty("mediumVulnerabilityQueries")
    private List<QueryData> mediumVulnerabilityQueries;

    @JsonProperty("lowVulnerabilityQueries")
    private List<QueryData> lowVulnerabilityQueries;

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


    public List<QueryData> getHighVulnerabilityQueries() {
        return highVulnerabilityQueries;
    }

    public void setHighVulnerabilityQueries(List<QueryData> highVulnerabilityQueries) {
        this.highVulnerabilityQueries = highVulnerabilityQueries;
    }

    public List<QueryData> getMediumVulnerabilityQueries() {
        return mediumVulnerabilityQueries;
    }

    public void setMediumVulnerabilityQueries(List<QueryData> mediumVulnerabilityQueries) {
        this.mediumVulnerabilityQueries = mediumVulnerabilityQueries;
    }

    public List<QueryData> getLowVulnerabilityQueries() {
        return lowVulnerabilityQueries;
    }

    public void setLowVulnerabilityQueries(List<QueryData> lowVulnerabilityQueries) {
        this.lowVulnerabilityQueries = lowVulnerabilityQueries;
    }

    public String getViewerUri() {
        return viewerUri;
    }

    public void setViewerUri(String viewerUri) {
        this.viewerUri = viewerUri;
    }
}
