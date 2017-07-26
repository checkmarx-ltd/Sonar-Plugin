/**
 * CxWSResponseScanResults.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseScanResults  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private byte[] scanResults;

    private boolean containsAllResults;

    public CxWSResponseScanResults() {
    }

    public CxWSResponseScanResults(
           boolean isSuccesfull,
           String errorMessage,
           byte[] scanResults,
           boolean containsAllResults) {
        super(
            isSuccesfull,
            errorMessage);
        this.scanResults = scanResults;
        this.containsAllResults = containsAllResults;
    }


    /**
     * Gets the scanResults value for this CxWSResponseScanResults.
     *
     * @return scanResults
     */
    public byte[] getScanResults() {
        return scanResults;
    }


    /**
     * Sets the scanResults value for this CxWSResponseScanResults.
     *
     * @param scanResults
     */
    public void setScanResults(byte[] scanResults) {
        this.scanResults = scanResults;
    }


    /**
     * Gets the containsAllResults value for this CxWSResponseScanResults.
     *
     * @return containsAllResults
     */
    public boolean isContainsAllResults() {
        return containsAllResults;
    }


    /**
     * Sets the containsAllResults value for this CxWSResponseScanResults.
     *
     * @param containsAllResults
     */
    public void setContainsAllResults(boolean containsAllResults) {
        this.containsAllResults = containsAllResults;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseScanResults)) return false;
        CxWSResponseScanResults other = (CxWSResponseScanResults) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.scanResults==null && other.getScanResults()==null) ||
             (this.scanResults!=null &&
              java.util.Arrays.equals(this.scanResults, other.getScanResults()))) &&
            this.containsAllResults == other.isContainsAllResults();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getScanResults() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScanResults());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getScanResults(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isContainsAllResults() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseScanResults.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanResults"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("containsAllResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "containsAllResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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
