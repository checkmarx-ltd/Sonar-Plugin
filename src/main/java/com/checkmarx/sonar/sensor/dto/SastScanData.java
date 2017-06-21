package com.checkmarx.sonar.sensor.dto;

import com.checkmarx.soap.client.*;

import java.util.List;
import java.util.Map;

/**
 * Created by: Zoharby.
 * Date: 25/05/2017.
 */
public class SastScanData {
    final private Map<CxWSQueryVulnerabilityData, Integer> queriesSummery;
    final private List<CxWSSingleResultData> results;
    final private CxWSResponseBasicScanData scanData;
    final private ProjectDisplayData projectDisplayData;
    final private ScanDisplayData scanDisplayData;
    final private CxWSResponseScanSummary scanSummary;

    public SastScanData(ProjectDisplayData projectDisplayData,
                        CxWSResponseBasicScanData scanData,
                        CxWSResponseScanSummary scanSummary,
                        Map<CxWSQueryVulnerabilityData, Integer> queries,
                        List<CxWSSingleResultData> results,
                        ScanDisplayData scansDisplayData) {
        this.projectDisplayData = projectDisplayData;
        this.scanData = scanData;
        this.queriesSummery = queries;
        this.results = results;
        this.scanSummary = scanSummary;
        this.scanDisplayData = scansDisplayData;
    }

    public Map<CxWSQueryVulnerabilityData, Integer> getQueriesSummery() {
        return queriesSummery;
    }

    public List<CxWSSingleResultData> getResults() {
        return results;
    }

    public CxWSResponseBasicScanData getScanData() {
        return scanData;
    }

    public CxWSResponseScanSummary getScanSummary() {
        return scanSummary;
    }

    public ProjectDisplayData getProjectDisplayData() {
        return projectDisplayData;
    }

    public ScanDisplayData getScanDisplayData() {
        return scanDisplayData;
    }
}