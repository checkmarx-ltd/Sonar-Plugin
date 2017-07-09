package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.cxportalservice.osa.OsaScanClient;
import com.checkmarx.sonar.cxportalservice.osa.model.*;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.dto.OsaReportData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.measures.Metric;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.checkmarx.sonar.measures.OsaMetrics.*;

/**
 * Created by: zoharby.
 * Date: 19/06/2017.
 */
public class OsaStageExecutor {

    private OsaScanClient osaScanClient;
    private ObjectMapper mapper = new ObjectMapper();

    private Logger logger = Loggers.get(OsaStageExecutor.class);

    public void execute(SensorContext context, CxFullCredentials cxFullCredentials, long projectId){
        logger.info("Extracting Checkmarx Osa results.");

        OsaLatestScansData osaLatestScansData = null;
        OsaScan lastOsaScan = null;
        GetOpenSourceSummaryResponse openSourceSummaryResponse = null;

        try {
            osaScanClient = new OsaScanClient(cxFullCredentials);
            osaLatestScansData = osaScanClient.getLastOsaScan(projectId);
            lastOsaScan = osaLatestScansData.getLastSuccessfulOsaScan();
            openSourceSummaryResponse = osaScanClient.getOpenSourceSummary(String.valueOf(lastOsaScan.getId()));
        }catch (Exception e){
            String errMsg = "Error while extracting Checkmarx OSA results from server: "+e.getMessage() +"\n Checkmarx Osa measures and report will not be presented.";
            logger.error(errMsg);
            context.newAnalysisError().message(errMsg).save();
            return;
        }
        try {
            addScanStatusToMeasure(context, osaLatestScansData.isLastScanSuccessful());
            addVulnerabilitiesToMetrics(context, openSourceSummaryResponse);
        }catch (Exception e){
            String errMsg = "Error while Checkmarx OSA results to Sonar database: "+e.getMessage() +"\n Checkmarx Osa measures and report will not be presented.";
            logger.error(errMsg);
            context.newAnalysisError().message(errMsg).save();
            return;
        }

        try {
            String osaDetailsJson = createOsaDetailsJson(osaLatestScansData, openSourceSummaryResponse);
            addReportDataToMeasure(context, osaDetailsJson);
        }catch (Exception e){
            String errMsg = "Error while saving Checkmarx OSA results to Sonar database: "+e.getMessage() +"\n Checkmarx report will not be presented.";
            logger.error(errMsg);
            context.newAnalysisError().message(errMsg).save();
        }
        osaScanClient.close();
    }

    private void addVulnerabilitiesToMetrics(SensorContext context, GetOpenSourceSummaryResponse openSourceSummaryResponse){
        addMetric(context, OSA_HIGH_VULNERABILITIES, openSourceSummaryResponse.getHighCount());
        addMetric(context,  OSA_MEDIUM_VULNERABILITIES, openSourceSummaryResponse.getMediumCount());
        addMetric(context,OSA_LOW_VULNERABILITIES, openSourceSummaryResponse.getLowCount());
        addMetric(context, OSA_TOTAL_VULNERABILITIES, openSourceSummaryResponse.getHighCount() +
                openSourceSummaryResponse.getMediumCount() + openSourceSummaryResponse.getLowCount());
    }

    private void addMetric(final SensorContext context, final Metric<Integer> metric, int value) {
        context.<Integer> newMeasure().forMetric(metric).on(context.module()).withValue(value).save();
    }

    private String createOsaDetailsJson(OsaLatestScansData lastOsaScanData, GetOpenSourceSummaryResponse openSourceSummaryResponse){

        OsaScan lastOsaScan = lastOsaScanData.getLastSuccessfulOsaScan();

        List<CVE> cves = getCompleteCves(lastOsaScan);

        String scanStart = "";
        String scanEnd = "";
        try {
            scanStart = formatScanDate(lastOsaScan.getStartAnalyzeTime());
            scanEnd = formatScanDate(lastOsaScan.getEndAnalyzeTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        OsaReportData osaReportData = new OsaReportData();
        osaReportData.setStartAnalyzeTime(scanStart);
        osaReportData.setEndAnalyzeTime(scanEnd);
        osaReportData.setAllCves(cves);
        osaReportData.setFiles(openSourceSummaryResponse.getTotalLibreries());
        osaReportData.setFailureMsg(lastOsaScanData.getFailureMsg());

        try {
            return mapper.writeValueAsString(osaReportData);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private List<CVE> getCompleteCves(OsaScan osaScan){
        List<CVE> cves = osaScanClient.getScanResultCVEs(osaScan.getId());

        List<Library> libraries = osaScanClient.getScanResultLibraries(osaScan.getId());
        setCVEsLibraryName(cves, libraries);

        formatCVEsDates(cves);

        return cves;
    }

    private void setCVEsLibraryName(List<CVE> cveList, List<Library> libraryList){
        for(CVE cve:cveList){
            String libraryName = getLibraryNameFromList(cve.getLibraryId(),libraryList);
            cve.setLibraryName(libraryName);
        }
    }

    private String getLibraryNameFromList(String libraryId, List<Library> libraryList){
        for (Library library:libraryList){
            if(library.getId().equals(libraryId)){
                return library.getName();
            }
        }
        return null;
    }

    private void formatCVEsDates(List<CVE> cveList){
        for (CVE cve: cveList){
            String[] timeParts = cve.getPublishDate().split("T");
            String[] partsOfTimePart = timeParts[0].split("-");
            String metricSimpleTime = partsOfTimePart[2]+"-"+partsOfTimePart[1]+"-"+partsOfTimePart[0];
            cve.setPublishDate(metricSimpleTime);
        }
    }

    //from "2017-06-15T10:50:35" to "15/06/17 10:50"
    private String formatScanDate(String dateToFormat) throws ParseException {
        String oldPattern = "yyyy-mm-dd'T'hh:mm:ss";
        Locale locale = Locale.ENGLISH;
        DateFormat oldDateFormat = new SimpleDateFormat(oldPattern, locale);
        Date date = oldDateFormat.parse(dateToFormat);

        String displayDatePattern = "dd/MM/yy HH:mm";
        return new SimpleDateFormat(displayDatePattern, locale).format(date);
    }

    private void addReportDataToMeasure(SensorContext context, String osaDetailsJson){
        context.<String> newMeasure().on(context.module()).forMetric(OSA_SCAN_DETAILS).withValue( "\""+osaDetailsJson+"\"").save();
    }

    private void addScanStatusToMeasure(SensorContext context, Boolean isSuccess){
        context.<String> newMeasure().on(context.module()).forMetric(OSA_LAST_SCAN_STATUS).withValue(LastOsaScanStatus.fromBoolean(isSuccess).getPresentationValue()).save();
    }
}
