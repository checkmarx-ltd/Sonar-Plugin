package com.checkmarx.sonar.cxpropfilesUtil;

import java.util.ArrayList;
import java.util.List;

public class CxProfileData {
    private String name;
    private String language;
    private List<CxRuleData> rules = new ArrayList<>();

    public CxProfileData(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public List<CxRuleData> getRules() {
        return rules;
    }

    public void addRule(CxRuleData rule) {
        rules.add(rule);
    }
}
