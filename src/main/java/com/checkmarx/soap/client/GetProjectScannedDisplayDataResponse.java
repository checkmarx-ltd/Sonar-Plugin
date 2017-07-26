/**
 * GetProjectScannedDisplayDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetProjectScannedDisplayDataResponse  implements java.io.Serializable {
    private CxWSResponseProjectScannedDisplayData getProjectScannedDisplayDataResult;

    public GetProjectScannedDisplayDataResponse() {
    }

    public GetProjectScannedDisplayDataResponse(
           CxWSResponseProjectScannedDisplayData getProjectScannedDisplayDataResult) {
           this.getProjectScannedDisplayDataResult = getProjectScannedDisplayDataResult;
    }


    /**
     * Gets the getProjectScannedDisplayDataResult value for this GetProjectScannedDisplayDataResponse.
     *
     * @return getProjectScannedDisplayDataResult
     */
    public CxWSResponseProjectScannedDisplayData getGetProjectScannedDisplayDataResult() {
        return getProjectScannedDisplayDataResult;
    }


    /**
     * Sets the getProjectScannedDisplayDataResult value for this GetProjectScannedDisplayDataResponse.
     *
     * @param getProjectScannedDisplayDataResult
     */
    public void setGetProjectScannedDisplayDataResult(CxWSResponseProjectScannedDisplayData getProjectScannedDisplayDataResult) {
        this.getProjectScannedDisplayDataResult = getProjectScannedDisplayDataResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetProjectScannedDisplayDataResponse)) return false;
        GetProjectScannedDisplayDataResponse other = (GetProjectScannedDisplayDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.getProjectScannedDisplayDataResult==null && other.getGetProjectScannedDisplayDataResult()==null) ||
             (this.getProjectScannedDisplayDataResult!=null &&
              this.getProjectScannedDisplayDataResult.equals(other.getGetProjectScannedDisplayDataResult())));
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
        if (getGetProjectScannedDisplayDataResult() != null) {
            _hashCode += getGetProjectScannedDisplayDataResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetProjectScannedDisplayDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetProjectScannedDisplayDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getProjectScannedDisplayDataResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetProjectScannedDisplayDataResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectScannedDisplayData"));
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
