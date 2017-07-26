/**
 * ArrayOfConfigurationSet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfConfigurationSet  implements java.io.Serializable {
    private ConfigurationSet[] configurationSet;

    public ArrayOfConfigurationSet() {
    }

    public ArrayOfConfigurationSet(
           ConfigurationSet[] configurationSet) {
           this.configurationSet = configurationSet;
    }


    /**
     * Gets the configurationSet value for this ArrayOfConfigurationSet.
     *
     * @return configurationSet
     */
    public ConfigurationSet[] getConfigurationSet() {
        return configurationSet;
    }


    /**
     * Sets the configurationSet value for this ArrayOfConfigurationSet.
     *
     * @param configurationSet
     */
    public void setConfigurationSet(ConfigurationSet[] configurationSet) {
        this.configurationSet = configurationSet;
    }

    public ConfigurationSet getConfigurationSet(int i) {
        return this.configurationSet[i];
    }

    public void setConfigurationSet(int i, ConfigurationSet _value) {
        this.configurationSet[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfConfigurationSet)) return false;
        ArrayOfConfigurationSet other = (ArrayOfConfigurationSet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.configurationSet==null && other.getConfigurationSet()==null) ||
             (this.configurationSet!=null &&
              java.util.Arrays.equals(this.configurationSet, other.getConfigurationSet())));
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
        if (getConfigurationSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfigurationSet());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getConfigurationSet(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfConfigurationSet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfConfigurationSet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configurationSet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ConfigurationSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ConfigurationSet"));
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
