package com.peregrinefalcon.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	private static final String DD_MM_YYYY = "dd/MM/yyyy";
	private static final String HH_MM_SS = "HH:mm:ss";

	public static String getFechaYHora(){
		
		String fecha = "";
		DateFormat formatoHora = new SimpleDateFormat(HH_MM_SS);
        DateFormat formatoFecha = new SimpleDateFormat(DD_MM_YYYY);
		Date currentDate = new Date();
		
		fecha = formatoFecha.format(currentDate) + " " + formatoHora.format(currentDate);
		return fecha;
		
	}
	
	 
 
 

}
