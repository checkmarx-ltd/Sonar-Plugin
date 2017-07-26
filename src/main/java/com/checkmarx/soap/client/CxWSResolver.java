/**
 * CxWSResolver.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public interface CxWSResolver extends javax.xml.rpc.Service {
    public String getCxWSResolverSoapAddress();

    public CxWSResolverSoap_PortType getCxWSResolverSoap() throws javax.xml.rpc.ServiceException;

    public CxWSResolverSoap_PortType getCxWSResolverSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public String getCxWSResolverSoap12Address();

    public CxWSResolverSoap_PortType getCxWSResolverSoap12() throws javax.xml.rpc.ServiceException;

    public CxWSResolverSoap_PortType getCxWSResolverSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
