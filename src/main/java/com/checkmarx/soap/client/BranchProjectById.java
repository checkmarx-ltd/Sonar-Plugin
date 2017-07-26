/**
 * BranchProjectById.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class BranchProjectById  implements java.io.Serializable {
    private String sessionId;

    private long originProjectId;

    private String newBranchProjectName;

    public BranchProjectById() {
    }

    public BranchProjectById(
           String sessionId,
           long originProjectId,
           String newBranchProjectName) {
           this.sessionId = sessionId;
           this.originProjectId = originProjectId;
           this.newBranchProjectName = newBranchProjectName;
    }


    /**
     * Gets the sessionId value for this BranchProjectById.
     *
     * @return sessionId
     */
    public String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this BranchProjectById.
     *
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the originProjectId value for this BranchProjectById.
     *
     * @return originProjectId
     */
    public long getOriginProjectId() {
        return originProjectId;
    }


    /**
     * Sets the originProjectId value for this BranchProjectById.
     *
     * @param originProjectId
     */
    public void setOriginProjectId(long originProjectId) {
        this.originProjectId = originProjectId;
    }


    /**
     * Gets the newBranchProjectName value for this BranchProjectById.
     *
     * @return newBranchProjectName
     */
    public String getNewBranchProjectName() {
        return newBranchProjectName;
    }


    /**
     * Sets the newBranchProjectName value for this BranchProjectById.
     *
     * @param newBranchProjectName
     */
    public void setNewBranchProjectName(String newBranchProjectName) {
        this.newBranchProjectName = newBranchProjectName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof BranchProjectById)) return false;
        BranchProjectById other = (BranchProjectById) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.sessionId==null && other.getSessionId()==null) ||
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            this.originProjectId == other.getOriginProjectId() &&
            ((this.newBranchProjectName==null && other.getNewBranchProjectName()==null) ||
             (this.newBranchProjectName!=null &&
              this.newBranchProjectName.equals(other.getNewBranchProjectName())));
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
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        _hashCode += new Long(getOriginProjectId()).hashCode();
        if (getNewBranchProjectName() != null) {
            _hashCode += getNewBranchProjectName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BranchProjectById.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">BranchProjectById"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originProjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "originProjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newBranchProjectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "newBranchProjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
