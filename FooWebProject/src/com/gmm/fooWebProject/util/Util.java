package com.gmm.fooWebProject.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	
	private static final String YYYY_MM_DD_T_HH_MM_SS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	private static final String YY_M_MDD_H_HMMSS_Z = "yyMMddHHmmssZ";
	private static final String EEE_D_MMM_YYYY_HH_MM_SS_Z = "EEE, d MMM yyyy HH:mm:ss Z";
	private static final String YYYYY_MMMMM_DD_GGG_HH_MM_AAA = "yyyyy.MMMMM.dd GGG hh:mm aaa";
	private static final String K_MM_A_Z = "K:mm a, z";
	private static final String HH_O_CLOCK_A_ZZZZ = "hh 'o''clock' a, zzzz";
	private static final String H_MM_A = "h:mm a";
	private static final String EEE_MMM_D_YY = "EEE, MMM d, ''yy";
	private static final String YYYY_MM_DD_G_AT_HH_MM_SS_Z = "yyyy.MM.dd G 'at' HH:mm:ss z";
	private static final String DD_MM_YYYY = "dd/MM/yyyy";
	private static final String HH_MM_SS = "HH:mm:ss";
	
	/**
	 * 	
	 "yyyy.MM.dd G 'at' HH:mm:ss z"	2001.07.04 AD at 12:08:56 PDT
		"EEE, MMM d, ''yy"	Wed, Jul 4, '01
		"h:mm a"	12:08 PM
		"hh 'o''clock' a, zzzz"	12 o'clock PM, Pacific Daylight Time
		"K:mm a, z"	0:08 PM, PDT
		"yyyyy.MMMMM.dd GGG hh:mm aaa"	02001.July.04 AD 12:08 PM
		"EEE, d MMM yyyy HH:mm:ss Z"	Wed, 4 Jul 2001 12:08:56 -0700
		"yyMMddHHmmssZ"	010704120856-0700
		"yyyy-MM-dd'T'HH:mm:ss.SSSZ"	2001-07-04T12:08:56.235-0700
	 */
	
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
	
public static String getFechaYHora(){
		
		String fecha = "";
		DateFormat formatoHora = new SimpleDateFormat(HH_MM_SS);
        DateFormat formatoFecha = new SimpleDateFormat(DD_MM_YYYY);
		Date currentDate = new Date();
		
		fecha = formatoHora.format(currentDate)+" "+formatoFecha.format(currentDate);
		return fecha;
		
	}
	
	
	
public static void main(String[] args) {
        
        //Fecha actual en formato completo:
        //Tue Sep 23 01:18:48 CEST 2014
        Date fechaActual = new Date();
        System.out.println(fechaActual);
        System.out.println("---------------------------------------------");
        
        //Formateando la fecha:
        DateFormat formatoHora = new SimpleDateFormat(HH_MM_SS);
        DateFormat formatoFecha = new SimpleDateFormat(DD_MM_YYYY);
        System.out.println("Son las: "+formatoHora.format(fechaActual)+" de fecha: "+formatoFecha.format(fechaActual));
        
        //Fecha actual desglosada:
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
 
        System.out.println("Fecha Actual: "+ dia + "/" + (mes) + "/" + año);
        System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo);
        System.out.println("-------------Fecha desglosada----------------");
        System.out.println("El año es: "+ año);
        System.out.println("El mes es: "+ mes);
        System.out.println("El día es: "+ dia);
        System.out.printf("La hora es: %02d %n", hora);
        System.out.printf("El minuto es: %02d %n", minuto);
        System.out.printf("El segundo es: %02d %n", segundo);
        
    }

}
