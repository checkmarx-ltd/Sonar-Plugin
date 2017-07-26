/**
 * GetConfigurationSetListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetConfigurationSetListResponse  implements java.io.Serializable {
    private CxWSResponseConfigSetList getConfigurationSetListResult;

    public GetConfigurationSetListResponse() {
    }

    public GetConfigurationSetListResponse(
           CxWSResponseConfigSetList getConfigurationSetListResult) {
           this.getConfigurationSetListResult = getConfigurationSetListResult;
    }


    /**
     * Gets the getConfigurationSetListResult value for this GetConfigurationSetListResponse.
     *
     * @return getConfigurationSetListResult
     */
    public CxWSResponseConfigSetList getGetConfigurationSetListResult() {
        return getConfigurationSetListResult;
    }


    /**
     * Sets the getConfigurationSetListResult value for this GetConfigurationSetListResponse.
     *
     * @param getConfigurationSetListResult
     */
    public void setGetConfigurationSetListResult(CxWSResponseConfigSetList getConfigurationSetListResult) {
        this.getConfigurationSetListResult = getConfigurationSetListResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetConfigurationSetListResponse)) return false;
        GetConfigurationSetListResponse other = (GetConfigurationSetListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.getConfigurationSetListResult==null && other.getGetConfigurationSetListResult()==null) ||
             (this.getConfigurationSetListResult!=null &&
              this.getConfigurationSetListResult.equals(other.getGetConfigurationSetListResult())));
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
        if (getGetConfigurationSetListResult() != null) {
            _hashCode += getGetConfigurationSetListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetConfigurationSetListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetConfigurationSetListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getConfigurationSetListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetConfigurationSetListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseConfigSetList"));
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
