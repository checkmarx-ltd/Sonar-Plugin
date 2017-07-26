/**
 * CxWSBasicRepsonse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSBasicRepsonse  implements java.io.Serializable {
    private boolean isSuccesfull;

    private String errorMessage;

    public CxWSBasicRepsonse() {
    }

    public CxWSBasicRepsonse(
           boolean isSuccesfull,
           String errorMessage) {
           this.isSuccesfull = isSuccesfull;
           this.errorMessage = errorMessage;
    }


    /**
     * Gets the isSuccesfull value for this CxWSBasicRepsonse.
     *
     * @return isSuccesfull
     */
    public boolean isIsSuccesfull() {
        return isSuccesfull;
    }


    /**
     * Sets the isSuccesfull value for this CxWSBasicRepsonse.
     *
     * @param isSuccesfull
     */
    public void setIsSuccesfull(boolean isSuccesfull) {
        this.isSuccesfull = isSuccesfull;
    }


    /**
     * Gets the errorMessage value for this CxWSBasicRepsonse.
     *
     * @return errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this CxWSBasicRepsonse.
     *
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSBasicRepsonse)) return false;
        CxWSBasicRepsonse other = (CxWSBasicRepsonse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.isSuccesfull == other.isIsSuccesfull() &&
            ((this.errorMessage==null && other.getErrorMessage()==null) ||
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage())));
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
        _hashCode += (isIsSuccesfull() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSBasicRepsonse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSuccesfull");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsSuccesfull"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ErrorMessage"));
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
