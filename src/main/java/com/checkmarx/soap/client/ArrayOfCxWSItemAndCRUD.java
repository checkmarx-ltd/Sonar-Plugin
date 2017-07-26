/**
 * ArrayOfCxWSItemAndCRUD.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfCxWSItemAndCRUD  implements java.io.Serializable {
    private CxWSItemAndCRUD[] cxWSItemAndCRUD;

    public ArrayOfCxWSItemAndCRUD() {
    }

    public ArrayOfCxWSItemAndCRUD(
           CxWSItemAndCRUD[] cxWSItemAndCRUD) {
           this.cxWSItemAndCRUD = cxWSItemAndCRUD;
    }


    /**
     * Gets the cxWSItemAndCRUD value for this ArrayOfCxWSItemAndCRUD.
     *
     * @return cxWSItemAndCRUD
     */
    public CxWSItemAndCRUD[] getCxWSItemAndCRUD() {
        return cxWSItemAndCRUD;
    }


    /**
     * Sets the cxWSItemAndCRUD value for this ArrayOfCxWSItemAndCRUD.
     *
     * @param cxWSItemAndCRUD
     */
    public void setCxWSItemAndCRUD(CxWSItemAndCRUD[] cxWSItemAndCRUD) {
        this.cxWSItemAndCRUD = cxWSItemAndCRUD;
    }

    public CxWSItemAndCRUD getCxWSItemAndCRUD(int i) {
        return this.cxWSItemAndCRUD[i];
    }

    public void setCxWSItemAndCRUD(int i, CxWSItemAndCRUD _value) {
        this.cxWSItemAndCRUD[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfCxWSItemAndCRUD)) return false;
        ArrayOfCxWSItemAndCRUD other = (ArrayOfCxWSItemAndCRUD) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.cxWSItemAndCRUD==null && other.getCxWSItemAndCRUD()==null) ||
             (this.cxWSItemAndCRUD!=null &&
              java.util.Arrays.equals(this.cxWSItemAndCRUD, other.getCxWSItemAndCRUD())));
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
        if (getCxWSItemAndCRUD() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCxWSItemAndCRUD());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCxWSItemAndCRUD(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfCxWSItemAndCRUD.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSItemAndCRUD"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cxWSItemAndCRUD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSItemAndCRUD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSItemAndCRUD"));
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
