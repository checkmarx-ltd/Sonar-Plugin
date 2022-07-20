package com.checkmarx.sonar.cxpropfiles;

import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;

/**
 * Created by: zoharby.
 * Date: 03/10/2017.
 */
public class CxJavaScriptProfile implements BuiltInQualityProfilesDefinition {
    private final XMLProfileParser xmlProfileParser;

    public CxJavaScriptProfile(XMLProfileParser xmlProfileParser) {
        this.xmlProfileParser = xmlProfileParser;
    }

    @Override
    public void define(Context context) {
        ValidationMessages validation = ValidationMessages.create();
        RulesProfile profile = xmlProfileParser.parseResource(getClass().getClassLoader(),
                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                        CXProgrammingLanguage.JAVASCRIPT.getName().toLowerCase()), validation);

        context.createBuiltInQualityProfile(profile.getName(), profile.getLanguage());
    }
}
