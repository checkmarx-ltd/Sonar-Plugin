/**
 * CliScanArgs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CliScanArgs  implements java.io.Serializable {
    private ProjectSettings prjSettings;

    private SourceCodeSettings srcCodeSettings;

    private boolean isPrivateScan;

    private boolean isIncremental;

    private String comment;

    private boolean ignoreScanWithUnchangedCode;

    private CxClientType clientOrigin;

    public CliScanArgs() {
    }

    public CliScanArgs(
           ProjectSettings prjSettings,
           SourceCodeSettings srcCodeSettings,
           boolean isPrivateScan,
           boolean isIncremental,
           String comment,
           boolean ignoreScanWithUnchangedCode,
           CxClientType clientOrigin) {
           this.prjSettings = prjSettings;
           this.srcCodeSettings = srcCodeSettings;
           this.isPrivateScan = isPrivateScan;
           this.isIncremental = isIncremental;
           this.comment = comment;
           this.ignoreScanWithUnchangedCode = ignoreScanWithUnchangedCode;
           this.clientOrigin = clientOrigin;
    }


    /**
     * Gets the prjSettings value for this CliScanArgs.
     *
     * @return prjSettings
     */
    public ProjectSettings getPrjSettings() {
        return prjSettings;
    }


    /**
     * Sets the prjSettings value for this CliScanArgs.
     *
     * @param prjSettings
     */
    public void setPrjSettings(ProjectSettings prjSettings) {
        this.prjSettings = prjSettings;
    }


    /**
     * Gets the srcCodeSettings value for this CliScanArgs.
     *
     * @return srcCodeSettings
     */
    public SourceCodeSettings getSrcCodeSettings() {
        return srcCodeSettings;
    }


    /**
     * Sets the srcCodeSettings value for this CliScanArgs.
     *
     * @param srcCodeSettings
     */
    public void setSrcCodeSettings(SourceCodeSettings srcCodeSettings) {
        this.srcCodeSettings = srcCodeSettings;
    }


    /**
     * Gets the isPrivateScan value for this CliScanArgs.
     *
     * @return isPrivateScan
     */
    public boolean isIsPrivateScan() {
        return isPrivateScan;
    }


    /**
     * Sets the isPrivateScan value for this CliScanArgs.
     *
     * @param isPrivateScan
     */
    public void setIsPrivateScan(boolean isPrivateScan) {
        this.isPrivateScan = isPrivateScan;
    }


    /**
     * Gets the isIncremental value for this CliScanArgs.
     *
     * @return isIncremental
     */
    public boolean isIsIncremental() {
        return isIncremental;
    }


    /**
     * Sets the isIncremental value for this CliScanArgs.
     *
     * @param isIncremental
     */
    public void setIsIncremental(boolean isIncremental) {
        this.isIncremental = isIncremental;
    }


    /**
     * Gets the comment value for this CliScanArgs.
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this CliScanArgs.
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * Gets the ignoreScanWithUnchangedCode value for this CliScanArgs.
     *
     * @return ignoreScanWithUnchangedCode
     */
    public boolean isIgnoreScanWithUnchangedCode() {
        return ignoreScanWithUnchangedCode;
    }


    /**
     * Sets the ignoreScanWithUnchangedCode value for this CliScanArgs.
     *
     * @param ignoreScanWithUnchangedCode
     */
    public void setIgnoreScanWithUnchangedCode(boolean ignoreScanWithUnchangedCode) {
        this.ignoreScanWithUnchangedCode = ignoreScanWithUnchangedCode;
    }


    /**
     * Gets the clientOrigin value for this CliScanArgs.
     *
     * @return clientOrigin
     */
    public CxClientType getClientOrigin() {
        return clientOrigin;
    }


    /**
     * Sets the clientOrigin value for this CliScanArgs.
     *
     * @param clientOrigin
     */
    public void setClientOrigin(CxClientType clientOrigin) {
        this.clientOrigin = clientOrigin;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CliScanArgs)) return false;
        CliScanArgs other = (CliScanArgs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.prjSettings==null && other.getPrjSettings()==null) ||
             (this.prjSettings!=null &&
              this.prjSettings.equals(other.getPrjSettings()))) &&
            ((this.srcCodeSettings==null && other.getSrcCodeSettings()==null) ||
             (this.srcCodeSettings!=null &&
              this.srcCodeSettings.equals(other.getSrcCodeSettings()))) &&
            this.isPrivateScan == other.isIsPrivateScan() &&
            this.isIncremental == other.isIsIncremental() &&
            ((this.comment==null && other.getComment()==null) ||
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            this.ignoreScanWithUnchangedCode == other.isIgnoreScanWithUnchangedCode() &&
            ((this.clientOrigin==null && other.getClientOrigin()==null) ||
             (this.clientOrigin!=null &&
              this.clientOrigin.equals(other.getClientOrigin())));
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
        if (getPrjSettings() != null) {
            _hashCode += getPrjSettings().hashCode();
        }
        if (getSrcCodeSettings() != null) {
            _hashCode += getSrcCodeSettings().hashCode();
        }
        _hashCode += (isIsPrivateScan() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsIncremental() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        _hashCode += (isIgnoreScanWithUnchangedCode() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getClientOrigin() != null) {
            _hashCode += getClientOrigin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CliScanArgs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CliScanArgs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prjSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PrjSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("srcCodeSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SrcCodeSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceCodeSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPrivateScan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsPrivateScan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isIncremental");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsIncremental"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("ignoreScanWithUnchangedCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IgnoreScanWithUnchangedCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientOrigin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ClientOrigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxClientType"));
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
