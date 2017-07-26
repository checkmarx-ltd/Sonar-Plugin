/**
 * ArrayOfCxWSQueryLanguageState.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfCxWSQueryLanguageState  implements java.io.Serializable {
    private CxWSQueryLanguageState[] cxWSQueryLanguageState;

    public ArrayOfCxWSQueryLanguageState() {
    }

    public ArrayOfCxWSQueryLanguageState(
           CxWSQueryLanguageState[] cxWSQueryLanguageState) {
           this.cxWSQueryLanguageState = cxWSQueryLanguageState;
    }


    /**
     * Gets the cxWSQueryLanguageState value for this ArrayOfCxWSQueryLanguageState.
     *
     * @return cxWSQueryLanguageState
     */
    public CxWSQueryLanguageState[] getCxWSQueryLanguageState() {
        return cxWSQueryLanguageState;
    }


    /**
     * Sets the cxWSQueryLanguageState value for this ArrayOfCxWSQueryLanguageState.
     *
     * @param cxWSQueryLanguageState
     */
    public void setCxWSQueryLanguageState(CxWSQueryLanguageState[] cxWSQueryLanguageState) {
        this.cxWSQueryLanguageState = cxWSQueryLanguageState;
    }

    public CxWSQueryLanguageState getCxWSQueryLanguageState(int i) {
        return this.cxWSQueryLanguageState[i];
    }

    public void setCxWSQueryLanguageState(int i, CxWSQueryLanguageState _value) {
        this.cxWSQueryLanguageState[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfCxWSQueryLanguageState)) return false;
        ArrayOfCxWSQueryLanguageState other = (ArrayOfCxWSQueryLanguageState) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.cxWSQueryLanguageState==null && other.getCxWSQueryLanguageState()==null) ||
             (this.cxWSQueryLanguageState!=null &&
              java.util.Arrays.equals(this.cxWSQueryLanguageState, other.getCxWSQueryLanguageState())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCxWSQueryLanguageState() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCxWSQueryLanguageState());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCxWSQueryLanguageState(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfCxWSQueryLanguageState.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSQueryLanguageState"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cxWSQueryLanguageState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSQueryLanguageState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSQueryLanguageState"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
