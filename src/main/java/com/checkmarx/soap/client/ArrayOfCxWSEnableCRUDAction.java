/**
 * ArrayOfCxWSEnableCRUDAction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfCxWSEnableCRUDAction  implements java.io.Serializable {
    private CxWSEnableCRUDAction[] cxWSEnableCRUDAction;

    public ArrayOfCxWSEnableCRUDAction() {
    }

    public ArrayOfCxWSEnableCRUDAction(
           CxWSEnableCRUDAction[] cxWSEnableCRUDAction) {
           this.cxWSEnableCRUDAction = cxWSEnableCRUDAction;
    }


    /**
     * Gets the cxWSEnableCRUDAction value for this ArrayOfCxWSEnableCRUDAction.
     *
     * @return cxWSEnableCRUDAction
     */
    public CxWSEnableCRUDAction[] getCxWSEnableCRUDAction() {
        return cxWSEnableCRUDAction;
    }


    /**
     * Sets the cxWSEnableCRUDAction value for this ArrayOfCxWSEnableCRUDAction.
     *
     * @param cxWSEnableCRUDAction
     */
    public void setCxWSEnableCRUDAction(CxWSEnableCRUDAction[] cxWSEnableCRUDAction) {
        this.cxWSEnableCRUDAction = cxWSEnableCRUDAction;
    }

    public CxWSEnableCRUDAction getCxWSEnableCRUDAction(int i) {
        return this.cxWSEnableCRUDAction[i];
    }

    public void setCxWSEnableCRUDAction(int i, CxWSEnableCRUDAction _value) {
        this.cxWSEnableCRUDAction[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfCxWSEnableCRUDAction)) return false;
        ArrayOfCxWSEnableCRUDAction other = (ArrayOfCxWSEnableCRUDAction) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.cxWSEnableCRUDAction==null && other.getCxWSEnableCRUDAction()==null) ||
             (this.cxWSEnableCRUDAction!=null &&
              java.util.Arrays.equals(this.cxWSEnableCRUDAction, other.getCxWSEnableCRUDAction())));
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
        if (getCxWSEnableCRUDAction() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCxWSEnableCRUDAction());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCxWSEnableCRUDAction(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfCxWSEnableCRUDAction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSEnableCRUDAction"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cxWSEnableCRUDAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSEnableCRUDAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSEnableCRUDAction"));
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
