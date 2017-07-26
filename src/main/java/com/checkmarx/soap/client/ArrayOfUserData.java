/**
 * ArrayOfUserData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfUserData  implements java.io.Serializable {
    private UserData[] userData;

    public ArrayOfUserData() {
    }

    public ArrayOfUserData(
           UserData[] userData) {
           this.userData = userData;
    }


    /**
     * Gets the userData value for this ArrayOfUserData.
     *
     * @return userData
     */
    public UserData[] getUserData() {
        return userData;
    }


    /**
     * Sets the userData value for this ArrayOfUserData.
     *
     * @param userData
     */
    public void setUserData(UserData[] userData) {
        this.userData = userData;
    }

    public UserData getUserData(int i) {
        return this.userData[i];
    }

    public void setUserData(int i, UserData _value) {
        this.userData[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfUserData)) return false;
        ArrayOfUserData other = (ArrayOfUserData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.userData==null && other.getUserData()==null) ||
             (this.userData!=null &&
              java.util.Arrays.equals(this.userData, other.getUserData())));
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
        if (getUserData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserData());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getUserData(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfUserData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfUserData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserData"));
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
