package com.checkmarx.sonar.sensor;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;
import com.checkmarx.sonar.cxportalservice.sast.services.CxSastResultsService;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.logger.CxLogger;
import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.SastReportData;
import com.checkmarx.sonar.sensor.execution.CxResultsAdapter;
import com.checkmarx.sonar.sensor.execution.SastMetricsCollector;
import com.checkmarx.sonar.settings.CxProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;

import java.util.ArrayList;

import static com.checkmarx.sonar.measures.SastMetrics.SAST_SCAN_DETAILS;
import static com.checkmarx.sonar.measures.SastMetrics.SONAR_PROJECT_HAVE_SAST_RESULTS;

/**
 * Created by: Zoharby.
 * Date: 24/05/2017.
 */
public class CheckmarxSensor implements Sensor {

    private CxLogger logger = new CxLogger(CheckmarxSensor.class);

    private ObjectMapper mapper = new ObjectMapper();

    private static final String CANCEL_MESSAGE = "NOTE: Checkmarx scan is canceled;\n";

    private CxSastResultsService cxSastResultsService = new CxSastResultsService();
    private SastMetricsCollector sastMetricsCollector = new SastMetricsCollector();

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name("Compute size of file names");
    }

    @Override
    public void execute(SensorContext context) {
        logger.info("Getting Checkmarx configuration data from sonar Database.");

        CxFullCredentials cxFullCredentials;
        String cxCredentialsJson = context.settings().getString(CxProperties.CX_CREDENTIALS_KEY);
        String cxProject = context.settings().getString(CxProperties.CXPROJECT_KEY);
        if (cxCredentialsJson == null || cxProject == null) {
            logErrorAndNotifyContext(CANCEL_MESSAGE + "Error while retrieving Checkmarx settings from sonar Database.\n", context);
            return;
        }
        if ("".equals(cxCredentialsJson) || "".equals(cxProject)) {
            logErrorAndNotifyContext(CANCEL_MESSAGE + "Checkmarx settings were not configured.\n Can be configured by admin at: " +
                    "Project Page > Administration > Checkmarx\n", context);
            return;
        }
        try {
            cxFullCredentials = mapper.readValue(cxCredentialsJson, CxFullCredentials.class);
        } catch (Exception e) {
            logErrorAndNotifyContext(CANCEL_MESSAGE + "Error while parsing credentials: " + e.getMessage(), context);
            return;
        }

        try {
            CxXMLResults cxXMLResults = cxSastResultsService.retrieveScan(cxFullCredentials, cxProject);
            CxReportToSonarReport cxReportToSonarReport = CxResultsAdapter.adaptCxXmlResultsForSonar(cxXMLResults);

            sastMetricsCollector.collectVulnerabilitiesAndSaveToMetrics(context, cxReportToSonarReport);
            notifyComputeSatMeasuresSonarProjectHaveSastResults(context);

            SastReportData sastReportData = CxResultsAdapter.adaptCxXmlResultsToCxDetailReport(cxXMLResults, cxFullCredentials);
            saveSastForDetailReport(context, sastReportData);

        } catch (Exception e) {
            logger.error("---------------------------------------------------------------------------------------\n");
            logger.error("Sast results retrieval failed due to exception: "+e.getMessage() + "\n");
            logger.error("---------------------------------------------------------------------------------------");
            e.printStackTrace();
        }
    }

    private void notifyComputeSatMeasuresSonarProjectHaveSastResults(SensorContext context){
        Iterable<InputFile> mainfiles = getMainFiles(context);
        for (InputFile file : mainfiles){
            context.<Integer>newMeasure().on(file).forMetric(SONAR_PROJECT_HAVE_SAST_RESULTS).withValue(1).save();
        }
    }

    private Iterable<InputFile> getMainFiles(SensorContext context){
        FileSystem fs = context.fileSystem();
        if(fs == null){
            return new ArrayList<>();
        }

        Iterable<InputFile> mainFiles = fs.inputFiles(fs.predicates().hasType(InputFile.Type.MAIN));
        if(mainFiles == null){
            return new ArrayList<>();
        }
        return mainFiles;
    }

    private void saveSastForDetailReport(SensorContext context, SastReportData sastReportData) throws JsonProcessingException {
        String scanDetails = mapper.writeValueAsString(sastReportData);
        context.<String>newMeasure().on(context.module()).forMetric(SAST_SCAN_DETAILS).withValue(scanDetails).save();
    }

    private void logErrorAndNotifyContext(String massage, SensorContext context){
        logger.error(massage);
        context.newAnalysisError().message(massage).save();
    }
}