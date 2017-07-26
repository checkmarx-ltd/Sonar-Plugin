/**
 * ProjectOrigin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ProjectOrigin implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ProjectOrigin(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _LocalPath = "LocalPath";
    public static final String _SharedPath = "SharedPath";
    public static final String _TFS = "TFS";
    public static final String _External = "External";
    public static final String _SVN = "SVN";
    public static final String _CVS = "CVS";
    public static final String _GIT = "GIT";
    public static final String _Perforce = "Perforce";
    public static final ProjectOrigin LocalPath = new ProjectOrigin(_LocalPath);
    public static final ProjectOrigin SharedPath = new ProjectOrigin(_SharedPath);
    public static final ProjectOrigin TFS = new ProjectOrigin(_TFS);
    public static final ProjectOrigin External = new ProjectOrigin(_External);
    public static final ProjectOrigin SVN = new ProjectOrigin(_SVN);
    public static final ProjectOrigin CVS = new ProjectOrigin(_CVS);
    public static final ProjectOrigin GIT = new ProjectOrigin(_GIT);
    public static final ProjectOrigin Perforce = new ProjectOrigin(_Perforce);
    public String getValue() { return _value_;}
    public static ProjectOrigin fromValue(String value)
          throws IllegalArgumentException {
        ProjectOrigin enumeration = (ProjectOrigin)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static ProjectOrigin fromString(String value)
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
        new org.apache.axis.description.TypeDesc(ProjectOrigin.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectOrigin"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
