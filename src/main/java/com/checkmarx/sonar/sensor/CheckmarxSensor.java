package com.checkmarx.sonar.sensor;

import com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.SastReportData;
import com.checkmarx.sonar.sensor.execution.CxResultsAdapter;
import com.checkmarx.sonar.sensor.execution.SastResultsCollector;
import com.checkmarx.sonar.sensor.utils.CxConfigHelper;
import com.checkmarx.sonar.sensor.version.PluginVersionProvider;
import com.cx.restclient.CxShragaClient;
import com.cx.restclient.configuration.CxScanConfig;
import com.cx.restclient.sast.dto.SASTResults;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static com.checkmarx.sonar.measures.SastMetrics.SAST_SCAN_DETAILS;
import static com.checkmarx.sonar.measures.SastMetrics.SONAR_PROJECT_HAVE_SAST_RESULTS;

/**
 * Created by: Zoharby.
 * Date: 24/05/2017.
 */
public class CheckmarxSensor implements Sensor {

    private Logger logger = LoggerFactory.getLogger(CheckmarxSensor.class);
    private PluginVersionProvider versionProvider = new PluginVersionProvider();
    private ObjectMapper mapper = new ObjectMapper();
    private SastResultsCollector sastResultsCollector = new SastResultsCollector();
    private CxShragaClient shraga = null;



    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name("Import Checkmarx scan results to SonarQube");
    }

    @Override
    public void execute(SensorContext context) {
        logger.info(versionProvider.appendVersionToMsg("Retrieving Checkmarx scan results for current module"));
        logger.info("Getting Checkmarx configuration data from sonar Database.");

        try {
            CxConfigHelper configHelper = new CxConfigHelper(logger);
            CxFullCredentials cxCredentials = configHelper.getCxFullCredentials(context);
            CxScanConfig config = configHelper.getScanConfig(cxCredentials, context);

            logger.info("Connecting to {}", config.getUrl());
            shraga = new CxShragaClient(config, logger);
            shraga.init();
            SASTResults latestSASTResults = shraga.getLatestSASTResults();
//            shraga.generateHTMLSummary(latestSASTResults, new OSAResults());
            CxXMLResults cxXMLResults = convertToXMLResult(latestSASTResults.getRawXMLReport());
            CxReportToSonarReport cxReportToSonarReport = CxResultsAdapter.adaptCxXmlResultsForSonar(cxXMLResults);

            sastResultsCollector.collectVulnerabilitiesAndSaveToMetrics(context, cxReportToSonarReport);
            notifyComputeSatMeasuresSonarProjectHaveSastResults(context);

            SastReportData sastReportData = CxResultsAdapter.adaptCxXmlResultsToCxDetailReport(cxXMLResults, cxCredentials);
            saveSastForDetailReport(context, sastReportData);

            logger.info("Sast results retrieval finished.");
        } catch (Exception e) {
            logger.error("---------------------------------------------------------------------------------------\n");
            logger.error("Sast results retrieval failed due to exception: "+e.getMessage() + "\n");
            logger.error(versionProvider.appendVersionToMsg(""));
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

    private com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults convertToXMLResult(byte[] cxReport) throws IOException, JAXBException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cxReport);
        JAXBContext jaxbContext = JAXBContext.newInstance(com.cx.restclient.sast.dto.CxXMLResults.class.getPackage().getName(),
                com.checkmarx.sonar.cxportalservice.sast.model.CxXMLResults.class.getClassLoader());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (CxXMLResults) unmarshaller.unmarshal(byteArrayInputStream);
    }

}