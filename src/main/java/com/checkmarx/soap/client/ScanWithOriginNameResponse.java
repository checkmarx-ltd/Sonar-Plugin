/**
 * ScanWithOriginNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanWithOriginNameResponse  implements java.io.Serializable {
    private CxWSResponseRunID scanWithOriginNameResult;

    public ScanWithOriginNameResponse() {
    }

    public ScanWithOriginNameResponse(
           CxWSResponseRunID scanWithOriginNameResult) {
           this.scanWithOriginNameResult = scanWithOriginNameResult;
    }


    /**
     * Gets the scanWithOriginNameResult value for this ScanWithOriginNameResponse.
     *
     * @return scanWithOriginNameResult
     */
    public CxWSResponseRunID getScanWithOriginNameResult() {
        return scanWithOriginNameResult;
    }


    /**
     * Sets the scanWithOriginNameResult value for this ScanWithOriginNameResponse.
     *
     * @param scanWithOriginNameResult
     */
    public void setScanWithOriginNameResult(CxWSResponseRunID scanWithOriginNameResult) {
        this.scanWithOriginNameResult = scanWithOriginNameResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanWithOriginNameResponse)) return false;
        ScanWithOriginNameResponse other = (ScanWithOriginNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.scanWithOriginNameResult==null && other.getScanWithOriginNameResult()==null) ||
             (this.scanWithOriginNameResult!=null &&
              this.scanWithOriginNameResult.equals(other.getScanWithOriginNameResult())));
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
        if (getScanWithOriginNameResult() != null) {
            _hashCode += getScanWithOriginNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanWithOriginNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithOriginNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanWithOriginNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithOriginNameResult"));
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
