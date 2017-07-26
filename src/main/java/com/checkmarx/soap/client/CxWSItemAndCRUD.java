/**
 * CxWSItemAndCRUD.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSItemAndCRUD  implements java.io.Serializable {
    private CxWSItemTypeEnum type;

    private ArrayOfCxWSEnableCRUDAction CRUDActionList;

    public CxWSItemAndCRUD() {
    }

    public CxWSItemAndCRUD(
           CxWSItemTypeEnum type,
           ArrayOfCxWSEnableCRUDAction CRUDActionList) {
           this.type = type;
           this.CRUDActionList = CRUDActionList;
    }


    /**
     * Gets the type value for this CxWSItemAndCRUD.
     *
     * @return type
     */
    public CxWSItemTypeEnum getType() {
        return type;
    }


    /**
     * Sets the type value for this CxWSItemAndCRUD.
     *
     * @param type
     */
    public void setType(CxWSItemTypeEnum type) {
        this.type = type;
    }


    /**
     * Gets the CRUDActionList value for this CxWSItemAndCRUD.
     *
     * @return CRUDActionList
     */
    public ArrayOfCxWSEnableCRUDAction getCRUDActionList() {
        return CRUDActionList;
    }


    /**
     * Sets the CRUDActionList value for this CxWSItemAndCRUD.
     *
     * @param CRUDActionList
     */
    public void setCRUDActionList(ArrayOfCxWSEnableCRUDAction CRUDActionList) {
        this.CRUDActionList = CRUDActionList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSItemAndCRUD)) return false;
        CxWSItemAndCRUD other = (CxWSItemAndCRUD) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.type==null && other.getType()==null) ||
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.CRUDActionList==null && other.getCRUDActionList()==null) ||
             (this.CRUDActionList!=null &&
              this.CRUDActionList.equals(other.getCRUDActionList())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getCRUDActionList() != null) {
            _hashCode += getCRUDActionList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSItemAndCRUD.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSItemAndCRUD"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSItemTypeEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CRUDActionList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CRUDActionList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSEnableCRUDAction"));
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
