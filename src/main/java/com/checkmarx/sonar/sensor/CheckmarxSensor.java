package com.checkmarx.sonar.sensor;

import com.checkmarx.sonar.cxportalservice.sast.exception.ConnectionException;
import com.checkmarx.sonar.cxportalservice.sast.sastnew.CxConfigSoapService;
import com.checkmarx.sonar.cxportalservice.sast.sastnew.CxSastResultsService;
import com.checkmarx.sonar.cxportalservice.sast.sastnew.model.AllSastResults;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.sensor.execution.SastStageExecutor;
import com.checkmarx.sonar.settings.CxProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by: Zoharby.
 * Date: 24/05/2017.
 */
public class CheckmarxSensor implements Sensor {

    private Logger logger = Loggers.get(CheckmarxSensor.class);

    private ObjectMapper mapper = new ObjectMapper();

    //private CxResultsSoapService cxResultsSoapService = new CxResultsSoapService();
    private CxConfigSoapService cxConfigSoapService = new CxConfigSoapService();
    private SastStageExecutor sastStageExecutor = new SastStageExecutor();

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name("Compute size of file names");
    }

    @Override
    public void execute(SensorContext context) {
        logger.info("Getting Checkmarx configuration data from sonar Database.");

        String cancelMsg = "NOTE: Checkmarx scan is canceled;\n";

        //todo this is experiment
       /* ActiveRules myRules = context.activeRules();

        ActiveRule rule = myRules.findByInternalKey("fortify-ruby","API Abuse/ADF Faces Bad Practices/unsecure Attribute");

        Iterable<InputFile> mainfiles = context.fileSystem().inputFiles(context.fileSystem().predicates().hasType(InputFile.Type.MAIN));
        InputFile inputFile = null;
        for (InputFile file: mainfiles){
            if(file.isFile()){
                inputFile = file;
                break;
            }
        }

        if(inputFile != null) {
            DefaultIssueLocation defaultIssueLocation = new DefaultIssueLocation();
            //InputComponent inputComponent = defaultIssueLocation.on(inputFile).inputComponent();

            context.newIssue().forRule(rule.ruleKey()).at(defaultIssueLocation.on(inputFile)).save();
        }*/

        CxFullCredentials cxFullCredentials;
        String cxCredentialsJson = context.settings().getString(CxProperties.CX_CREDENTIALS_KEY);
        String cxProject = context.settings().getString(CxProperties.CXPROJECT_KEY);
        if (cxCredentialsJson == null || cxProject == null) {
            logErrorAndNotifyContext(cancelMsg + "Error while retrieving Checkmarx settings from sonar Database.\n", context);
            return;
        }
        if ("".equals(cxCredentialsJson) || "".equals(cxProject)) {
            logErrorAndNotifyContext(cancelMsg + "Checkmarx settings were not configured.\n Can be configured by admin at: " +
                    "Project Page > Administration > Checkmarx\n", context);
            return;
        }
        try {
            cxFullCredentials = mapper.readValue(cxCredentialsJson, CxFullCredentials.class);
        } catch (Exception e) {
            logErrorAndNotifyContext(cancelMsg + "Error while parsing credentials: " + e.getMessage(), context);
            return;
        }

        try {
            cxConfigSoapService.login(cxFullCredentials);
        } catch (ConnectionException e) {
            logger.error("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            logErrorAndNotifyContext(cancelMsg + "Login to Checkmarx failed: " + e.getMessage(), context);
            logger.error("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            return;
        }

        try {
            CxSastResultsService cxSastResultsService = new CxSastResultsService();
            AllSastResults allSastResults = cxSastResultsService.retrieveScan(cxFullCredentials, cxProject);



          /*  SastScanData downloadedData = cxResultsSoapService.getQueriesOfLastScanForProject(cxFullCredentials, cxProject);
            sastStageExecutor.execute(context, downloadedData);

            if (downloadedData.getProjectDisplayData().getTotalOsaScans() != 0) {
                OsaStageExecutor osaScanExecutor = new OsaStageExecutor();
                osaScanExecutor.execute(context, cxFullCredentials, (downloadedData.getProjectDisplayData().getProjectID()));
            }*/
            //  }catch (ConnectionException e){
            //    logErrorAndNotifyContext(cancelMsg + "Error retrieving scan data from server: "+e.getMessage(), context);
            // } catch (InterruptedException e) {
            //  e.printStackTrace();
            //} catch (IOException e) {
            //  e.printStackTrace();
            //} catch (JAXBException e) {
            //e.printStackTrace();
            //}
        } catch (InterruptedException | IOException | JAXBException e) {
           logger.error("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            logger.error("Sast results retrival failed due to exception: "+e.getMessage());
            logger.error("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            e.printStackTrace();
        }
    }

    private void logErrorAndNotifyContext(String massage, SensorContext context){
        logger.error(massage);
        context.newAnalysisError().message(massage).save();
    }
}