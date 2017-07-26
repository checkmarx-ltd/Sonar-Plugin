/**
 * ScanAction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ScanAction  implements java.io.Serializable {
    private ArrayOfString parameters;

    private ScanEventType trigger;

    private ScanActionType action;

    public ScanAction() {
    }

    public ScanAction(
           ArrayOfString parameters,
           ScanEventType trigger,
           ScanActionType action) {
           this.parameters = parameters;
           this.trigger = trigger;
           this.action = action;
    }


    /**
     * Gets the parameters value for this ScanAction.
     *
     * @return parameters
     */
    public ArrayOfString getParameters() {
        return parameters;
    }


    /**
     * Sets the parameters value for this ScanAction.
     *
     * @param parameters
     */
    public void setParameters(ArrayOfString parameters) {
        this.parameters = parameters;
    }


    /**
     * Gets the trigger value for this ScanAction.
     *
     * @return trigger
     */
    public ScanEventType getTrigger() {
        return trigger;
    }


    /**
     * Sets the trigger value for this ScanAction.
     *
     * @param trigger
     */
    public void setTrigger(ScanEventType trigger) {
        this.trigger = trigger;
    }


    /**
     * Gets the action value for this ScanAction.
     *
     * @return action
     */
    public ScanActionType getAction() {
        return action;
    }


    /**
     * Sets the action value for this ScanAction.
     *
     * @param action
     */
    public void setAction(ScanActionType action) {
        this.action = action;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ScanAction)) return false;
        ScanAction other = (ScanAction) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.parameters==null && other.getParameters()==null) ||
             (this.parameters!=null &&
              this.parameters.equals(other.getParameters()))) &&
            ((this.trigger==null && other.getTrigger()==null) ||
             (this.trigger!=null &&
              this.trigger.equals(other.getTrigger()))) &&
            ((this.action==null && other.getAction()==null) ||
             (this.action!=null &&
              this.action.equals(other.getAction())));
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
        if (getParameters() != null) {
            _hashCode += getParameters().hashCode();
        }
        if (getTrigger() != null) {
            _hashCode += getTrigger().hashCode();
        }
        if (getAction() != null) {
            _hashCode += getAction().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanAction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanAction"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Parameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trigger");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Trigger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanEventType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("action");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Action"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanActionType"));
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
