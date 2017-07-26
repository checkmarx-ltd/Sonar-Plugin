/**
 * ArrayOfCxWSIssueTrackingParam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfCxWSIssueTrackingParam  implements java.io.Serializable {
    private CxWSIssueTrackingParam[] cxWSIssueTrackingParam;

    public ArrayOfCxWSIssueTrackingParam() {
    }

    public ArrayOfCxWSIssueTrackingParam(
           CxWSIssueTrackingParam[] cxWSIssueTrackingParam) {
           this.cxWSIssueTrackingParam = cxWSIssueTrackingParam;
    }


    /**
     * Gets the cxWSIssueTrackingParam value for this ArrayOfCxWSIssueTrackingParam.
     *
     * @return cxWSIssueTrackingParam
     */
    public CxWSIssueTrackingParam[] getCxWSIssueTrackingParam() {
        return cxWSIssueTrackingParam;
    }


    /**
     * Sets the cxWSIssueTrackingParam value for this ArrayOfCxWSIssueTrackingParam.
     *
     * @param cxWSIssueTrackingParam
     */
    public void setCxWSIssueTrackingParam(CxWSIssueTrackingParam[] cxWSIssueTrackingParam) {
        this.cxWSIssueTrackingParam = cxWSIssueTrackingParam;
    }

    public CxWSIssueTrackingParam getCxWSIssueTrackingParam(int i) {
        return this.cxWSIssueTrackingParam[i];
    }

    public void setCxWSIssueTrackingParam(int i, CxWSIssueTrackingParam _value) {
        this.cxWSIssueTrackingParam[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfCxWSIssueTrackingParam)) return false;
        ArrayOfCxWSIssueTrackingParam other = (ArrayOfCxWSIssueTrackingParam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.cxWSIssueTrackingParam==null && other.getCxWSIssueTrackingParam()==null) ||
             (this.cxWSIssueTrackingParam!=null &&
              java.util.Arrays.equals(this.cxWSIssueTrackingParam, other.getCxWSIssueTrackingParam())));
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
        if (getCxWSIssueTrackingParam() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCxWSIssueTrackingParam());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCxWSIssueTrackingParam(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfCxWSIssueTrackingParam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSIssueTrackingParam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cxWSIssueTrackingParam");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSIssueTrackingParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSIssueTrackingParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
