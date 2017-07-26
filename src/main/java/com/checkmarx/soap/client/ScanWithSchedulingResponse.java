/**
 * ScanWithSchedulingResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanWithSchedulingResponse  implements java.io.Serializable {
    private CxWSResponseRunID scanWithSchedulingResult;

    public ScanWithSchedulingResponse() {
    }

    public ScanWithSchedulingResponse(
           CxWSResponseRunID scanWithSchedulingResult) {
           this.scanWithSchedulingResult = scanWithSchedulingResult;
    }


    /**
     * Gets the scanWithSchedulingResult value for this ScanWithSchedulingResponse.
     *
     * @return scanWithSchedulingResult
     */
    public CxWSResponseRunID getScanWithSchedulingResult() {
        return scanWithSchedulingResult;
    }


    /**
     * Sets the scanWithSchedulingResult value for this ScanWithSchedulingResponse.
     *
     * @param scanWithSchedulingResult
     */
    public void setScanWithSchedulingResult(CxWSResponseRunID scanWithSchedulingResult) {
        this.scanWithSchedulingResult = scanWithSchedulingResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanWithSchedulingResponse)) return false;
        ScanWithSchedulingResponse other = (ScanWithSchedulingResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.scanWithSchedulingResult==null && other.getScanWithSchedulingResult()==null) ||
             (this.scanWithSchedulingResult!=null &&
              this.scanWithSchedulingResult.equals(other.getScanWithSchedulingResult())));
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
        if (getScanWithSchedulingResult() != null) {
            _hashCode += getScanWithSchedulingResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanWithSchedulingResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithSchedulingResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanWithSchedulingResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithSchedulingResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID"));
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
