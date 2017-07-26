/**
 * CxWSResponseDiscovery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseDiscovery  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private String serviceURL;

    public CxWSResponseDiscovery() {
    }

    public CxWSResponseDiscovery(
           boolean isSuccesfull,
           String errorMessage,
           String serviceURL) {
        super(
            isSuccesfull,
            errorMessage);
        this.serviceURL = serviceURL;
    }


    /**
     * Gets the serviceURL value for this CxWSResponseDiscovery.
     *
     * @return serviceURL
     */
    public String getServiceURL() {
        return serviceURL;
    }


    /**
     * Sets the serviceURL value for this CxWSResponseDiscovery.
     *
     * @param serviceURL
     */
    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseDiscovery)) return false;
        CxWSResponseDiscovery other = (CxWSResponseDiscovery) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.serviceURL==null && other.getServiceURL()==null) ||
             (this.serviceURL!=null &&
              this.serviceURL.equals(other.getServiceURL())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getServiceURL() != null) {
            _hashCode += getServiceURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseDiscovery.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com", "CxWSResponseDiscovery"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com", "ServiceURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
