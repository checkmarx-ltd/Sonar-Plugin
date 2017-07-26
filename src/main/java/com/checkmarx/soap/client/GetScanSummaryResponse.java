/**
 * GetScanSummaryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetScanSummaryResponse  implements java.io.Serializable {
    private CxWSResponseScanSummary getScanSummaryResult;

    public GetScanSummaryResponse() {
    }

    public GetScanSummaryResponse(
           CxWSResponseScanSummary getScanSummaryResult) {
           this.getScanSummaryResult = getScanSummaryResult;
    }


    /**
     * Gets the getScanSummaryResult value for this GetScanSummaryResponse.
     *
     * @return getScanSummaryResult
     */
    public CxWSResponseScanSummary getGetScanSummaryResult() {
        return getScanSummaryResult;
    }


    /**
     * Sets the getScanSummaryResult value for this GetScanSummaryResponse.
     *
     * @param getScanSummaryResult
     */
    public void setGetScanSummaryResult(CxWSResponseScanSummary getScanSummaryResult) {
        this.getScanSummaryResult = getScanSummaryResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetScanSummaryResponse)) return false;
        GetScanSummaryResponse other = (GetScanSummaryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.getScanSummaryResult==null && other.getGetScanSummaryResult()==null) ||
             (this.getScanSummaryResult!=null &&
              this.getScanSummaryResult.equals(other.getGetScanSummaryResult())));
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
        if (getGetScanSummaryResult() != null) {
            _hashCode += getGetScanSummaryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetScanSummaryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanSummaryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getScanSummaryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanSummaryResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanSummary"));
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
