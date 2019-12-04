package com.checkmarx.sonar.settings;

import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by: zoharby.
 * Date: 26/04/2017.
 */
public class CxProperties {

    public static final String CXPROJECT_KEY = "checkmarx.server.project_name";
    public static final String CX_REMEDIATION_EFFORT = "checkmarx.server.remediation";

    public static final String CREDENTIALS_KEY = "checkmarx.server.credentials";

    public CxProperties() {
    }

    public static List<PropertyDefinition> getProperties() {
        PropertyDefinition[] properties = new PropertyDefinition[]{
                defineProperty(CXPROJECT_KEY, "cx_project", "cx_project"),
                defineProperty(CX_REMEDIATION_EFFORT, "cx_remediation_effort", "remediation per checkmarx vulnerability"),
                defineProperty(CREDENTIALS_KEY, "Credentials", "Parameters required to connect to Checkmarx server")
        };

        return Arrays.asList(properties);
    }

    private static PropertyDefinition defineProperty(String key, String name, String description) {
        return PropertyDefinition.builder(key)
                .name(name)
                .description(description)
                .defaultValue("")
                .category("checkmarx")
                .onQualifiers(Qualifiers.PROJECT)
                .build();
    }

}

