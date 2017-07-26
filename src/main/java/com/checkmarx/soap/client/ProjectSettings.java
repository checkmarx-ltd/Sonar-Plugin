/**
 * ProjectSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ProjectSettings  implements java.io.Serializable {
    private long projectID;

    private String projectName;

    private long presetID;

    private String associatedGroupID;

    private long scanConfigurationID;

    private String description;

    private String owner;

    private boolean isPublic;

    private ProjectSharedLocation openSourceSettings;

    private ProjectOrigin openSourceAnalysisOrigin;

    public ProjectSettings() {
    }

    public ProjectSettings(
           long projectID,
           String projectName,
           long presetID,
           String associatedGroupID,
           long scanConfigurationID,
           String description,
           String owner,
           boolean isPublic,
           ProjectSharedLocation openSourceSettings,
           ProjectOrigin openSourceAnalysisOrigin) {
           this.projectID = projectID;
           this.projectName = projectName;
           this.presetID = presetID;
           this.associatedGroupID = associatedGroupID;
           this.scanConfigurationID = scanConfigurationID;
           this.description = description;
           this.owner = owner;
           this.isPublic = isPublic;
           this.openSourceSettings = openSourceSettings;
           this.openSourceAnalysisOrigin = openSourceAnalysisOrigin;
    }


    /**
     * Gets the projectID value for this ProjectSettings.
     *
     * @return projectID
     */
    public long getProjectID() {
        return projectID;
    }


    /**
     * Sets the projectID value for this ProjectSettings.
     *
     * @param projectID
     */
    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }


    /**
     * Gets the projectName value for this ProjectSettings.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }


    /**
     * Sets the projectName value for this ProjectSettings.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Gets the presetID value for this ProjectSettings.
     *
     * @return presetID
     */
    public long getPresetID() {
        return presetID;
    }


    /**
     * Sets the presetID value for this ProjectSettings.
     *
     * @param presetID
     */
    public void setPresetID(long presetID) {
        this.presetID = presetID;
    }


    /**
     * Gets the associatedGroupID value for this ProjectSettings.
     *
     * @return associatedGroupID
     */
    public String getAssociatedGroupID() {
        return associatedGroupID;
    }


    /**
     * Sets the associatedGroupID value for this ProjectSettings.
     *
     * @param associatedGroupID
     */
    public void setAssociatedGroupID(String associatedGroupID) {
        this.associatedGroupID = associatedGroupID;
    }


    /**
     * Gets the scanConfigurationID value for this ProjectSettings.
     *
     * @return scanConfigurationID
     */
    public long getScanConfigurationID() {
        return scanConfigurationID;
    }


    /**
     * Sets the scanConfigurationID value for this ProjectSettings.
     *
     * @param scanConfigurationID
     */
    public void setScanConfigurationID(long scanConfigurationID) {
        this.scanConfigurationID = scanConfigurationID;
    }


    /**
     * Gets the description value for this ProjectSettings.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ProjectSettings.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets the owner value for this ProjectSettings.
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this ProjectSettings.
     *
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }


    /**
     * Gets the isPublic value for this ProjectSettings.
     *
     * @return isPublic
     */
    public boolean isIsPublic() {
        return isPublic;
    }


    /**
     * Sets the isPublic value for this ProjectSettings.
     *
     * @param isPublic
     */
    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


    /**
     * Gets the openSourceSettings value for this ProjectSettings.
     *
     * @return openSourceSettings
     */
    public ProjectSharedLocation getOpenSourceSettings() {
        return openSourceSettings;
    }


    /**
     * Sets the openSourceSettings value for this ProjectSettings.
     *
     * @param openSourceSettings
     */
    public void setOpenSourceSettings(ProjectSharedLocation openSourceSettings) {
        this.openSourceSettings = openSourceSettings;
    }


    /**
     * Gets the openSourceAnalysisOrigin value for this ProjectSettings.
     *
     * @return openSourceAnalysisOrigin
     */
    public ProjectOrigin getOpenSourceAnalysisOrigin() {
        return openSourceAnalysisOrigin;
    }


    /**
     * Sets the openSourceAnalysisOrigin value for this ProjectSettings.
     *
     * @param openSourceAnalysisOrigin
     */
    public void setOpenSourceAnalysisOrigin(ProjectOrigin openSourceAnalysisOrigin) {
        this.openSourceAnalysisOrigin = openSourceAnalysisOrigin;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ProjectSettings)) return false;
        ProjectSettings other = (ProjectSettings) obj;
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
            this.presetID == other.getPresetID() &&
            ((this.associatedGroupID==null && other.getAssociatedGroupID()==null) ||
             (this.associatedGroupID!=null &&
              this.associatedGroupID.equals(other.getAssociatedGroupID()))) &&
            this.scanConfigurationID == other.getScanConfigurationID() &&
            ((this.description==null && other.getDescription()==null) ||
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.owner==null && other.getOwner()==null) ||
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            this.isPublic == other.isIsPublic() &&
            ((this.openSourceSettings==null && other.getOpenSourceSettings()==null) ||
             (this.openSourceSettings!=null &&
              this.openSourceSettings.equals(other.getOpenSourceSettings()))) &&
            ((this.openSourceAnalysisOrigin==null && other.getOpenSourceAnalysisOrigin()==null) ||
             (this.openSourceAnalysisOrigin!=null &&
              this.openSourceAnalysisOrigin.equals(other.getOpenSourceAnalysisOrigin())));
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
        _hashCode += new Long(getPresetID()).hashCode();
        if (getAssociatedGroupID() != null) {
            _hashCode += getAssociatedGroupID().hashCode();
        }
        _hashCode += new Long(getScanConfigurationID()).hashCode();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        _hashCode += (isIsPublic() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getOpenSourceSettings() != null) {
            _hashCode += getOpenSourceSettings().hashCode();
        }
        if (getOpenSourceAnalysisOrigin() != null) {
            _hashCode += getOpenSourceAnalysisOrigin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjectSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectID"));
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
        elemField.setFieldName("presetID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PresetID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("associatedGroupID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "AssociatedGroupID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanConfigurationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanConfigurationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("openSourceSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "OpenSourceSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSharedLocation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openSourceAnalysisOrigin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "OpenSourceAnalysisOrigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectOrigin"));
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
