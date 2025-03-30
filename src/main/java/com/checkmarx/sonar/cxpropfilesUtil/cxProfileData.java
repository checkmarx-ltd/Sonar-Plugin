package com.checkmarx.sonar.cxpropfilesUtil;

import java.util.ArrayList;
import java.util.List;

public class cxProfileData {
    private String name;
    private String language;
    private List<cxRuleData> rules = new ArrayList<>();

    public cxProfileData(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public List<cxRuleData> getRules() {
        return rules;
    }

    public void addRule(cxRuleData rule) {
        rules.add(rule);
    }
}
