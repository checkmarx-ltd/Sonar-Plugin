/**
 * ArrayOfCxWSProjectCustomField.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfCxWSProjectCustomField  implements java.io.Serializable {
    private CxWSProjectCustomField[] cxWSProjectCustomField;

    public ArrayOfCxWSProjectCustomField() {
    }

    public ArrayOfCxWSProjectCustomField(
           CxWSProjectCustomField[] cxWSProjectCustomField) {
           this.cxWSProjectCustomField = cxWSProjectCustomField;
    }


    /**
     * Gets the cxWSProjectCustomField value for this ArrayOfCxWSProjectCustomField.
     *
     * @return cxWSProjectCustomField
     */
    public CxWSProjectCustomField[] getCxWSProjectCustomField() {
        return cxWSProjectCustomField;
    }


    /**
     * Sets the cxWSProjectCustomField value for this ArrayOfCxWSProjectCustomField.
     *
     * @param cxWSProjectCustomField
     */
    public void setCxWSProjectCustomField(CxWSProjectCustomField[] cxWSProjectCustomField) {
        this.cxWSProjectCustomField = cxWSProjectCustomField;
    }

    public CxWSProjectCustomField getCxWSProjectCustomField(int i) {
        return this.cxWSProjectCustomField[i];
    }

    public void setCxWSProjectCustomField(int i, CxWSProjectCustomField _value) {
        this.cxWSProjectCustomField[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfCxWSProjectCustomField)) return false;
        ArrayOfCxWSProjectCustomField other = (ArrayOfCxWSProjectCustomField) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.cxWSProjectCustomField==null && other.getCxWSProjectCustomField()==null) ||
             (this.cxWSProjectCustomField!=null &&
              java.util.Arrays.equals(this.cxWSProjectCustomField, other.getCxWSProjectCustomField())));
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
        if (getCxWSProjectCustomField() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCxWSProjectCustomField());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCxWSProjectCustomField(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfCxWSProjectCustomField.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSProjectCustomField"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cxWSProjectCustomField");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSProjectCustomField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSProjectCustomField"));
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
