/**
 * IFooWSImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.foows.ws;

public interface IFooWSImplService extends javax.xml.rpc.Service {
    public java.lang.String getIFooWSImplAddress();

    public com.foows.ws.IFooWSImpl getIFooWSImpl() throws javax.xml.rpc.ServiceException;

    public com.foows.ws.IFooWSImpl getIFooWSImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
