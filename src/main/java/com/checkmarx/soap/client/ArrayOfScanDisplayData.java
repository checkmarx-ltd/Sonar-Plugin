/**
 * ArrayOfScanDisplayData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfScanDisplayData  implements java.io.Serializable {
    private ScanDisplayData[] scanDisplayData;

    public ArrayOfScanDisplayData() {
    }

    public ArrayOfScanDisplayData(
           ScanDisplayData[] scanDisplayData) {
           this.scanDisplayData = scanDisplayData;
    }


    /**
     * Gets the scanDisplayData value for this ArrayOfScanDisplayData.
     *
     * @return scanDisplayData
     */
    public ScanDisplayData[] getScanDisplayData() {
        return scanDisplayData;
    }


    /**
     * Sets the scanDisplayData value for this ArrayOfScanDisplayData.
     *
     * @param scanDisplayData
     */
    public void setScanDisplayData(ScanDisplayData[] scanDisplayData) {
        this.scanDisplayData = scanDisplayData;
    }

    public ScanDisplayData getScanDisplayData(int i) {
        return this.scanDisplayData[i];
    }

    public void setScanDisplayData(int i, ScanDisplayData _value) {
        this.scanDisplayData[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfScanDisplayData)) return false;
        ArrayOfScanDisplayData other = (ArrayOfScanDisplayData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.scanDisplayData==null && other.getScanDisplayData()==null) ||
             (this.scanDisplayData!=null &&
              java.util.Arrays.equals(this.scanDisplayData, other.getScanDisplayData())));
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
        if (getScanDisplayData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScanDisplayData());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getScanDisplayData(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfScanDisplayData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanDisplayData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanDisplayData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanDisplayData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanDisplayData"));
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
