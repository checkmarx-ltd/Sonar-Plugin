package com.checkmarx.sonar.cxpropfiles;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;

import java.util.List;

import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.NewBuiltInQualityProfile;
import org.sonar.api.utils.ValidationMessages;

/**
 * Created by: zoharby.
 * Date: 17/09/2017.
 */
public class CxKotlinProfile implements BuiltInQualityProfilesDefinition {

    private final XMLProfileParser xmlProfileParser;

    public CxKotlinProfile(XMLProfileParser xmlProfileParser) {
        this.xmlProfileParser = xmlProfileParser;
    }

//    @Override
//    public RulesProfile createProfile(ValidationMessages validation) {
//        return xmlProfileParser.parseResource(getClass().getClassLoader(),
//                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
//                        CXProgrammingLanguage.KOTLIN.getName().toLowerCase()), validation);
//    }

	@Override
	public void define(Context context) {
		ValidationMessages validation = ValidationMessages.create();
		RulesProfile profile = xmlProfileParser.parseResource(getClass().getClassLoader(),
				String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
						CXProgrammingLanguage.KOTLIN.getName().toLowerCase()),
				validation);

		NewBuiltInQualityProfile qprofile = context.createBuiltInQualityProfile(profile.getName(),
				profile.getLanguage());

		List<ActiveRule> rules = profile.getActiveRules();

		if (rules != null && rules.size() > 0) {
			for (ActiveRule r : rules) {
				qprofile.activateRule(r.getRepositoryKey(), r.getRuleKey());
			}
		}

		qprofile.done();

	}
    
    
    
    
}
