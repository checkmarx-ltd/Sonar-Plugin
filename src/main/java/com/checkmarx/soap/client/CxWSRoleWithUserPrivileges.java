/**
 * CxWSRoleWithUserPrivileges.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSRoleWithUserPrivileges  extends Role  implements java.io.Serializable {
    private ArrayOfCxWSItemAndCRUD itemsCRUD;

    public CxWSRoleWithUserPrivileges() {
    }

    public CxWSRoleWithUserPrivileges(
           String name,
           String ID,
           ArrayOfCxWSItemAndCRUD itemsCRUD) {
        super(
            name,
            ID);
        this.itemsCRUD = itemsCRUD;
    }


    /**
     * Gets the itemsCRUD value for this CxWSRoleWithUserPrivileges.
     *
     * @return itemsCRUD
     */
    public ArrayOfCxWSItemAndCRUD getItemsCRUD() {
        return itemsCRUD;
    }


    /**
     * Sets the itemsCRUD value for this CxWSRoleWithUserPrivileges.
     *
     * @param itemsCRUD
     */
    public void setItemsCRUD(ArrayOfCxWSItemAndCRUD itemsCRUD) {
        this.itemsCRUD = itemsCRUD;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSRoleWithUserPrivileges)) return false;
        CxWSRoleWithUserPrivileges other = (CxWSRoleWithUserPrivileges) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.itemsCRUD==null && other.getItemsCRUD()==null) ||
             (this.itemsCRUD!=null &&
              this.itemsCRUD.equals(other.getItemsCRUD())));
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
        if (getItemsCRUD() != null) {
            _hashCode += getItemsCRUD().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSRoleWithUserPrivileges.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSRoleWithUserPrivileges"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemsCRUD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ItemsCRUD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSItemAndCRUD"));
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
