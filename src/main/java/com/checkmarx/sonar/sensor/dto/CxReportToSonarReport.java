package com.checkmarx.sonar.sensor.dto;

import java.util.HashMap;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 30/07/2017.
 *
 * This Class is a translation of Cx results to sonar hierarchy
 */
public class CxReportToSonarReport {

    private HashMap<String, List<CxResultToSonarResult>> resultsMappedByFileDir = new HashMap<>();

    public CxReportToSonarReport(HashMap<String, List<CxResultToSonarResult>> allResults) {
        this.resultsMappedByFileDir = allResults;
    }

    public HashMap<String, List<CxResultToSonarResult>> getResultsMappedByFileDir() {
        return resultsMappedByFileDir;
    }
}
