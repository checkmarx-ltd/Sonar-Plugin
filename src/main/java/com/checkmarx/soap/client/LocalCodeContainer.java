/**
 * LocalCodeContainer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class LocalCodeContainer  implements java.io.Serializable {
    private byte[] zippedFile;

    private String fileName;

    public LocalCodeContainer() {
    }

    public LocalCodeContainer(
           byte[] zippedFile,
           String fileName) {
           this.zippedFile = zippedFile;
           this.fileName = fileName;
    }


    /**
     * Gets the zippedFile value for this LocalCodeContainer.
     *
     * @return zippedFile
     */
    public byte[] getZippedFile() {
        return zippedFile;
    }


    /**
     * Sets the zippedFile value for this LocalCodeContainer.
     *
     * @param zippedFile
     */
    public void setZippedFile(byte[] zippedFile) {
        this.zippedFile = zippedFile;
    }


    /**
     * Gets the fileName value for this LocalCodeContainer.
     *
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this LocalCodeContainer.
     *
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof LocalCodeContainer)) return false;
        LocalCodeContainer other = (LocalCodeContainer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.zippedFile==null && other.getZippedFile()==null) ||
             (this.zippedFile!=null &&
              java.util.Arrays.equals(this.zippedFile, other.getZippedFile()))) &&
            ((this.fileName==null && other.getFileName()==null) ||
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName())));
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
        if (getZippedFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getZippedFile());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getZippedFile(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LocalCodeContainer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LocalCodeContainer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zippedFile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ZippedFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "FileName"));
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
