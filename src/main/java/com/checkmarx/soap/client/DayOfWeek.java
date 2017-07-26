/**
 * DayOfWeek.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class DayOfWeek implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected DayOfWeek(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _Sunday = "Sunday";
    public static final String _Monday = "Monday";
    public static final String _Tuesday = "Tuesday";
    public static final String _Wednesday = "Wednesday";
    public static final String _Thursday = "Thursday";
    public static final String _Friday = "Friday";
    public static final String _Saturday = "Saturday";
    public static final DayOfWeek Sunday = new DayOfWeek(_Sunday);
    public static final DayOfWeek Monday = new DayOfWeek(_Monday);
    public static final DayOfWeek Tuesday = new DayOfWeek(_Tuesday);
    public static final DayOfWeek Wednesday = new DayOfWeek(_Wednesday);
    public static final DayOfWeek Thursday = new DayOfWeek(_Thursday);
    public static final DayOfWeek Friday = new DayOfWeek(_Friday);
    public static final DayOfWeek Saturday = new DayOfWeek(_Saturday);
    public String getValue() { return _value_;}
    public static DayOfWeek fromValue(String value)
          throws IllegalArgumentException {
        DayOfWeek enumeration = (DayOfWeek)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static DayOfWeek fromString(String value)
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
        new org.apache.axis.description.TypeDesc(DayOfWeek.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DayOfWeek"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
