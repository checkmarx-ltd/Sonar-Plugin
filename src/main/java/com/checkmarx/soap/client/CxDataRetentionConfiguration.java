/**
 * CxDataRetentionConfiguration.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxDataRetentionConfiguration  implements java.io.Serializable {
    private CxDataRetentionType dataRetentionType;

    private int numOfScansToPreserve;

    private long startDate;

    private long endDate;

    private Long durationLimitInHours;

    public CxDataRetentionConfiguration() {
    }

    public CxDataRetentionConfiguration(
           CxDataRetentionType dataRetentionType,
           int numOfScansToPreserve,
           long startDate,
           long endDate,
           Long durationLimitInHours) {
           this.dataRetentionType = dataRetentionType;
           this.numOfScansToPreserve = numOfScansToPreserve;
           this.startDate = startDate;
           this.endDate = endDate;
           this.durationLimitInHours = durationLimitInHours;
    }


    /**
     * Gets the dataRetentionType value for this CxDataRetentionConfiguration.
     *
     * @return dataRetentionType
     */
    public CxDataRetentionType getDataRetentionType() {
        return dataRetentionType;
    }


    /**
     * Sets the dataRetentionType value for this CxDataRetentionConfiguration.
     *
     * @param dataRetentionType
     */
    public void setDataRetentionType(CxDataRetentionType dataRetentionType) {
        this.dataRetentionType = dataRetentionType;
    }


    /**
     * Gets the numOfScansToPreserve value for this CxDataRetentionConfiguration.
     *
     * @return numOfScansToPreserve
     */
    public int getNumOfScansToPreserve() {
        return numOfScansToPreserve;
    }


    /**
     * Sets the numOfScansToPreserve value for this CxDataRetentionConfiguration.
     *
     * @param numOfScansToPreserve
     */
    public void setNumOfScansToPreserve(int numOfScansToPreserve) {
        this.numOfScansToPreserve = numOfScansToPreserve;
    }


    /**
     * Gets the startDate value for this CxDataRetentionConfiguration.
     *
     * @return startDate
     */
    public long getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this CxDataRetentionConfiguration.
     *
     * @param startDate
     */
    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this CxDataRetentionConfiguration.
     *
     * @return endDate
     */
    public long getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this CxDataRetentionConfiguration.
     *
     * @param endDate
     */
    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the durationLimitInHours value for this CxDataRetentionConfiguration.
     *
     * @return durationLimitInHours
     */
    public Long getDurationLimitInHours() {
        return durationLimitInHours;
    }


    /**
     * Sets the durationLimitInHours value for this CxDataRetentionConfiguration.
     *
     * @param durationLimitInHours
     */
    public void setDurationLimitInHours(Long durationLimitInHours) {
        this.durationLimitInHours = durationLimitInHours;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxDataRetentionConfiguration)) return false;
        CxDataRetentionConfiguration other = (CxDataRetentionConfiguration) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.dataRetentionType==null && other.getDataRetentionType()==null) ||
             (this.dataRetentionType!=null &&
              this.dataRetentionType.equals(other.getDataRetentionType()))) &&
            this.numOfScansToPreserve == other.getNumOfScansToPreserve() &&
            this.startDate == other.getStartDate() &&
            this.endDate == other.getEndDate() &&
            ((this.durationLimitInHours==null && other.getDurationLimitInHours()==null) ||
             (this.durationLimitInHours!=null &&
              this.durationLimitInHours.equals(other.getDurationLimitInHours())));
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
        if (getDataRetentionType() != null) {
            _hashCode += getDataRetentionType().hashCode();
        }
        _hashCode += getNumOfScansToPreserve();
        _hashCode += new Long(getStartDate()).hashCode();
        _hashCode += new Long(getEndDate()).hashCode();
        if (getDurationLimitInHours() != null) {
            _hashCode += getDurationLimitInHours().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxDataRetentionConfiguration.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDataRetentionConfiguration"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataRetentionType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DataRetentionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDataRetentionType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numOfScansToPreserve");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "NumOfScansToPreserve"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "EndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("durationLimitInHours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DurationLimitInHours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
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
