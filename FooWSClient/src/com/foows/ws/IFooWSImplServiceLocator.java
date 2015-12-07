/**
 * IFooWSImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.foows.ws;

public class IFooWSImplServiceLocator extends org.apache.axis.client.Service implements com.foows.ws.IFooWSImplService {

    public IFooWSImplServiceLocator() {
    }


    public IFooWSImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IFooWSImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IFooWSImpl
    private java.lang.String IFooWSImpl_address = "http://localhost:8080/FooWS/services/IFooWSImpl";

    public java.lang.String getIFooWSImplAddress() {
        return IFooWSImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IFooWSImplWSDDServiceName = "IFooWSImpl";

    public java.lang.String getIFooWSImplWSDDServiceName() {
        return IFooWSImplWSDDServiceName;
    }

    public void setIFooWSImplWSDDServiceName(java.lang.String name) {
        IFooWSImplWSDDServiceName = name;
    }

    public com.foows.ws.IFooWSImpl getIFooWSImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IFooWSImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIFooWSImpl(endpoint);
    }

    public com.foows.ws.IFooWSImpl getIFooWSImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.foows.ws.IFooWSImplSoapBindingStub _stub = new com.foows.ws.IFooWSImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getIFooWSImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIFooWSImplEndpointAddress(java.lang.String address) {
        IFooWSImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.foows.ws.IFooWSImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.foows.ws.IFooWSImplSoapBindingStub _stub = new com.foows.ws.IFooWSImplSoapBindingStub(new java.net.URL(IFooWSImpl_address), this);
                _stub.setPortName(getIFooWSImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
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
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IFooWSImpl".equals(inputPortName)) {
            return getIFooWSImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.foows.com", "IFooWSImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.foows.com", "IFooWSImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IFooWSImpl".equals(portName)) {
            setIFooWSImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
