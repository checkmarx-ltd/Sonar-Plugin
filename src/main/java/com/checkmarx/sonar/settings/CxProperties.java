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

    public static final String CXPROJECT_KEY = "checkmarx.server.project_name.secured";
    public static final String CX_REMEDIATION_EFFORT = "checkmarx.server.remediation";

    public static final String SERVER_URL_KEY = "checkmarx.server.url.secured";
    public static final String USERNAME_KEY = "checkmarx.server.username.secured";
    public static final String PASSWORD_KEY = "checkmarx.server.password.secured";

    public CxProperties() {
    }

    public static List<PropertyDefinition> getProperties() {
        PropertyDefinition[] properties = new PropertyDefinition[]{
                defineProperty(CXPROJECT_KEY, "cx_project", "cx_project"),
                defineProperty(CX_REMEDIATION_EFFORT, "cx_remediation_effort", "remediation per checkmarx vulnerability"),

                defineProperty(SERVER_URL_KEY, "Server URL", "Server URL"),
                defineProperty(USERNAME_KEY, "Username", "Username"),
                defineProperty(PASSWORD_KEY, "Password", "Password")
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

