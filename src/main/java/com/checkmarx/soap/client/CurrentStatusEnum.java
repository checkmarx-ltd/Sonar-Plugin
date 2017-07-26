/**
 * CurrentStatusEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CurrentStatusEnum implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CurrentStatusEnum(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _Queued = "Queued";
    public static final String _Working = "Working";
    public static final String _Finished = "Finished";
    public static final String _Failed = "Failed";
    public static final String _Canceled = "Canceled";
    public static final String _Deleted = "Deleted";
    public static final String _Unknown = "Unknown";
    public static final String _Unzipping = "Unzipping";
    public static final String _WaitingToProcess = "WaitingToProcess";
    public static final CurrentStatusEnum Queued = new CurrentStatusEnum(_Queued);
    public static final CurrentStatusEnum Working = new CurrentStatusEnum(_Working);
    public static final CurrentStatusEnum Finished = new CurrentStatusEnum(_Finished);
    public static final CurrentStatusEnum Failed = new CurrentStatusEnum(_Failed);
    public static final CurrentStatusEnum Canceled = new CurrentStatusEnum(_Canceled);
    public static final CurrentStatusEnum Deleted = new CurrentStatusEnum(_Deleted);
    public static final CurrentStatusEnum Unknown = new CurrentStatusEnum(_Unknown);
    public static final CurrentStatusEnum Unzipping = new CurrentStatusEnum(_Unzipping);
    public static final CurrentStatusEnum WaitingToProcess = new CurrentStatusEnum(_WaitingToProcess);
    public String getValue() { return _value_;}
    public static CurrentStatusEnum fromValue(String value)
          throws IllegalArgumentException {
        CurrentStatusEnum enumeration = (CurrentStatusEnum)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static CurrentStatusEnum fromString(String value)
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
        new org.apache.axis.description.TypeDesc(CurrentStatusEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CurrentStatusEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
