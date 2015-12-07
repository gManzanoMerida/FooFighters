package com.foows.ws;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFooWS extends Remote {

	public String getHi(String name) throws RemoteException;
	public String getBye(String name) throws RemoteException;
	public String getTerryQuotes() throws RemoteException;
}
