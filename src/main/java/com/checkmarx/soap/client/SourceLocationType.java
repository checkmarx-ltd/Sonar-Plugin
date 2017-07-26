/**
 * SourceLocationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class SourceLocationType implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SourceLocationType(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _Local = "Local";
    public static final String _Shared = "Shared";
    public static final String _SourceControl = "SourceControl";
    public static final String _SourcePulling = "SourcePulling";
    public static final SourceLocationType Local = new SourceLocationType(_Local);
    public static final SourceLocationType Shared = new SourceLocationType(_Shared);
    public static final SourceLocationType SourceControl = new SourceLocationType(_SourceControl);
    public static final SourceLocationType SourcePulling = new SourceLocationType(_SourcePulling);
    public String getValue() { return _value_;}
    public static SourceLocationType fromValue(String value)
          throws IllegalArgumentException {
        SourceLocationType enumeration = (SourceLocationType)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static SourceLocationType fromString(String value)
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
        new org.apache.axis.description.TypeDesc(SourceLocationType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceLocationType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
