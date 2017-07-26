/**
 * CxDateTime.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxDateTime  implements java.io.Serializable {
    private int hour;

    private int minute;

    private int second;

    private int day;

    private int month;

    private int year;

    public CxDateTime() {
    }

    public CxDateTime(
           int hour,
           int minute,
           int second,
           int day,
           int month,
           int year) {
           this.hour = hour;
           this.minute = minute;
           this.second = second;
           this.day = day;
           this.month = month;
           this.year = year;
    }


    /**
     * Gets the hour value for this CxDateTime.
     * 
     * @return hour
     */
    public int getHour() {
        return hour;
    }


    /**
     * Sets the hour value for this CxDateTime.
     * 
     * @param hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }


    /**
     * Gets the minute value for this CxDateTime.
     * 
     * @return minute
     */
    public int getMinute() {
        return minute;
    }


    /**
     * Sets the minute value for this CxDateTime.
     * 
     * @param minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }


    /**
     * Gets the second value for this CxDateTime.
     * 
     * @return second
     */
    public int getSecond() {
        return second;
    }


    /**
     * Sets the second value for this CxDateTime.
     * 
     * @param second
     */
    public void setSecond(int second) {
        this.second = second;
    }


    /**
     * Gets the day value for this CxDateTime.
     * 
     * @return day
     */
    public int getDay() {
        return day;
    }


    /**
     * Sets the day value for this CxDateTime.
     * 
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }


    /**
     * Gets the month value for this CxDateTime.
     * 
     * @return month
     */
    public int getMonth() {
        return month;
    }


    /**
     * Sets the month value for this CxDateTime.
     * 
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }


    /**
     * Gets the year value for this CxDateTime.
     * 
     * @return year
     */
    public int getYear() {
        return year;
    }


    /**
     * Sets the year value for this CxDateTime.
     * 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxDateTime)) return false;
        CxDateTime other = (CxDateTime) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.hour == other.getHour() &&
            this.minute == other.getMinute() &&
            this.second == other.getSecond() &&
            this.day == other.getDay() &&
            this.month == other.getMonth() &&
            this.year == other.getYear();
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
        _hashCode += getHour();
        _hashCode += getMinute();
        _hashCode += getSecond();
        _hashCode += getDay();
        _hashCode += getMonth();
        _hashCode += getYear();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxDateTime.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hour");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Hour"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minute");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Minute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("second");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Second"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Year"));
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
