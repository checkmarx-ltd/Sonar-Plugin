/**
 * ConfigurationSet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ConfigurationSet  implements java.io.Serializable {
    private String configSetName;

    private long ID;

    public ConfigurationSet() {
    }

    public ConfigurationSet(
           String configSetName,
           long ID) {
           this.configSetName = configSetName;
           this.ID = ID;
    }


    /**
     * Gets the configSetName value for this ConfigurationSet.
     *
     * @return configSetName
     */
    public String getConfigSetName() {
        return configSetName;
    }


    /**
     * Sets the configSetName value for this ConfigurationSet.
     *
     * @param configSetName
     */
    public void setConfigSetName(String configSetName) {
        this.configSetName = configSetName;
    }


    /**
     * Gets the ID value for this ConfigurationSet.
     *
     * @return ID
     */
    public long getID() {
        return ID;
    }


    /**
     * Sets the ID value for this ConfigurationSet.
     *
     * @param ID
     */
    public void setID(long ID) {
        this.ID = ID;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ConfigurationSet)) return false;
        ConfigurationSet other = (ConfigurationSet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.configSetName==null && other.getConfigSetName()==null) ||
             (this.configSetName!=null &&
              this.configSetName.equals(other.getConfigSetName()))) &&
            this.ID == other.getID();
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
        if (getConfigSetName() != null) {
            _hashCode += getConfigSetName().hashCode();
        }
        _hashCode += new Long(getID()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfigurationSet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ConfigurationSet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configSetName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ConfigSetName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
