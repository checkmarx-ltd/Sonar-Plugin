package com.checkmarx.sonar.sensor.dto;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;

/**
 * Created by: zoharby.
 * Date: 30/07/2017.
 */
public class CxResultToSonarResult {

    private CxXMLResults.Query query;

    private CxXMLResults.Query.Result resultData;

    private CxXMLResults.Query.Result.Path.PathNode nodeToMarkOnFile;

    public CxResultToSonarResult(CxXMLResults.Query query, CxXMLResults.Query.Result resultData, CxXMLResults.Query.Result.Path.PathNode nodeToMarkOnFile) {
        this.query = query;
        this.resultData = resultData;
        this.nodeToMarkOnFile = nodeToMarkOnFile;
    }

    public CxXMLResults.Query getQuery() {
        return query;
    }

    public CxXMLResults.Query.Result getResultData() {
        return resultData;
    }

    public CxXMLResults.Query.Result.Path.PathNode getNodeToMarkOnFile() {
        return nodeToMarkOnFile;
    }
}
