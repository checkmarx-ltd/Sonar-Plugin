/**
 * LoginWithTokenResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class LoginWithTokenResponse  implements java.io.Serializable {
    private CxWSResponseLoginData loginWithTokenResult;

    public LoginWithTokenResponse() {
    }

    public LoginWithTokenResponse(
           CxWSResponseLoginData loginWithTokenResult) {
           this.loginWithTokenResult = loginWithTokenResult;
    }


    /**
     * Gets the loginWithTokenResult value for this LoginWithTokenResponse.
     *
     * @return loginWithTokenResult
     */
    public CxWSResponseLoginData getLoginWithTokenResult() {
        return loginWithTokenResult;
    }


    /**
     * Sets the loginWithTokenResult value for this LoginWithTokenResponse.
     *
     * @param loginWithTokenResult
     */
    public void setLoginWithTokenResult(CxWSResponseLoginData loginWithTokenResult) {
        this.loginWithTokenResult = loginWithTokenResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof LoginWithTokenResponse)) return false;
        LoginWithTokenResponse other = (LoginWithTokenResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.loginWithTokenResult==null && other.getLoginWithTokenResult()==null) ||
             (this.loginWithTokenResult!=null &&
              this.loginWithTokenResult.equals(other.getLoginWithTokenResult())));
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
        if (getLoginWithTokenResult() != null) {
            _hashCode += getLoginWithTokenResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginWithTokenResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">LoginWithTokenResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginWithTokenResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LoginWithTokenResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseLoginData"));
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
