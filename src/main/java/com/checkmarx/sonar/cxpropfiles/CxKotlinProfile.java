package com.checkmarx.sonar.cxpropfiles;

import com.checkmarx.sonar.cxpropfilesUtil.cxProfileData;
import com.checkmarx.sonar.cxpropfilesUtil.cxProfileParserUtil;
import com.checkmarx.sonar.cxpropfilesUtil.cxRuleData;
import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import com.checkmarx.sonar.logger.CxLogger;

import java.io.InputStream;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;

/**
 * Created by: zoharby.
 * Date: 17/09/2017.
 */
public class CxKotlinProfile implements BuiltInQualityProfilesDefinition {

    private CxLogger logger = new CxLogger(CxKotlinProfile.class);

	@Override
	public void define(Context context) {
        String profilePath = String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                CXProgrammingLanguage.KOTLIN.getName().toLowerCase());

        try (InputStream profileFile = getClass().getClassLoader().getResourceAsStream(profilePath)) {
            if (profileFile == null) {
                logger.warn("Profile file not found: " + profilePath);
                return;
            }
            // Parse the XML using our utility
            cxProfileData profileData = cxProfileParserUtil.parseProfile(profileFile);
            NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(profileData.getName(),
                    profileData.getLanguage());

            // Activate each rule
            for (cxRuleData rule : profileData.getRules()) {
                profile.activateRule(rule.getRepositoryKey(), rule.getKey());
            }
            profile.done();
        } catch (Exception e) {
            logger.error("Failed to define built-in quality profile: " + profilePath);
            e.printStackTrace();
        }

	}
    
    
    
    
}
