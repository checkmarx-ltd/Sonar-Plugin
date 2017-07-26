/**
 * CxWSCrudEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSCrudEnum implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CxWSCrudEnum(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _Create = "Create";
    public static final String _Delete = "Delete";
    public static final String _Update = "Update";
    public static final String _View = "View";
    public static final String _Run = "Run";
    public static final String _Investigate = "Investigate";
    public static final CxWSCrudEnum Create = new CxWSCrudEnum(_Create);
    public static final CxWSCrudEnum Delete = new CxWSCrudEnum(_Delete);
    public static final CxWSCrudEnum Update = new CxWSCrudEnum(_Update);
    public static final CxWSCrudEnum View = new CxWSCrudEnum(_View);
    public static final CxWSCrudEnum Run = new CxWSCrudEnum(_Run);
    public static final CxWSCrudEnum Investigate = new CxWSCrudEnum(_Investigate);
    public String getValue() { return _value_;}
    public static CxWSCrudEnum fromValue(String value)
          throws IllegalArgumentException {
        CxWSCrudEnum enumeration = (CxWSCrudEnum)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static CxWSCrudEnum fromString(String value)
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
        new org.apache.axis.description.TypeDesc(CxWSCrudEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSCrudEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
