/**
 * CxSDKWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public interface CxSDKWebService extends javax.xml.rpc.Service {
    public String getCxSDKWebServiceSoap12Address();

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap12() throws javax.xml.rpc.ServiceException;

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public String getCxSDKWebServiceSoapAddress();

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap() throws javax.xml.rpc.ServiceException;

    public CxSDKWebServiceSoap_PortType getCxSDKWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
