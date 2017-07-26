/**
 * Preset.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class Preset  implements java.io.Serializable {
    private String presetName;

    private long ID;

    private String owningUser;

    private boolean isUserAllowToUpdate;

    private boolean isUserAllowToDelete;

    public Preset() {
    }

    public Preset(
           String presetName,
           long ID,
           String owningUser,
           boolean isUserAllowToUpdate,
           boolean isUserAllowToDelete) {
           this.presetName = presetName;
           this.ID = ID;
           this.owningUser = owningUser;
           this.isUserAllowToUpdate = isUserAllowToUpdate;
           this.isUserAllowToDelete = isUserAllowToDelete;
    }


    /**
     * Gets the presetName value for this Preset.
     *
     * @return presetName
     */
    public String getPresetName() {
        return presetName;
    }


    /**
     * Sets the presetName value for this Preset.
     *
     * @param presetName
     */
    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }


    /**
     * Gets the ID value for this Preset.
     *
     * @return ID
     */
    public long getID() {
        return ID;
    }


    /**
     * Sets the ID value for this Preset.
     *
     * @param ID
     */
    public void setID(long ID) {
        this.ID = ID;
    }


    /**
     * Gets the owningUser value for this Preset.
     *
     * @return owningUser
     */
    public String getOwningUser() {
        return owningUser;
    }


    /**
     * Sets the owningUser value for this Preset.
     *
     * @param owningUser
     */
    public void setOwningUser(String owningUser) {
        this.owningUser = owningUser;
    }


    /**
     * Gets the isUserAllowToUpdate value for this Preset.
     *
     * @return isUserAllowToUpdate
     */
    public boolean isIsUserAllowToUpdate() {
        return isUserAllowToUpdate;
    }


    /**
     * Sets the isUserAllowToUpdate value for this Preset.
     *
     * @param isUserAllowToUpdate
     */
    public void setIsUserAllowToUpdate(boolean isUserAllowToUpdate) {
        this.isUserAllowToUpdate = isUserAllowToUpdate;
    }


    /**
     * Gets the isUserAllowToDelete value for this Preset.
     *
     * @return isUserAllowToDelete
     */
    public boolean isIsUserAllowToDelete() {
        return isUserAllowToDelete;
    }


    /**
     * Sets the isUserAllowToDelete value for this Preset.
     *
     * @param isUserAllowToDelete
     */
    public void setIsUserAllowToDelete(boolean isUserAllowToDelete) {
        this.isUserAllowToDelete = isUserAllowToDelete;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Preset)) return false;
        Preset other = (Preset) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.presetName==null && other.getPresetName()==null) ||
             (this.presetName!=null &&
              this.presetName.equals(other.getPresetName()))) &&
            this.ID == other.getID() &&
            ((this.owningUser==null && other.getOwningUser()==null) ||
             (this.owningUser!=null &&
              this.owningUser.equals(other.getOwningUser()))) &&
            this.isUserAllowToUpdate == other.isIsUserAllowToUpdate() &&
            this.isUserAllowToDelete == other.isIsUserAllowToDelete();
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
        if (getPresetName() != null) {
            _hashCode += getPresetName().hashCode();
        }
        _hashCode += new Long(getID()).hashCode();
        if (getOwningUser() != null) {
            _hashCode += getOwningUser().hashCode();
        }
        _hashCode += (isIsUserAllowToUpdate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsUserAllowToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Preset.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Preset"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("presetName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PresetName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owningUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "owningUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isUserAllowToUpdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "isUserAllowToUpdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isUserAllowToDelete");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "isUserAllowToDelete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
