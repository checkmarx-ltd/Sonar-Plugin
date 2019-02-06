package com.checkmarx.sonar.sensor.dto;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ProjectDetails {

    private String projectName;
    private String teamName;
    private String teamId;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

}