package com.checkmarx.sonar.cxpropfiles;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.utils.ValidationMessages;

/**
 * Created by: zoharby.
 * Date: 17/09/2017.
 */
public class CxKotlinProfile extends ProfileDefinition {

    private final XMLProfileParser xmlProfileParser;

    public CxKotlinProfile(XMLProfileParser xmlProfileParser) {
        this.xmlProfileParser = xmlProfileParser;
    }

    @Override
    public RulesProfile createProfile(ValidationMessages validation) {
        return xmlProfileParser.parseResource(getClass().getClassLoader(),
                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                        CXProgrammingLanguage.KOTLIN.getName().toLowerCase()), validation);
    }
}
