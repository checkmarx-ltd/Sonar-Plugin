/**
 * SourceCodeSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class SourceCodeSettings  implements java.io.Serializable {
    private SourceLocationType sourceOrigin;

    private Credentials userCredentials;

    private ArrayOfScanPath pathList;

    private SourceControlSettings sourceControlSetting;

    private LocalCodeContainer packagedCode;

    private String sourcePullingAction;

    private SourceFilterPatterns sourceFilterLists;

    public SourceCodeSettings() {
    }

    public SourceCodeSettings(
           SourceLocationType sourceOrigin,
           Credentials userCredentials,
           ArrayOfScanPath pathList,
           SourceControlSettings sourceControlSetting,
           LocalCodeContainer packagedCode,
           String sourcePullingAction,
           SourceFilterPatterns sourceFilterLists) {
           this.sourceOrigin = sourceOrigin;
           this.userCredentials = userCredentials;
           this.pathList = pathList;
           this.sourceControlSetting = sourceControlSetting;
           this.packagedCode = packagedCode;
           this.sourcePullingAction = sourcePullingAction;
           this.sourceFilterLists = sourceFilterLists;
    }


    /**
     * Gets the sourceOrigin value for this SourceCodeSettings.
     *
     * @return sourceOrigin
     */
    public SourceLocationType getSourceOrigin() {
        return sourceOrigin;
    }


    /**
     * Sets the sourceOrigin value for this SourceCodeSettings.
     *
     * @param sourceOrigin
     */
    public void setSourceOrigin(SourceLocationType sourceOrigin) {
        this.sourceOrigin = sourceOrigin;
    }


    /**
     * Gets the userCredentials value for this SourceCodeSettings.
     *
     * @return userCredentials
     */
    public Credentials getUserCredentials() {
        return userCredentials;
    }


    /**
     * Sets the userCredentials value for this SourceCodeSettings.
     *
     * @param userCredentials
     */
    public void setUserCredentials(Credentials userCredentials) {
        this.userCredentials = userCredentials;
    }


    /**
     * Gets the pathList value for this SourceCodeSettings.
     *
     * @return pathList
     */
    public ArrayOfScanPath getPathList() {
        return pathList;
    }


    /**
     * Sets the pathList value for this SourceCodeSettings.
     *
     * @param pathList
     */
    public void setPathList(ArrayOfScanPath pathList) {
        this.pathList = pathList;
    }


    /**
     * Gets the sourceControlSetting value for this SourceCodeSettings.
     *
     * @return sourceControlSetting
     */
    public SourceControlSettings getSourceControlSetting() {
        return sourceControlSetting;
    }


    /**
     * Sets the sourceControlSetting value for this SourceCodeSettings.
     *
     * @param sourceControlSetting
     */
    public void setSourceControlSetting(SourceControlSettings sourceControlSetting) {
        this.sourceControlSetting = sourceControlSetting;
    }


    /**
     * Gets the packagedCode value for this SourceCodeSettings.
     *
     * @return packagedCode
     */
    public LocalCodeContainer getPackagedCode() {
        return packagedCode;
    }


    /**
     * Sets the packagedCode value for this SourceCodeSettings.
     *
     * @param packagedCode
     */
    public void setPackagedCode(LocalCodeContainer packagedCode) {
        this.packagedCode = packagedCode;
    }


    /**
     * Gets the sourcePullingAction value for this SourceCodeSettings.
     *
     * @return sourcePullingAction
     */
    public String getSourcePullingAction() {
        return sourcePullingAction;
    }


    /**
     * Sets the sourcePullingAction value for this SourceCodeSettings.
     *
     * @param sourcePullingAction
     */
    public void setSourcePullingAction(String sourcePullingAction) {
        this.sourcePullingAction = sourcePullingAction;
    }


    /**
     * Gets the sourceFilterLists value for this SourceCodeSettings.
     *
     * @return sourceFilterLists
     */
    public SourceFilterPatterns getSourceFilterLists() {
        return sourceFilterLists;
    }


    /**
     * Sets the sourceFilterLists value for this SourceCodeSettings.
     *
     * @param sourceFilterLists
     */
    public void setSourceFilterLists(SourceFilterPatterns sourceFilterLists) {
        this.sourceFilterLists = sourceFilterLists;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SourceCodeSettings)) return false;
        SourceCodeSettings other = (SourceCodeSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.sourceOrigin==null && other.getSourceOrigin()==null) ||
             (this.sourceOrigin!=null &&
              this.sourceOrigin.equals(other.getSourceOrigin()))) &&
            ((this.userCredentials==null && other.getUserCredentials()==null) ||
             (this.userCredentials!=null &&
              this.userCredentials.equals(other.getUserCredentials()))) &&
            ((this.pathList==null && other.getPathList()==null) ||
             (this.pathList!=null &&
              this.pathList.equals(other.getPathList()))) &&
            ((this.sourceControlSetting==null && other.getSourceControlSetting()==null) ||
             (this.sourceControlSetting!=null &&
              this.sourceControlSetting.equals(other.getSourceControlSetting()))) &&
            ((this.packagedCode==null && other.getPackagedCode()==null) ||
             (this.packagedCode!=null &&
              this.packagedCode.equals(other.getPackagedCode()))) &&
            ((this.sourcePullingAction==null && other.getSourcePullingAction()==null) ||
             (this.sourcePullingAction!=null &&
              this.sourcePullingAction.equals(other.getSourcePullingAction()))) &&
            ((this.sourceFilterLists==null && other.getSourceFilterLists()==null) ||
             (this.sourceFilterLists!=null &&
              this.sourceFilterLists.equals(other.getSourceFilterLists())));
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
        if (getSourceOrigin() != null) {
            _hashCode += getSourceOrigin().hashCode();
        }
        if (getUserCredentials() != null) {
            _hashCode += getUserCredentials().hashCode();
        }
        if (getPathList() != null) {
            _hashCode += getPathList().hashCode();
        }
        if (getSourceControlSetting() != null) {
            _hashCode += getSourceControlSetting().hashCode();
        }
        if (getPackagedCode() != null) {
            _hashCode += getPackagedCode().hashCode();
        }
        if (getSourcePullingAction() != null) {
            _hashCode += getSourcePullingAction().hashCode();
        }
        if (getSourceFilterLists() != null) {
            _hashCode += getSourceFilterLists().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SourceCodeSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceCodeSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceOrigin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceOrigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceLocationType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userCredentials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserCredentials"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pathList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PathList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanPath"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceControlSetting");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceControlSetting"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceControlSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packagedCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PackagedCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LocalCodeContainer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourcePullingAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourcePullingAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceFilterLists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceFilterLists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceFilterPatterns"));
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
