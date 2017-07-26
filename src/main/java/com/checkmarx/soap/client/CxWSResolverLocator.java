/**
 * CxWSResolverLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResolverLocator extends org.apache.axis.client.Service implements CxWSResolver {

    public CxWSResolverLocator() {
    }


    public CxWSResolverLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CxWSResolverLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CxWSResolverSoap
    private String CxWSResolverSoap_address = "http://10.31.2.117/Cxwebinterface/CxWSResolver.asmx";

    public String getCxWSResolverSoapAddress() {
        return CxWSResolverSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String CxWSResolverSoapWSDDServiceName = "CxWSResolverSoap";

    public String getCxWSResolverSoapWSDDServiceName() {
        return CxWSResolverSoapWSDDServiceName;
    }

    public void setCxWSResolverSoapWSDDServiceName(String name) {
        CxWSResolverSoapWSDDServiceName = name;
    }

    public CxWSResolverSoap_PortType getCxWSResolverSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CxWSResolverSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCxWSResolverSoap(endpoint);
    }

    public CxWSResolverSoap_PortType getCxWSResolverSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CxWSResolverSoap_BindingStub _stub = new CxWSResolverSoap_BindingStub(portAddress, this);
            _stub.setPortName(getCxWSResolverSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCxWSResolverSoapEndpointAddress(String address) {
        CxWSResolverSoap_address = address;
    }


    // Use to get a proxy class for CxWSResolverSoap12
    private String CxWSResolverSoap12_address = "http://10.31.2.117/Cxwebinterface/CxWSResolver.asmx";

    public String getCxWSResolverSoap12Address() {
        return CxWSResolverSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String CxWSResolverSoap12WSDDServiceName = "CxWSResolverSoap12";

    public String getCxWSResolverSoap12WSDDServiceName() {
        return CxWSResolverSoap12WSDDServiceName;
    }

    public void setCxWSResolverSoap12WSDDServiceName(String name) {
        CxWSResolverSoap12WSDDServiceName = name;
    }

    public CxWSResolverSoap_PortType getCxWSResolverSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CxWSResolverSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCxWSResolverSoap12(endpoint);
    }

    public CxWSResolverSoap_PortType getCxWSResolverSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CxWSResolverSoap12Stub _stub = new CxWSResolverSoap12Stub(portAddress, this);
            _stub.setPortName(getCxWSResolverSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCxWSResolverSoap12EndpointAddress(String address) {
        CxWSResolverSoap12_address = address;
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
            if (CxWSResolverSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CxWSResolverSoap_BindingStub _stub = new CxWSResolverSoap_BindingStub(new java.net.URL(CxWSResolverSoap_address), this);
                _stub.setPortName(getCxWSResolverSoapWSDDServiceName());
                return _stub;
            }
            if (CxWSResolverSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CxWSResolverSoap12Stub _stub = new CxWSResolverSoap12Stub(new java.net.URL(CxWSResolverSoap12_address), this);
                _stub.setPortName(getCxWSResolverSoap12WSDDServiceName());
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
        if ("CxWSResolverSoap".equals(inputPortName)) {
            return getCxWSResolverSoap();
        }
        else if ("CxWSResolverSoap12".equals(inputPortName)) {
            return getCxWSResolverSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Checkmarx.com", "CxWSResolver");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Checkmarx.com", "CxWSResolverSoap"));
            ports.add(new javax.xml.namespace.QName("http://Checkmarx.com", "CxWSResolverSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("CxWSResolverSoap".equals(portName)) {
            setCxWSResolverSoapEndpointAddress(address);
        }
        else
if ("CxWSResolverSoap12".equals(portName)) {
            setCxWSResolverSoap12EndpointAddress(address);
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
