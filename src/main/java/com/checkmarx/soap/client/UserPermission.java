/**
 * UserPermission.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class UserPermission  implements java.io.Serializable {
    private boolean isAllowedToDelete;

    private boolean isAllowedToDuplicate;

    private boolean isAllowedToRun;

    private boolean isAllowedToUpdate;

    public UserPermission() {
    }

    public UserPermission(
           boolean isAllowedToDelete,
           boolean isAllowedToDuplicate,
           boolean isAllowedToRun,
           boolean isAllowedToUpdate) {
           this.isAllowedToDelete = isAllowedToDelete;
           this.isAllowedToDuplicate = isAllowedToDuplicate;
           this.isAllowedToRun = isAllowedToRun;
           this.isAllowedToUpdate = isAllowedToUpdate;
    }


    /**
     * Gets the isAllowedToDelete value for this UserPermission.
     * 
     * @return isAllowedToDelete
     */
    public boolean isIsAllowedToDelete() {
        return isAllowedToDelete;
    }


    /**
     * Sets the isAllowedToDelete value for this UserPermission.
     * 
     * @param isAllowedToDelete
     */
    public void setIsAllowedToDelete(boolean isAllowedToDelete) {
        this.isAllowedToDelete = isAllowedToDelete;
    }


    /**
     * Gets the isAllowedToDuplicate value for this UserPermission.
     * 
     * @return isAllowedToDuplicate
     */
    public boolean isIsAllowedToDuplicate() {
        return isAllowedToDuplicate;
    }


    /**
     * Sets the isAllowedToDuplicate value for this UserPermission.
     * 
     * @param isAllowedToDuplicate
     */
    public void setIsAllowedToDuplicate(boolean isAllowedToDuplicate) {
        this.isAllowedToDuplicate = isAllowedToDuplicate;
    }


    /**
     * Gets the isAllowedToRun value for this UserPermission.
     * 
     * @return isAllowedToRun
     */
    public boolean isIsAllowedToRun() {
        return isAllowedToRun;
    }


    /**
     * Sets the isAllowedToRun value for this UserPermission.
     * 
     * @param isAllowedToRun
     */
    public void setIsAllowedToRun(boolean isAllowedToRun) {
        this.isAllowedToRun = isAllowedToRun;
    }


    /**
     * Gets the isAllowedToUpdate value for this UserPermission.
     * 
     * @return isAllowedToUpdate
     */
    public boolean isIsAllowedToUpdate() {
        return isAllowedToUpdate;
    }


    /**
     * Sets the isAllowedToUpdate value for this UserPermission.
     * 
     * @param isAllowedToUpdate
     */
    public void setIsAllowedToUpdate(boolean isAllowedToUpdate) {
        this.isAllowedToUpdate = isAllowedToUpdate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UserPermission)) return false;
        UserPermission other = (UserPermission) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.isAllowedToDelete == other.isIsAllowedToDelete() &&
            this.isAllowedToDuplicate == other.isIsAllowedToDuplicate() &&
            this.isAllowedToRun == other.isIsAllowedToRun() &&
            this.isAllowedToUpdate == other.isIsAllowedToUpdate();
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
        _hashCode += (isIsAllowedToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToDuplicate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToRun() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToUpdate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserPermission.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserPermission"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToDelete");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToDelete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToDuplicate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToDuplicate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToRun");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToRun"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToUpdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToUpdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
