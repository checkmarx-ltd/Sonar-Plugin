package com.checkmarx.sonar.cxpropfiles;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import java.io.InputStream;

import com.checkmarx.sonar.cxpropfilesUtil.CxProfileData;
import com.checkmarx.sonar.cxpropfilesUtil.CxProfileParserUtil;
import com.checkmarx.sonar.cxpropfilesUtil.CxRuleData;
import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import com.checkmarx.sonar.logger.CxLogger;

/**
 * Created by: zoharby.
 * Date: 17/09/2017.
 */
public class CxJavaProfile implements BuiltInQualityProfilesDefinition {

    private CxLogger logger = new CxLogger(CxJavaProfile.class);

    @Override
    public void define(Context context) {

        String profilePath = String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                CXProgrammingLanguage.JAVA.getName().toLowerCase());

        try (InputStream profileFile = getClass().getClassLoader().getResourceAsStream(profilePath)) {
            if (profileFile == null) {
                logger.warn("Profile file not found: " + profilePath);
                return;
            }
            // Parse the XML using our utility
            CxProfileData profileData = CxProfileParserUtil.parseProfile(profileFile);
            NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(profileData.getName(),
                    profileData.getLanguage());

            // Activate each rule
            for (CxRuleData rule : profileData.getRules()) {
                profile.activateRule(rule.getRepositoryKey(), rule.getKey());
            }
            profile.done();
        } catch (Exception e) {
            logger.error("Failed to define built-in quality profile: " + profilePath);
            e.printStackTrace();
        }
    }
}
