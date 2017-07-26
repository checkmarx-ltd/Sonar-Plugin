/**
 * CxWSResponseScanSummary.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseScanSummary  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private CxDateTime started;

    private CxDateTime finished;

    private int scanRisk;

    private String preset;

    private String path;

    private String comment;

    private long LOC;

    private long filesCount;

    private int high;

    private int medium;

    private int low;

    private int info;

    private int scanRiskSeverity;

    private int scanRiskQuantity;

    private boolean isIncremental;

    private ScanType scanType;

    private ArrayOfCxWSQueryLanguageState scanLanguageStateCollection;

    private CxDateTime engineStart;

    private CxDateTime engineFinish;

    private CxDateTime scanQueued;

    private long totalScanTime;

    private CxDateTime statisticsCalculationDate;

    private String projectName;

    private String teamName;

    public CxWSResponseScanSummary() {
    }

    public CxWSResponseScanSummary(
           boolean isSuccesfull,
           String errorMessage,
           CxDateTime started,
           CxDateTime finished,
           int scanRisk,
           String preset,
           String path,
           String comment,
           long LOC,
           long filesCount,
           int high,
           int medium,
           int low,
           int info,
           int scanRiskSeverity,
           int scanRiskQuantity,
           boolean isIncremental,
           ScanType scanType,
           ArrayOfCxWSQueryLanguageState scanLanguageStateCollection,
           CxDateTime engineStart,
           CxDateTime engineFinish,
           CxDateTime scanQueued,
           long totalScanTime,
           CxDateTime statisticsCalculationDate,
           String projectName,
           String teamName) {
        super(
            isSuccesfull,
            errorMessage);
        this.started = started;
        this.finished = finished;
        this.scanRisk = scanRisk;
        this.preset = preset;
        this.path = path;
        this.comment = comment;
        this.LOC = LOC;
        this.filesCount = filesCount;
        this.high = high;
        this.medium = medium;
        this.low = low;
        this.info = info;
        this.scanRiskSeverity = scanRiskSeverity;
        this.scanRiskQuantity = scanRiskQuantity;
        this.isIncremental = isIncremental;
        this.scanType = scanType;
        this.scanLanguageStateCollection = scanLanguageStateCollection;
        this.engineStart = engineStart;
        this.engineFinish = engineFinish;
        this.scanQueued = scanQueued;
        this.totalScanTime = totalScanTime;
        this.statisticsCalculationDate = statisticsCalculationDate;
        this.projectName = projectName;
        this.teamName = teamName;
    }


    /**
     * Gets the started value for this CxWSResponseScanSummary.
     *
     * @return started
     */
    public CxDateTime getStarted() {
        return started;
    }


    /**
     * Sets the started value for this CxWSResponseScanSummary.
     *
     * @param started
     */
    public void setStarted(CxDateTime started) {
        this.started = started;
    }


    /**
     * Gets the finished value for this CxWSResponseScanSummary.
     *
     * @return finished
     */
    public CxDateTime getFinished() {
        return finished;
    }


    /**
     * Sets the finished value for this CxWSResponseScanSummary.
     *
     * @param finished
     */
    public void setFinished(CxDateTime finished) {
        this.finished = finished;
    }


    /**
     * Gets the scanRisk value for this CxWSResponseScanSummary.
     *
     * @return scanRisk
     */
    public int getScanRisk() {
        return scanRisk;
    }


    /**
     * Sets the scanRisk value for this CxWSResponseScanSummary.
     *
     * @param scanRisk
     */
    public void setScanRisk(int scanRisk) {
        this.scanRisk = scanRisk;
    }


    /**
     * Gets the preset value for this CxWSResponseScanSummary.
     *
     * @return preset
     */
    public String getPreset() {
        return preset;
    }


    /**
     * Sets the preset value for this CxWSResponseScanSummary.
     *
     * @param preset
     */
    public void setPreset(String preset) {
        this.preset = preset;
    }


    /**
     * Gets the path value for this CxWSResponseScanSummary.
     *
     * @return path
     */
    public String getPath() {
        return path;
    }


    /**
     * Sets the path value for this CxWSResponseScanSummary.
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }


    /**
     * Gets the comment value for this CxWSResponseScanSummary.
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this CxWSResponseScanSummary.
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * Gets the LOC value for this CxWSResponseScanSummary.
     *
     * @return LOC
     */
    public long getLOC() {
        return LOC;
    }


    /**
     * Sets the LOC value for this CxWSResponseScanSummary.
     *
     * @param LOC
     */
    public void setLOC(long LOC) {
        this.LOC = LOC;
    }


    /**
     * Gets the filesCount value for this CxWSResponseScanSummary.
     *
     * @return filesCount
     */
    public long getFilesCount() {
        return filesCount;
    }


    /**
     * Sets the filesCount value for this CxWSResponseScanSummary.
     *
     * @param filesCount
     */
    public void setFilesCount(long filesCount) {
        this.filesCount = filesCount;
    }


    /**
     * Gets the high value for this CxWSResponseScanSummary.
     *
     * @return high
     */
    public int getHigh() {
        return high;
    }


    /**
     * Sets the high value for this CxWSResponseScanSummary.
     *
     * @param high
     */
    public void setHigh(int high) {
        this.high = high;
    }


    /**
     * Gets the medium value for this CxWSResponseScanSummary.
     *
     * @return medium
     */
    public int getMedium() {
        return medium;
    }


    /**
     * Sets the medium value for this CxWSResponseScanSummary.
     *
     * @param medium
     */
    public void setMedium(int medium) {
        this.medium = medium;
    }


    /**
     * Gets the low value for this CxWSResponseScanSummary.
     *
     * @return low
     */
    public int getLow() {
        return low;
    }


    /**
     * Sets the low value for this CxWSResponseScanSummary.
     *
     * @param low
     */
    public void setLow(int low) {
        this.low = low;
    }


    /**
     * Gets the info value for this CxWSResponseScanSummary.
     *
     * @return info
     */
    public int getInfo() {
        return info;
    }


    /**
     * Sets the info value for this CxWSResponseScanSummary.
     *
     * @param info
     */
    public void setInfo(int info) {
        this.info = info;
    }


    /**
     * Gets the scanRiskSeverity value for this CxWSResponseScanSummary.
     *
     * @return scanRiskSeverity
     */
    public int getScanRiskSeverity() {
        return scanRiskSeverity;
    }


    /**
     * Sets the scanRiskSeverity value for this CxWSResponseScanSummary.
     *
     * @param scanRiskSeverity
     */
    public void setScanRiskSeverity(int scanRiskSeverity) {
        this.scanRiskSeverity = scanRiskSeverity;
    }


    /**
     * Gets the scanRiskQuantity value for this CxWSResponseScanSummary.
     *
     * @return scanRiskQuantity
     */
    public int getScanRiskQuantity() {
        return scanRiskQuantity;
    }


    /**
     * Sets the scanRiskQuantity value for this CxWSResponseScanSummary.
     *
     * @param scanRiskQuantity
     */
    public void setScanRiskQuantity(int scanRiskQuantity) {
        this.scanRiskQuantity = scanRiskQuantity;
    }


    /**
     * Gets the isIncremental value for this CxWSResponseScanSummary.
     *
     * @return isIncremental
     */
    public boolean isIsIncremental() {
        return isIncremental;
    }


    /**
     * Sets the isIncremental value for this CxWSResponseScanSummary.
     *
     * @param isIncremental
     */
    public void setIsIncremental(boolean isIncremental) {
        this.isIncremental = isIncremental;
    }


    /**
     * Gets the scanType value for this CxWSResponseScanSummary.
     *
     * @return scanType
     */
    public ScanType getScanType() {
        return scanType;
    }


    /**
     * Sets the scanType value for this CxWSResponseScanSummary.
     *
     * @param scanType
     */
    public void setScanType(ScanType scanType) {
        this.scanType = scanType;
    }


    /**
     * Gets the scanLanguageStateCollection value for this CxWSResponseScanSummary.
     *
     * @return scanLanguageStateCollection
     */
    public ArrayOfCxWSQueryLanguageState getScanLanguageStateCollection() {
        return scanLanguageStateCollection;
    }


    /**
     * Sets the scanLanguageStateCollection value for this CxWSResponseScanSummary.
     *
     * @param scanLanguageStateCollection
     */
    public void setScanLanguageStateCollection(ArrayOfCxWSQueryLanguageState scanLanguageStateCollection) {
        this.scanLanguageStateCollection = scanLanguageStateCollection;
    }


    /**
     * Gets the engineStart value for this CxWSResponseScanSummary.
     *
     * @return engineStart
     */
    public CxDateTime getEngineStart() {
        return engineStart;
    }


    /**
     * Sets the engineStart value for this CxWSResponseScanSummary.
     *
     * @param engineStart
     */
    public void setEngineStart(CxDateTime engineStart) {
        this.engineStart = engineStart;
    }


    /**
     * Gets the engineFinish value for this CxWSResponseScanSummary.
     *
     * @return engineFinish
     */
    public CxDateTime getEngineFinish() {
        return engineFinish;
    }


    /**
     * Sets the engineFinish value for this CxWSResponseScanSummary.
     *
     * @param engineFinish
     */
    public void setEngineFinish(CxDateTime engineFinish) {
        this.engineFinish = engineFinish;
    }


    /**
     * Gets the scanQueued value for this CxWSResponseScanSummary.
     *
     * @return scanQueued
     */
    public CxDateTime getScanQueued() {
        return scanQueued;
    }


    /**
     * Sets the scanQueued value for this CxWSResponseScanSummary.
     *
     * @param scanQueued
     */
    public void setScanQueued(CxDateTime scanQueued) {
        this.scanQueued = scanQueued;
    }


    /**
     * Gets the totalScanTime value for this CxWSResponseScanSummary.
     *
     * @return totalScanTime
     */
    public long getTotalScanTime() {
        return totalScanTime;
    }


    /**
     * Sets the totalScanTime value for this CxWSResponseScanSummary.
     *
     * @param totalScanTime
     */
    public void setTotalScanTime(long totalScanTime) {
        this.totalScanTime = totalScanTime;
    }


    /**
     * Gets the statisticsCalculationDate value for this CxWSResponseScanSummary.
     *
     * @return statisticsCalculationDate
     */
    public CxDateTime getStatisticsCalculationDate() {
        return statisticsCalculationDate;
    }


    /**
     * Sets the statisticsCalculationDate value for this CxWSResponseScanSummary.
     *
     * @param statisticsCalculationDate
     */
    public void setStatisticsCalculationDate(CxDateTime statisticsCalculationDate) {
        this.statisticsCalculationDate = statisticsCalculationDate;
    }


    /**
     * Gets the projectName value for this CxWSResponseScanSummary.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }


    /**
     * Sets the projectName value for this CxWSResponseScanSummary.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Gets the teamName value for this CxWSResponseScanSummary.
     *
     * @return teamName
     */
    public String getTeamName() {
        return teamName;
    }


    /**
     * Sets the teamName value for this CxWSResponseScanSummary.
     *
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseScanSummary)) return false;
        CxWSResponseScanSummary other = (CxWSResponseScanSummary) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.started==null && other.getStarted()==null) ||
             (this.started!=null &&
              this.started.equals(other.getStarted()))) &&
            ((this.finished==null && other.getFinished()==null) ||
             (this.finished!=null &&
              this.finished.equals(other.getFinished()))) &&
            this.scanRisk == other.getScanRisk() &&
            ((this.preset==null && other.getPreset()==null) ||
             (this.preset!=null &&
              this.preset.equals(other.getPreset()))) &&
            ((this.path==null && other.getPath()==null) ||
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            ((this.comment==null && other.getComment()==null) ||
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            this.LOC == other.getLOC() &&
            this.filesCount == other.getFilesCount() &&
            this.high == other.getHigh() &&
            this.medium == other.getMedium() &&
            this.low == other.getLow() &&
            this.info == other.getInfo() &&
            this.scanRiskSeverity == other.getScanRiskSeverity() &&
            this.scanRiskQuantity == other.getScanRiskQuantity() &&
            this.isIncremental == other.isIsIncremental() &&
            ((this.scanType==null && other.getScanType()==null) ||
             (this.scanType!=null &&
              this.scanType.equals(other.getScanType()))) &&
            ((this.scanLanguageStateCollection==null && other.getScanLanguageStateCollection()==null) ||
             (this.scanLanguageStateCollection!=null &&
              this.scanLanguageStateCollection.equals(other.getScanLanguageStateCollection()))) &&
            ((this.engineStart==null && other.getEngineStart()==null) ||
             (this.engineStart!=null &&
              this.engineStart.equals(other.getEngineStart()))) &&
            ((this.engineFinish==null && other.getEngineFinish()==null) ||
             (this.engineFinish!=null &&
              this.engineFinish.equals(other.getEngineFinish()))) &&
            ((this.scanQueued==null && other.getScanQueued()==null) ||
             (this.scanQueued!=null &&
              this.scanQueued.equals(other.getScanQueued()))) &&
            this.totalScanTime == other.getTotalScanTime() &&
            ((this.statisticsCalculationDate==null && other.getStatisticsCalculationDate()==null) ||
             (this.statisticsCalculationDate!=null &&
              this.statisticsCalculationDate.equals(other.getStatisticsCalculationDate()))) &&
            ((this.projectName==null && other.getProjectName()==null) ||
             (this.projectName!=null &&
              this.projectName.equals(other.getProjectName()))) &&
            ((this.teamName==null && other.getTeamName()==null) ||
             (this.teamName!=null &&
              this.teamName.equals(other.getTeamName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getStarted() != null) {
            _hashCode += getStarted().hashCode();
        }
        if (getFinished() != null) {
            _hashCode += getFinished().hashCode();
        }
        _hashCode += getScanRisk();
        if (getPreset() != null) {
            _hashCode += getPreset().hashCode();
        }
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        _hashCode += new Long(getLOC()).hashCode();
        _hashCode += new Long(getFilesCount()).hashCode();
        _hashCode += getHigh();
        _hashCode += getMedium();
        _hashCode += getLow();
        _hashCode += getInfo();
        _hashCode += getScanRiskSeverity();
        _hashCode += getScanRiskQuantity();
        _hashCode += (isIsIncremental() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getScanType() != null) {
            _hashCode += getScanType().hashCode();
        }
        if (getScanLanguageStateCollection() != null) {
            _hashCode += getScanLanguageStateCollection().hashCode();
        }
        if (getEngineStart() != null) {
            _hashCode += getEngineStart().hashCode();
        }
        if (getEngineFinish() != null) {
            _hashCode += getEngineFinish().hashCode();
        }
        if (getScanQueued() != null) {
            _hashCode += getScanQueued().hashCode();
        }
        _hashCode += new Long(getTotalScanTime()).hashCode();
        if (getStatisticsCalculationDate() != null) {
            _hashCode += getStatisticsCalculationDate().hashCode();
        }
        if (getProjectName() != null) {
            _hashCode += getProjectName().hashCode();
        }
        if (getTeamName() != null) {
            _hashCode += getTeamName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseScanSummary.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanSummary"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("started");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Started"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finished");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Finished"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanRisk");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanRisk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Preset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Comment"));
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
        elemField.setFieldName("filesCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "FilesCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("high");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "High"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medium");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Medium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("low");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Low"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanRiskSeverity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanRiskSeverity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanRiskQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanRiskQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isIncremental");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsIncremental"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanLanguageStateCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanLanguageStateCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSQueryLanguageState"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("engineStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "EngineStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("engineFinish");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "EngineFinish"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanQueued");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanQueued"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalScanTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TotalScanTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("projectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectName"));
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
