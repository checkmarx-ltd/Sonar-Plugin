package com.checkmarx.sonar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by: umeshw.
 * Date: 27/07/2022.
 */
public class CxSensorSetting {

    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;

    public CxSensorSetting() {
    }

	public CxSensorSetting(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public final String getKey() {
		return key;
	}

	public final void setKey(String key) {
		this.key = key;
	}

	public final String getValue() {
		return value;
	}

	public final void setValue(String value) {
		this.value = value;
	}
	
}