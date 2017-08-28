package com.checkmarx.sonar.sensor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by: zoharby.
 * Date: 24/08/2017.
 */
public class FileQueries {

    @JsonProperty("highVulnerabilityQueries")
    private List<QueryData> highVulnerabilityQueries;
    @JsonProperty("mediumVulnerabilityQuries")
    private List<QueryData> mediumVulnerabilityQuries;
    @JsonProperty("lowVulnerabilityQueries")
    private List<QueryData> lowVulnerabilityQueries;

    public FileQueries() {
    }

    public FileQueries(List<QueryData> highVulnerabilityNonIssues, List<QueryData> mediumVulnerabilityNonIssues, List<QueryData> lowVulnerabilityNonIssues) {
        this.highVulnerabilityQueries = highVulnerabilityNonIssues;
        this.mediumVulnerabilityQuries = mediumVulnerabilityNonIssues;
        this.lowVulnerabilityQueries = lowVulnerabilityNonIssues;
    }

    public List<QueryData> getHighVulnerabilityQueries() {
        return highVulnerabilityQueries;
    }

    public void setHighVulnerabilityQueries(List<QueryData> highVulnerabilityQueries) {
        this.highVulnerabilityQueries = highVulnerabilityQueries;
    }

    public List<QueryData> getMediumVulnerabilityQuries() {
        return mediumVulnerabilityQuries;
    }

    public void setMediumVulnerabilityQuries(List<QueryData> mediumVulnerabilityQuries) {
        this.mediumVulnerabilityQuries = mediumVulnerabilityQuries;
    }

    public List<QueryData> getLowVulnerabilityQueries() {
        return lowVulnerabilityQueries;
    }

    public void setLowVulnerabilityQueries(List<QueryData> lowVulnerabilityQueries) {
        this.lowVulnerabilityQueries = lowVulnerabilityQueries;
    }
}
