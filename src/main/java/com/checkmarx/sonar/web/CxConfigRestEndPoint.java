package com.checkmarx.sonar.web;

import com.checkmarx.soap.client.ProjectDisplayData;
import com.checkmarx.sonar.cxportalservice.sast.exception.ConnectionException;
import com.checkmarx.sonar.cxportalservice.sast.services.CxConfigSoapService;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.logger.CxLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.sonar.api.server.ws.Request;
import org.sonar.api.server.ws.RequestHandler;
import org.sonar.api.server.ws.Response;
import org.sonar.api.server.ws.WebService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by: Zoharby.
 * Date: 08/05/2017.
 */
public class CxConfigRestEndPoint implements WebService {


    private CxConfigSoapService cxConfigSoapService = new CxConfigSoapService();

    private CxLogger logger = new CxLogger(CxConfigRestEndPoint.class);



    @Override
    public void define(Context context) {

        NewController controller = context.createController("api/checkmarx");
        controller.setDescription("Web service example");


        controller.createAction("connect")
                .setPost(true)
                .setDescription("Entry point")
                .setInternal(true)
                .setHandler(new RequestHandler() {
                    @Override
                    public void handle(Request request, Response response) {

                        CxFullCredentials cxFullCredentials = null;
                        try {
                           String credentialsJson = request.getParam("credentials").getValue();
                            if(credentialsJson != null && !credentialsJson.equals("")) {
                                cxFullCredentials = CxFullCredentials.getCxFullCredentials(credentialsJson);
                            }else {
                                throw new IOException("No credentials provided");
                            }
                            validateCredentials(cxFullCredentials);

                            cxConfigSoapService.login(cxFullCredentials);
                            // read request parameters and generates response output
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", true)
                                    .prop("sessionId", "")
                                    .endObject()
                                    .close();
                        } catch (Exception e) {
                            logger.error("Login failed due to Exception: " + e.getMessage());
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", false)
                                    .prop("errorMsg", e.getMessage())
                                    .endObject()
                                    .close();
                        }
                    }
                })
                .createParam("credentials").setDescription("cx credentials").setRequired(true);




        controller.createAction("projects")
                .setPost(true)
                .setDescription("Return projects of default Checkmarx server (the server that was configured by SonarQube administrator).")
                .setInternal(true)
                .setHandler(new RequestHandler() {
                    @Override
                    public void handle(Request request, Response response) {

                        logger.info("Retrieving Cx server projects.");
                        try {
                            String sessionId = request.getParam("sessionId").getValue();

                            String projects = getProjects(sessionId);
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("projects", projects)
                                    .prop("isSuccessful", true)
                                    .endObject()
                                    .close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("Projects retrieval failed due to Exception: " + e.getMessage());
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("projects", "")
                                    .prop("isSuccessful", false)
                                    .prop("errorMsg", e.getMessage())
                                    .endObject()
                                    .close();
                        }
                    }
                }).createParam("sessionId").setDescription("cx session id").setRequired(true);



        controller.createAction("clean_connection")
                .setPost(true)
                .setDescription("Close connection of default Checkmarx server (the server that was configured by SonarQube administrator).")
                .setInternal(true)
                .setHandler(new RequestHandler() {
                    @Override
                    public void handle(Request request, Response response) {
                        logger.info("Logging out of Checkmarx.");
                        try {
                            String sessionId = request.getParam("sessionId").getValue();

                            cxConfigSoapService.closeConnection(sessionId);
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", true)
                                    .endObject()
                                    .close();

                        } catch (Exception e) {
                            logger.error("Logging out of Checkmarx failed due to Exception: " + e.getMessage());
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", false)
                                    .prop("errorMsg", e.getMessage())
                                    .endObject()
                                    .close();

                        }
                    }
                }).createParam("sessionId").setDescription("cx session id").setRequired(true);

        //apply changes
        controller.done();
    }




    private void validateCredentials(CxFullCredentials cxFullCredentials) throws IOException {
        if(cxFullCredentials == null){
            throw new IOException("No credentials provided");
        }
        if(cxFullCredentials.getCxServerUrl() == null || cxFullCredentials.getCxServerUrl().equals("")){
            throw new IOException("Checkmarx server URL was not provided.");
        }
        if(cxFullCredentials.getCxUsername() == null || cxFullCredentials.getCxUsername().equals("")){
            throw new IOException("Checkmarx server username was not provided.");
        }
        if(cxFullCredentials.getCxPassword() == null || cxFullCredentials.getCxPassword().equals("")){
            throw new IOException("Checkmarx server password was not provided.");
        }
    }


    private String getProjects(String sessionId) throws JSONException, ConnectionException {
        List<ProjectDisplayData> projectsDisplayData = cxConfigSoapService.getProjectsDisplayData(sessionId);

        List<String> projectNames = new LinkedList<>();

        for (ProjectDisplayData projectDisplayData : projectsDisplayData){
            String toAdd = projectDisplayData.getGroup()+"\\"+projectDisplayData.getProjectName();
            projectNames.add(toAdd);
        }
        return convertToJsonArray(projectNames);
    }

    private String convertToJsonArray(List<String> listToConvert) throws JSONException {
        JSONArray jsonArray = new JSONArray(listToConvert);
        return jsonArray.toString();
    }
}
