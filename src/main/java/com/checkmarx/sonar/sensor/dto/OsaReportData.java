package com.checkmarx.sonar.sensor.dto;

import com.checkmarx.sonar.cxportalservice.osa.model.CVE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 19/06/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OsaReportData {

    @JsonProperty("startAnalyzeTime")
    private String startAnalyzeTime;

    @JsonProperty("endAnalyzeTime")
    private String endAnalyzeTime;

    @JsonProperty("files")
    private int files;

    @JsonProperty("highVulnerabilityCves")
    private List<CVE> highVulnerabilityCves;

    @JsonProperty("mediumVulnerabilityCves")
    private List<CVE> mediumVulnerabilityCves;

    @JsonProperty("lowVulnerabilityCves")
    private List<CVE> lowVulnerabilityCves;


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

    public int getFiles() {
        return files;
    }

    public void setFiles(int files) {
        this.files = files;
    }

    public List<CVE> getHighVulnerabilityCves() {
        return highVulnerabilityCves;
    }

    public void setHighVulnerabilityCves(List<CVE> highVulnerabilityCves) {
        this.highVulnerabilityCves = highVulnerabilityCves;
    }

    public List<CVE> getMediumVulnerabilityCves() {
        return mediumVulnerabilityCves;
    }

    public void setMediumVulnerabilityCves(List<CVE> mediumVulnerabilityCves) {
        this.mediumVulnerabilityCves = mediumVulnerabilityCves;
    }

    public List<CVE> getLowVulnerabilityCves() {
        return lowVulnerabilityCves;
    }

    public void setLowVulnerabilityCves(List<CVE> lowVulnerabilityCves) {
        this.lowVulnerabilityCves = lowVulnerabilityCves;
    }

    public void setAllCves(List<CVE> cveList){
        List<CVE> high = new LinkedList<>();
        List<CVE> medium = new LinkedList<>();
        List<CVE> low = new LinkedList<>();

        for (CVE cve: cveList){
            OsaSeverity osaSeverity = OsaSeverity.fromId(cve.getSeverity().getId());
            if(osaSeverity == null){
                continue;
            }
            switch(osaSeverity){
                case OSA_HIGH: high.add(cve);
                    continue;
                case OSA_MEDIUM: medium.add(cve);
                    continue;
                case OSA_LOW: low.add(cve);
            }
        }

        setHighVulnerabilityCves(high);
        setMediumVulnerabilityCves(medium);
        setLowVulnerabilityCves(low);
    }

}
