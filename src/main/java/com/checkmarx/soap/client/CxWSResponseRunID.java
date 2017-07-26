/**
 * CxWSResponseRunID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseRunID  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private long projectID;

    private String runId;

    public CxWSResponseRunID() {
    }

    public CxWSResponseRunID(
           boolean isSuccesfull,
           String errorMessage,
           long projectID,
           String runId) {
        super(
            isSuccesfull,
            errorMessage);
        this.projectID = projectID;
        this.runId = runId;
    }


    /**
     * Gets the projectID value for this CxWSResponseRunID.
     *
     * @return projectID
     */
    public long getProjectID() {
        return projectID;
    }


    /**
     * Sets the projectID value for this CxWSResponseRunID.
     *
     * @param projectID
     */
    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }


    /**
     * Gets the runId value for this CxWSResponseRunID.
     *
     * @return runId
     */
    public String getRunId() {
        return runId;
    }


    /**
     * Sets the runId value for this CxWSResponseRunID.
     *
     * @param runId
     */
    public void setRunId(String runId) {
        this.runId = runId;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseRunID)) return false;
        CxWSResponseRunID other = (CxWSResponseRunID) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            this.projectID == other.getProjectID() &&
            ((this.runId==null && other.getRunId()==null) ||
             (this.runId!=null &&
              this.runId.equals(other.getRunId())));
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
        _hashCode += new Long(getProjectID()).hashCode();
        if (getRunId() != null) {
            _hashCode += getRunId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseRunID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RunId"));
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
