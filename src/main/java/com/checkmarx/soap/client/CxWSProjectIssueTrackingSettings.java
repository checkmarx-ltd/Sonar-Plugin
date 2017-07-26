/**
 * CxWSProjectIssueTrackingSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSProjectIssueTrackingSettings  implements java.io.Serializable {
    private long trackingSystemID;

    private ArrayOfCxWSIssueTrackingParam params;

    public CxWSProjectIssueTrackingSettings() {
    }

    public CxWSProjectIssueTrackingSettings(
           long trackingSystemID,
           ArrayOfCxWSIssueTrackingParam params) {
           this.trackingSystemID = trackingSystemID;
           this.params = params;
    }


    /**
     * Gets the trackingSystemID value for this CxWSProjectIssueTrackingSettings.
     *
     * @return trackingSystemID
     */
    public long getTrackingSystemID() {
        return trackingSystemID;
    }


    /**
     * Sets the trackingSystemID value for this CxWSProjectIssueTrackingSettings.
     *
     * @param trackingSystemID
     */
    public void setTrackingSystemID(long trackingSystemID) {
        this.trackingSystemID = trackingSystemID;
    }


    /**
     * Gets the params value for this CxWSProjectIssueTrackingSettings.
     *
     * @return params
     */
    public ArrayOfCxWSIssueTrackingParam getParams() {
        return params;
    }


    /**
     * Sets the params value for this CxWSProjectIssueTrackingSettings.
     *
     * @param params
     */
    public void setParams(ArrayOfCxWSIssueTrackingParam params) {
        this.params = params;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSProjectIssueTrackingSettings)) return false;
        CxWSProjectIssueTrackingSettings other = (CxWSProjectIssueTrackingSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.trackingSystemID == other.getTrackingSystemID() &&
            ((this.params==null && other.getParams()==null) ||
             (this.params!=null &&
              this.params.equals(other.getParams())));
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
        _hashCode += new Long(getTrackingSystemID()).hashCode();
        if (getParams() != null) {
            _hashCode += getParams().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSProjectIssueTrackingSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSProjectIssueTrackingSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackingSystemID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TrackingSystemID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("params");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Params"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSIssueTrackingParam"));
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
