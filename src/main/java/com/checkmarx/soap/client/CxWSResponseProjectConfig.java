/**
 * CxWSResponseProjectConfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseProjectConfig  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private ProjectConfiguration projectConfig;

    private UserPermission permission;

    public CxWSResponseProjectConfig() {
    }

    public CxWSResponseProjectConfig(
           boolean isSuccesfull,
           String errorMessage,
           ProjectConfiguration projectConfig,
           UserPermission permission) {
        super(
            isSuccesfull,
            errorMessage);
        this.projectConfig = projectConfig;
        this.permission = permission;
    }


    /**
     * Gets the projectConfig value for this CxWSResponseProjectConfig.
     *
     * @return projectConfig
     */
    public ProjectConfiguration getProjectConfig() {
        return projectConfig;
    }


    /**
     * Sets the projectConfig value for this CxWSResponseProjectConfig.
     *
     * @param projectConfig
     */
    public void setProjectConfig(ProjectConfiguration projectConfig) {
        this.projectConfig = projectConfig;
    }


    /**
     * Gets the permission value for this CxWSResponseProjectConfig.
     *
     * @return permission
     */
    public UserPermission getPermission() {
        return permission;
    }


    /**
     * Sets the permission value for this CxWSResponseProjectConfig.
     *
     * @param permission
     */
    public void setPermission(UserPermission permission) {
        this.permission = permission;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseProjectConfig)) return false;
        CxWSResponseProjectConfig other = (CxWSResponseProjectConfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.projectConfig==null && other.getProjectConfig()==null) ||
             (this.projectConfig!=null &&
              this.projectConfig.equals(other.getProjectConfig()))) &&
            ((this.permission==null && other.getPermission()==null) ||
             (this.permission!=null &&
              this.permission.equals(other.getPermission())));
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
        if (getProjectConfig() != null) {
            _hashCode += getProjectConfig().hashCode();
        }
        if (getPermission() != null) {
            _hashCode += getPermission().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseProjectConfig.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectConfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectConfiguration"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Permission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserPermission"));
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
