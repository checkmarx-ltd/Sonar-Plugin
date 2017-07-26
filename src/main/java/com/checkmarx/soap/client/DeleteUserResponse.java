/**
 * DeleteUserResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class DeleteUserResponse  implements java.io.Serializable {
    private CxWSBasicRepsonse deleteUserResult;

    public DeleteUserResponse() {
    }

    public DeleteUserResponse(
           CxWSBasicRepsonse deleteUserResult) {
           this.deleteUserResult = deleteUserResult;
    }


    /**
     * Gets the deleteUserResult value for this DeleteUserResponse.
     *
     * @return deleteUserResult
     */
    public CxWSBasicRepsonse getDeleteUserResult() {
        return deleteUserResult;
    }


    /**
     * Sets the deleteUserResult value for this DeleteUserResponse.
     *
     * @param deleteUserResult
     */
    public void setDeleteUserResult(CxWSBasicRepsonse deleteUserResult) {
        this.deleteUserResult = deleteUserResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof DeleteUserResponse)) return false;
        DeleteUserResponse other = (DeleteUserResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.deleteUserResult==null && other.getDeleteUserResult()==null) ||
             (this.deleteUserResult!=null &&
              this.deleteUserResult.equals(other.getDeleteUserResult())));
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
        if (getDeleteUserResult() != null) {
            _hashCode += getDeleteUserResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteUserResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">DeleteUserResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteUserResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DeleteUserResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
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
