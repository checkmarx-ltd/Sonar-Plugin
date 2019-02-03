package com.checkmarx.sonar.web;

import com.checkmarx.sonar.cxrules.CxSonarConstants;
import com.checkmarx.sonar.dto.CxFullCredentials;
import com.checkmarx.sonar.logger.CxLogger;
import com.cx.restclient.CxShragaClient;
import com.cx.restclient.exception.CxClientException;
import com.cx.restclient.sast.dto.Project;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.server.ws.Request;
import org.sonar.api.server.ws.RequestHandler;
import org.sonar.api.server.ws.Response;
import org.sonar.api.server.ws.WebService;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by: Zoharby.
 * Date: 08/05/2017.
 */
public class CxConfigRestEndPoint implements WebService {

    private Logger logger = LoggerFactory.getLogger(CxConfigRestEndPoint.class);
    private CxShragaClient shraga;

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
                            URL url = new URL(cxFullCredentials.getCxServerUrl());
                            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

                            shraga = new CxShragaClient(cxFullCredentials.getCxServerUrl().trim(), cxFullCredentials.getCxUsername(), cxFullCredentials.getCxPassword(), CxSonarConstants.CX_SONAR_ORIGIN, false, logger);
                            shraga.login();
                            urlConn.connect();
                            // read request parameters and generates response output
                            response.newJsonWriter()
                                    .beginObject()
                                    .prop("isSuccessful", true)
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
                            String projects = getProjects();
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
                });

        controller.createAction("clean_connection")
                .setPost(true)
                .setDescription("Close connection of default Checkmarx server (the server that was configured by SonarQube administrator).")
                .setInternal(true)
                .setHandler(new RequestHandler() {
                    @Override
                    public void handle(Request request, Response response) {
                        logger.info("Logging out of Checkmarx.");
                        try {
                            shraga.close();
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
                });

        //apply changes
        controller.done();
    }

    public String getTeamId(String teamName, CxFullCredentials cxFullCredentials) throws IOException {
        String teamId;
        try {
            if(shraga == null){
                shraga = new CxShragaClient(cxFullCredentials.getCxServerUrl().trim(), cxFullCredentials.getCxUsername(), cxFullCredentials.getCxPassword(), CxSonarConstants.CX_SONAR_ORIGIN, false, logger);
            }
            teamId = shraga.getTeamIdByName(teamName);
        } catch (CxClientException e) {
            throw new IOException("Error in getTeamIdByName, teamName:" + teamName);
        } catch (IOException e) {
            throw new IOException("Error in getTeamIdByName , teamName:" + teamName);
        }
        return  teamId;
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


    private String getProjects() throws IOException, CxClientException {
        List<Project> allProjects = shraga.getAllProjects();

        List<String> projectNames = new LinkedList<>();
        for (Project project: allProjects) {
            String teamName = shraga.getTeamNameById(project.getTeamId());
            teamName = teamName.replace("/", "\\");
            projectNames.add(teamName + "\\" + project.getName());
        }
        return convertToJsonArray(projectNames);
    }

    private String convertToJsonArray(List<String> listToConvert) {
        JSONArray jsonArray = new JSONArray(listToConvert);
        return jsonArray.toString();
    }
}
