/**
 * GetScanReportStatusResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetScanReportStatusResponse  implements java.io.Serializable {
    private CxWSReportStatusResponse getScanReportStatusResult;

    public GetScanReportStatusResponse() {
    }

    public GetScanReportStatusResponse(
           CxWSReportStatusResponse getScanReportStatusResult) {
           this.getScanReportStatusResult = getScanReportStatusResult;
    }


    /**
     * Gets the getScanReportStatusResult value for this GetScanReportStatusResponse.
     *
     * @return getScanReportStatusResult
     */
    public CxWSReportStatusResponse getGetScanReportStatusResult() {
        return getScanReportStatusResult;
    }


    /**
     * Sets the getScanReportStatusResult value for this GetScanReportStatusResponse.
     *
     * @param getScanReportStatusResult
     */
    public void setGetScanReportStatusResult(CxWSReportStatusResponse getScanReportStatusResult) {
        this.getScanReportStatusResult = getScanReportStatusResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetScanReportStatusResponse)) return false;
        GetScanReportStatusResponse other = (GetScanReportStatusResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.getScanReportStatusResult==null && other.getGetScanReportStatusResult()==null) ||
             (this.getScanReportStatusResult!=null &&
              this.getScanReportStatusResult.equals(other.getGetScanReportStatusResult())));
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
        if (getGetScanReportStatusResult() != null) {
            _hashCode += getGetScanReportStatusResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetScanReportStatusResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanReportStatusResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getScanReportStatusResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanReportStatusResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSReportStatusResponse"));
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
