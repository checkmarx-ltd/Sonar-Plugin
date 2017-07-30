package com.checkmarx.sonar.sensor;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;
import com.checkmarx.sonar.logger.CxLogger;
import com.checkmarx.sonar.sensor.dto.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by: zoharby.
 * Date: 30/07/2017.
 */
public class CxResultsAdapter {

    private static CxLogger logger = new CxLogger(CxResultsAdapter.class);

    public static CxReportToSonarReport adaptCxXmlResultsForSonar(CxXMLResults results){
        HashMap<String, List<CxResultToSonarResult>> resultHashMap = new HashMap<>();

        for (CxXMLResults.Query query : results.getQuery()){

            if("Info".equals(query.getSeverity())){
                continue;
            }

            for (CxXMLResults.Query.Result result : query.getResult()){
                SastSeverity severity = SastSeverity.fromId(query.getSeverityIndex());
                if (SastSeverity.SAST_INFO.equals(severity) || severity == null) {
                    continue;
                }

                CxXMLResults.Query.Result.Path.PathNode markNode = retrieveNodeToMarkInResultFile(result);

               if(markNode != null) {
                   List<CxResultToSonarResult> resultsForFile = resultHashMap.get(markNode.getFileName());

                   if(resultsForFile == null) {
                        resultsForFile = new LinkedList<>();
                        resultHashMap.put(markNode.getFileName(), resultsForFile);
                   }
                   resultsForFile.add(new CxResultToSonarResult(query, result, markNode));

               }else{
                    logger.error("Location was not found for query: " + query.getName() + ". Checkmarx results might be incomplete.");
               }
            }//results loop
        }//queries loop

        return new CxReportToSonarReport(resultHashMap);
    }

    public static SastReportData adaptCxXmlResultsToCxDetailReport(CxXMLResults results){
        SastReportData sastReportData = new SastReportData();
        setQueryDataListsToRepoerData(sastReportData, results.getQuery());
        sastReportData.setNumOfCodeLines(results.getLinesOfCodeScanned());
        sastReportData.setNumOfFiles(results.getFilesScanned());
        setStartEndDateTime(sastReportData, results);
        return sastReportData;
    }


    private static CxXMLResults.Query.Result.Path.PathNode retrieveNodeToMarkInResultFile(CxXMLResults.Query.Result result){
        List<CxXMLResults.Query.Result.Path.PathNode> nodes = result.getPath().getPathNode();
        for (int i = (nodes.size() - 1) ; i > -1 ; --i){
            CxXMLResults.Query.Result.Path.PathNode currNode = nodes.get(i);
            if(currNode.getFileName() != null && currNode.getLine() != null){
                return currNode;
            }
        }
        return null;
    }

    private static void setQueryDataListsToRepoerData(SastReportData sastReportData, List<CxXMLResults.Query> queries){
        List<QueryData> lowQueries = new LinkedList<>();
        List<QueryData> mediumQueries = new LinkedList<>();
        List<QueryData> highQueries = new LinkedList<>();
        for (CxXMLResults.Query query : queries){
            QueryData queryData = new QueryData(query.getName(), query.getResult().size());

            switch (query.getSeverity()){
                case "High": highQueries.add(queryData);
                    break;
                case "Medium": mediumQueries.add(queryData);
                    break;
                case "Low": lowQueries.add(queryData);
                    break;
            }

        }
        sastReportData.setHighVulnerabilityQueries(highQueries);
        sastReportData.setMediumVulnerabilityQueries(mediumQueries);
        sastReportData.setLowVulnerabilityQueries(lowQueries);
    }


    private static void setStartEndDateTime(SastReportData sastReportData, CxXMLResults results) {

        try {
            //turn strings to date objects
            Date scanStartDate = createStartDate(results.getScanStart());
            Date scanTimeDate = createTimeDate(results.getScanTime());
            Date scanEndDate = createEndDate(scanStartDate, scanTimeDate);

            //turn dates back to strings
            String scanStartDateFormatted = formatToDisplayDate(scanStartDate);
            String scanEndDateFormatted = formatToDisplayDate(scanEndDate);

            //set sast scan result object with formatted strings
            sastReportData.setScanStart(scanStartDateFormatted);
            sastReportData.setScanFinish(scanEndDateFormatted);

        } catch (ParseException e) {
            //logger.error("Scan dates in wrong format. Could not parse scan start and end dates and scan time");
        }

    }

    private static String formatToDisplayDate(Date date) {
        //"26/2/17 12:17"
        String displayDatePattern = "dd/MM/yy HH:mm";
        Locale locale = Locale.ENGLISH;

        return new SimpleDateFormat(displayDatePattern, locale).format(date);
    }

    private static Date createStartDate(String scanStart) throws ParseException {
        //"Sunday, February 26, 2017 12:17:09 PM"
        String oldPattern = "EEEE, MMMM dd, yyyy hh:mm:ss a";
        Locale locale = Locale.ENGLISH;

        DateFormat oldDateFormat = new SimpleDateFormat(oldPattern, locale);

        return oldDateFormat.parse(scanStart);
    }

    private static Date createTimeDate(String scanTime) throws ParseException {
        //"00h:00m:30s"
        String oldPattern = "HH'h':mm'm':ss's'";

        DateFormat oldTimeFormat = new SimpleDateFormat(oldPattern);
        oldTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        return oldTimeFormat.parse(scanTime);
    }

    private static Date createEndDate(Date scanStartDate, Date scanTimeDate) {
        long time /*no c*/ = scanStartDate.getTime() + scanTimeDate.getTime();
        return new Date(time);
    }
}
