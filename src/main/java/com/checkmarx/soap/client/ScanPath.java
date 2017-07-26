/**
 * ScanPath.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanPath  implements java.io.Serializable {
    private String path;

    private boolean includeSubTree;

    public ScanPath() {
    }

    public ScanPath(
           String path,
           boolean includeSubTree) {
           this.path = path;
           this.includeSubTree = includeSubTree;
    }


    /**
     * Gets the path value for this ScanPath.
     *
     * @return path
     */
    public String getPath() {
        return path;
    }


    /**
     * Sets the path value for this ScanPath.
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }


    /**
     * Gets the includeSubTree value for this ScanPath.
     *
     * @return includeSubTree
     */
    public boolean isIncludeSubTree() {
        return includeSubTree;
    }


    /**
     * Sets the includeSubTree value for this ScanPath.
     *
     * @param includeSubTree
     */
    public void setIncludeSubTree(boolean includeSubTree) {
        this.includeSubTree = includeSubTree;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanPath)) return false;
        ScanPath other = (ScanPath) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.path==null && other.getPath()==null) ||
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            this.includeSubTree == other.isIncludeSubTree();
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
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        _hashCode += (isIncludeSubTree() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanPath.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanPath"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeSubTree");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IncludeSubTree"));
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
