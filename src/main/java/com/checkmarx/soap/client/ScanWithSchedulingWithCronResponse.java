/**
 * ScanWithSchedulingWithCronResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanWithSchedulingWithCronResponse  implements java.io.Serializable {
    private CxWSResponseRunID scanWithSchedulingWithCronResult;

    public ScanWithSchedulingWithCronResponse() {
    }

    public ScanWithSchedulingWithCronResponse(
           CxWSResponseRunID scanWithSchedulingWithCronResult) {
           this.scanWithSchedulingWithCronResult = scanWithSchedulingWithCronResult;
    }


    /**
     * Gets the scanWithSchedulingWithCronResult value for this ScanWithSchedulingWithCronResponse.
     *
     * @return scanWithSchedulingWithCronResult
     */
    public CxWSResponseRunID getScanWithSchedulingWithCronResult() {
        return scanWithSchedulingWithCronResult;
    }


    /**
     * Sets the scanWithSchedulingWithCronResult value for this ScanWithSchedulingWithCronResponse.
     *
     * @param scanWithSchedulingWithCronResult
     */
    public void setScanWithSchedulingWithCronResult(CxWSResponseRunID scanWithSchedulingWithCronResult) {
        this.scanWithSchedulingWithCronResult = scanWithSchedulingWithCronResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanWithSchedulingWithCronResponse)) return false;
        ScanWithSchedulingWithCronResponse other = (ScanWithSchedulingWithCronResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.scanWithSchedulingWithCronResult==null && other.getScanWithSchedulingWithCronResult()==null) ||
             (this.scanWithSchedulingWithCronResult!=null &&
              this.scanWithSchedulingWithCronResult.equals(other.getScanWithSchedulingWithCronResult())));
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
        if (getScanWithSchedulingWithCronResult() != null) {
            _hashCode += getScanWithSchedulingWithCronResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanWithSchedulingWithCronResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithSchedulingWithCronResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanWithSchedulingWithCronResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithSchedulingWithCronResult"));
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
