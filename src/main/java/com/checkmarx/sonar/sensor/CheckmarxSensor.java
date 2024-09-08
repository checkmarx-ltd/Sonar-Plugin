package com.checkmarx.sonar.sensor;

import static com.checkmarx.sonar.measures.SastMetrics.SAST_SCAN_DETAILS;
import static com.checkmarx.sonar.measures.SastMetrics.SONAR_PROJECT_HAVE_SAST_RESULTS;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;

import com.checkmarx.sonar.cxportalservice.sast.exception.CxRestLoginException;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.dto.CxReportToSonarReport;
import com.checkmarx.sonar.sensor.dto.SastReportData;
import com.checkmarx.sonar.sensor.execution.CxResultsAdapter;
import com.checkmarx.sonar.sensor.execution.SastResultsCollector;
import com.checkmarx.sonar.sensor.utils.CxConfigHelper;
import com.checkmarx.sonar.sensor.version.PluginVersionProvider;
import com.checkmarx.sonar.settings.CxProperties;
import com.checkmarx.sonar.web.HttpHelper;
import com.checkmarx.sonar.web.ProxyParams;
import com.cx.restclient.CxClientDelegator;
import com.cx.restclient.configuration.CxScanConfig;
import com.cx.restclient.exception.CxClientException;
import com.cx.restclient.sast.dto.CxXMLResults;
import com.cx.restclient.sast.dto.SASTResults;
import com.cx.restclient.sast.utils.SASTUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.checkmarx.sonar.cxrules.CxSonarConstants;

/**
 * Created by: Zoharby.
 * Date: 24/05/2017.
 */
public class CheckmarxSensor implements Sensor {

    private Logger logger = LoggerFactory.getLogger(CheckmarxSensor.class);
    private PluginVersionProvider versionProvider = new PluginVersionProvider();
    private ObjectMapper mapper = new ObjectMapper();
    private SastResultsCollector sastResultsCollector = new SastResultsCollector();

    private CxClientDelegator shraga = null;
    
    static {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
    }

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name("Import Checkmarx scan results to SonarQube").global();
    }

    @Override
    public void execute(SensorContext context) {
        logger.info(versionProvider.appendVersionToMsg("Retrieving Checkmarx scan results for current module"));
        logger.info("Getting Checkmarx configuration data from sonar Database.");

        try {
            CxConfigHelper configHelper = new CxConfigHelper(logger);
            String cxProject = configHelper.getSonarProperty(context, CxProperties.CXPROJECT_KEY);
            if (StringUtils.isEmpty(cxProject)) {
                logger.info("Checkmarx analysis isn't configured, skipping step.");
                return;
            }
            CxFullCredentials cxCredentials = configHelper.getCxFullCredentials(context);
            if (cxCredentials == null) {
                throw new CxRestLoginException("Missing Checkmarx credentials");
            }
            CxScanConfig config = configHelper.getScanConfig(cxCredentials, context);

            logger.info("Connecting to {}", config.getUrl());
            ProxyParams proxyParam = HttpHelper.getProxyParam();
            if (proxyParam == null) {
            	shraga = new CxClientDelegator(config, logger);
            } else {
            	shraga = new CxClientDelegator(
                        proxyParam.getHost() + ":" + proxyParam.getPort(),
                        proxyParam.getUser(),
                        proxyParam.getPssd(),
                        CxSonarConstants.CX_SONAR_ORIGIN,
                        true,
                        logger);
            }

            shraga.init();
            SASTResults latestSASTResults = shraga.getLatestScanResults().getSastResults();
            logger.info("Checkmarx High vulnerabilities: " + latestSASTResults.getHigh());
            logger.info("Checkmarx New-High vulnerabilities: " + latestSASTResults.getNewHigh());
            logger.info("Checkmarx Medium vulnerabilities: " + latestSASTResults.getMedium());
            logger.info("Checkmarx New-Medium vulnerabilities: " + latestSASTResults.getNewMedium());
            logger.info("Checkmarx Low vulnerabilities: " + latestSASTResults.getLow());
            logger.info("Checkmarx New-Low vulnerabilities: " + latestSASTResults.getNewLow());
            logger.info("Checkmarx scan link: " + latestSASTResults.getSastScanLink());

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
            logger.error("Sast results retrieval failed due to exception: " + e.getMessage() + "\n");
            logger.error(versionProvider.appendVersionToMsg(""));
            logger.error("---------------------------------------------------------------------------------------");
            e.printStackTrace();
        }
    }

    private void notifyComputeSatMeasuresSonarProjectHaveSastResults(SensorContext context) {
        Iterable<InputFile> mainfiles = getMainFiles(context);
        for (InputFile file : mainfiles) {
            context.<Integer>newMeasure().on(file).forMetric(SONAR_PROJECT_HAVE_SAST_RESULTS).withValue(1).save();
            /*String prjPath = ((DefaultInputFile) file).getProjectRelativePath();
            String mdlPath = ((DefaultInputFile) file).getModuleRelativePath();
            String absPath = ((DefaultInputFile) file).absolutePath();
            logger.info("Sonar project have SAST results metric on file:\nProject path: " + prjPath + "\nModule path: " + mdlPath + "\nAbsolute path: " + absPath);*/
        }
    }

    private Iterable<InputFile> getMainFiles(SensorContext context) {
        FileSystem fs = context.fileSystem();
        if (fs == null) {
            return new ArrayList<>();
        }

        Iterable<InputFile> mainFiles = fs.inputFiles(fs.predicates().hasType(InputFile.Type.MAIN));
        if (mainFiles == null) {
            return new ArrayList<>();
        }
        return mainFiles;
    }

    private void saveSastForDetailReport(SensorContext context, SastReportData sastReportData) throws JsonProcessingException {
        String scanDetails = mapper.writeValueAsString(sastReportData);
        context.<String>newMeasure().on(context.module()).forMetric(SAST_SCAN_DETAILS).withValue(scanDetails).save();
        logger.info("Scan report details: " + scanDetails);
    }

    private com.cx.restclient.sast.dto.CxXMLResults convertToXMLResult(byte[] cxReport) throws IOException, JAXBException, CxClientException {
        return SASTUtils.convertToXMLResult(cxReport);
    }

}