/**
 * ScanEventType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanEventType implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ScanEventType(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _BeforeScanStarts = "BeforeScanStarts";
    public static final String _AfterScanSucceeds = "AfterScanSucceeds";
    public static final String _OnScanFailure = "OnScanFailure";
    public static final ScanEventType BeforeScanStarts = new ScanEventType(_BeforeScanStarts);
    public static final ScanEventType AfterScanSucceeds = new ScanEventType(_AfterScanSucceeds);
    public static final ScanEventType OnScanFailure = new ScanEventType(_OnScanFailure);
    public String getValue() { return _value_;}
    public static ScanEventType fromValue(String value)
          throws IllegalArgumentException {
        ScanEventType enumeration = (ScanEventType)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static ScanEventType fromString(String value)
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
        new org.apache.axis.description.TypeDesc(ScanEventType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanEventType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
