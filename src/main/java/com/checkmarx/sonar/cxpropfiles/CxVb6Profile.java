package com.checkmarx.sonar.cxpropfiles;

import java.util.List;
import org.sonar.api.*;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

/*
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.NewBuiltInQualityProfile;
import org.sonar.api.utils.ValidationMessages;
*/
import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;

/**
 * Created by: zoharby.
 * Date: 03/10/2017.
 */
public class CxVb6Profile  implements BuiltInQualityProfilesDefinition {
//    private final XMLProfileParser xmlProfileParser;
//
//    public CxVb6Profile(XMLProfileParser xmlProfileParser) {
//        this.xmlProfileParser = xmlProfileParser;
//    }

    @Override
    public void define(Context context) {
        ValidationMessages validation = ValidationMessages.create();
        RulesProfile profile = getRulesProfile(
                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                        CXProgrammingLanguage.VB6.getName().toLowerCase()), validation);

        NewBuiltInQualityProfile qprofile =   context.createBuiltInQualityProfile(profile.getName(), profile.getLanguage());
        
        List<ActiveRule> rules =  profile.getActiveRules();
        
        if(rules != null && rules.size() > 0) {
        	for(ActiveRule r: rules) {
        		qprofile.activateRule(r.getRepositoryKey(),r.getRuleKey());
        	}        	
        }
        
        qprofile.done();
    }

	private RulesProfile getRulesProfile(String format, ValidationMessages validation) {
		// TODO Auto-generated method stub
		final RulesProfile profile = RulesProfile.create("sonar way", format);
		return profile;
	}
}
