/**
 * CxWSReportStatusResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSReportStatusResponse  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private boolean isReady;

    private boolean isFailed;

    public CxWSReportStatusResponse() {
    }

    public CxWSReportStatusResponse(
           boolean isSuccesfull,
           String errorMessage,
           boolean isReady,
           boolean isFailed) {
        super(
            isSuccesfull,
            errorMessage);
        this.isReady = isReady;
        this.isFailed = isFailed;
    }


    /**
     * Gets the isReady value for this CxWSReportStatusResponse.
     *
     * @return isReady
     */
    public boolean isIsReady() {
        return isReady;
    }


    /**
     * Sets the isReady value for this CxWSReportStatusResponse.
     *
     * @param isReady
     */
    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }


    /**
     * Gets the isFailed value for this CxWSReportStatusResponse.
     *
     * @return isFailed
     */
    public boolean isIsFailed() {
        return isFailed;
    }


    /**
     * Sets the isFailed value for this CxWSReportStatusResponse.
     *
     * @param isFailed
     */
    public void setIsFailed(boolean isFailed) {
        this.isFailed = isFailed;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSReportStatusResponse)) return false;
        CxWSReportStatusResponse other = (CxWSReportStatusResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            this.isReady == other.isIsReady() &&
            this.isFailed == other.isIsFailed();
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
        _hashCode += (isIsReady() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsFailed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSReportStatusResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSReportStatusResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isReady");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsReady"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFailed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsFailed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
