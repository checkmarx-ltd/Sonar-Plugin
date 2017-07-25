package com.checkmarx.sonar.cxportalservice.sast.sastnew.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by: Dorg.
 * Date: 15/09/2016.
 */
public class ScanResults {

    @JsonProperty("projectId")
    private long projectId;

    @JsonProperty("scanID")
    private long scanID;

    @JsonProperty("riskLevelScore")
    private int riskLevelScore;

    @JsonProperty("highSeverityResults")
    private int highSeverityResults;

    @JsonProperty("mediumSeverityResults")
    private int mediumSeverityResults;

    @JsonProperty("lowSeverityResults")
    private int lowSeverityResults;

    @JsonProperty("infoSeverityResults")
    private int infoSeverityResults;

    @JsonProperty("scanStart")
    private String scanStart;
    @JsonProperty("scanTime")
    private String scanTime;
    @JsonProperty("fileScanned")
    private String filesScanned;
    @JsonProperty("linesOfCodeScanned")
    private String linesOfCodeScanned;
    @JsonProperty("queryList")
    private List<CxXMLResults.Query> queryList;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getScanID() {
        return scanID;
    }

    public void setScanID(long scanID) {
        this.scanID = scanID;
    }

    public int getRiskLevelScore() {
        return riskLevelScore;
    }

    public void setRiskLevelScore(int riskLevelScore) {
        this.riskLevelScore = riskLevelScore;
    }

    public int getHighSeverityResults() {
        return highSeverityResults;
    }

    public void setHighSeverityResults(int highSeverityResults) {
        this.highSeverityResults = highSeverityResults;
    }

    public int getMediumSeverityResults() {
        return mediumSeverityResults;
    }

    public void setMediumSeverityResults(int mediumSeverityResults) {
        this.mediumSeverityResults = mediumSeverityResults;
    }

    public int getLowSeverityResults() {
        return lowSeverityResults;
    }

    public void setLowSeverityResults(int lowSeverityResults) {
        this.lowSeverityResults = lowSeverityResults;
    }

    public int getInfoSeverityResults() {
        return infoSeverityResults;
    }

    public void setInfoSeverityResults(int infoSeverityResults) {
        this.infoSeverityResults = infoSeverityResults;
    }

    public void setScanDetailedReport(CxXMLResults reportObj) {
        this.scanStart = reportObj.getScanStart();
        this.scanTime = reportObj.getScanTime();
        this.linesOfCodeScanned = reportObj.getLinesOfCodeScanned();
        this.filesScanned = reportObj.getFilesScanned();

        this.queryList = reportObj.getQuery();

    }

    public void setScanStart(String scanStart) {
        this.scanStart = scanStart;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getFilesScanned() {
        return filesScanned;
    }

    public void setFilesScanned(String filesScanned) {
        this.filesScanned = filesScanned;
    }

    public String getLinesOfCodeScanned() {
        return linesOfCodeScanned;
    }

    public void setLinesOfCodeScanned(String linesOfCodeScanned) {
        this.linesOfCodeScanned = linesOfCodeScanned;
    }

    public List<CxXMLResults.Query> getQueryList() {
        return queryList;
    }

    public void setQueryList(List<CxXMLResults.Query> queryList) {
        this.queryList = queryList;
    }

    public String getScanStart() {
        return scanStart;
    }
}
