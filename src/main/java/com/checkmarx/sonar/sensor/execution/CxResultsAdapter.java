package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.logger.CxLogger;
import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.CxResultToSonarResult;
import com.checkmarx.sonar.sensor.dto.SastReportData;
import com.cx.restclient.sast.dto.CxXMLResults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by: zoharby.
 * Date: 30/07/2017.
 **/

public class CxResultsAdapter {

    private static CxLogger logger = new CxLogger(CxResultsAdapter.class);

    /*
     * Changes the hierarchy of Checkmarx results and maps it by files.
     * The purpose of the rearrangement is to simplify the process of matching Cx results with the projects filesystem,
     * as Sonar ScannerContext provides the filesystem.
     */
    public static CxReportToSonarReport adaptCxXmlResultsForSonar(CxXMLResults results){
        HashMap<String, List<CxResultToSonarResult>> resultHashMap = new HashMap<>();

        for (CxXMLResults.Query query : results.getQuery()){
            for (CxXMLResults.Query.Result result : query.getResult()){
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

    /**
     * Creates dto to be saves as Json in sonar DB.
     * The Json's contains data that needs to be presented in Checkmarx details report (at project> more> Checkmarx)
     * (is not presented as numeric metric in the measures page)
     */
    public static SastReportData adaptCxXmlResultsToCxDetailReport(CxXMLResults results, CxFullCredentials cxFullCredentials){
        SastReportData sastReportData = new SastReportData();
        if(results.getLinesOfCodeScanned() != null)
            sastReportData.setNumOfCodeLines(Long.valueOf(results.getLinesOfCodeScanned()));
        if(results.getFilesScanned() != null)
            sastReportData.setNumOfFiles(Long.valueOf(results.getFilesScanned()));
        setStartEndDateTime(sastReportData, results);
        String viewerUri = cxFullCredentials.getCxServerUrl() + "/CxWebClient/ViewerMain.aspx?scanId=" + results.getScanId() + "&ProjectID=" + results.getProjectId();
        sastReportData.setViewerUri(viewerUri);
        return sastReportData;
    }

    private static CxXMLResults.Query.Result.Path.PathNode retrieveNodeToMarkInResultFile(CxXMLResults.Query.Result result){
        List<CxXMLResults.Query.Result.Path.PathNode> nodes = result.getPath().getPathNode();
        for (int i = (nodes.size() - 1) ; i > -1 ; --i){
            CxXMLResults.Query.Result.Path.PathNode currNode = nodes.get(i);
            if(currNode.getFileName() != null && !"0".equals(currNode.getLine())){
                return currNode;
            }
        }
        return null;
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
