package com.foows.ws.client;

import com.foows.ws.IFooWSImpl;
import com.foows.ws.IFooWSImplServiceLocator;

public class FooWSClient {
	
	public static void main(String[] args) {

        try {

              IFooWSImplServiceLocator fooWSImplServiceLocator = new IFooWSImplServiceLocator ();

              IFooWSImpl iFooWSImpl = fooWSImplServiceLocator.getIFooWSImpl();

              System.out.println(iFooWSImpl.getTerryQuotes());

        } catch (Exception e) {

              e.printStackTrace();

        }

  }



}
