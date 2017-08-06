package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;
import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.CxResultToSonarResult;
import com.checkmarx.sonar.sensor.dto.SastSeverity;
import com.checkmarx.sonar.settings.CxProperties;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.rule.ActiveRule;
import org.sonar.api.batch.rule.ActiveRules;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.batch.sensor.issue.internal.DefaultIssueLocation;
import org.sonar.api.measures.Metric;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.util.*;

import static com.checkmarx.sonar.measures.SastMetrics.*;

/**
 * Created by: zoharby.
 * Date: 20/06/2017.
 */
public class SastMeasuresCollector {

    private Logger logger = Loggers.get(SastMeasuresCollector.class);

    private ActiveRules activeRules;
    Iterable<InputFile> mainFiles;
    //assignment with a small number will generate zero (assignment with zero will generate 1min)
    private Double remediationEffortPerVulnerability = 0.000000001d;

    private FileMetricsCounter currFileSumVulnerabilityCounter;
    private FileMetricsCounter currFileNewVulnerabilityCounter;

    public void collectVulnerabilitiesAndSaveToMetrics(SensorContext context, CxReportToSonarReport cxReport) {
        init(context);
        for (InputFile file : mainFiles) {
            currFileSumVulnerabilityCounter = new FileMetricsCounter();
            currFileNewVulnerabilityCounter = new FileMetricsCounter();

            if (!file.isEmpty() && file.isFile()) {
                List<CxResultToSonarResult> resultsForCurrFile = CxSonarFilePathUtil.findResultsByFilePath(cxReport, file.absolutePath());
                if (resultsForCurrFile == null) {
                    continue;
                }

                for (CxResultToSonarResult result : resultsForCurrFile) {
                        ActiveRule rule = findRuleAndHandleErrors(activeRules, result.getQuery());
                        if (rule == null) {
                            continue;
                        }

                        List<NewIssueLocation> locations = new LinkedList<>();
                        int nodeLoopStartIdx = 0;

                        List<CxXMLResults.Query.Result.Path.PathNode> resultsNodes = result.getResultData().getPath().getPathNode();
                        if(!CxSonarFilePathUtil.isCxPathAndSonarPathEquals(resultsNodes.get(0).getFileName(), file.absolutePath())){
                            String msg = "Origin - file: " + resultsNodes.get(0).getFileName() + " line: " + resultsNodes.get(0).getLine();

                            for (CxXMLResults.Query.Result.Path.PathNode node : result.getResultData().getPath().getPathNode()){
                                 if(CxSonarFilePathUtil.isCxPathAndSonarPathEquals(node.getFileName(), file.absolutePath())){
                                     DefaultIssueLocation defaultIssueLocation = createLocationFromPathNode(file, node);
                                     if(defaultIssueLocation == null){
                                         continue;
                                     }
                                     nodeLoopStartIdx = resultsNodes.indexOf(node) + 1;
                                     locations.add(defaultIssueLocation.message(msg));
                                     break;
                                 }
                             }
                        }

                        int nodeLoopEndIdx = resultsNodes.size() - 1;
                        for (int i = nodeLoopStartIdx ; i < nodeLoopEndIdx ; ++i){
                            CxXMLResults.Query.Result.Path.PathNode currNode = resultsNodes.get(i);
                            DefaultIssueLocation defaultIssueLocation = createLocationFromPathNode(file, currNode);
                            if(defaultIssueLocation == null){
                                continue;
                            }
                            locations.add(defaultIssueLocation);
                        }

                        //DefaultIssueLocation defaultIssueLocation = createLocationFromPathNode(file, result.getNodeToMarkOnFile());
                        DefaultIssueLocation defaultIssueLocation = new DefaultIssueLocation();
                        context.newIssue()
                                .forRule(rule.ruleKey())
                                .gap(remediationEffortPerVulnerability)
                                .at(defaultIssueLocation.on(file)
                                .at(file.selectLine(result.getNodeToMarkOnFile().getLine()))
                                .message("Checkmarx Vulnerability : " + result.getQuery().getName()))
                                .addFlow(locations)
                                .save();

                        updateCurrFileVulnerabilities(result);
                    }//result loop
                }//if !file.isEmpty() && file.isFile())
                saveCxCustomMetrics(context, file);
            }//files loop
        }

    private void init(SensorContext context){
        mainFiles = getMainFiles(context);
        activeRules = context.activeRules();
        setRemediationEffortPerVulnerability(context);
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

        private void setRemediationEffortPerVulnerability(SensorContext context){
            String remediationEffortInSonarDb = context.settings().getString(CxProperties.CX_REMEDIATION_EFFORT);
            if((remediationEffortInSonarDb != null) && !remediationEffortInSonarDb.equals("0")){
                try {
                    remediationEffortPerVulnerability = Double.valueOf(remediationEffortInSonarDb);
                }catch (Exception ignored)
                {}
            }
        }

        private DefaultIssueLocation createLocationFromPathNode(InputFile file, CxXMLResults.Query.Result.Path.PathNode node){
            CodeHighlightsUtil.Highlight highlight = CodeHighlightsUtil.getHighlightForPathNode(node);
            if(highlight == null){
                return null;
            }
            DefaultIssueLocation defaultIssueLocation = new DefaultIssueLocation();
            return defaultIssueLocation.on(file)
                    .at(file.newRange(file.newPointer(highlight.getLine(), highlight.getStart()),
                            file.newPointer(highlight.getLine(), highlight.getEnd())));
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
                logger.info("Rule: " + ":checkmarx_" + query.getId() + "is not active or not existing. It will not appear in Checkmarx scan results.");
                logger.info("If rule exists in " + language.getSonarRuleRepository() + " rule repository, you can update it to your quality profile.");
            }

            return rule;
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
                addSumVulnerabilitiesMetrics(context, file);
                addNewVulnerabilitiesMetrics(context, file);
            } catch (Exception e) {
                String errMsg = "Error saving Checkmarx vulnerabilities to to file: " + file.absolutePath() + "\nError: " + e.getMessage() +
                        "\nPresented scan measures and report might be incomplete.";
                logger.error(errMsg);
                context.newAnalysisError().onFile(file).message(errMsg);
            }
        }


        private void addSumVulnerabilitiesMetrics(SensorContext context, InputFile file){
           if(currFileSumVulnerabilityCounter.getSumVulnerabilities() > 0) {
               addMetric(context, file, SAST_TOTAL_VULNERABILITIES, currFileSumVulnerabilityCounter.getSumVulnerabilities());
               if (currFileSumVulnerabilityCounter.getHigh() != 0) {
                   addMetric(context, file, SAST_HIGH_VULNERABILITIES, currFileSumVulnerabilityCounter.getHigh());
               }
               if (currFileSumVulnerabilityCounter.getMedium() != 0) {
                   addMetric(context, file, SAST_MEDIUM_VULNERABILITIES, currFileSumVulnerabilityCounter.getMedium());
               }
               if (currFileSumVulnerabilityCounter.getLow() != 0) {
                   addMetric(context, file, SAST_LOW_VULNERABILITIES, currFileSumVulnerabilityCounter.getLow());
               }
           }
        }

        private void addNewVulnerabilitiesMetrics(SensorContext context, InputFile file){
            if(currFileNewVulnerabilityCounter.getSumVulnerabilities() != 0 ) {
                addMetric(context, file, SAST_TOTAL_NEW_VULNERABILITIES, currFileNewVulnerabilityCounter.getSumVulnerabilities());
                if(currFileNewVulnerabilityCounter.getHigh() != 0) {
                    addMetric(context, file, SAST_NEW_HIGH_VULNERABILITIES, currFileNewVulnerabilityCounter.getHigh());
                }
                if(currFileNewVulnerabilityCounter.getMedium() != 0) {
                    addMetric(context, file, SAST_NEW_MEDIUM_VULNERABILITIES, currFileNewVulnerabilityCounter.getMedium());
                }
                if(currFileNewVulnerabilityCounter.getLow() != 0) {
                    addMetric(context, file, SAST_NEW_LOW_VULNERABILITIES, currFileNewVulnerabilityCounter.getLow());
                }
            }
        }

        private void addMetric(final SensorContext context, final InputFile inputFile, final Metric<Integer> metric, int value) {
            context.<Integer> newMeasure().forMetric(metric).on(inputFile).withValue(value).save();
        }
}
