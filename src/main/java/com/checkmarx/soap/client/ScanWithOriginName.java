/**
 * ScanWithOriginName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanWithOriginName  implements java.io.Serializable {
    private String sessionId;

    private CliScanArgs args;

    private String origName;

    public ScanWithOriginName() {
    }

    public ScanWithOriginName(
           String sessionId,
           CliScanArgs args,
           String origName) {
           this.sessionId = sessionId;
           this.args = args;
           this.origName = origName;
    }


    /**
     * Gets the sessionId value for this ScanWithOriginName.
     *
     * @return sessionId
     */
    public String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this ScanWithOriginName.
     *
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the args value for this ScanWithOriginName.
     *
     * @return args
     */
    public CliScanArgs getArgs() {
        return args;
    }


    /**
     * Sets the args value for this ScanWithOriginName.
     *
     * @param args
     */
    public void setArgs(CliScanArgs args) {
        this.args = args;
    }


    /**
     * Gets the origName value for this ScanWithOriginName.
     *
     * @return origName
     */
    public String getOrigName() {
        return origName;
    }


    /**
     * Sets the origName value for this ScanWithOriginName.
     *
     * @param origName
     */
    public void setOrigName(String origName) {
        this.origName = origName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanWithOriginName)) return false;
        ScanWithOriginName other = (ScanWithOriginName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.sessionId==null && other.getSessionId()==null) ||
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            ((this.args==null && other.getArgs()==null) ||
             (this.args!=null &&
              this.args.equals(other.getArgs()))) &&
            ((this.origName==null && other.getOrigName()==null) ||
             (this.origName!=null &&
              this.origName.equals(other.getOrigName())));
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
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        if (getArgs() != null) {
            _hashCode += getArgs().hashCode();
        }
        if (getOrigName() != null) {
            _hashCode += getOrigName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanWithOriginName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithOriginName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("args");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "args"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CliScanArgs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "origName"));
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
