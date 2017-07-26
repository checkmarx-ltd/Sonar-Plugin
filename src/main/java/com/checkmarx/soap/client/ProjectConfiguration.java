/**
 * ProjectConfiguration.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ProjectConfiguration  implements java.io.Serializable {
    private ProjectSettings projectSettings;

    private SourceCodeSettings sourceCodeSettings;

    private ScheduleSettings scheduleSettings;

    private ScanActionSettings scanActionSettings;

    private CxWSProjectIssueTrackingSettings projectIssueTrackingSettings;

    private ArrayOfCxWSProjectCustomField customFields;

    private DataRetentionSettings dataRetentionSettings;

    public ProjectConfiguration() {
    }

    public ProjectConfiguration(
           ProjectSettings projectSettings,
           SourceCodeSettings sourceCodeSettings,
           ScheduleSettings scheduleSettings,
           ScanActionSettings scanActionSettings,
           CxWSProjectIssueTrackingSettings projectIssueTrackingSettings,
           ArrayOfCxWSProjectCustomField customFields,
           DataRetentionSettings dataRetentionSettings) {
           this.projectSettings = projectSettings;
           this.sourceCodeSettings = sourceCodeSettings;
           this.scheduleSettings = scheduleSettings;
           this.scanActionSettings = scanActionSettings;
           this.projectIssueTrackingSettings = projectIssueTrackingSettings;
           this.customFields = customFields;
           this.dataRetentionSettings = dataRetentionSettings;
    }


    /**
     * Gets the projectSettings value for this ProjectConfiguration.
     *
     * @return projectSettings
     */
    public ProjectSettings getProjectSettings() {
        return projectSettings;
    }


    /**
     * Sets the projectSettings value for this ProjectConfiguration.
     *
     * @param projectSettings
     */
    public void setProjectSettings(ProjectSettings projectSettings) {
        this.projectSettings = projectSettings;
    }


    /**
     * Gets the sourceCodeSettings value for this ProjectConfiguration.
     *
     * @return sourceCodeSettings
     */
    public SourceCodeSettings getSourceCodeSettings() {
        return sourceCodeSettings;
    }


    /**
     * Sets the sourceCodeSettings value for this ProjectConfiguration.
     *
     * @param sourceCodeSettings
     */
    public void setSourceCodeSettings(SourceCodeSettings sourceCodeSettings) {
        this.sourceCodeSettings = sourceCodeSettings;
    }


    /**
     * Gets the scheduleSettings value for this ProjectConfiguration.
     *
     * @return scheduleSettings
     */
    public ScheduleSettings getScheduleSettings() {
        return scheduleSettings;
    }


    /**
     * Sets the scheduleSettings value for this ProjectConfiguration.
     *
     * @param scheduleSettings
     */
    public void setScheduleSettings(ScheduleSettings scheduleSettings) {
        this.scheduleSettings = scheduleSettings;
    }


    /**
     * Gets the scanActionSettings value for this ProjectConfiguration.
     *
     * @return scanActionSettings
     */
    public ScanActionSettings getScanActionSettings() {
        return scanActionSettings;
    }


    /**
     * Sets the scanActionSettings value for this ProjectConfiguration.
     *
     * @param scanActionSettings
     */
    public void setScanActionSettings(ScanActionSettings scanActionSettings) {
        this.scanActionSettings = scanActionSettings;
    }


    /**
     * Gets the projectIssueTrackingSettings value for this ProjectConfiguration.
     *
     * @return projectIssueTrackingSettings
     */
    public CxWSProjectIssueTrackingSettings getProjectIssueTrackingSettings() {
        return projectIssueTrackingSettings;
    }


    /**
     * Sets the projectIssueTrackingSettings value for this ProjectConfiguration.
     *
     * @param projectIssueTrackingSettings
     */
    public void setProjectIssueTrackingSettings(CxWSProjectIssueTrackingSettings projectIssueTrackingSettings) {
        this.projectIssueTrackingSettings = projectIssueTrackingSettings;
    }


    /**
     * Gets the customFields value for this ProjectConfiguration.
     *
     * @return customFields
     */
    public ArrayOfCxWSProjectCustomField getCustomFields() {
        return customFields;
    }


    /**
     * Sets the customFields value for this ProjectConfiguration.
     *
     * @param customFields
     */
    public void setCustomFields(ArrayOfCxWSProjectCustomField customFields) {
        this.customFields = customFields;
    }


    /**
     * Gets the dataRetentionSettings value for this ProjectConfiguration.
     *
     * @return dataRetentionSettings
     */
    public DataRetentionSettings getDataRetentionSettings() {
        return dataRetentionSettings;
    }


    /**
     * Sets the dataRetentionSettings value for this ProjectConfiguration.
     *
     * @param dataRetentionSettings
     */
    public void setDataRetentionSettings(DataRetentionSettings dataRetentionSettings) {
        this.dataRetentionSettings = dataRetentionSettings;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ProjectConfiguration)) return false;
        ProjectConfiguration other = (ProjectConfiguration) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.projectSettings==null && other.getProjectSettings()==null) ||
             (this.projectSettings!=null &&
              this.projectSettings.equals(other.getProjectSettings()))) &&
            ((this.sourceCodeSettings==null && other.getSourceCodeSettings()==null) ||
             (this.sourceCodeSettings!=null &&
              this.sourceCodeSettings.equals(other.getSourceCodeSettings()))) &&
            ((this.scheduleSettings==null && other.getScheduleSettings()==null) ||
             (this.scheduleSettings!=null &&
              this.scheduleSettings.equals(other.getScheduleSettings()))) &&
            ((this.scanActionSettings==null && other.getScanActionSettings()==null) ||
             (this.scanActionSettings!=null &&
              this.scanActionSettings.equals(other.getScanActionSettings()))) &&
            ((this.projectIssueTrackingSettings==null && other.getProjectIssueTrackingSettings()==null) ||
             (this.projectIssueTrackingSettings!=null &&
              this.projectIssueTrackingSettings.equals(other.getProjectIssueTrackingSettings()))) &&
            ((this.customFields==null && other.getCustomFields()==null) ||
             (this.customFields!=null &&
              this.customFields.equals(other.getCustomFields()))) &&
            ((this.dataRetentionSettings==null && other.getDataRetentionSettings()==null) ||
             (this.dataRetentionSettings!=null &&
              this.dataRetentionSettings.equals(other.getDataRetentionSettings())));
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
        if (getProjectSettings() != null) {
            _hashCode += getProjectSettings().hashCode();
        }
        if (getSourceCodeSettings() != null) {
            _hashCode += getSourceCodeSettings().hashCode();
        }
        if (getScheduleSettings() != null) {
            _hashCode += getScheduleSettings().hashCode();
        }
        if (getScanActionSettings() != null) {
            _hashCode += getScanActionSettings().hashCode();
        }
        if (getProjectIssueTrackingSettings() != null) {
            _hashCode += getProjectIssueTrackingSettings().hashCode();
        }
        if (getCustomFields() != null) {
            _hashCode += getCustomFields().hashCode();
        }
        if (getDataRetentionSettings() != null) {
            _hashCode += getDataRetentionSettings().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjectConfiguration.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectConfiguration"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceCodeSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceCodeSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceCodeSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScheduleSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScheduleSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanActionSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanActionSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanActionSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectIssueTrackingSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectIssueTrackingSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSProjectIssueTrackingSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customFields");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CustomFields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSProjectCustomField"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataRetentionSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DataRetentionSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DataRetentionSettings"));
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
