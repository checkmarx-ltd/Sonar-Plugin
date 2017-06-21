package com.checkmarx.sonar.sensor.dto;

/**
 * Created by: zoharby.
 * Date: 20/06/2017.
 */
public enum SastSeverity {

    SAST_HIGH(3), SAST_MEDIUM(2), SAST_LOW(1), SAST_INFO(0);
    int value;

    SastSeverity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SastSeverity fromId(int id){
        for (SastSeverity type : SastSeverity.values()) {
            if (type.getValue() == id) {
                return type;
            }
        }
        return null;
    }

}
