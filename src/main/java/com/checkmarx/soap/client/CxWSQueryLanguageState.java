/**
 * CxWSQueryLanguageState.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSQueryLanguageState  implements java.io.Serializable {
    private int languageID;

    private String languageName;

    private String languageHash;

    private java.util.Calendar stateCreationDate;

    public CxWSQueryLanguageState() {
    }

    public CxWSQueryLanguageState(
           int languageID,
           String languageName,
           String languageHash,
           java.util.Calendar stateCreationDate) {
           this.languageID = languageID;
           this.languageName = languageName;
           this.languageHash = languageHash;
           this.stateCreationDate = stateCreationDate;
    }


    /**
     * Gets the languageID value for this CxWSQueryLanguageState.
     *
     * @return languageID
     */
    public int getLanguageID() {
        return languageID;
    }


    /**
     * Sets the languageID value for this CxWSQueryLanguageState.
     *
     * @param languageID
     */
    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }


    /**
     * Gets the languageName value for this CxWSQueryLanguageState.
     *
     * @return languageName
     */
    public String getLanguageName() {
        return languageName;
    }


    /**
     * Sets the languageName value for this CxWSQueryLanguageState.
     *
     * @param languageName
     */
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }


    /**
     * Gets the languageHash value for this CxWSQueryLanguageState.
     *
     * @return languageHash
     */
    public String getLanguageHash() {
        return languageHash;
    }


    /**
     * Sets the languageHash value for this CxWSQueryLanguageState.
     *
     * @param languageHash
     */
    public void setLanguageHash(String languageHash) {
        this.languageHash = languageHash;
    }


    /**
     * Gets the stateCreationDate value for this CxWSQueryLanguageState.
     *
     * @return stateCreationDate
     */
    public java.util.Calendar getStateCreationDate() {
        return stateCreationDate;
    }


    /**
     * Sets the stateCreationDate value for this CxWSQueryLanguageState.
     *
     * @param stateCreationDate
     */
    public void setStateCreationDate(java.util.Calendar stateCreationDate) {
        this.stateCreationDate = stateCreationDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSQueryLanguageState)) return false;
        CxWSQueryLanguageState other = (CxWSQueryLanguageState) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.languageID == other.getLanguageID() &&
            ((this.languageName==null && other.getLanguageName()==null) ||
             (this.languageName!=null &&
              this.languageName.equals(other.getLanguageName()))) &&
            ((this.languageHash==null && other.getLanguageHash()==null) ||
             (this.languageHash!=null &&
              this.languageHash.equals(other.getLanguageHash()))) &&
            ((this.stateCreationDate==null && other.getStateCreationDate()==null) ||
             (this.stateCreationDate!=null &&
              this.stateCreationDate.equals(other.getStateCreationDate())));
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
        _hashCode += getLanguageID();
        if (getLanguageName() != null) {
            _hashCode += getLanguageName().hashCode();
        }
        if (getLanguageHash() != null) {
            _hashCode += getLanguageHash().hashCode();
        }
        if (getStateCreationDate() != null) {
            _hashCode += getStateCreationDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSQueryLanguageState.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSQueryLanguageState"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LanguageID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LanguageName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageHash");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LanguageHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateCreationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StateCreationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
