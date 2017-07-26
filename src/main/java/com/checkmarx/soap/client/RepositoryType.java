/**
 * RepositoryType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class RepositoryType implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected RepositoryType(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _TFS = "TFS";
    public static final String _SVN = "SVN";
    public static final String _CVS = "CVS";
    public static final String _GIT = "GIT";
    public static final String _Perforce = "Perforce";
    public static final String _NONE = "NONE";
    public static final RepositoryType TFS = new RepositoryType(_TFS);
    public static final RepositoryType SVN = new RepositoryType(_SVN);
    public static final RepositoryType CVS = new RepositoryType(_CVS);
    public static final RepositoryType GIT = new RepositoryType(_GIT);
    public static final RepositoryType Perforce = new RepositoryType(_Perforce);
    public static final RepositoryType NONE = new RepositoryType(_NONE);
    public String getValue() { return _value_;}
    public static RepositoryType fromValue(String value)
          throws IllegalArgumentException {
        RepositoryType enumeration = (RepositoryType)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static RepositoryType fromString(String value)
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
        new org.apache.axis.description.TypeDesc(RepositoryType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RepositoryType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
