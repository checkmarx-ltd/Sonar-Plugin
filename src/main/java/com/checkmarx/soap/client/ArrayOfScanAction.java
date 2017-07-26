/**
 * ArrayOfScanAction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ArrayOfScanAction  implements java.io.Serializable {
    private ScanAction[] scanAction;

    public ArrayOfScanAction() {
    }

    public ArrayOfScanAction(
           ScanAction[] scanAction) {
           this.scanAction = scanAction;
    }


    /**
     * Gets the scanAction value for this ArrayOfScanAction.
     *
     * @return scanAction
     */
    public ScanAction[] getScanAction() {
        return scanAction;
    }


    /**
     * Sets the scanAction value for this ArrayOfScanAction.
     *
     * @param scanAction
     */
    public void setScanAction(ScanAction[] scanAction) {
        this.scanAction = scanAction;
    }

    public ScanAction getScanAction(int i) {
        return this.scanAction[i];
    }

    public void setScanAction(int i, ScanAction _value) {
        this.scanAction[i] = _value;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ArrayOfScanAction)) return false;
        ArrayOfScanAction other = (ArrayOfScanAction) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.scanAction==null && other.getScanAction()==null) ||
             (this.scanAction!=null &&
              java.util.Arrays.equals(this.scanAction, other.getScanAction())));
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
        if (getScanAction() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScanAction());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getScanAction(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfScanAction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanAction"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanAction"));
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
