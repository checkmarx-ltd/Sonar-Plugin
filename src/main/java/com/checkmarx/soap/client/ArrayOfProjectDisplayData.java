/**
 * ArrayOfProjectDisplayData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfProjectDisplayData  implements java.io.Serializable {
    private ProjectDisplayData[] projectDisplayData;

    public ArrayOfProjectDisplayData() {
    }

    public ArrayOfProjectDisplayData(
           ProjectDisplayData[] projectDisplayData) {
           this.projectDisplayData = projectDisplayData;
    }


    /**
     * Gets the projectDisplayData value for this ArrayOfProjectDisplayData.
     *
     * @return projectDisplayData
     */
    public ProjectDisplayData[] getProjectDisplayData() {
        return projectDisplayData;
    }


    /**
     * Sets the projectDisplayData value for this ArrayOfProjectDisplayData.
     *
     * @param projectDisplayData
     */
    public void setProjectDisplayData(ProjectDisplayData[] projectDisplayData) {
        this.projectDisplayData = projectDisplayData;
    }

    public ProjectDisplayData getProjectDisplayData(int i) {
        return this.projectDisplayData[i];
    }

    public void setProjectDisplayData(int i, ProjectDisplayData _value) {
        this.projectDisplayData[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfProjectDisplayData)) return false;
        ArrayOfProjectDisplayData other = (ArrayOfProjectDisplayData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.projectDisplayData==null && other.getProjectDisplayData()==null) ||
             (this.projectDisplayData!=null &&
              java.util.Arrays.equals(this.projectDisplayData, other.getProjectDisplayData())));
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
        if (getProjectDisplayData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProjectDisplayData());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getProjectDisplayData(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfProjectDisplayData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfProjectDisplayData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectDisplayData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectDisplayData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectDisplayData"));
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
