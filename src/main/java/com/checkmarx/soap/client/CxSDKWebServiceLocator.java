/**
 * CxSDKWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxSDKWebServiceLocator extends org.apache.axis.client.Service implements CxSDKWebService {

    public CxSDKWebServiceLocator() {
    }


    public CxSDKWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CxSDKWebServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CxSDKWebServiceSoap12
    private String CxSDKWebServiceSoap12_address = "http://10.31.2.117/Cxwebinterface/sdk/CxSDKWebService.asmx";

    public String getCxSDKWebServiceSoap12Address() {
        return CxSDKWebServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String CxSDKWebServiceSoap12WSDDServiceName = "CxSDKWebServiceSoap12";

    public String getCxSDKWebServiceSoap12WSDDServiceName() {
        return CxSDKWebServiceSoap12WSDDServiceName;
    }

    public void setCxSDKWebServiceSoap12WSDDServiceName(String name) {
        CxSDKWebServiceSoap12WSDDServiceName = name;
    }

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CxSDKWebServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCxSDKWebServiceSoap12(endpoint);
    }

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CxSDKWebServiceSoap12Stub _stub = new CxSDKWebServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getCxSDKWebServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCxSDKWebServiceSoap12EndpointAddress(String address) {
        CxSDKWebServiceSoap12_address = address;
    }


    // Use to get a proxy class for CxSDKWebServiceSoap
    private String CxSDKWebServiceSoap_address = "http://10.31.2.117/Cxwebinterface/sdk/CxSDKWebService.asmx";

    public String getCxSDKWebServiceSoapAddress() {
        return CxSDKWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String CxSDKWebServiceSoapWSDDServiceName = "CxSDKWebServiceSoap";

    public String getCxSDKWebServiceSoapWSDDServiceName() {
        return CxSDKWebServiceSoapWSDDServiceName;
    }

    public void setCxSDKWebServiceSoapWSDDServiceName(String name) {
        CxSDKWebServiceSoapWSDDServiceName = name;
    }

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CxSDKWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCxSDKWebServiceSoap(endpoint);
    }

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CxSDKWebServiceSoap_BindingStub _stub = new CxSDKWebServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getCxSDKWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCxSDKWebServiceSoapEndpointAddress(String address) {
        CxSDKWebServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (CxSDKWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CxSDKWebServiceSoap12Stub _stub = new CxSDKWebServiceSoap12Stub(new java.net.URL(CxSDKWebServiceSoap12_address), this);
                _stub.setPortName(getCxSDKWebServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (CxSDKWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CxSDKWebServiceSoap_BindingStub _stub = new CxSDKWebServiceSoap_BindingStub(new java.net.URL(CxSDKWebServiceSoap_address), this);
                _stub.setPortName(getCxSDKWebServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("CxSDKWebServiceSoap12".equals(inputPortName)) {
            return getCxSDKWebServiceSoap12();
        }
        else if ("CxSDKWebServiceSoap".equals(inputPortName)) {
            return getCxSDKWebServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxSDKWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxSDKWebServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxSDKWebServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("CxSDKWebServiceSoap12".equals(portName)) {
            setCxSDKWebServiceSoap12EndpointAddress(address);
        }
        else
if ("CxSDKWebServiceSoap".equals(portName)) {
            setCxSDKWebServiceSoapEndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
