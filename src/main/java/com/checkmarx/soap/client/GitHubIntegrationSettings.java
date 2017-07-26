/**
 * GitHubIntegrationSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GitHubIntegrationSettings  implements java.io.Serializable {
    private Credentials contributorCredentials;

    private Credentials ownerCredentials;

    private int eventsThreshold;

    public GitHubIntegrationSettings() {
    }

    public GitHubIntegrationSettings(
           Credentials contributorCredentials,
           Credentials ownerCredentials,
           int eventsThreshold) {
           this.contributorCredentials = contributorCredentials;
           this.ownerCredentials = ownerCredentials;
           this.eventsThreshold = eventsThreshold;
    }


    /**
     * Gets the contributorCredentials value for this GitHubIntegrationSettings.
     *
     * @return contributorCredentials
     */
    public Credentials getContributorCredentials() {
        return contributorCredentials;
    }


    /**
     * Sets the contributorCredentials value for this GitHubIntegrationSettings.
     *
     * @param contributorCredentials
     */
    public void setContributorCredentials(Credentials contributorCredentials) {
        this.contributorCredentials = contributorCredentials;
    }


    /**
     * Gets the ownerCredentials value for this GitHubIntegrationSettings.
     *
     * @return ownerCredentials
     */
    public Credentials getOwnerCredentials() {
        return ownerCredentials;
    }


    /**
     * Sets the ownerCredentials value for this GitHubIntegrationSettings.
     *
     * @param ownerCredentials
     */
    public void setOwnerCredentials(Credentials ownerCredentials) {
        this.ownerCredentials = ownerCredentials;
    }


    /**
     * Gets the eventsThreshold value for this GitHubIntegrationSettings.
     *
     * @return eventsThreshold
     */
    public int getEventsThreshold() {
        return eventsThreshold;
    }


    /**
     * Sets the eventsThreshold value for this GitHubIntegrationSettings.
     *
     * @param eventsThreshold
     */
    public void setEventsThreshold(int eventsThreshold) {
        this.eventsThreshold = eventsThreshold;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GitHubIntegrationSettings)) return false;
        GitHubIntegrationSettings other = (GitHubIntegrationSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.contributorCredentials==null && other.getContributorCredentials()==null) ||
             (this.contributorCredentials!=null &&
              this.contributorCredentials.equals(other.getContributorCredentials()))) &&
            ((this.ownerCredentials==null && other.getOwnerCredentials()==null) ||
             (this.ownerCredentials!=null &&
              this.ownerCredentials.equals(other.getOwnerCredentials()))) &&
            this.eventsThreshold == other.getEventsThreshold();
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
        if (getContributorCredentials() != null) {
            _hashCode += getContributorCredentials().hashCode();
        }
        if (getOwnerCredentials() != null) {
            _hashCode += getOwnerCredentials().hashCode();
        }
        _hashCode += getEventsThreshold();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GitHubIntegrationSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GitHubIntegrationSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributorCredentials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ContributorCredentials"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerCredentials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "OwnerCredentials"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventsThreshold");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "EventsThreshold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
