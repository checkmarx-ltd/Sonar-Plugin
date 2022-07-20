package com.checkmarx.sonar.cxpropfiles;

import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;

/**
 * Created by: zoharby.
 * Date: 17/09/2017.
 */
public class CxJavaProfile implements BuiltInQualityProfilesDefinition {

    private final XMLProfileParser xmlProfileParser;

    public CxJavaProfile(XMLProfileParser xmlProfileParser) {
        this.xmlProfileParser = xmlProfileParser;
    }

    @Override
    public void define(Context context) {
        ValidationMessages validation = ValidationMessages.create();
        RulesProfile profile = xmlProfileParser.parseResource(getClass().getClassLoader(),
                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                        CXProgrammingLanguage.JAVA.getName().toLowerCase()), validation);

        context.createBuiltInQualityProfile(profile.getName(), profile.getLanguage());
    }
}
