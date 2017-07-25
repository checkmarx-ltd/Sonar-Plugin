package com.checkmarx.sonar.sensor.execution;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.measures.Metric;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import static com.checkmarx.sonar.measures.SastMetrics.*;

/**
 * Created by: zoharby.
 * Date: 20/06/2017.
 */
public class SastStageExecutor {

    private ObjectMapper mapper = new ObjectMapper();
    private Logger logger = Loggers.get(SastStageExecutor.class);

    public void execute(SensorContext context/*, SastScanData sastScanData*/){
        collectVulnerabilitiesAndSaveToMetrics(context/*, sastScanData*/);
        //collectReportDataAndSaveToMeasure(context, sastScanData);
    }

    private void collectVulnerabilitiesAndSaveToMetrics(SensorContext context/*, SastScanData sastScanData*/){
        FileSystem fs = context.fileSystem();
        Iterable<InputFile> mainfiles = fs.inputFiles(fs.predicates().hasType(InputFile.Type.MAIN));

        for (InputFile file : mainfiles) {

            if (!file.isEmpty() && file.isFile()) {
                String fileFullPath = file.absolutePath().replace("\\", "/");

                int highVulnerabilities = 0;
                int newHighVulnerabilities = 0;
                int mediumVulnerabilities = 0;
                int newMediumVulnerabilities = 0;
                int lowVulnerabilities = 0;
                int newLowVulnerabilities = 0;

           /*     for (CxWSSingleResultData result : sastScanData.getResults()) {
                    String resultFilePath = (result.getSourceFolder() + "/" + result.getSourceFile()).replace("\\", "/");

                    boolean isNew = result.getResultStatus().getValue().equals(CompareStatusType._New);

                    if (fileFullPath.contains(resultFilePath)) {

                        SastSeverity severity = SastSeverity.fromId(result.getSeverity());
                        if (severity == null) {
                            continue;
                        }

                        switch (severity) {
                            case SAST_HIGH:
                                ++highVulnerabilities;
                                if (isNew) {
                                    ++newHighVulnerabilities;
                                }
                                break;
                            case SAST_MEDIUM:
                                ++mediumVulnerabilities;
                                if (isNew) {
                                    ++newMediumVulnerabilities;
                                }
                                break;
                            case SAST_LOW:
                                ++lowVulnerabilities;
                                if (isNew) {
                                    ++newLowVulnerabilities;
                                }
                        }
                    }
                }*/
              try {
                  addSumVulnerabilitiesMetrics(context, file, new FileMetricsSummery(highVulnerabilities, mediumVulnerabilities, lowVulnerabilities));
                  addNewVulnerabilitiesMetrics(context, file, new FileMetricsSummery(newHighVulnerabilities, newMediumVulnerabilities, newLowVulnerabilities));
              }catch (Exception e){
                 String errMsg = "Error saving Checkmarx vulnerabilities to to file: "+file.absolutePath() +"\nError: "+e.getMessage() +
                                                                                            "\nPresented scan mesures and report might be incomplete.";
                  logger.error(errMsg);
                  context.newAnalysisError().onFile(file).message(errMsg);
              }
            }
        }
    }

    private class FileMetricsSummery{

        int high;
        int medium;
        int low;
        int sumVulnerabilities;

        FileMetricsSummery(int high, int medium, int low){
            this.high = high;
            this.medium = medium;
            this.low = low;
            this.sumVulnerabilities = this.high + this.medium + this.low;
        }
    }

    private void addSumVulnerabilitiesMetrics(SensorContext context, InputFile file, FileMetricsSummery fileMetricsSummery){
       if(fileMetricsSummery.sumVulnerabilities > 0) {
           addMetric(context, file, SAST_TOTAL_VULNERABILITIES, fileMetricsSummery.sumVulnerabilities);
           if (fileMetricsSummery.high != 0) {
               addMetric(context, file, SAST_HIGH_VULNERABILITIES, fileMetricsSummery.high);
           }
           if (fileMetricsSummery.medium != 0) {
               addMetric(context, file, SAST_MEDIUM_VULNERABILITIES, fileMetricsSummery.medium);
           }
           if (fileMetricsSummery.low != 0) {
               addMetric(context, file, SAST_LOW_VULNERABILITIES, fileMetricsSummery.low);
           }
       }
    }

    private void addNewVulnerabilitiesMetrics(SensorContext context, InputFile file, FileMetricsSummery fileMetricsSummery){
        if(fileMetricsSummery.sumVulnerabilities != 0 ) {
            addMetric(context, file, SAST_TOTAL_NEW_VULNERABILITIES, fileMetricsSummery.sumVulnerabilities);
            if(fileMetricsSummery.high != 0) {
                addMetric(context, file, SAST_NEW_HIGH_VULNERABILITIES, fileMetricsSummery.high);
            }
            if(fileMetricsSummery.medium != 0) {
                addMetric(context, file, SAST_NEW_MEDIUM_VULNERABILITIES, fileMetricsSummery.medium);
            }
            if(fileMetricsSummery.low != 0) {
                addMetric(context, file, SAST_NEW_LOW_VULNERABILITIES, fileMetricsSummery.low);
            }
        }
    }

    private void addMetric(final SensorContext context, final InputFile inputFile, final Metric<Integer> metric, int value) {
        context.<Integer> newMeasure().forMetric(metric).on(inputFile).withValue(value).save();
    }

  /*  private void collectReportDataAndSaveToMeasure(SensorContext context, SastScanData sastScanData){
        try {
            String scanDetails = createScanDetailsJson(sastScanData);
            context.<String>newMeasure().on(context.module()).forMetric(SAST_SCAN_DETAILS).withValue("\"" + scanDetails + "\"").save();
        }catch (Exception e){
            String errMsg = "Error while saving Checkmarx sast results to Sonar database: "+e.getMessage() +"\n Checkmarx report will not be presented.";
            logger.error(errMsg);
            context.newAnalysisError().message(errMsg).save();
        }
    }

    private String createScanDetailsJson(SastScanData sastScanData) throws JsonProcessingException {
        SastReportData reportData = createReportData(sastScanData);
        return mapper.writeValueAsString(reportData);
    }

    private SastReportData createReportData(SastScanData sastScanData){
        SastReportData reportData = new SastReportData();
       /* reportData.setNumOfCodeLines(sastScanData.getScanDisplayData().getLOC());
        reportData.setNumOfFiles(sastScanData.getScanSummary().getFilesCount());
        reportData.setAllQueries(sastScanData.getQueriesSummery());
        reportData.setScanStart(formatToDisplayDate(sastScanData.getScanDisplayData().getQueuedDateTime()));
        reportData.setScanFinish(formatToDisplayDate(sastScanData.getScanDisplayData().getFinishedDateTime()));*/
  /*      return reportData;
    }

    //from objects to form: "26/2/17 12:17"
    private String formatToDisplayDate(/*CxDateTime time) {
      //  return time.getDay()+"/"+(time.getMonth() < 10 ? "0"+time.getMonth() : time.getMonth())+"/"+String.valueOf(time.getYear()).substring(2)+" "
        //                                                         +time.getHour()+":"+ (time.getMinute() < 10 ? "0"+time.getMinute() : time.getMinute());
      /*  return "";
    }
*/
}
