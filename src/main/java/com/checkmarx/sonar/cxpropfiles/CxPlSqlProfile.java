package com.checkmarx.sonar.cxpropfiles;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

/**
 * Created by: zoharby.
 * Date: 17/09/2017.
 */
public class CxPlSqlProfile implements BuiltInQualityProfilesDefinition {

    private final XMLProfileParser xmlProfileParser;

    public CxPlSqlProfile(XMLProfileParser xmlProfileParser) {
        this.xmlProfileParser = xmlProfileParser;
    }

    @Override
    public void define(BuiltInQualityProfilesDefinition.Context context) {
        ValidationMessages validation = ValidationMessages.create();
        RulesProfile profile = xmlProfileParser.parseResource(getClass().getClassLoader(),
                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                        CXProgrammingLanguage.PLSQL.getName().toLowerCase()), validation);

        context.createBuiltInQualityProfile(profile.getName(), profile.getLanguage());

    }

}
