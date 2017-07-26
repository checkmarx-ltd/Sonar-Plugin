/**
 * Login.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class Login  implements java.io.Serializable {
    private Credentials applicationCredentials;

    private int lcid;

    public Login() {
    }

    public Login(
           Credentials applicationCredentials,
           int lcid) {
           this.applicationCredentials = applicationCredentials;
           this.lcid = lcid;
    }


    /**
     * Gets the applicationCredentials value for this Login.
     *
     * @return applicationCredentials
     */
    public Credentials getApplicationCredentials() {
        return applicationCredentials;
    }


    /**
     * Sets the applicationCredentials value for this Login.
     *
     * @param applicationCredentials
     */
    public void setApplicationCredentials(Credentials applicationCredentials) {
        this.applicationCredentials = applicationCredentials;
    }


    /**
     * Gets the lcid value for this Login.
     *
     * @return lcid
     */
    public int getLcid() {
        return lcid;
    }


    /**
     * Sets the lcid value for this Login.
     *
     * @param lcid
     */
    public void setLcid(int lcid) {
        this.lcid = lcid;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Login)) return false;
        Login other = (Login) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.applicationCredentials==null && other.getApplicationCredentials()==null) ||
             (this.applicationCredentials!=null &&
              this.applicationCredentials.equals(other.getApplicationCredentials()))) &&
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
        if (getApplicationCredentials() != null) {
            _hashCode += getApplicationCredentials().hashCode();
        }
        _hashCode += getLcid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Login.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">Login"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationCredentials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "applicationCredentials"));
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
