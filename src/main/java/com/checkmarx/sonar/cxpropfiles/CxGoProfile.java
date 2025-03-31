package com.checkmarx.sonar.cxpropfiles;

import java.io.InputStream;
import java.util.List;

import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

import com.checkmarx.sonar.cxpropfilesUtil.cxProfileData;
import com.checkmarx.sonar.cxpropfilesUtil.cxProfileParserUtil;
import com.checkmarx.sonar.cxpropfilesUtil.cxRuleData;
import com.checkmarx.sonar.cxrules.CXProgrammingLanguage;
import com.checkmarx.sonar.logger.CxLogger;

/**
 * Created by: zoharby.
 * Date: 03/10/2017.
 */
public class CxGoProfile implements BuiltInQualityProfilesDefinition {

    private CxLogger logger = new CxLogger(CxGoProfile.class);

    @Override
    public void define(Context context) {
        String profilePath = String.format(CxProfilesConstants.PROFILE_PATH_TEMPLATE,
                CXProgrammingLanguage.GO.getName().toLowerCase());

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

