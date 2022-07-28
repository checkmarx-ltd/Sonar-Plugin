package com.checkmarx.sonar.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by: umeshw.
 * Date: 27/07/2022.
 */
public class CxSensorSettings {

    @JsonProperty("settings")
    private List<CxSensorSetting> settings;
    @JsonProperty("setSecuredSettings")
    private List<CxSensorSetting> setSecuredSettings;

    public CxSensorSettings() {
    }

    public CxSensorSettings(List<CxSensorSetting> settings, List<CxSensorSetting> setSecuredSettings) {		
		this.settings = settings;
		this.setSecuredSettings = setSecuredSettings;
	}
    
    public String getFirstSettingValue() {
    	if(settings != null && settings.size() > 0 ) {
    		return settings.get(0).getValue();
    	}
    	return "";
    }
}