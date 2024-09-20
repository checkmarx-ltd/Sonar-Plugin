package com.checkmarx.sonar.cxpropfiles;

import java.util.List;

//import org.sonar.api.profiles.RulesProfile;
//import org.sonar.api.*;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.ActiveRule;
//import org.sonar.api.rules.ActiveRule;
//import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
//import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.NewBuiltInQualityProfile;
//import org.sonar.api.utils.ValidationMessages;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;
import org.sonar.api.rules.ActiveRule;


import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;



//import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;


/**
 * Created by: zoharby.
 * Date: 03/10/2017.
 */
public class CxCppProfile implements BuiltInQualityProfilesDefinition {

   // private final XMLProfileParser xmlProfileParser;

 //   public CxCppProfile(XMLProfileParser xmlProfileParser) {
    //    this.xmlProfileParser = xmlProfileParser;
 //   }
    //@Override
    //public RulesProfile createProfile(ValidationMessages validation) {
    //    return xmlProfileParser.parseResource(getClass().getClassLoader(),
    //            String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
    //                    CXProgrammingLanguage.CPP.getName().toLowerCase()), validation);
    //}

    @Override
    public void define(Context context) {
        ValidationMessages validation = ValidationMessages.create();
//        RulesProfile profile = xmlProfileParser.parseResource(getClass().getClassLoader(),
//                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
//                        CXProgrammingLanguage.CPP.getName().toLowerCase()), validation);
        RulesProfile profile = getRulesProfile(String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
              CXProgrammingLanguage.CPP.getName().toLowerCase()), validation);
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