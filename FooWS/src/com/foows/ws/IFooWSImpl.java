package com.foows.ws;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

import com.foows.CONSTANTES;
import com.foows.Util;

public class IFooWSImpl implements Remote {
	
	private static final String RESOURCES_TERRY_PRATCHET_QUOTES_TXT = "resources/TerryPratchetQuotes.txt";

	public String getHi(String name) throws RemoteException{
		return "Hi "+name+ " from Foo";
	}
	
	public String getBye(String name) throws RemoteException{
		return "Bye "+name+ " from Foo";
	}
	
	public String getTerryQuotes() throws Exception{
		String quote = "No comments...";
		
		ArrayList<String> lineasFichero = Util.getLineasFichero(RESOURCES_TERRY_PRATCHET_QUOTES_TXT);
		
		int MAX = lineasFichero.size();
		Random r = new Random();
		int azar = 0;
		if (MAX>0){
			
			azar = r.nextInt(MAX);  // Entre 0 y MAX
			
			quote = lineasFichero.get(azar);
		} else {
			String[] quotes = CONSTANTES.TERRY_PRATCHET_QUOTES.split(";");
			if (quotes!=null && quotes.length>0){
				azar = r.nextInt(quotes.length);  // Entre 0 y quotes.length
				quote = quotes[azar];
			}
		}
		
		return quote;
	}
}
