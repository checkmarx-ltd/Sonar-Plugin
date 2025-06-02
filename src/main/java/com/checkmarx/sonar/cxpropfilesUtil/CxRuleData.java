package com.checkmarx.sonar.cxpropfilesUtil;

public class CxRuleData {
    private String repositoryKey;
    private String key;
    // Optionally, you can add priority and parameters fields

    public CxRuleData(String repositoryKey, String key) {
        this.repositoryKey = repositoryKey;
        this.key = key;
    }

    public String getRepositoryKey() {
        return repositoryKey;
    }

    public String getKey() {
        return key;
    }
}
