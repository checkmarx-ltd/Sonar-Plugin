/**
 * SourceFilterPatterns.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class SourceFilterPatterns  implements java.io.Serializable {
    private String excludeFilesPatterns;

    private String excludeFoldersPatterns;

    public SourceFilterPatterns() {
    }

    public SourceFilterPatterns(
           String excludeFilesPatterns,
           String excludeFoldersPatterns) {
           this.excludeFilesPatterns = excludeFilesPatterns;
           this.excludeFoldersPatterns = excludeFoldersPatterns;
    }


    /**
     * Gets the excludeFilesPatterns value for this SourceFilterPatterns.
     *
     * @return excludeFilesPatterns
     */
    public String getExcludeFilesPatterns() {
        return excludeFilesPatterns;
    }


    /**
     * Sets the excludeFilesPatterns value for this SourceFilterPatterns.
     *
     * @param excludeFilesPatterns
     */
    public void setExcludeFilesPatterns(String excludeFilesPatterns) {
        this.excludeFilesPatterns = excludeFilesPatterns;
    }


    /**
     * Gets the excludeFoldersPatterns value for this SourceFilterPatterns.
     *
     * @return excludeFoldersPatterns
     */
    public String getExcludeFoldersPatterns() {
        return excludeFoldersPatterns;
    }


    /**
     * Sets the excludeFoldersPatterns value for this SourceFilterPatterns.
     *
     * @param excludeFoldersPatterns
     */
    public void setExcludeFoldersPatterns(String excludeFoldersPatterns) {
        this.excludeFoldersPatterns = excludeFoldersPatterns;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SourceFilterPatterns)) return false;
        SourceFilterPatterns other = (SourceFilterPatterns) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.excludeFilesPatterns==null && other.getExcludeFilesPatterns()==null) ||
             (this.excludeFilesPatterns!=null &&
              this.excludeFilesPatterns.equals(other.getExcludeFilesPatterns()))) &&
            ((this.excludeFoldersPatterns==null && other.getExcludeFoldersPatterns()==null) ||
             (this.excludeFoldersPatterns!=null &&
              this.excludeFoldersPatterns.equals(other.getExcludeFoldersPatterns())));
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
        if (getExcludeFilesPatterns() != null) {
            _hashCode += getExcludeFilesPatterns().hashCode();
        }
        if (getExcludeFoldersPatterns() != null) {
            _hashCode += getExcludeFoldersPatterns().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SourceFilterPatterns.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceFilterPatterns"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excludeFilesPatterns");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ExcludeFilesPatterns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excludeFoldersPatterns");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ExcludeFoldersPatterns"));
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
