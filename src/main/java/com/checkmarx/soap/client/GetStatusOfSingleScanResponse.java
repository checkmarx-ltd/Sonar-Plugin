/**
 * GetStatusOfSingleScanResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetStatusOfSingleScanResponse  implements java.io.Serializable {
    private CxWSResponseScanStatus getStatusOfSingleScanResult;

    public GetStatusOfSingleScanResponse() {
    }

    public GetStatusOfSingleScanResponse(
           CxWSResponseScanStatus getStatusOfSingleScanResult) {
           this.getStatusOfSingleScanResult = getStatusOfSingleScanResult;
    }


    /**
     * Gets the getStatusOfSingleScanResult value for this GetStatusOfSingleScanResponse.
     *
     * @return getStatusOfSingleScanResult
     */
    public CxWSResponseScanStatus getGetStatusOfSingleScanResult() {
        return getStatusOfSingleScanResult;
    }


    /**
     * Sets the getStatusOfSingleScanResult value for this GetStatusOfSingleScanResponse.
     *
     * @param getStatusOfSingleScanResult
     */
    public void setGetStatusOfSingleScanResult(CxWSResponseScanStatus getStatusOfSingleScanResult) {
        this.getStatusOfSingleScanResult = getStatusOfSingleScanResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetStatusOfSingleScanResponse)) return false;
        GetStatusOfSingleScanResponse other = (GetStatusOfSingleScanResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.getStatusOfSingleScanResult==null && other.getGetStatusOfSingleScanResult()==null) ||
             (this.getStatusOfSingleScanResult!=null &&
              this.getStatusOfSingleScanResult.equals(other.getGetStatusOfSingleScanResult())));
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
        if (getGetStatusOfSingleScanResult() != null) {
            _hashCode += getGetStatusOfSingleScanResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStatusOfSingleScanResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetStatusOfSingleScanResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getStatusOfSingleScanResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetStatusOfSingleScanResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanStatus"));
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
