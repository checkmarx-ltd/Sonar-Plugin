/**
 * CxWSPerforceBrowsingMode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSPerforceBrowsingMode implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CxWSPerforceBrowsingMode(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _None = "None";
    public static final String _Depot = "Depot";
    public static final String _Workspace = "Workspace";
    public static final CxWSPerforceBrowsingMode None = new CxWSPerforceBrowsingMode(_None);
    public static final CxWSPerforceBrowsingMode Depot = new CxWSPerforceBrowsingMode(_Depot);
    public static final CxWSPerforceBrowsingMode Workspace = new CxWSPerforceBrowsingMode(_Workspace);
    public String getValue() { return _value_;}
    public static CxWSPerforceBrowsingMode fromValue(String value)
          throws IllegalArgumentException {
        CxWSPerforceBrowsingMode enumeration = (CxWSPerforceBrowsingMode)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static CxWSPerforceBrowsingMode fromString(String value)
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
        new org.apache.axis.description.TypeDesc(CxWSPerforceBrowsingMode.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSPerforceBrowsingMode"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
