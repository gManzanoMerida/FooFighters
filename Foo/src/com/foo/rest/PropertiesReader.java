package com.foo.rest;

import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class PropertiesReader {
	
	/**
	 * Fichero de configuración
	 */
	public static final String NOMBRE_PROPERTIES = "sksm0016";
	
	
	/**
	 * Datos del servicio web
	 */
	public static final String NAMESPACE_SERVICIO = "http://es.eci.servicios.sksm0016";
	public static final String NOMBRE_SERVICIO = "sksm0016ws";
	public static final String NOMBRE_EXCEPCION = "Sksm0016Exception";

	private static Properties properties = null;
	
	/**
	 * Rellena la instanciacion de properties local con los datos del archivo de properties
	 * @return void
	 */
	private static void getPropertiesFile() {
			
		PropertyResourceBundle objProperties = null;
		objProperties = (PropertyResourceBundle) PropertyResourceBundle.getBundle(Constantes.NOMBRE_PROPERTIES);			
		final Enumeration<String> e = objProperties.getKeys();
		String key = null;
		String value = null;
		properties = new Properties();
		boolean blnHayMas = e.hasMoreElements();
		while (blnHayMas) {				
			key = (String) e.nextElement();				
			value = objProperties.getString(key);
			properties.setProperty(key.toUpperCase(), value);
			blnHayMas = e.hasMoreElements();
		}		
	}
	
	/**
	 * Refresca la instanciacion del archivo de properties
	 * @return void
	 */
	public static synchronized void refresh() {
		properties = null;
	}
	
	/**
	 * Devuelve el valor de una propiedad pasada como parametro
	 * @param arg String Propiedad a leer del archivo de properties
	 * @return String Valor de la propiedad en el archivo de properties
	 */
	public static synchronized String get(String arg) {
		if ( properties == null ) {
			getPropertiesFile();
		}
		return pget(properties, arg.toUpperCase());
	}

	/**
	 * Devuelve el valor de una propiedad pasada como parametro en formato entero
	 * @param arg String Propiedad a leer del archivo de properties
	 * @return int Valor de la propiedad en el archivo de properties, en formato entero
	 */
	public static synchronized int getInt(String arg) {
		if ( properties == null ) {
			getPropertiesFile();
		}
		String str = pget(properties, arg.toUpperCase());
		return Integer.parseInt(Constantes.STR_VACIA.equals(str) ? Constantes.LITERAL_0 : str);
	}

	/**
	 * Devuelve el valor de una propiedad pasada como parametro en formato booleano
	 * @param arg String Propiedad a leer del archivo de properties
	 * @return boolean Valor de la propiedad en el archivo de properties, en formato booleano
	 */
	public static synchronized boolean getBoolean(String arg, String valueIfTrue) {
		if ( properties == null ) {
			getPropertiesFile();
		}
		return pget(properties, arg.toUpperCase()).equals(valueIfTrue);
	}
	
	/**
	 * Fija el valor de una propiedad pasada como parametro. Si no existe la crea
	 * @param key String Propiedad del archivo
	 * @param value String Valor de la propiedad
	 */
	public static void set(String key, String value) {
		if ( properties == null ) {
			getPropertiesFile();
		}
		String arg = key.toUpperCase();
		if (properties.containsKey(arg)) {
			properties.remove(arg);
			properties.put(arg, value);		
		} else {
			properties.put(arg, value);
		}
	}
	
	/**
	 * Devuelve el valor de una propiedad pasada como parametro
	 * @param p Properties
	 * @param arg String
	 * @return String
	 */
	private static String pget(Properties p, String arg) {
		final String prp = p.getProperty(arg);
		if (prp == null) {
			return Constantes.STR_VACIA;
		} else {
			return prp; 
		}
	}
	
	public static Properties leer_borrar() {
		getPropertiesFile();
		return properties;
	}
	
}
