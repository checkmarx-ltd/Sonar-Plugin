/**
 * ScanDisplayData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanDisplayData  implements java.io.Serializable {
    private long scanID;

    private boolean isAllowedToDelete;

    private CxDateTime queuedDateTime;

    private int riskLevelScore;

    private CxDateTime finishedDateTime;

    private long projectId;

    private String projectName;

    private String initiatorName;

    private String teamName;

    private boolean isIncremental;

    private String cxVersion;

    private long LOC;

    private int highSeverityResults;

    private int mediumSeverityResults;

    private int lowSeverityResults;

    private String comments;

    private ScanType scanDisplayType;

    private String serverName;

    private String origin;

    private String failedLOC;

    private CxDateTime statisticsCalculationDate;

    private boolean isPublic;

    private boolean isLocked;

    public ScanDisplayData() {
    }

    public ScanDisplayData(
           long scanID,
           boolean isAllowedToDelete,
           CxDateTime queuedDateTime,
           int riskLevelScore,
           CxDateTime finishedDateTime,
           long projectId,
           String projectName,
           String initiatorName,
           String teamName,
           boolean isIncremental,
           String cxVersion,
           long LOC,
           int highSeverityResults,
           int mediumSeverityResults,
           int lowSeverityResults,
           String comments,
           ScanType scanDisplayType,
           String serverName,
           String origin,
           String failedLOC,
           CxDateTime statisticsCalculationDate,
           boolean isPublic,
           boolean isLocked) {
           this.scanID = scanID;
           this.isAllowedToDelete = isAllowedToDelete;
           this.queuedDateTime = queuedDateTime;
           this.riskLevelScore = riskLevelScore;
           this.finishedDateTime = finishedDateTime;
           this.projectId = projectId;
           this.projectName = projectName;
           this.initiatorName = initiatorName;
           this.teamName = teamName;
           this.isIncremental = isIncremental;
           this.cxVersion = cxVersion;
           this.LOC = LOC;
           this.highSeverityResults = highSeverityResults;
           this.mediumSeverityResults = mediumSeverityResults;
           this.lowSeverityResults = lowSeverityResults;
           this.comments = comments;
           this.scanDisplayType = scanDisplayType;
           this.serverName = serverName;
           this.origin = origin;
           this.failedLOC = failedLOC;
           this.statisticsCalculationDate = statisticsCalculationDate;
           this.isPublic = isPublic;
           this.isLocked = isLocked;
    }


    /**
     * Gets the scanID value for this ScanDisplayData.
     *
     * @return scanID
     */
    public long getScanID() {
        return scanID;
    }


    /**
     * Sets the scanID value for this ScanDisplayData.
     *
     * @param scanID
     */
    public void setScanID(long scanID) {
        this.scanID = scanID;
    }


    /**
     * Gets the isAllowedToDelete value for this ScanDisplayData.
     *
     * @return isAllowedToDelete
     */
    public boolean isIsAllowedToDelete() {
        return isAllowedToDelete;
    }


    /**
     * Sets the isAllowedToDelete value for this ScanDisplayData.
     *
     * @param isAllowedToDelete
     */
    public void setIsAllowedToDelete(boolean isAllowedToDelete) {
        this.isAllowedToDelete = isAllowedToDelete;
    }


    /**
     * Gets the queuedDateTime value for this ScanDisplayData.
     *
     * @return queuedDateTime
     */
    public CxDateTime getQueuedDateTime() {
        return queuedDateTime;
    }


    /**
     * Sets the queuedDateTime value for this ScanDisplayData.
     *
     * @param queuedDateTime
     */
    public void setQueuedDateTime(CxDateTime queuedDateTime) {
        this.queuedDateTime = queuedDateTime;
    }


    /**
     * Gets the riskLevelScore value for this ScanDisplayData.
     *
     * @return riskLevelScore
     */
    public int getRiskLevelScore() {
        return riskLevelScore;
    }


    /**
     * Sets the riskLevelScore value for this ScanDisplayData.
     *
     * @param riskLevelScore
     */
    public void setRiskLevelScore(int riskLevelScore) {
        this.riskLevelScore = riskLevelScore;
    }


    /**
     * Gets the finishedDateTime value for this ScanDisplayData.
     *
     * @return finishedDateTime
     */
    public CxDateTime getFinishedDateTime() {
        return finishedDateTime;
    }


    /**
     * Sets the finishedDateTime value for this ScanDisplayData.
     *
     * @param finishedDateTime
     */
    public void setFinishedDateTime(CxDateTime finishedDateTime) {
        this.finishedDateTime = finishedDateTime;
    }


    /**
     * Gets the projectId value for this ScanDisplayData.
     *
     * @return projectId
     */
    public long getProjectId() {
        return projectId;
    }


    /**
     * Sets the projectId value for this ScanDisplayData.
     *
     * @param projectId
     */
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }


    /**
     * Gets the projectName value for this ScanDisplayData.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }


    /**
     * Sets the projectName value for this ScanDisplayData.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Gets the initiatorName value for this ScanDisplayData.
     *
     * @return initiatorName
     */
    public String getInitiatorName() {
        return initiatorName;
    }


    /**
     * Sets the initiatorName value for this ScanDisplayData.
     *
     * @param initiatorName
     */
    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }


    /**
     * Gets the teamName value for this ScanDisplayData.
     *
     * @return teamName
     */
    public String getTeamName() {
        return teamName;
    }


    /**
     * Sets the teamName value for this ScanDisplayData.
     *
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    /**
     * Gets the isIncremental value for this ScanDisplayData.
     *
     * @return isIncremental
     */
    public boolean isIsIncremental() {
        return isIncremental;
    }


    /**
     * Sets the isIncremental value for this ScanDisplayData.
     *
     * @param isIncremental
     */
    public void setIsIncremental(boolean isIncremental) {
        this.isIncremental = isIncremental;
    }


    /**
     * Gets the cxVersion value for this ScanDisplayData.
     *
     * @return cxVersion
     */
    public String getCxVersion() {
        return cxVersion;
    }


    /**
     * Sets the cxVersion value for this ScanDisplayData.
     *
     * @param cxVersion
     */
    public void setCxVersion(String cxVersion) {
        this.cxVersion = cxVersion;
    }


    /**
     * Gets the LOC value for this ScanDisplayData.
     *
     * @return LOC
     */
    public long getLOC() {
        return LOC;
    }


    /**
     * Sets the LOC value for this ScanDisplayData.
     *
     * @param LOC
     */
    public void setLOC(long LOC) {
        this.LOC = LOC;
    }


    /**
     * Gets the highSeverityResults value for this ScanDisplayData.
     *
     * @return highSeverityResults
     */
    public int getHighSeverityResults() {
        return highSeverityResults;
    }


    /**
     * Sets the highSeverityResults value for this ScanDisplayData.
     *
     * @param highSeverityResults
     */
    public void setHighSeverityResults(int highSeverityResults) {
        this.highSeverityResults = highSeverityResults;
    }


    /**
     * Gets the mediumSeverityResults value for this ScanDisplayData.
     *
     * @return mediumSeverityResults
     */
    public int getMediumSeverityResults() {
        return mediumSeverityResults;
    }


    /**
     * Sets the mediumSeverityResults value for this ScanDisplayData.
     *
     * @param mediumSeverityResults
     */
    public void setMediumSeverityResults(int mediumSeverityResults) {
        this.mediumSeverityResults = mediumSeverityResults;
    }


    /**
     * Gets the lowSeverityResults value for this ScanDisplayData.
     *
     * @return lowSeverityResults
     */
    public int getLowSeverityResults() {
        return lowSeverityResults;
    }


    /**
     * Sets the lowSeverityResults value for this ScanDisplayData.
     *
     * @param lowSeverityResults
     */
    public void setLowSeverityResults(int lowSeverityResults) {
        this.lowSeverityResults = lowSeverityResults;
    }


    /**
     * Gets the comments value for this ScanDisplayData.
     *
     * @return comments
     */
    public String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this ScanDisplayData.
     *
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }


    /**
     * Gets the scanDisplayType value for this ScanDisplayData.
     *
     * @return scanDisplayType
     */
    public ScanType getScanDisplayType() {
        return scanDisplayType;
    }


    /**
     * Sets the scanDisplayType value for this ScanDisplayData.
     *
     * @param scanDisplayType
     */
    public void setScanDisplayType(ScanType scanDisplayType) {
        this.scanDisplayType = scanDisplayType;
    }


    /**
     * Gets the serverName value for this ScanDisplayData.
     *
     * @return serverName
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the serverName value for this ScanDisplayData.
     *
     * @param serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Gets the origin value for this ScanDisplayData.
     *
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }


    /**
     * Sets the origin value for this ScanDisplayData.
     *
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }


    /**
     * Gets the failedLOC value for this ScanDisplayData.
     *
     * @return failedLOC
     */
    public String getFailedLOC() {
        return failedLOC;
    }


    /**
     * Sets the failedLOC value for this ScanDisplayData.
     *
     * @param failedLOC
     */
    public void setFailedLOC(String failedLOC) {
        this.failedLOC = failedLOC;
    }


    /**
     * Gets the statisticsCalculationDate value for this ScanDisplayData.
     *
     * @return statisticsCalculationDate
     */
    public CxDateTime getStatisticsCalculationDate() {
        return statisticsCalculationDate;
    }


    /**
     * Sets the statisticsCalculationDate value for this ScanDisplayData.
     *
     * @param statisticsCalculationDate
     */
    public void setStatisticsCalculationDate(CxDateTime statisticsCalculationDate) {
        this.statisticsCalculationDate = statisticsCalculationDate;
    }


    /**
     * Gets the isPublic value for this ScanDisplayData.
     *
     * @return isPublic
     */
    public boolean isIsPublic() {
        return isPublic;
    }


    /**
     * Sets the isPublic value for this ScanDisplayData.
     *
     * @param isPublic
     */
    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


    /**
     * Gets the isLocked value for this ScanDisplayData.
     *
     * @return isLocked
     */
    public boolean isIsLocked() {
        return isLocked;
    }


    /**
     * Sets the isLocked value for this ScanDisplayData.
     *
     * @param isLocked
     */
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanDisplayData)) return false;
        ScanDisplayData other = (ScanDisplayData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.scanID == other.getScanID() &&
            this.isAllowedToDelete == other.isIsAllowedToDelete() &&
            ((this.queuedDateTime==null && other.getQueuedDateTime()==null) ||
             (this.queuedDateTime!=null &&
              this.queuedDateTime.equals(other.getQueuedDateTime()))) &&
            this.riskLevelScore == other.getRiskLevelScore() &&
            ((this.finishedDateTime==null && other.getFinishedDateTime()==null) ||
             (this.finishedDateTime!=null &&
              this.finishedDateTime.equals(other.getFinishedDateTime()))) &&
            this.projectId == other.getProjectId() &&
            ((this.projectName==null && other.getProjectName()==null) ||
             (this.projectName!=null &&
              this.projectName.equals(other.getProjectName()))) &&
            ((this.initiatorName==null && other.getInitiatorName()==null) ||
             (this.initiatorName!=null &&
              this.initiatorName.equals(other.getInitiatorName()))) &&
            ((this.teamName==null && other.getTeamName()==null) ||
             (this.teamName!=null &&
              this.teamName.equals(other.getTeamName()))) &&
            this.isIncremental == other.isIsIncremental() &&
            ((this.cxVersion==null && other.getCxVersion()==null) ||
             (this.cxVersion!=null &&
              this.cxVersion.equals(other.getCxVersion()))) &&
            this.LOC == other.getLOC() &&
            this.highSeverityResults == other.getHighSeverityResults() &&
            this.mediumSeverityResults == other.getMediumSeverityResults() &&
            this.lowSeverityResults == other.getLowSeverityResults() &&
            ((this.comments==null && other.getComments()==null) ||
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.scanDisplayType==null && other.getScanDisplayType()==null) ||
             (this.scanDisplayType!=null &&
              this.scanDisplayType.equals(other.getScanDisplayType()))) &&
            ((this.serverName==null && other.getServerName()==null) ||
             (this.serverName!=null &&
              this.serverName.equals(other.getServerName()))) &&
            ((this.origin==null && other.getOrigin()==null) ||
             (this.origin!=null &&
              this.origin.equals(other.getOrigin()))) &&
            ((this.failedLOC==null && other.getFailedLOC()==null) ||
             (this.failedLOC!=null &&
              this.failedLOC.equals(other.getFailedLOC()))) &&
            ((this.statisticsCalculationDate==null && other.getStatisticsCalculationDate()==null) ||
             (this.statisticsCalculationDate!=null &&
              this.statisticsCalculationDate.equals(other.getStatisticsCalculationDate()))) &&
            this.isPublic == other.isIsPublic() &&
            this.isLocked == other.isIsLocked();
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
        _hashCode += new Long(getScanID()).hashCode();
        _hashCode += (isIsAllowedToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getQueuedDateTime() != null) {
            _hashCode += getQueuedDateTime().hashCode();
        }
        _hashCode += getRiskLevelScore();
        if (getFinishedDateTime() != null) {
            _hashCode += getFinishedDateTime().hashCode();
        }
        _hashCode += new Long(getProjectId()).hashCode();
        if (getProjectName() != null) {
            _hashCode += getProjectName().hashCode();
        }
        if (getInitiatorName() != null) {
            _hashCode += getInitiatorName().hashCode();
        }
        if (getTeamName() != null) {
            _hashCode += getTeamName().hashCode();
        }
        _hashCode += (isIsIncremental() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCxVersion() != null) {
            _hashCode += getCxVersion().hashCode();
        }
        _hashCode += new Long(getLOC()).hashCode();
        _hashCode += getHighSeverityResults();
        _hashCode += getMediumSeverityResults();
        _hashCode += getLowSeverityResults();
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getScanDisplayType() != null) {
            _hashCode += getScanDisplayType().hashCode();
        }
        if (getServerName() != null) {
            _hashCode += getServerName().hashCode();
        }
        if (getOrigin() != null) {
            _hashCode += getOrigin().hashCode();
        }
        if (getFailedLOC() != null) {
            _hashCode += getFailedLOC().hashCode();
        }
        if (getStatisticsCalculationDate() != null) {
            _hashCode += getStatisticsCalculationDate().hashCode();
        }
        _hashCode += (isIsPublic() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsLocked() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanDisplayData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanDisplayData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToDelete");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToDelete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queuedDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "QueuedDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
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
        elemField.setFieldName("finishedDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "FinishedDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectId"));
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
        elemField.setFieldName("initiatorName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "InitiatorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("isIncremental");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsIncremental"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cxVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highSeverityResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "HighSeverityResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediumSeverityResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "MediumSeverityResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowSeverityResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LowSeverityResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanDisplayType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanDisplayType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ServerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Origin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPublic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsPublic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLocked");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsLocked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
