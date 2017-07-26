/**
 * GetScansDisplayDataForAllProjectsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetScansDisplayDataForAllProjectsResponse  implements java.io.Serializable {
    private CxWSResponseScansDisplayData getScansDisplayDataForAllProjectsResult;

    public GetScansDisplayDataForAllProjectsResponse() {
    }

    public GetScansDisplayDataForAllProjectsResponse(
           CxWSResponseScansDisplayData getScansDisplayDataForAllProjectsResult) {
           this.getScansDisplayDataForAllProjectsResult = getScansDisplayDataForAllProjectsResult;
    }


    /**
     * Gets the getScansDisplayDataForAllProjectsResult value for this GetScansDisplayDataForAllProjectsResponse.
     *
     * @return getScansDisplayDataForAllProjectsResult
     */
    public CxWSResponseScansDisplayData getGetScansDisplayDataForAllProjectsResult() {
        return getScansDisplayDataForAllProjectsResult;
    }


    /**
     * Sets the getScansDisplayDataForAllProjectsResult value for this GetScansDisplayDataForAllProjectsResponse.
     *
     * @param getScansDisplayDataForAllProjectsResult
     */
    public void setGetScansDisplayDataForAllProjectsResult(CxWSResponseScansDisplayData getScansDisplayDataForAllProjectsResult) {
        this.getScansDisplayDataForAllProjectsResult = getScansDisplayDataForAllProjectsResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetScansDisplayDataForAllProjectsResponse)) return false;
        GetScansDisplayDataForAllProjectsResponse other = (GetScansDisplayDataForAllProjectsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.getScansDisplayDataForAllProjectsResult==null && other.getGetScansDisplayDataForAllProjectsResult()==null) ||
             (this.getScansDisplayDataForAllProjectsResult!=null &&
              this.getScansDisplayDataForAllProjectsResult.equals(other.getGetScansDisplayDataForAllProjectsResult())));
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
        if (getGetScansDisplayDataForAllProjectsResult() != null) {
            _hashCode += getGetScansDisplayDataForAllProjectsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetScansDisplayDataForAllProjectsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScansDisplayDataForAllProjectsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getScansDisplayDataForAllProjectsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScansDisplayDataForAllProjectsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScansDisplayData"));
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
