package com.foows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {
	
	public static ArrayList<String> getLineasFichero(String fichero) throws IOException{
		ArrayList<String> resultado = new ArrayList<>();
		try {
		      FileReader fr = new FileReader(fichero);
		      BufferedReader br = new BufferedReader(fr);
		 
		      String linea;
		      while((linea = br.readLine()) != null)
		        resultado.add(linea);
		 
		      fr.close();
		    }catch (FileNotFoundException e){
		    	System.out.println(e);
		    	
		    }
		
		return resultado;
	}
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<String> lineasFichero = Util.getLineasFichero("resources/TerryPratchetQuotes.txt");
		
		for (String s:lineasFichero){
			System.out.println(s);
		}
		
	}

}
