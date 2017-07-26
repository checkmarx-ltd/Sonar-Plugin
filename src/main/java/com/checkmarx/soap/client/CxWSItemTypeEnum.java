/**
 * CxWSItemTypeEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSItemTypeEnum implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CxWSItemTypeEnum(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _Project = "Project";
    public static final String _Task = "Task";
    public static final String _Scan = "Scan";
    public static final String _Preset = "Preset";
    public static final String _Configuration = "Configuration";
    public static final String _Users = "Users";
    public static final String _Roles = "Roles";
    public static final String _Other = "Other";
    public static final String _SystemSettings = "SystemSettings";
    public static final String _Ignore_Path = "Ignore_Path";
    public static final String _ResultComment = "ResultComment";
    public static final String _ResultSeverity = "ResultSeverity";
    public static final String _ResultStatus = "ResultStatus";
    public static final String _AuditUser = "AuditUser";
    public static final CxWSItemTypeEnum Project = new CxWSItemTypeEnum(_Project);
    public static final CxWSItemTypeEnum Task = new CxWSItemTypeEnum(_Task);
    public static final CxWSItemTypeEnum Scan = new CxWSItemTypeEnum(_Scan);
    public static final CxWSItemTypeEnum Preset = new CxWSItemTypeEnum(_Preset);
    public static final CxWSItemTypeEnum Configuration = new CxWSItemTypeEnum(_Configuration);
    public static final CxWSItemTypeEnum Users = new CxWSItemTypeEnum(_Users);
    public static final CxWSItemTypeEnum Roles = new CxWSItemTypeEnum(_Roles);
    public static final CxWSItemTypeEnum Other = new CxWSItemTypeEnum(_Other);
    public static final CxWSItemTypeEnum SystemSettings = new CxWSItemTypeEnum(_SystemSettings);
    public static final CxWSItemTypeEnum Ignore_Path = new CxWSItemTypeEnum(_Ignore_Path);
    public static final CxWSItemTypeEnum ResultComment = new CxWSItemTypeEnum(_ResultComment);
    public static final CxWSItemTypeEnum ResultSeverity = new CxWSItemTypeEnum(_ResultSeverity);
    public static final CxWSItemTypeEnum ResultStatus = new CxWSItemTypeEnum(_ResultStatus);
    public static final CxWSItemTypeEnum AuditUser = new CxWSItemTypeEnum(_AuditUser);
    public String getValue() { return _value_;}
    public static CxWSItemTypeEnum fromValue(String value)
          throws IllegalArgumentException {
        CxWSItemTypeEnum enumeration = (CxWSItemTypeEnum)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static CxWSItemTypeEnum fromString(String value)
          throws IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public String toString() { return _value_;}
    public Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSItemTypeEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSItemTypeEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
