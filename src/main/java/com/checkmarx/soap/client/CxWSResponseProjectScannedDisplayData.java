/**
 * CxWSResponseProjectScannedDisplayData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseProjectScannedDisplayData  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private ArrayOfProjectScannedDisplayData projectScannedList;

    public CxWSResponseProjectScannedDisplayData() {
    }

    public CxWSResponseProjectScannedDisplayData(
           boolean isSuccesfull,
           String errorMessage,
           ArrayOfProjectScannedDisplayData projectScannedList) {
        super(
            isSuccesfull,
            errorMessage);
        this.projectScannedList = projectScannedList;
    }


    /**
     * Gets the projectScannedList value for this CxWSResponseProjectScannedDisplayData.
     *
     * @return projectScannedList
     */
    public ArrayOfProjectScannedDisplayData getProjectScannedList() {
        return projectScannedList;
    }


    /**
     * Sets the projectScannedList value for this CxWSResponseProjectScannedDisplayData.
     *
     * @param projectScannedList
     */
    public void setProjectScannedList(ArrayOfProjectScannedDisplayData projectScannedList) {
        this.projectScannedList = projectScannedList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseProjectScannedDisplayData)) return false;
        CxWSResponseProjectScannedDisplayData other = (CxWSResponseProjectScannedDisplayData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.projectScannedList==null && other.getProjectScannedList()==null) ||
             (this.projectScannedList!=null &&
              this.projectScannedList.equals(other.getProjectScannedList())));
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
        if (getProjectScannedList() != null) {
            _hashCode += getProjectScannedList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseProjectScannedDisplayData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectScannedDisplayData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectScannedList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectScannedList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfProjectScannedDisplayData"));
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
