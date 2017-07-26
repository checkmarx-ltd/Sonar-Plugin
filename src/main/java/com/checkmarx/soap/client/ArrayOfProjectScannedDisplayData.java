/**
 * ArrayOfProjectScannedDisplayData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfProjectScannedDisplayData  implements java.io.Serializable {
    private ProjectScannedDisplayData[] projectScannedDisplayData;

    public ArrayOfProjectScannedDisplayData() {
    }

    public ArrayOfProjectScannedDisplayData(
           ProjectScannedDisplayData[] projectScannedDisplayData) {
           this.projectScannedDisplayData = projectScannedDisplayData;
    }


    /**
     * Gets the projectScannedDisplayData value for this ArrayOfProjectScannedDisplayData.
     *
     * @return projectScannedDisplayData
     */
    public ProjectScannedDisplayData[] getProjectScannedDisplayData() {
        return projectScannedDisplayData;
    }


    /**
     * Sets the projectScannedDisplayData value for this ArrayOfProjectScannedDisplayData.
     *
     * @param projectScannedDisplayData
     */
    public void setProjectScannedDisplayData(ProjectScannedDisplayData[] projectScannedDisplayData) {
        this.projectScannedDisplayData = projectScannedDisplayData;
    }

    public ProjectScannedDisplayData getProjectScannedDisplayData(int i) {
        return this.projectScannedDisplayData[i];
    }

    public void setProjectScannedDisplayData(int i, ProjectScannedDisplayData _value) {
        this.projectScannedDisplayData[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfProjectScannedDisplayData)) return false;
        ArrayOfProjectScannedDisplayData other = (ArrayOfProjectScannedDisplayData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.projectScannedDisplayData==null && other.getProjectScannedDisplayData()==null) ||
             (this.projectScannedDisplayData!=null &&
              java.util.Arrays.equals(this.projectScannedDisplayData, other.getProjectScannedDisplayData())));
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
        if (getProjectScannedDisplayData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProjectScannedDisplayData());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getProjectScannedDisplayData(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfProjectScannedDisplayData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfProjectScannedDisplayData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectScannedDisplayData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectScannedDisplayData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectScannedDisplayData"));
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
