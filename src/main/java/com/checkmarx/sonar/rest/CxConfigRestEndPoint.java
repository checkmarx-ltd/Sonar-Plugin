package com.checkmarx.sonar.rest;

import com.checkmarx.sonar.cxservice.CxConfigSoapService;
import com.checkmarx.sonar.cxservice.dto.CxFullCredentials;
import com.checkmarx.sonar.cxservice.exception.ConnectionException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raps.code.generate.ws.ProjectDisplayData;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(CxConfigRestEndPoint.class);

    private ObjectMapper mapper = new ObjectMapper();

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
                                cxFullCredentials = mapper.readValue(credentialsJson, CxFullCredentials.class);
                            }else {
                                throw new IOException("No credentials provided");
                            }
                            validateCredentials(cxFullCredentials);

                            String sessionId = cxConfigSoapService.login(cxFullCredentials);
                            // read request parameters and generates response output
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", true)
                                    .prop("sessionId", sessionId)
                                    .endObject()
                                    .close();
                        } catch (IOException e) {
                            e.printStackTrace();
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
                            validateSessionId(sessionId);

                            String projects = getProjects(sessionId);
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("projects", projects)
                                    .prop("isSuccessful", true)
                                    .endObject()
                                    .close();
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                            logger.error("Projects retrieval failed due to Exception: " + e.getMessage());
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("projects", "")
                                    .prop("isSuccessful", false)
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

                        try {
                            String sessionId = request.getParam("sessionId").getValue();
                            validateSessionId(sessionId);

                            cxConfigSoapService.closeConnection(sessionId);
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", true)
                                    .endObject()
                                    .close();

                        } catch (IOException e) {
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", false)
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
        if(cxFullCredentials.getServerUrl() == null || cxFullCredentials.getServerUrl().equals("")){
            throw new IOException("Checkmarx server URL was not provided.");
        }
        if(cxFullCredentials.getUsername() == null || cxFullCredentials.getUsername().equals("")){
            throw new IOException("Checkmarx server username was not provided.");
        }
        if(cxFullCredentials.getPassword() == null || cxFullCredentials.getPassword().equals("")){
            throw new IOException("Checkmarx server password was not provided.");
        }
    }

    private void validateSessionId(String sessionId) throws IOException {
        if(sessionId == null || sessionId.equals("")){
            throw new IOException("Session id is not provided (user might not be logged in).");
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
