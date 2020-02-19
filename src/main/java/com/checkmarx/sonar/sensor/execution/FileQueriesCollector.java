package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.sensor.dto.FileQueries;
import com.checkmarx.sonar.sensor.dto.QueryData;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by: zoharby.
 * Date: 24/08/2017.
 */
public class FileQueriesCollector {

    private HashMap<String, Integer> highVulnerabilityQueries = new HashMap<>();
    private HashMap<String, Integer> mediumVulnerabilityQueries = new HashMap<>();
    private HashMap<String, Integer> lowVulnerabilityQueries = new HashMap<>();


    void addHighQuery(String queryName){
        if(highVulnerabilityQueries.get(queryName) != null){
            highVulnerabilityQueries.put(queryName, highVulnerabilityQueries.get(queryName) + 1);
        }else {
            highVulnerabilityQueries.put(queryName, 1);
        }
    }

    void addMediumQuery(String queryName){
        if(mediumVulnerabilityQueries.get(queryName) != null){
            mediumVulnerabilityQueries.put(queryName, mediumVulnerabilityQueries.get(queryName) + 1);
        }else {
            mediumVulnerabilityQueries.put(queryName, 1);
        }
    }

    void addLowQuery(String queryName){
        if(lowVulnerabilityQueries.get(queryName) != null){
            lowVulnerabilityQueries.put(queryName, lowVulnerabilityQueries.get(queryName) + 1);
        }else {
            lowVulnerabilityQueries.put(queryName, 1);
        }
    }

    public HashMap<String, Integer> getHighVulnerabilityQueries() {
        return highVulnerabilityQueries;
    }

    public HashMap<String, Integer> getMediumVulnerabilityQueries() {
        return mediumVulnerabilityQueries;
    }

    public HashMap<String, Integer> getLowVulnerabilityQueries() {
        return lowVulnerabilityQueries;
    }

    FileQueries getAsFileQueriesObject(){
        return new FileQueries(getAsQueryDataList(highVulnerabilityQueries), getAsQueryDataList(mediumVulnerabilityQueries), getAsQueryDataList(lowVulnerabilityQueries));
    }

    //changing from hashmap to querydata list to improve json readability in ui
    private List<QueryData> getAsQueryDataList(HashMap<String, Integer> vulnerabilityNonIssues){
        List<QueryData> toRet = new LinkedList<>();
        for (Object o : vulnerabilityNonIssues.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            toRet.add(new QueryData((String) pair.getKey(), (Integer) pair.getValue()));
        }
        return toRet;
    }
}
