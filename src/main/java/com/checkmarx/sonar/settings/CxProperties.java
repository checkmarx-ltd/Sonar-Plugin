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

    public static final String CXPROJECT_KEY = "checkmarx.server.project_name.secured";
    public static final String CX_CREDENTIALS_KEY = "checkmarx.server.credentials.secured";
    public static final String CX_REMEDIATION_EFFORT = "checkmarx.server.remediation";
    public static final String CX_REPORT_DATA_KEY = "checkmarx.server.report_data";

    public CxProperties() {
    }

    public static List<PropertyDefinition> getProperties() {

        List<PropertyDefinition> propertyDefinitionList = new LinkedList<>();


        propertyDefinitionList.add(PropertyDefinition.builder(CX_CREDENTIALS_KEY)
                .name("cx_credentials")
                .description("Checkmarx server credentials")
                .defaultValue("")
                .category("checkmarx")
                .onlyOnQualifiers(Qualifiers.PROJECT)
                .build());

        propertyDefinitionList.add(PropertyDefinition.builder(CXPROJECT_KEY)
                .name("cx_project")
                .description("cx_project")
                .defaultValue("")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build());

        propertyDefinitionList.add(PropertyDefinition.builder(CX_REMEDIATION_EFFORT)
                .name("cx_remediation_effort")
                .description("remediation per checkmarx vulnerability")
                .defaultValue("")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build());


        propertyDefinitionList.add(PropertyDefinition.builder(CX_REPORT_DATA_KEY)
                .name("cx_report_data")
                .description("data for checkmarx report")
                .defaultValue("0")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build());



        return propertyDefinitionList;
    }
}

