/**
 * ScheduleSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScheduleSettings  implements java.io.Serializable {
    private ScheduleType schedule;

    private ArrayOfDayOfWeek scheduledDays;

    private CxDateTime time;

    private CxDateTime startSchedulingPeriod;

    private CxDateTime endSchedulingPeriod;

    private int schedulingFrequency;

    public ScheduleSettings() {
    }

    public ScheduleSettings(
           ScheduleType schedule,
           ArrayOfDayOfWeek scheduledDays,
           CxDateTime time,
           CxDateTime startSchedulingPeriod,
           CxDateTime endSchedulingPeriod,
           int schedulingFrequency) {
           this.schedule = schedule;
           this.scheduledDays = scheduledDays;
           this.time = time;
           this.startSchedulingPeriod = startSchedulingPeriod;
           this.endSchedulingPeriod = endSchedulingPeriod;
           this.schedulingFrequency = schedulingFrequency;
    }


    /**
     * Gets the schedule value for this ScheduleSettings.
     *
     * @return schedule
     */
    public ScheduleType getSchedule() {
        return schedule;
    }


    /**
     * Sets the schedule value for this ScheduleSettings.
     *
     * @param schedule
     */
    public void setSchedule(ScheduleType schedule) {
        this.schedule = schedule;
    }


    /**
     * Gets the scheduledDays value for this ScheduleSettings.
     *
     * @return scheduledDays
     */
    public ArrayOfDayOfWeek getScheduledDays() {
        return scheduledDays;
    }


    /**
     * Sets the scheduledDays value for this ScheduleSettings.
     *
     * @param scheduledDays
     */
    public void setScheduledDays(ArrayOfDayOfWeek scheduledDays) {
        this.scheduledDays = scheduledDays;
    }


    /**
     * Gets the time value for this ScheduleSettings.
     *
     * @return time
     */
    public CxDateTime getTime() {
        return time;
    }


    /**
     * Sets the time value for this ScheduleSettings.
     *
     * @param time
     */
    public void setTime(CxDateTime time) {
        this.time = time;
    }


    /**
     * Gets the startSchedulingPeriod value for this ScheduleSettings.
     *
     * @return startSchedulingPeriod
     */
    public CxDateTime getStartSchedulingPeriod() {
        return startSchedulingPeriod;
    }


    /**
     * Sets the startSchedulingPeriod value for this ScheduleSettings.
     *
     * @param startSchedulingPeriod
     */
    public void setStartSchedulingPeriod(CxDateTime startSchedulingPeriod) {
        this.startSchedulingPeriod = startSchedulingPeriod;
    }


    /**
     * Gets the endSchedulingPeriod value for this ScheduleSettings.
     *
     * @return endSchedulingPeriod
     */
    public CxDateTime getEndSchedulingPeriod() {
        return endSchedulingPeriod;
    }


    /**
     * Sets the endSchedulingPeriod value for this ScheduleSettings.
     *
     * @param endSchedulingPeriod
     */
    public void setEndSchedulingPeriod(CxDateTime endSchedulingPeriod) {
        this.endSchedulingPeriod = endSchedulingPeriod;
    }


    /**
     * Gets the schedulingFrequency value for this ScheduleSettings.
     *
     * @return schedulingFrequency
     */
    public int getSchedulingFrequency() {
        return schedulingFrequency;
    }


    /**
     * Sets the schedulingFrequency value for this ScheduleSettings.
     *
     * @param schedulingFrequency
     */
    public void setSchedulingFrequency(int schedulingFrequency) {
        this.schedulingFrequency = schedulingFrequency;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScheduleSettings)) return false;
        ScheduleSettings other = (ScheduleSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.schedule==null && other.getSchedule()==null) ||
             (this.schedule!=null &&
              this.schedule.equals(other.getSchedule()))) &&
            ((this.scheduledDays==null && other.getScheduledDays()==null) ||
             (this.scheduledDays!=null &&
              this.scheduledDays.equals(other.getScheduledDays()))) &&
            ((this.time==null && other.getTime()==null) ||
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.startSchedulingPeriod==null && other.getStartSchedulingPeriod()==null) ||
             (this.startSchedulingPeriod!=null &&
              this.startSchedulingPeriod.equals(other.getStartSchedulingPeriod()))) &&
            ((this.endSchedulingPeriod==null && other.getEndSchedulingPeriod()==null) ||
             (this.endSchedulingPeriod!=null &&
              this.endSchedulingPeriod.equals(other.getEndSchedulingPeriod()))) &&
            this.schedulingFrequency == other.getSchedulingFrequency();
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
        if (getSchedule() != null) {
            _hashCode += getSchedule().hashCode();
        }
        if (getScheduledDays() != null) {
            _hashCode += getScheduledDays().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getStartSchedulingPeriod() != null) {
            _hashCode += getStartSchedulingPeriod().hashCode();
        }
        if (getEndSchedulingPeriod() != null) {
            _hashCode += getEndSchedulingPeriod().hashCode();
        }
        _hashCode += getSchedulingFrequency();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScheduleSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScheduleSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("schedule");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Schedule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScheduleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledDays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScheduledDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfDayOfWeek"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startSchedulingPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StartSchedulingPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endSchedulingPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "EndSchedulingPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("schedulingFrequency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SchedulingFrequency"));
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
