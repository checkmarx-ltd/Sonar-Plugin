/**
 * ArrayOfScanPath.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfScanPath  implements java.io.Serializable {
    private ScanPath[] scanPath;

    public ArrayOfScanPath() {
    }

    public ArrayOfScanPath(
           ScanPath[] scanPath) {
           this.scanPath = scanPath;
    }


    /**
     * Gets the scanPath value for this ArrayOfScanPath.
     *
     * @return scanPath
     */
    public ScanPath[] getScanPath() {
        return scanPath;
    }


    /**
     * Sets the scanPath value for this ArrayOfScanPath.
     *
     * @param scanPath
     */
    public void setScanPath(ScanPath[] scanPath) {
        this.scanPath = scanPath;
    }

    public ScanPath getScanPath(int i) {
        return this.scanPath[i];
    }

    public void setScanPath(int i, ScanPath _value) {
        this.scanPath[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfScanPath)) return false;
        ArrayOfScanPath other = (ArrayOfScanPath) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.scanPath==null && other.getScanPath()==null) ||
             (this.scanPath!=null &&
              java.util.Arrays.equals(this.scanPath, other.getScanPath())));
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
        if (getScanPath() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScanPath());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getScanPath(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfScanPath.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanPath"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanPath"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
