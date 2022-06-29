package com.checkmarx.sonar.sensor.execution;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import com.checkmarx.sonar.logger.CxLogger;
import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.CxResultToSonarResult;
import com.checkmarx.sonar.sensor.dto.FileQueries;
import com.checkmarx.sonar.sensor.dto.SastSeverity;
import com.checkmarx.sonar.settings.CxProperties;
import com.cx.restclient.sast.dto.CxXMLResults;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.rule.ActiveRule;
import org.sonar.api.batch.rule.ActiveRules;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.batch.sensor.issue.internal.DefaultIssueLocation;
import org.sonar.api.measures.Metric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static com.checkmarx.sonar.measures.SastMetrics.*;

/**
 * Created by: zoharby.
 * Date: 20/06/2017.
 */
public class SastResultsCollector {

    private CxLogger logger = new CxLogger(SastResultsCollector.class);
    private ObjectMapper mapper = new ObjectMapper();

    private ActiveRules activeRules;
    private Iterable<InputFile> mainFiles;
    //assignment with a small number will generate zero (assignment with zero will generate 1min)
    private Double remediationEffortPerVulnerability = 0.000000001d;

    private FileMetricsCounter currFileSumVulnerabilityCounter;
    private FileMetricsCounter currFileNewVulnerabilityCounter;
    private FileQueriesCollector currFileQueriesCollector;

    public void collectVulnerabilitiesAndSaveToMetrics(SensorContext context, CxReportToSonarReport cxReport) {
        init(context);
        int mainFileSize = 0;
        for (InputFile file : mainFiles) {
            mainFileSize++;
            currFileSumVulnerabilityCounter = new FileMetricsCounter();
            currFileNewVulnerabilityCounter = new FileMetricsCounter();
            currFileQueriesCollector = new FileQueriesCollector();

            FileIssueLocationsCreator fileLocationsCreator = new FileIssueLocationsCreator(file);

            if (!file.isEmpty() && file.isFile()) {
                List<CxResultToSonarResult> resultsForCurrFile = CxSonarFilePathUtil.findResultsByFilePath(cxReport, file.toString());
                if (resultsForCurrFile == null) {
                    //logger.debug("[CHECKMARX] No results for current file: " + file.toString());
                    continue;
                }

                for (CxResultToSonarResult result : resultsForCurrFile) {

                    ActiveRule rule = findRuleAndHandleErrors(activeRules, result.getQuery());
                    SastSeverity sastSeverity = getSastSeverity(result);
                    if (!checkValidity(result, rule, sastSeverity)) {
                        //logger.debug("[CHECKMARX] Result failed validity check");
                        continue;
                    }

                    List<NewIssueLocation> flowLocationsInFile = fileLocationsCreator.createFlowLocations(result);
                    DefaultIssueLocation issueLocation = fileLocationsCreator.createIssueLocation(result);
                    HashMap <String,String> states = getMappingStates();
                    context.newIssue()
                            .forRule(rule.ruleKey())
                            .overrideSeverity(sastSeverity.getSonarSeverity())
                            .gap(remediationEffortPerVulnerability)
                            .at(issueLocation)
                            .addFlow(flowLocationsInFile)
                            .newLocation(states)
                            .save();

                    updateCurrFileVulnerabilities(result);
                    updateQueryToCurrFile(result);
                }//result loop
            } else {
                logger.warn("File '" + file.toString() + "' is empty or not file type");
            }
            //if !file.isEmpty() && file.isFile())
            saveCxCustomMetrics(context, file);
            saveCxQueriesMeasure(context, file);
        }//files loop
        logger.info("[CHECKMARX] Main files size: " + mainFileSize);
    }

    private boolean checkValidity(CxResultToSonarResult result, ActiveRule rule, SastSeverity sastSeverity) {
        if ("1".equals(result.getResultData().getState())) {
            //logger.info("[CHECKMARX] FAILED due: Result state equal '1'");
            //continue if result state is "Not Exploitable"
            return false;
        }

        if (rule == null) {
            //logger.info("[CHECKMARX] FAILED due: Result is null");
            return false;
        }

        if (SastSeverity.SAST_INFO.equals(sastSeverity) || sastSeverity == null) {
            //logger.info("[CHECKMARX] FAILED due: SAST severity is " + sastSeverity);
            return false;
        }

        return true;
    }

    private void init(SensorContext context) {
        mainFiles = getMainFiles(context);
        activeRules = context.activeRules();
        setRemediationEffortPerVulnerability(context);
        //logger.info("[CHECKMARX] Initiated SAST results collector");
    }


    private Iterable<InputFile> getMainFiles(SensorContext context) {
        FileSystem fs = context.fileSystem();
        if (fs == null) {
            logger.error("File system was not provided.");
            return new ArrayList<>();
        }

        Iterable<InputFile> mainFiles = fs.inputFiles(fs.predicates().hasType(InputFile.Type.MAIN));
        if (mainFiles == null) {
            logger.info("File system has no Main folder.");
            return new ArrayList<>();
        }
        return mainFiles;
    }

    private SastSeverity getSastSeverity(CxResultToSonarResult result) {
        SastSeverity sastSeverity = SastSeverity.fromName(result.getResultData().getSeverity());
        if (sastSeverity == null) {
            int index = result.getQuery().getSeverityIndex() != null ? Integer.valueOf(result.getQuery().getSeverityIndex()) : null;
            sastSeverity = SastSeverity.fromId(index);
        }
        return sastSeverity;
    }


    private void setRemediationEffortPerVulnerability(SensorContext context) {
        String remediationEffortInSonarDb = context.config().get(CxProperties.CX_REMEDIATION_EFFORT).orElse(null);
        if ((remediationEffortInSonarDb != null) && !remediationEffortInSonarDb.equals("0")) {
            try {
                remediationEffortPerVulnerability = Double.valueOf(remediationEffortInSonarDb);
            } catch (Exception e) {
                logger.error("Failed to set remediation effort, error: " + e.getMessage());
            }
        }
    }


    private ActiveRule findRuleAndHandleErrors(ActiveRules activeRules, CxXMLResults.Query query) {
        CXProgrammingLanguage language = CXProgrammingLanguage.fromLanguageName(query.getLanguage());
        if (language == null) {
            logger.error("Unknown language: " + query.getLanguage() + "for query: " + query.getName());
            return null;
        }

        Collection<ActiveRule> rules = activeRules.findByRepository(language.getSonarRuleRepository());
        ActiveRule rule = null;
        for (ActiveRule currRule : rules) {
            if (currRule.ruleKey().rule().equals("checkmarx_" + query.getId())) {
                rule = currRule;
                break;
            }
        }

        if (rule == null) {
            logger.info("Rule: " + "checkmarx_" + query.getId() + " is not active or not existing. It will not appear in Checkmarx scan results.");
            logger.info("If rule exists in " + language.getSonarRuleRepository() + " rule repository, you can update it to your quality profile.");
        }

        return rule;
    }

    private void updateQueryToCurrFile(CxResultToSonarResult nonIssueResult) {
        SastSeverity severity = SastSeverity.fromName(nonIssueResult.getResultData().getSeverity());
        if (severity == null) {
            logger.error("Result for query " + nonIssueResult.getQuery().getName() + " has no severity. Checkmarx result may be incomplete.");
            return;
        }
        switch (severity) {
            case SAST_HIGH:
                currFileQueriesCollector.addHighQuery(nonIssueResult.getQuery().getName());
                break;
            case SAST_MEDIUM:
                currFileQueriesCollector.addMediumQuery(nonIssueResult.getQuery().getName());
                break;
            case SAST_LOW:
                currFileQueriesCollector.addLowQuery(nonIssueResult.getQuery().getName());
                break;
            default:
                break;
        }
    }

    private void updateCurrFileVulnerabilities(CxResultToSonarResult result) {
        SastSeverity severity = SastSeverity.fromName(result.getResultData().getSeverity());
        if (severity == null) {
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
                break;
            default:
                break;
        }
    }

    private void saveCxCustomMetrics(SensorContext context, InputFile file) {
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

    private void addSumVulnerabilitiesMetrics(SensorContext context, InputFile file) {
        if (currFileSumVulnerabilityCounter.getSumVulnerabilities() > 0) {
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

    private void addNewVulnerabilitiesMetrics(SensorContext context, InputFile file) {
        if (currFileNewVulnerabilityCounter.getSumVulnerabilities() != 0) {
            addMetric(context, file, SAST_TOTAL_NEW_VULNERABILITIES, currFileNewVulnerabilityCounter.getSumVulnerabilities());
            if (currFileNewVulnerabilityCounter.getHigh() != 0) {
                addMetric(context, file, SAST_NEW_HIGH_VULNERABILITIES, currFileNewVulnerabilityCounter.getHigh());
            }
            if (currFileNewVulnerabilityCounter.getMedium() != 0) {
                addMetric(context, file, SAST_NEW_MEDIUM_VULNERABILITIES, currFileNewVulnerabilityCounter.getMedium());
            }
            if (currFileNewVulnerabilityCounter.getLow() != 0) {
                addMetric(context, file, SAST_NEW_LOW_VULNERABILITIES, currFileNewVulnerabilityCounter.getLow());
            }
        }
    }

    private void addMetric(final SensorContext context, final InputFile inputFile, final Metric<Integer> metric, int value) {
        context.<Integer>newMeasure().forMetric(metric).on(inputFile).withValue(value).save();
        //logger.info("[CHECKMARX] Added measure, metric: " + metric.getName() + ", File: " + ((DefaultInputFile) inputFile).getProjectRelativePath());
    }

    private void saveCxQueriesMeasure(SensorContext context, InputFile file) {
        FileQueries fileQueries = currFileQueriesCollector.getAsFileQueriesObject();
        String json = "";
        try {
            json = mapper.writeValueAsString(fileQueries);
        } catch (JsonProcessingException e) {
            logger.error("Error parsing Checkmarx queries du to exception: " + e.getMessage());
            logger.error("Details report may be incomplete.");
        }
        context.<String>newMeasure().forMetric(SAST_SCAN_QUERIES).on(file).withValue(json).save();
        //logger.info("[CHECKMARX] Added query measure, metric: " + SAST_SCAN_QUERIES.getName() + ", File: " + ((DefaultInputFile) file).getProjectRelativePath());
    }
    private HashMap<String, String> getMappingStates(){
    	HashMap<String, String> states = new HashMap<String, String>();
    	states.put("Open", "To Verify");
    	states.put("Resolve as fixed", "Not Exploitable");
    	states.put("Resolve as false positive", "Confirmed");
    	states.put("Proposed Not Exploitable", "Resolve as won'nt fix");
    	states.put("Resolve as fixed", "Urgent");
    	return states;
    	
    }
}
