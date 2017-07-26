/**
 * CxClientType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxClientType implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CxClientType(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _None = "None";
    public static final String _WebPortal = "WebPortal";
    public static final String _CLI = "CLI";
    public static final String _Eclipse = "Eclipse";
    public static final String _VS = "VS";
    public static final String _InteliJ = "InteliJ";
    public static final String _Audit = "Audit";
    public static final String _SDK = "SDK";
    public static final String _Jenkins = "Jenkins";
    public static final String _TFSBuild = "TFSBuild";
    public static final String _Importer = "Importer";
    public static final String _Other = "Other";
    public static final String _Sonar = "Sonar";
    public static final CxClientType None = new CxClientType(_None);
    public static final CxClientType WebPortal = new CxClientType(_WebPortal);
    public static final CxClientType CLI = new CxClientType(_CLI);
    public static final CxClientType Eclipse = new CxClientType(_Eclipse);
    public static final CxClientType VS = new CxClientType(_VS);
    public static final CxClientType InteliJ = new CxClientType(_InteliJ);
    public static final CxClientType Audit = new CxClientType(_Audit);
    public static final CxClientType SDK = new CxClientType(_SDK);
    public static final CxClientType Jenkins = new CxClientType(_Jenkins);
    public static final CxClientType TFSBuild = new CxClientType(_TFSBuild);
    public static final CxClientType Importer = new CxClientType(_Importer);
    public static final CxClientType Other = new CxClientType(_Other);
    public static final CxClientType Sonar = new CxClientType(_Sonar);
    public String getValue() { return _value_;}
    public static CxClientType fromValue(String value)
          throws IllegalArgumentException {
        CxClientType enumeration = (CxClientType)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static CxClientType fromString(String value)
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
        new org.apache.axis.description.TypeDesc(CxClientType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxClientType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
