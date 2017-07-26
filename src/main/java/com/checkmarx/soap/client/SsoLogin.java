/**
 * SsoLogin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class SsoLogin  implements java.io.Serializable {
    private Credentials encryptedCredentials;

    private int lcid;

    public SsoLogin() {
    }

    public SsoLogin(
           Credentials encryptedCredentials,
           int lcid) {
           this.encryptedCredentials = encryptedCredentials;
           this.lcid = lcid;
    }


    /**
     * Gets the encryptedCredentials value for this SsoLogin.
     *
     * @return encryptedCredentials
     */
    public Credentials getEncryptedCredentials() {
        return encryptedCredentials;
    }


    /**
     * Sets the encryptedCredentials value for this SsoLogin.
     *
     * @param encryptedCredentials
     */
    public void setEncryptedCredentials(Credentials encryptedCredentials) {
        this.encryptedCredentials = encryptedCredentials;
    }


    /**
     * Gets the lcid value for this SsoLogin.
     *
     * @return lcid
     */
    public int getLcid() {
        return lcid;
    }


    /**
     * Sets the lcid value for this SsoLogin.
     *
     * @param lcid
     */
    public void setLcid(int lcid) {
        this.lcid = lcid;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SsoLogin)) return false;
        SsoLogin other = (SsoLogin) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.encryptedCredentials==null && other.getEncryptedCredentials()==null) ||
             (this.encryptedCredentials!=null &&
              this.encryptedCredentials.equals(other.getEncryptedCredentials()))) &&
            this.lcid == other.getLcid();
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
        if (getEncryptedCredentials() != null) {
            _hashCode += getEncryptedCredentials().hashCode();
        }
        _hashCode += getLcid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SsoLogin.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">SsoLogin"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedCredentials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "encryptedCredentials"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lcid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "lcid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
