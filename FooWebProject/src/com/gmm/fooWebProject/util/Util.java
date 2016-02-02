package com.gmm.fooWebProject.util;

public class Util {
	
	/**
	 * Metodo estatico que completa con blancos por la derecha el string recibido
	 * @param campo contiene la cadena a tratar
	 * @param longitud a completar con blancos
	 * @return String cadena con el resultado de la cadena recibida completada con blancos
	 */
	public static String completaConBlancosIzq(String campo, int longitud){
		
		String miCampo = campo;
		if(miCampo == null) miCampo = Constantes.EMPTY_STR;
		int i = miCampo.length();
		while(i < longitud){
			miCampo = Constantes.STR_SPACE + miCampo;
			 i = miCampo.length();
	       }
		 return miCampo;
	}
	
	/**
	 * Metodo estatico que completa con blancos por la derecha el string recibido
	 * @param campo contiene la cadena a tratar
	 * @param longitud a completar con blancos
	 * @return String cadena con el resultado de la cadena recibida completada con blancos
	 */
	public static String completaConBlancosDer(String campo, int longitud){
		
		String miCampo = campo;
		if(miCampo == null) miCampo = Constantes.EMPTY_STR;
		int i = miCampo.length();
		while(i < longitud){
			miCampo = miCampo+ Constantes.STR_SPACE;
			 i = miCampo.length();
	       }
		 return miCampo;
	}
	
	/**
	 * Metodo estatico que completa con ceros por la izquierda el string recibido
	 * @param campo contiene la cadena a tratar
	 * @param longitud a completar con ceros
	 * @return String cadena con el resultado de la cadena recibida completada con ceros
	 */
	public static String completaConCerosIzq(String campo, int longitud){
		
		String miCampo = campo;
		if(miCampo == null) miCampo = Constantes.EMPTY_STR;
		int i = miCampo.length();
		while(i < longitud){
			miCampo = Constantes.LITERAL_0 + miCampo;
			 i = miCampo.length();
	       }
		 return miCampo;
	}

}
