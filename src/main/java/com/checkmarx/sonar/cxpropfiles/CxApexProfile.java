package com.checkmarx.sonar.cxpropfiles;

import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;

/**
 * Created by: zoharby.
 * Date: 18/10/2017.
 */
public class CxApexProfile implements BuiltInQualityProfilesDefinition {

    private final XMLProfileParser xmlProfileParser;

    public CxApexProfile(XMLProfileParser xmlProfileParser) {
        this.xmlProfileParser = xmlProfileParser;
    }

	/*
	 * @Override public RulesProfile createProfile(ValidationMessages validation) {
	 * return xmlProfileParser.parseResource(getClass().getClassLoader(),
	 * String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
	 * CXProgrammingLanguage.APEX.getName().toLowerCase()), validation); }
	 */
    
    @Override
    public void define(Context context) {
        ValidationMessages validation = ValidationMessages.create();
        RulesProfile profile = xmlProfileParser.parseResource(getClass().getClassLoader(),
                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                        CXProgrammingLanguage.APEX.getName().toLowerCase()), validation);

        context.createBuiltInQualityProfile(profile.getName(), profile.getLanguage());
    }
}