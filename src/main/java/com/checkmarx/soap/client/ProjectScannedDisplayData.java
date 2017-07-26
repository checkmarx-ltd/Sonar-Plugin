/**
 * ProjectScannedDisplayData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ProjectScannedDisplayData  implements java.io.Serializable {
    private long projectID;

    private String projectName;

    private long lastScanID;

    private long lastScanDate;

    private String teamName;

    private int riskLevelScore;

    private long LOC;

    private int highVulnerabilities;

    private int mediumVulnerabilities;

    private int lowVulnerabilities;

    private int infoVulnerabilities;

    private int totalVulnerabilities;

    private long queueTime;

    private long scanTime;

    private String failedLOC;

    private long statisticsCalculationDate;

    public ProjectScannedDisplayData() {
    }

    public ProjectScannedDisplayData(
           long projectID,
           String projectName,
           long lastScanID,
           long lastScanDate,
           String teamName,
           int riskLevelScore,
           long LOC,
           int highVulnerabilities,
           int mediumVulnerabilities,
           int lowVulnerabilities,
           int infoVulnerabilities,
           int totalVulnerabilities,
           long queueTime,
           long scanTime,
           String failedLOC,
           long statisticsCalculationDate) {
           this.projectID = projectID;
           this.projectName = projectName;
           this.lastScanID = lastScanID;
           this.lastScanDate = lastScanDate;
           this.teamName = teamName;
           this.riskLevelScore = riskLevelScore;
           this.LOC = LOC;
           this.highVulnerabilities = highVulnerabilities;
           this.mediumVulnerabilities = mediumVulnerabilities;
           this.lowVulnerabilities = lowVulnerabilities;
           this.infoVulnerabilities = infoVulnerabilities;
           this.totalVulnerabilities = totalVulnerabilities;
           this.queueTime = queueTime;
           this.scanTime = scanTime;
           this.failedLOC = failedLOC;
           this.statisticsCalculationDate = statisticsCalculationDate;
    }


    /**
     * Gets the projectID value for this ProjectScannedDisplayData.
     *
     * @return projectID
     */
    public long getProjectID() {
        return projectID;
    }


    /**
     * Sets the projectID value for this ProjectScannedDisplayData.
     *
     * @param projectID
     */
    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }


    /**
     * Gets the projectName value for this ProjectScannedDisplayData.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }


    /**
     * Sets the projectName value for this ProjectScannedDisplayData.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Gets the lastScanID value for this ProjectScannedDisplayData.
     *
     * @return lastScanID
     */
    public long getLastScanID() {
        return lastScanID;
    }


    /**
     * Sets the lastScanID value for this ProjectScannedDisplayData.
     *
     * @param lastScanID
     */
    public void setLastScanID(long lastScanID) {
        this.lastScanID = lastScanID;
    }


    /**
     * Gets the lastScanDate value for this ProjectScannedDisplayData.
     *
     * @return lastScanDate
     */
    public long getLastScanDate() {
        return lastScanDate;
    }


    /**
     * Sets the lastScanDate value for this ProjectScannedDisplayData.
     *
     * @param lastScanDate
     */
    public void setLastScanDate(long lastScanDate) {
        this.lastScanDate = lastScanDate;
    }


    /**
     * Gets the teamName value for this ProjectScannedDisplayData.
     *
     * @return teamName
     */
    public String getTeamName() {
        return teamName;
    }


    /**
     * Sets the teamName value for this ProjectScannedDisplayData.
     *
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    /**
     * Gets the riskLevelScore value for this ProjectScannedDisplayData.
     *
     * @return riskLevelScore
     */
    public int getRiskLevelScore() {
        return riskLevelScore;
    }


    /**
     * Sets the riskLevelScore value for this ProjectScannedDisplayData.
     *
     * @param riskLevelScore
     */
    public void setRiskLevelScore(int riskLevelScore) {
        this.riskLevelScore = riskLevelScore;
    }


    /**
     * Gets the LOC value for this ProjectScannedDisplayData.
     *
     * @return LOC
     */
    public long getLOC() {
        return LOC;
    }


    /**
     * Sets the LOC value for this ProjectScannedDisplayData.
     *
     * @param LOC
     */
    public void setLOC(long LOC) {
        this.LOC = LOC;
    }


    /**
     * Gets the highVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @return highVulnerabilities
     */
    public int getHighVulnerabilities() {
        return highVulnerabilities;
    }


    /**
     * Sets the highVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @param highVulnerabilities
     */
    public void setHighVulnerabilities(int highVulnerabilities) {
        this.highVulnerabilities = highVulnerabilities;
    }


    /**
     * Gets the mediumVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @return mediumVulnerabilities
     */
    public int getMediumVulnerabilities() {
        return mediumVulnerabilities;
    }


    /**
     * Sets the mediumVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @param mediumVulnerabilities
     */
    public void setMediumVulnerabilities(int mediumVulnerabilities) {
        this.mediumVulnerabilities = mediumVulnerabilities;
    }


    /**
     * Gets the lowVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @return lowVulnerabilities
     */
    public int getLowVulnerabilities() {
        return lowVulnerabilities;
    }


    /**
     * Sets the lowVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @param lowVulnerabilities
     */
    public void setLowVulnerabilities(int lowVulnerabilities) {
        this.lowVulnerabilities = lowVulnerabilities;
    }


    /**
     * Gets the infoVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @return infoVulnerabilities
     */
    public int getInfoVulnerabilities() {
        return infoVulnerabilities;
    }


    /**
     * Sets the infoVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @param infoVulnerabilities
     */
    public void setInfoVulnerabilities(int infoVulnerabilities) {
        this.infoVulnerabilities = infoVulnerabilities;
    }


    /**
     * Gets the totalVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @return totalVulnerabilities
     */
    public int getTotalVulnerabilities() {
        return totalVulnerabilities;
    }


    /**
     * Sets the totalVulnerabilities value for this ProjectScannedDisplayData.
     *
     * @param totalVulnerabilities
     */
    public void setTotalVulnerabilities(int totalVulnerabilities) {
        this.totalVulnerabilities = totalVulnerabilities;
    }


    /**
     * Gets the queueTime value for this ProjectScannedDisplayData.
     *
     * @return queueTime
     */
    public long getQueueTime() {
        return queueTime;
    }


    /**
     * Sets the queueTime value for this ProjectScannedDisplayData.
     *
     * @param queueTime
     */
    public void setQueueTime(long queueTime) {
        this.queueTime = queueTime;
    }


    /**
     * Gets the scanTime value for this ProjectScannedDisplayData.
     *
     * @return scanTime
     */
    public long getScanTime() {
        return scanTime;
    }


    /**
     * Sets the scanTime value for this ProjectScannedDisplayData.
     *
     * @param scanTime
     */
    public void setScanTime(long scanTime) {
        this.scanTime = scanTime;
    }


    /**
     * Gets the failedLOC value for this ProjectScannedDisplayData.
     *
     * @return failedLOC
     */
    public String getFailedLOC() {
        return failedLOC;
    }


    /**
     * Sets the failedLOC value for this ProjectScannedDisplayData.
     *
     * @param failedLOC
     */
    public void setFailedLOC(String failedLOC) {
        this.failedLOC = failedLOC;
    }


    /**
     * Gets the statisticsCalculationDate value for this ProjectScannedDisplayData.
     *
     * @return statisticsCalculationDate
     */
    public long getStatisticsCalculationDate() {
        return statisticsCalculationDate;
    }


    /**
     * Sets the statisticsCalculationDate value for this ProjectScannedDisplayData.
     *
     * @param statisticsCalculationDate
     */
    public void setStatisticsCalculationDate(long statisticsCalculationDate) {
        this.statisticsCalculationDate = statisticsCalculationDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ProjectScannedDisplayData)) return false;
        ProjectScannedDisplayData other = (ProjectScannedDisplayData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.projectID == other.getProjectID() &&
            ((this.projectName==null && other.getProjectName()==null) ||
             (this.projectName!=null &&
              this.projectName.equals(other.getProjectName()))) &&
            this.lastScanID == other.getLastScanID() &&
            this.lastScanDate == other.getLastScanDate() &&
            ((this.teamName==null && other.getTeamName()==null) ||
             (this.teamName!=null &&
              this.teamName.equals(other.getTeamName()))) &&
            this.riskLevelScore == other.getRiskLevelScore() &&
            this.LOC == other.getLOC() &&
            this.highVulnerabilities == other.getHighVulnerabilities() &&
            this.mediumVulnerabilities == other.getMediumVulnerabilities() &&
            this.lowVulnerabilities == other.getLowVulnerabilities() &&
            this.infoVulnerabilities == other.getInfoVulnerabilities() &&
            this.totalVulnerabilities == other.getTotalVulnerabilities() &&
            this.queueTime == other.getQueueTime() &&
            this.scanTime == other.getScanTime() &&
            ((this.failedLOC==null && other.getFailedLOC()==null) ||
             (this.failedLOC!=null &&
              this.failedLOC.equals(other.getFailedLOC()))) &&
            this.statisticsCalculationDate == other.getStatisticsCalculationDate();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Long(getProjectID()).hashCode();
        if (getProjectName() != null) {
            _hashCode += getProjectName().hashCode();
        }
        _hashCode += new Long(getLastScanID()).hashCode();
        _hashCode += new Long(getLastScanDate()).hashCode();
        if (getTeamName() != null) {
            _hashCode += getTeamName().hashCode();
        }
        _hashCode += getRiskLevelScore();
        _hashCode += new Long(getLOC()).hashCode();
        _hashCode += getHighVulnerabilities();
        _hashCode += getMediumVulnerabilities();
        _hashCode += getLowVulnerabilities();
        _hashCode += getInfoVulnerabilities();
        _hashCode += getTotalVulnerabilities();
        _hashCode += new Long(getQueueTime()).hashCode();
        _hashCode += new Long(getScanTime()).hashCode();
        if (getFailedLOC() != null) {
            _hashCode += getFailedLOC().hashCode();
        }
        _hashCode += new Long(getStatisticsCalculationDate()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjectScannedDisplayData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectScannedDisplayData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastScanID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LastScanID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastScanDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LastScanDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("teamName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TeamName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riskLevelScore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RiskLevelScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highVulnerabilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "HighVulnerabilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediumVulnerabilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "MediumVulnerabilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowVulnerabilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LowVulnerabilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoVulnerabilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "InfoVulnerabilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalVulnerabilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TotalVulnerabilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queueTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "QueueTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failedLOC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "FailedLOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statisticsCalculationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StatisticsCalculationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
