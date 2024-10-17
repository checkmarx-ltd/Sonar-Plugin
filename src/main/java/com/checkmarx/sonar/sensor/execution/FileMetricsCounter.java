package com.checkmarx.sonar.sensor.execution;

/**
 * Created by: zoharby.
 * Date: 06/08/2017.
 */
class FileMetricsCounter {

	private int critical = 0;
    private int high = 0;
    private int medium = 0;
    private int low = 0;
    private int sumVulnerabilities = 0;

    FileMetricsCounter() {
    }

    void incrementCritical() {
        ++ this.critical;
        incrementSum();
    }
    
    void incrementHigh() {
        ++ this.high;
        incrementSum();
    }

    void incrementMedium() {
        ++ this.medium;
        incrementSum();
    }

    void incrementLow() {
        ++this.low;
        incrementSum();
    }

    private void incrementSum() {
        ++ this.sumVulnerabilities;
    }

    public int getCritical() {
        return critical;
    }
    
    public int getHigh() {
        return high;
    }

    public int getMedium() {
        return medium;
    }

    public int getLow() {
        return low;
    }

    public int getSumVulnerabilities() {
        return sumVulnerabilities;
    }
}
