package com.foows.ws;

public class IFooWSImplProxy implements com.foows.ws.IFooWSImpl {
  private String _endpoint = null;
  private com.foows.ws.IFooWSImpl iFooWSImpl = null;
  
  public IFooWSImplProxy() {
    _initIFooWSImplProxy();
  }
  
  public IFooWSImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initIFooWSImplProxy();
  }
  
  private void _initIFooWSImplProxy() {
    try {
      iFooWSImpl = (new com.foows.ws.IFooWSImplServiceLocator()).getIFooWSImpl();
      if (iFooWSImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iFooWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iFooWSImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iFooWSImpl != null)
      ((javax.xml.rpc.Stub)iFooWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.foows.ws.IFooWSImpl getIFooWSImpl() {
    if (iFooWSImpl == null)
      _initIFooWSImplProxy();
    return iFooWSImpl;
  }
  
  public java.lang.String getBye(java.lang.String name) throws java.rmi.RemoteException{
    if (iFooWSImpl == null)
      _initIFooWSImplProxy();
    return iFooWSImpl.getBye(name);
  }
  
  public java.lang.String getHi(java.lang.String name) throws java.rmi.RemoteException{
    if (iFooWSImpl == null)
      _initIFooWSImplProxy();
    return iFooWSImpl.getHi(name);
  }
  
  public java.lang.String getTerryQuotes() throws java.rmi.RemoteException{
    if (iFooWSImpl == null)
      _initIFooWSImplProxy();
    return iFooWSImpl.getTerryQuotes();
  }
  
  
}