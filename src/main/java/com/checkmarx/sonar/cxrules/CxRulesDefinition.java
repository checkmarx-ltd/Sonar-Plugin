package com.checkmarx.sonar.cxrules;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionXmlLoader;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by: Zoharby.
 * Date: 18/07/2017.
 */
public class CxRulesDefinition implements RulesDefinition {

    private Logger logger = Loggers.get(CxRulesDefinition.class);

    @Override
    public void define(Context context) {

        for (CXProgrammingLanguage language : CXProgrammingLanguage.values()) {
            logger.info("Creating rule repository for: " + language.getName() + " language.");
            NewRepository repository = context.createRepository("checkmarx.rules." + language.getName().toLowerCase(), language.getSonarName()).setName("Checkmarx");
            try {
                InputStream rulesXml = this.getClass().getResourceAsStream(getLanguageRulesPath(language));
                if (rulesXml != null) {
                    RulesDefinitionXmlLoader rulesLoader = new RulesDefinitionXmlLoader();
                    rulesLoader.load(repository, rulesXml, StandardCharsets.UTF_8.name());
                } else {
                    logger.error("Could not load rules xml for: " + language.getName() + " language.");
                }
            } catch (Exception e) {
                logger.error("Could create rules repository for: " + language.getName() + " language.");
                e.printStackTrace();
            }

            repository.done();
        }

    }


    private String getLanguageRulesPath(CXProgrammingLanguage language) {
        return "/com/checkmarx/sonar/rules/" + language.getName().toLowerCase() + "-rules.xml";
    }

}
