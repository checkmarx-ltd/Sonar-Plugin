/**
 * GetTeamLdapGroupsMappingResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetTeamLdapGroupsMappingResponse  implements java.io.Serializable {
    private CxWSResponseTeamLdapGroupMappingData getTeamLdapGroupsMappingResult;

    public GetTeamLdapGroupsMappingResponse() {
    }

    public GetTeamLdapGroupsMappingResponse(
           CxWSResponseTeamLdapGroupMappingData getTeamLdapGroupsMappingResult) {
           this.getTeamLdapGroupsMappingResult = getTeamLdapGroupsMappingResult;
    }


    /**
     * Gets the getTeamLdapGroupsMappingResult value for this GetTeamLdapGroupsMappingResponse.
     *
     * @return getTeamLdapGroupsMappingResult
     */
    public CxWSResponseTeamLdapGroupMappingData getGetTeamLdapGroupsMappingResult() {
        return getTeamLdapGroupsMappingResult;
    }


    /**
     * Sets the getTeamLdapGroupsMappingResult value for this GetTeamLdapGroupsMappingResponse.
     *
     * @param getTeamLdapGroupsMappingResult
     */
    public void setGetTeamLdapGroupsMappingResult(CxWSResponseTeamLdapGroupMappingData getTeamLdapGroupsMappingResult) {
        this.getTeamLdapGroupsMappingResult = getTeamLdapGroupsMappingResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetTeamLdapGroupsMappingResponse)) return false;
        GetTeamLdapGroupsMappingResponse other = (GetTeamLdapGroupsMappingResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.getTeamLdapGroupsMappingResult==null && other.getGetTeamLdapGroupsMappingResult()==null) ||
             (this.getTeamLdapGroupsMappingResult!=null &&
              this.getTeamLdapGroupsMappingResult.equals(other.getGetTeamLdapGroupsMappingResult())));
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
        if (getGetTeamLdapGroupsMappingResult() != null) {
            _hashCode += getGetTeamLdapGroupsMappingResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTeamLdapGroupsMappingResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetTeamLdapGroupsMappingResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getTeamLdapGroupsMappingResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetTeamLdapGroupsMappingResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseTeamLdapGroupMappingData"));
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
