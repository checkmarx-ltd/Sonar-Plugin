package com.checkmarx.sonar.cxportalservice.sast.sastnew.model;

/**
 * Created by: Zoharby.
 * Date: 23/07/2017.
 */
public class AllSastResults {

    private CxXMLResults cxXMLResults;
    private ScanResults scanResults;

    public AllSastResults(CxXMLResults cxXMLResults, ScanResults scanResults) {
        this.cxXMLResults = cxXMLResults;
        this.scanResults = scanResults;
    }

    public CxXMLResults getCxXMLResults() {
        return cxXMLResults;
    }

    public ScanResults getScanResults() {
        return scanResults;
    }
}
