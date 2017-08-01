package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;
import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.CxResultToSonarResult;
import com.checkmarx.sonar.sensor.dto.SastSeverity;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.rule.ActiveRule;
import org.sonar.api.batch.rule.ActiveRules;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.internal.DefaultIssueLocation;
import org.sonar.api.measures.Metric;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static com.checkmarx.sonar.measures.SastMetrics.*;

/**
 * Created by: zoharby.
 * Date: 20/06/2017.
 */
public class SastMeasuresStageExecutor {

    private Logger logger = Loggers.get(SastMeasuresStageExecutor.class);

    private ActiveRules activeRules;

    private FileMetricsCounter currFileSumVulnerabilityCounter;
    private FileMetricsCounter currFileNewVulnerabilityCounter;

    public void execute(SensorContext context, CxReportToSonarReport cxReport){
        activeRules = context.activeRules();
        collectVulnerabilitiesAndSaveToMetrics(context, cxReport);
    }

    private void collectVulnerabilitiesAndSaveToMetrics(SensorContext context, CxReportToSonarReport cxReport) {
        Iterable<InputFile> mainFiles = getMainFiles(context);

        for (InputFile file : mainFiles) {
            currFileSumVulnerabilityCounter = new FileMetricsCounter();
            currFileNewVulnerabilityCounter = new FileMetricsCounter();

            if (!file.isEmpty() && file.isFile()) {
                List<CxResultToSonarResult> resultsForCurrFile = findResultsByFilePath(cxReport, file.absolutePath());

                if (resultsForCurrFile == null) {
                    continue;
                }

                for (CxResultToSonarResult result : resultsForCurrFile) {
                        ActiveRule rule = findRuleAndHandleErrors(activeRules, result.getQuery());
                        if (rule == null) {
                            continue;
                        }

                        DefaultIssueLocation defaultIssueLocation = new DefaultIssueLocation();
                        context.newIssue()
                                .forRule(rule.ruleKey())
                                .at(defaultIssueLocation.on(file)
                                .at(file.selectLine(result.getNodeToMarkOnFile().getLine()))
                                .message("Checkmarx Vulnerability : " + result.getQuery().getName()))
                                .save();

                        updateCurrFileVulnerabilities(result);
                    }
                }//if !file.isEmpty() && file.isFile())
                saveCxCustomMetrics(context, file);
            }//files loop
        }

        private List<CxResultToSonarResult> findResultsByFilePath(CxReportToSonarReport cxReport, String filePathFromSonar){
            //adjust for cx path pattern
            filePathFromSonar = filePathFromSonar.replace("\\", "/");

            List<CxResultToSonarResult> toRet = cxReport.getResultsMappedByFileDir().get(filePathFromSonar);

            //in a case where sonar and cx wrote the file directories from different starting point
            if(toRet == null)
                for (HashMap.Entry<String, List<CxResultToSonarResult>> entry : cxReport.getResultsMappedByFileDir().entrySet()) {
                    String filePathFromCx = entry.getKey();

                    if (filePathFromSonar.contains(filePathFromCx) || filePathFromCx.contains(filePathFromSonar)) {
                        toRet = entry.getValue();
                        break;
                    }
                }

            return toRet;
        }


        private Iterable<InputFile> getMainFiles(SensorContext context){
            FileSystem fs = context.fileSystem();
            if(fs == null){
                logger.error("File system was not provided.");
                return new ArrayList<>();
            }

            Iterable<InputFile> mainFiles = fs.inputFiles(fs.predicates().hasType(InputFile.Type.MAIN));
            if(mainFiles == null){
                logger.info("File system has no Main folder.");
                return new ArrayList<>();
            }
            return mainFiles;
        }

        private ActiveRule findRuleAndHandleErrors(ActiveRules activeRules, CxXMLResults.Query query){
            CXProgrammingLanguage language = CXProgrammingLanguage.fromLanguageName(query.getLanguage());
            if(language == null){
                logger.error("Unknown language: " + query.getLanguage() + "for query: " + query.getName());
                return null;
            }

            Collection<ActiveRule> rules = activeRules.findByRepository(language.getSonarRuleRepository());
            ActiveRule rule = null;
            for(ActiveRule currRule : rules) {
                if (currRule.ruleKey().rule().equals("checkmarx_" + query.getId())) {
                    rule = currRule;
                    break;
                }
            }

            if(rule == null){
                //todo ask liran - this or whildcard rule (info is still in order)
                logger.info("Rule: " + ":checkmarx_" + query.getId() + "is not active or not existing. It will not appear in Checkmarx scan results.");
                logger.info("If rule exists in " + language.getSonarRuleRepository() + " rule repository, you can update it to your quality profile.");
            }

            return rule;
        }

        private class FileMetricsCounter {
            int high = 0;
            int medium = 0;
            int low = 0;
            int sumVulnerabilities = 0;

            FileMetricsCounter() {
            }

            void incrementHigh() {
                ++ this.high;
                incrementSum();
            }

            void incrementMedium() {
                ++ this.medium;
                incrementSum();
            }

            void incrementLow() {
                ++this.low;
                incrementSum();
            }

            private void incrementSum() {
                ++ this.sumVulnerabilities;
            }
        }

        private void updateCurrFileVulnerabilities(CxResultToSonarResult result){
            SastSeverity severity = SastSeverity.fromId(result.getQuery().getSeverityIndex());
            if(severity == null){
                logger.error("Result for query " + result.getQuery().getName() + " has no severity. Checkmarx result may be incomplete.");
                return;
            }
            boolean isNew = "New".equals(result.getResultData().getStatus());

            switch (severity) {
                case SAST_HIGH:
                    currFileSumVulnerabilityCounter.incrementHigh();
                    if (isNew) {
                        currFileNewVulnerabilityCounter.incrementHigh();
                    }
                    break;
                case SAST_MEDIUM:
                    currFileSumVulnerabilityCounter.incrementMedium();
                    if (isNew) {
                        currFileNewVulnerabilityCounter.incrementMedium();
                    }
                    break;
                case SAST_LOW:
                    currFileSumVulnerabilityCounter.incrementLow();
                    if (isNew) {
                        currFileNewVulnerabilityCounter.incrementLow();
                    }
            }
        }

        private void saveCxCustomMetrics(SensorContext context, InputFile file){
            try {
                addSumVulnerabilitiesMetrics(context, file, currFileSumVulnerabilityCounter);
                addNewVulnerabilitiesMetrics(context, file, currFileNewVulnerabilityCounter);
            } catch (Exception e) {
                String errMsg = "Error saving Checkmarx vulnerabilities to to file: " + file.absolutePath() + "\nError: " + e.getMessage() +
                        "\nPresented scan measures and report might be incomplete.";
                logger.error(errMsg);
                context.newAnalysisError().onFile(file).message(errMsg);
            }
        }


        private void addSumVulnerabilitiesMetrics(SensorContext context, InputFile file, FileMetricsCounter fileMetricsSummery){
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

        private void addNewVulnerabilitiesMetrics(SensorContext context, InputFile file, FileMetricsCounter fileMetricsSummery){
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
}
