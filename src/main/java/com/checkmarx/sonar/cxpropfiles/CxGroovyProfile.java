package com.checkmarx.sonar.cxpropfiles;

import java.util.List;

import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.NewBuiltInQualityProfile;
import org.sonar.api.utils.ValidationMessages;

import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;

/**
 * Created by: zoharby.
 * Date: 03/10/2017.
 */
public class CxGroovyProfile implements BuiltInQualityProfilesDefinition {

    private final XMLProfileParser xmlProfileParser;

    public CxGroovyProfile(XMLProfileParser xmlProfileParser) {
        this.xmlProfileParser = xmlProfileParser;
    }

    @Override
    public void define(Context context) {
        ValidationMessages validation = ValidationMessages.create();
        RulesProfile profile = xmlProfileParser.parseResource(getClass().getClassLoader(),
                String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                        CXProgrammingLanguage.GROOVY.getName().toLowerCase()), validation);

        NewBuiltInQualityProfile qprofile =   context.createBuiltInQualityProfile(profile.getName(), profile.getLanguage());
        
        List<ActiveRule> rules =  profile.getActiveRules();
        
        if(rules != null && rules.size() > 0) {
        	for(ActiveRule r: rules) {
        		qprofile.activateRule(r.getRepositoryKey(),r.getRuleKey());
        	}        	
        }
        
        qprofile.done();
    }
}

