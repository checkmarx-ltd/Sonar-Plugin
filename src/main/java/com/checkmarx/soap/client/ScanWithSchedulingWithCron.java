/**
 * ScanWithSchedulingWithCron.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanWithSchedulingWithCron  implements java.io.Serializable {
    private String sessionId;

    private CliScanArgs args;

    private String cronString;

    private long utcEpochStartTime;

    private long utcEpochEndTime;

    public ScanWithSchedulingWithCron() {
    }

    public ScanWithSchedulingWithCron(
           String sessionId,
           CliScanArgs args,
           String cronString,
           long utcEpochStartTime,
           long utcEpochEndTime) {
           this.sessionId = sessionId;
           this.args = args;
           this.cronString = cronString;
           this.utcEpochStartTime = utcEpochStartTime;
           this.utcEpochEndTime = utcEpochEndTime;
    }


    /**
     * Gets the sessionId value for this ScanWithSchedulingWithCron.
     *
     * @return sessionId
     */
    public String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this ScanWithSchedulingWithCron.
     *
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the args value for this ScanWithSchedulingWithCron.
     *
     * @return args
     */
    public CliScanArgs getArgs() {
        return args;
    }


    /**
     * Sets the args value for this ScanWithSchedulingWithCron.
     *
     * @param args
     */
    public void setArgs(CliScanArgs args) {
        this.args = args;
    }


    /**
     * Gets the cronString value for this ScanWithSchedulingWithCron.
     *
     * @return cronString
     */
    public String getCronString() {
        return cronString;
    }


    /**
     * Sets the cronString value for this ScanWithSchedulingWithCron.
     *
     * @param cronString
     */
    public void setCronString(String cronString) {
        this.cronString = cronString;
    }


    /**
     * Gets the utcEpochStartTime value for this ScanWithSchedulingWithCron.
     *
     * @return utcEpochStartTime
     */
    public long getUtcEpochStartTime() {
        return utcEpochStartTime;
    }


    /**
     * Sets the utcEpochStartTime value for this ScanWithSchedulingWithCron.
     *
     * @param utcEpochStartTime
     */
    public void setUtcEpochStartTime(long utcEpochStartTime) {
        this.utcEpochStartTime = utcEpochStartTime;
    }


    /**
     * Gets the utcEpochEndTime value for this ScanWithSchedulingWithCron.
     *
     * @return utcEpochEndTime
     */
    public long getUtcEpochEndTime() {
        return utcEpochEndTime;
    }


    /**
     * Sets the utcEpochEndTime value for this ScanWithSchedulingWithCron.
     *
     * @param utcEpochEndTime
     */
    public void setUtcEpochEndTime(long utcEpochEndTime) {
        this.utcEpochEndTime = utcEpochEndTime;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanWithSchedulingWithCron)) return false;
        ScanWithSchedulingWithCron other = (ScanWithSchedulingWithCron) obj;
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
            ((this.cronString==null && other.getCronString()==null) ||
             (this.cronString!=null &&
              this.cronString.equals(other.getCronString()))) &&
            this.utcEpochStartTime == other.getUtcEpochStartTime() &&
            this.utcEpochEndTime == other.getUtcEpochEndTime();
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
        if (getCronString() != null) {
            _hashCode += getCronString().hashCode();
        }
        _hashCode += new Long(getUtcEpochStartTime()).hashCode();
        _hashCode += new Long(getUtcEpochEndTime()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanWithSchedulingWithCron.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithSchedulingWithCron"));
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
        elemField.setFieldName("cronString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "cronString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utcEpochStartTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "utcEpochStartTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utcEpochEndTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "utcEpochEndTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
