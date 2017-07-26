/**
 * ArrayOfPreset.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfPreset  implements java.io.Serializable {
    private Preset[] preset;

    public ArrayOfPreset() {
    }

    public ArrayOfPreset(
           Preset[] preset) {
           this.preset = preset;
    }


    /**
     * Gets the preset value for this ArrayOfPreset.
     *
     * @return preset
     */
    public Preset[] getPreset() {
        return preset;
    }


    /**
     * Sets the preset value for this ArrayOfPreset.
     *
     * @param preset
     */
    public void setPreset(Preset[] preset) {
        this.preset = preset;
    }

    public Preset getPreset(int i) {
        return this.preset[i];
    }

    public void setPreset(int i, Preset _value) {
        this.preset[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfPreset)) return false;
        ArrayOfPreset other = (ArrayOfPreset) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.preset==null && other.getPreset()==null) ||
             (this.preset!=null &&
              java.util.Arrays.equals(this.preset, other.getPreset())));
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
        if (getPreset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPreset());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getPreset(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfPreset.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfPreset"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Preset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Preset"));
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
