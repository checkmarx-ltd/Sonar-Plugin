/**
 * ScanActionSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanActionSettings  implements java.io.Serializable {
    private ArrayOfScanAction scanActionList;

    public ScanActionSettings() {
    }

    public ScanActionSettings(
           ArrayOfScanAction scanActionList) {
           this.scanActionList = scanActionList;
    }


    /**
     * Gets the scanActionList value for this ScanActionSettings.
     *
     * @return scanActionList
     */
    public ArrayOfScanAction getScanActionList() {
        return scanActionList;
    }


    /**
     * Sets the scanActionList value for this ScanActionSettings.
     *
     * @param scanActionList
     */
    public void setScanActionList(ArrayOfScanAction scanActionList) {
        this.scanActionList = scanActionList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanActionSettings)) return false;
        ScanActionSettings other = (ScanActionSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.scanActionList==null && other.getScanActionList()==null) ||
             (this.scanActionList!=null &&
              this.scanActionList.equals(other.getScanActionList())));
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
        if (getScanActionList() != null) {
            _hashCode += getScanActionList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanActionSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanActionSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanActionList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanActionList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanAction"));
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
