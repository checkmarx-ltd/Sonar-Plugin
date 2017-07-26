/**
 * CxWSResponsePresetList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponsePresetList  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private ArrayOfPreset presetList;

    public CxWSResponsePresetList() {
    }

    public CxWSResponsePresetList(
           boolean isSuccesfull,
           String errorMessage,
           ArrayOfPreset presetList) {
        super(
            isSuccesfull,
            errorMessage);
        this.presetList = presetList;
    }


    /**
     * Gets the presetList value for this CxWSResponsePresetList.
     *
     * @return presetList
     */
    public ArrayOfPreset getPresetList() {
        return presetList;
    }


    /**
     * Sets the presetList value for this CxWSResponsePresetList.
     *
     * @param presetList
     */
    public void setPresetList(ArrayOfPreset presetList) {
        this.presetList = presetList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponsePresetList)) return false;
        CxWSResponsePresetList other = (CxWSResponsePresetList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.presetList==null && other.getPresetList()==null) ||
             (this.presetList!=null &&
              this.presetList.equals(other.getPresetList())));
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
        if (getPresetList() != null) {
            _hashCode += getPresetList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponsePresetList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponsePresetList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("presetList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PresetList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfPreset"));
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
