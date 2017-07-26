/**
 * Group.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class Group  implements java.io.Serializable {
    private String groupName;

    private String ID;

    private GroupType type;

    private String guid;

    private String fullPath;

    private String path;

    public Group() {
    }

    public Group(
           String groupName,
           String ID,
           GroupType type,
           String guid,
           String fullPath,
           String path) {
           this.groupName = groupName;
           this.ID = ID;
           this.type = type;
           this.guid = guid;
           this.fullPath = fullPath;
           this.path = path;
    }


    /**
     * Gets the groupName value for this Group.
     *
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this Group.
     *
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the ID value for this Group.
     *
     * @return ID
     */
    public String getID() {
        return ID;
    }


    /**
     * Sets the ID value for this Group.
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }


    /**
     * Gets the type value for this Group.
     *
     * @return type
     */
    public GroupType getType() {
        return type;
    }


    /**
     * Sets the type value for this Group.
     *
     * @param type
     */
    public void setType(GroupType type) {
        this.type = type;
    }


    /**
     * Gets the guid value for this Group.
     *
     * @return guid
     */
    public String getGuid() {
        return guid;
    }


    /**
     * Sets the guid value for this Group.
     *
     * @param guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }


    /**
     * Gets the fullPath value for this Group.
     *
     * @return fullPath
     */
    public String getFullPath() {
        return fullPath;
    }


    /**
     * Sets the fullPath value for this Group.
     *
     * @param fullPath
     */
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }


    /**
     * Gets the path value for this Group.
     *
     * @return path
     */
    public String getPath() {
        return path;
    }


    /**
     * Sets the path value for this Group.
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Group)) return false;
        Group other = (Group) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.groupName==null && other.getGroupName()==null) ||
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            ((this.ID==null && other.getID()==null) ||
             (this.ID!=null &&
              this.ID.equals(other.getID()))) &&
            ((this.type==null && other.getType()==null) ||
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.guid==null && other.getGuid()==null) ||
             (this.guid!=null &&
              this.guid.equals(other.getGuid()))) &&
            ((this.fullPath==null && other.getFullPath()==null) ||
             (this.fullPath!=null &&
              this.fullPath.equals(other.getFullPath()))) &&
            ((this.path==null && other.getPath()==null) ||
             (this.path!=null &&
              this.path.equals(other.getPath())));
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
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        if (getID() != null) {
            _hashCode += getID().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getGuid() != null) {
            _hashCode += getGuid().hashCode();
        }
        if (getFullPath() != null) {
            _hashCode += getFullPath().hashCode();
        }
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Group.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Group"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GroupType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Guid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "FullPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Path"));
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
