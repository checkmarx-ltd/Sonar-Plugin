package com.checkmarx.sonar.cxportalservice.osa.model;

/**
 * Created by: zoharby.
 * Date: 09/07/2017.
 */
public enum LastOsaScanStatus {
    SUCCESS(Boolean.TRUE, "Success"), FAILURE(Boolean.FALSE, "Failure");

    private Boolean isSuccess;
    private String presentationValue;

    LastOsaScanStatus(Boolean isSuccess, String presentationValue) {
        this.isSuccess = isSuccess;
        this.presentationValue = presentationValue;
    }

    public String getPresentationValue() {
        return presentationValue;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public static LastOsaScanStatus fromBoolean(Boolean isLastScanSuccessFull){
        return isLastScanSuccessFull ? SUCCESS : FAILURE;
    }
}
