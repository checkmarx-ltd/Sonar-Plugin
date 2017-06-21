package com.checkmarx.sonar.sensor.dto;

/**
 * Created by: zoharby.
 * Date: 20/06/2017.
 */
public enum OsaSeverity {

    OSA_HIGH(2), OSA_MEDIUM(1), OSA_LOW(0);
    int value;

    OsaSeverity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OsaSeverity fromId(int id){
        for (OsaSeverity type : OsaSeverity.values()) {
            if (type.getValue() == id) {
                return type;
            }
        }
        return null;
    }
}
