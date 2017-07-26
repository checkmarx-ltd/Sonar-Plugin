/**
 * CxWSResponseUserData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseUserData  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private ArrayOfUserData userDataList;

    public CxWSResponseUserData() {
    }

    public CxWSResponseUserData(
           boolean isSuccesfull,
           String errorMessage,
           ArrayOfUserData userDataList) {
        super(
            isSuccesfull,
            errorMessage);
        this.userDataList = userDataList;
    }


    /**
     * Gets the userDataList value for this CxWSResponseUserData.
     *
     * @return userDataList
     */
    public ArrayOfUserData getUserDataList() {
        return userDataList;
    }


    /**
     * Sets the userDataList value for this CxWSResponseUserData.
     *
     * @param userDataList
     */
    public void setUserDataList(ArrayOfUserData userDataList) {
        this.userDataList = userDataList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseUserData)) return false;
        CxWSResponseUserData other = (CxWSResponseUserData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.userDataList==null && other.getUserDataList()==null) ||
             (this.userDataList!=null &&
              this.userDataList.equals(other.getUserDataList())));
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
        if (getUserDataList() != null) {
            _hashCode += getUserDataList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseUserData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseUserData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userDataList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserDataList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfUserData"));
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
