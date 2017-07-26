/**
 * ProjectSharedLocation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ProjectSharedLocation  implements java.io.Serializable {
    private ArrayOfString path;

    private Credentials credentials;

    public ProjectSharedLocation() {
    }

    public ProjectSharedLocation(
           ArrayOfString path,
           Credentials credentials) {
           this.path = path;
           this.credentials = credentials;
    }


    /**
     * Gets the path value for this ProjectSharedLocation.
     *
     * @return path
     */
    public ArrayOfString getPath() {
        return path;
    }


    /**
     * Sets the path value for this ProjectSharedLocation.
     *
     * @param path
     */
    public void setPath(ArrayOfString path) {
        this.path = path;
    }


    /**
     * Gets the credentials value for this ProjectSharedLocation.
     *
     * @return credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }


    /**
     * Sets the credentials value for this ProjectSharedLocation.
     *
     * @param credentials
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ProjectSharedLocation)) return false;
        ProjectSharedLocation other = (ProjectSharedLocation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.path==null && other.getPath()==null) ||
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            ((this.credentials==null && other.getCredentials()==null) ||
             (this.credentials!=null &&
              this.credentials.equals(other.getCredentials())));
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
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        if (getCredentials() != null) {
            _hashCode += getCredentials().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjectSharedLocation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSharedLocation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credentials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"));
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
