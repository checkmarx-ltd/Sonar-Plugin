package com.checkmarx.sonar.sensor.dto;

import com.checkmarx.soap.client.CxWSQueryVulnerabilityData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public void setAllQueries(Map<CxWSQueryVulnerabilityData, Integer> queriesSummery){
        List<QueryData> high = new LinkedList<>();
        List<QueryData> low = new LinkedList<>();
        List<QueryData> medium = new LinkedList<>();
        for (Object o : queriesSummery.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            CxWSQueryVulnerabilityData currQuery = (CxWSQueryVulnerabilityData) pair.getKey();

            SastSeverity severity = SastSeverity.fromId(currQuery.getSeverity());
            if(severity == null){
                continue;
            }
            switch(severity){
                case SAST_HIGH: high.add(new QueryData(currQuery.getQueryName(), currQuery.getSeverity(), (Integer) pair.getValue()));
                    continue;
                case SAST_MEDIUM: medium.add(new QueryData(currQuery.getQueryName(), currQuery.getSeverity(), (Integer) pair.getValue()));
                    continue;
                case SAST_LOW: low.add(new QueryData(currQuery.getQueryName(), currQuery.getSeverity(), (Integer) pair.getValue()));
            }
        }
        setHighVulnerabilityQueries(high);
        setMediumVulnerabilityQueries(medium);
        setLowVulnerabilityQueries(low);
    }
}
