package com.checkmarx.sonar.settings;

import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 26/04/2017.
 */
public class CxProperties {

    public static final String STATE_KEY = "checkmarx.server.state.secured"; //State can be one of: notConfigured, configured
    public static final String URL_KEY = "checkmarx.server.url.secured";
    public static final String USERNAME_KEY = "checkmarx.server.username.secured";
    public static final String PASSWORD_KEY = "checkmarx.server.password.secured";
    public static final String CXPROJECT_KEY = "checkmarx.server.project_name.secured";
    public static final String CX_CREDENTIALS = "checkmarx.server.credentials.secured";

    //todo: if thereis no global page - replace onqualefies with onlyonqulefiers

    public CxProperties() {
    }

    public static List<PropertyDefinition> getProperties() {

        List<PropertyDefinition> propertyDefinitionList = new LinkedList<>();


        propertyDefinitionList.add(PropertyDefinition.builder(CX_CREDENTIALS)
                .name("cx_credentials")
                .description("Checkmarx server credentials")
                .defaultValue( "{\"cxServerUrl\":\"cx_server_url_placholder\", \"cxUsername\": \"cx_username_placeholder\", \"cxPassword\": \"cx_password_placeholder\"}")
                .category("checkmarx")
                .onlyOnQualifiers(Qualifiers.PROJECT)
                .build());


        propertyDefinitionList.add(PropertyDefinition.builder(URL_KEY)
                .name("cx_project")
                .description("cx_project")
                .defaultValue("cx_server_placeholder")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build());


        propertyDefinitionList.add(PropertyDefinition.builder(USERNAME_KEY)
                .name("cx_project")
                .description("cx_project")
                .defaultValue("cx_username_placeholder")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build());


        propertyDefinitionList.add(PropertyDefinition.builder(PASSWORD_KEY)
                .name("cx_project")
                .description("cx_project")
                .defaultValue("cx_password_placeholder")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build());

        propertyDefinitionList.add(PropertyDefinition.builder(CXPROJECT_KEY)
                .name("cx_project")
                .description("cx_project")
                .defaultValue("cx_project_placeholder")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build());



        return propertyDefinitionList;
    }
}

