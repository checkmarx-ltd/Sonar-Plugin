/**
 * UpdateProjectIncrementalConfiguration.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class UpdateProjectIncrementalConfiguration  implements java.io.Serializable {
    private String sessionID;

    private long projectID;

    private ProjectConfiguration projectConfiguration;

    public UpdateProjectIncrementalConfiguration() {
    }

    public UpdateProjectIncrementalConfiguration(
           String sessionID,
           long projectID,
           ProjectConfiguration projectConfiguration) {
           this.sessionID = sessionID;
           this.projectID = projectID;
           this.projectConfiguration = projectConfiguration;
    }


    /**
     * Gets the sessionID value for this UpdateProjectIncrementalConfiguration.
     *
     * @return sessionID
     */
    public String getSessionID() {
        return sessionID;
    }


    /**
     * Sets the sessionID value for this UpdateProjectIncrementalConfiguration.
     *
     * @param sessionID
     */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }


    /**
     * Gets the projectID value for this UpdateProjectIncrementalConfiguration.
     *
     * @return projectID
     */
    public long getProjectID() {
        return projectID;
    }


    /**
     * Sets the projectID value for this UpdateProjectIncrementalConfiguration.
     *
     * @param projectID
     */
    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }


    /**
     * Gets the projectConfiguration value for this UpdateProjectIncrementalConfiguration.
     *
     * @return projectConfiguration
     */
    public ProjectConfiguration getProjectConfiguration() {
        return projectConfiguration;
    }


    /**
     * Sets the projectConfiguration value for this UpdateProjectIncrementalConfiguration.
     *
     * @param projectConfiguration
     */
    public void setProjectConfiguration(ProjectConfiguration projectConfiguration) {
        this.projectConfiguration = projectConfiguration;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UpdateProjectIncrementalConfiguration)) return false;
        UpdateProjectIncrementalConfiguration other = (UpdateProjectIncrementalConfiguration) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.sessionID==null && other.getSessionID()==null) ||
             (this.sessionID!=null &&
              this.sessionID.equals(other.getSessionID()))) &&
            this.projectID == other.getProjectID() &&
            ((this.projectConfiguration==null && other.getProjectConfiguration()==null) ||
             (this.projectConfiguration!=null &&
              this.projectConfiguration.equals(other.getProjectConfiguration())));
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
        if (getSessionID() != null) {
            _hashCode += getSessionID().hashCode();
        }
        _hashCode += new Long(getProjectID()).hashCode();
        if (getProjectConfiguration() != null) {
            _hashCode += getProjectConfiguration().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateProjectIncrementalConfiguration.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateProjectIncrementalConfiguration"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectConfiguration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectConfiguration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectConfiguration"));
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
