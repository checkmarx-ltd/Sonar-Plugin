package com.checkmarx.sonar.cxportalservice.osa.model;

/**
 * Created by: zoharby.
 * Date: 04/07/2017.
 */
public class OsaLatestScansData {

    private Boolean isLastScanSuccessful;
    private String failureMsg;
    private OsaScan lastSuccessfulOsaScan;

    public OsaLatestScansData(Boolean isLastScanSuccessful, String failureMsg, OsaScan lastSuccessfulOsaScan) {
        this.isLastScanSuccessful = isLastScanSuccessful;
        this.failureMsg = failureMsg;
        this.lastSuccessfulOsaScan = lastSuccessfulOsaScan;
    }

    public boolean isLastScanSuccessful() {
        return isLastScanSuccessful;
    }

    public void setLastScanSuccessful(Boolean lastScanSuccessful) {
        isLastScanSuccessful = lastScanSuccessful;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public OsaScan getLastSuccessfulOsaScan() {
        return lastSuccessfulOsaScan;
    }

    public void setLastSuccessfulOsaScan(OsaScan lastSuccessfulOsaScan) {
        this.lastSuccessfulOsaScan = lastSuccessfulOsaScan;
    }
}
