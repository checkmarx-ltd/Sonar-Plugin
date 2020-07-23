package com.checkmarx.sonar.cxportalservice.osa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.logging.Logger;

/**
 * Created by: zoharby.
 * Date: 19/06/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScanState {
    @JsonProperty("id")
    int id;
    @JsonProperty("name")
    String name;
    @JsonProperty("failureReason")
    String failureReason;

    @JsonIgnore
    private
    Logger logger = Logger.getLogger(ScanState.class.getName());

    public ScanState() {
        logger.info("ScanState empty constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

}
