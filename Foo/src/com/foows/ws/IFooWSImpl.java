package com.foows.ws;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class IFooWSImpl implements Remote {
	
	public String getHi(String name) throws RemoteException{
		return "Hi "+name+ " from Foo";
	}
	
	public String getBye(String name) throws RemoteException{
		return "Bye "+name+ " from Foo";
	}
}
