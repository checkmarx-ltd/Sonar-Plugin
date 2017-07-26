/**
 * ExecuteDataRetentionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ExecuteDataRetentionResponse  implements java.io.Serializable {
    private CxWSBasicRepsonse executeDataRetentionResult;

    public ExecuteDataRetentionResponse() {
    }

    public ExecuteDataRetentionResponse(
           CxWSBasicRepsonse executeDataRetentionResult) {
           this.executeDataRetentionResult = executeDataRetentionResult;
    }


    /**
     * Gets the executeDataRetentionResult value for this ExecuteDataRetentionResponse.
     *
     * @return executeDataRetentionResult
     */
    public CxWSBasicRepsonse getExecuteDataRetentionResult() {
        return executeDataRetentionResult;
    }


    /**
     * Sets the executeDataRetentionResult value for this ExecuteDataRetentionResponse.
     *
     * @param executeDataRetentionResult
     */
    public void setExecuteDataRetentionResult(CxWSBasicRepsonse executeDataRetentionResult) {
        this.executeDataRetentionResult = executeDataRetentionResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ExecuteDataRetentionResponse)) return false;
        ExecuteDataRetentionResponse other = (ExecuteDataRetentionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.executeDataRetentionResult==null && other.getExecuteDataRetentionResult()==null) ||
             (this.executeDataRetentionResult!=null &&
              this.executeDataRetentionResult.equals(other.getExecuteDataRetentionResult())));
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
        if (getExecuteDataRetentionResult() != null) {
            _hashCode += getExecuteDataRetentionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteDataRetentionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ExecuteDataRetentionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executeDataRetentionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ExecuteDataRetentionResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
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
