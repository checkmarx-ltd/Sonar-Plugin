/**
 * UserData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class UserData  extends WebClientUser  implements java.io.Serializable {
    private boolean isActive;

    private Role roleData;

    public UserData() {
    }

    public UserData(
           long ID,
           String firstName,
           String lastName,
           int userPreferedLanguageLCID,
           String password,
           String jobTitle,
           String email,
           String userName,
           String UPN,
           String phone,
           String cellPhone,
           String skype,
           String companyID,
           String companyName,
           String willExpireAfterDays,
           String country,
           java.util.Calendar dateCreated,
           boolean auditUser,
           ArrayOfGroup groupList,
           java.util.Calendar lastLoginDate,
           boolean limitAccessByIPAddress,
           ArrayOfString allowedIPs,
           boolean isActive,
           Role roleData) {
        super(
            ID,
            firstName,
            lastName,
            userPreferedLanguageLCID,
            password,
            jobTitle,
            email,
            userName,
            UPN,
            phone,
            cellPhone,
            skype,
            companyID,
            companyName,
            willExpireAfterDays,
            country,
            dateCreated,
            auditUser,
            groupList,
            lastLoginDate,
            limitAccessByIPAddress,
            allowedIPs);
        this.isActive = isActive;
        this.roleData = roleData;
    }


    /**
     * Gets the isActive value for this UserData.
     *
     * @return isActive
     */
    public boolean isIsActive() {
        return isActive;
    }


    /**
     * Sets the isActive value for this UserData.
     *
     * @param isActive
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    /**
     * Gets the roleData value for this UserData.
     *
     * @return roleData
     */
    public Role getRoleData() {
        return roleData;
    }


    /**
     * Sets the roleData value for this UserData.
     *
     * @param roleData
     */
    public void setRoleData(Role roleData) {
        this.roleData = roleData;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UserData)) return false;
        UserData other = (UserData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            this.isActive == other.isIsActive() &&
            ((this.roleData==null && other.getRoleData()==null) ||
             (this.roleData!=null &&
              this.roleData.equals(other.getRoleData())));
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
        _hashCode += (isIsActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRoleData() != null) {
            _hashCode += getRoleData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsActive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RoleData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Role"));
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
