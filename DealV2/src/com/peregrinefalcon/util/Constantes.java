package com.peregrinefalcon.util;


public class Constantes {
	
	/**
 	 * Constantes, manejo de strings.
 	 */
 
	public static final String FILE = "file";
	public static final String HOST = "HOST";
 	public static final String EMPTY_STR="";
 	public static final String LITERAL_0 = "0";
 	public static final String LITERAL_1="1";
 	public static final String DELIMITER = "#";
 	public static final String STR_SPACE=" ";
	public static final String COMILLA = "'";
	public static final String ABRE_PARENTESIS = "(";
	public static final String COMA = ",";
	public static final String CIERRA_PARENTESIS = null;
	public static final String SET = "SET";
	public static final String PUNTOS = ":";
	
	public static final String VPR_APLIC_ID="VPR";
	public static final String CINCO_CEROS="00000";
	public static final String DEST_STERLING="STERLING";
	public static final String MSGTYPE_VPR="INV04";
	public static final String CENTRO_PROV="PROV";
	

	public static final String FULTSTME = "FULTSTME";
	public static final String OK = "OK";
	
	/**
	 * Formato Fechas
	 */
	public static final String YYYYMMDD = "yyyyMMdd";
 	public static final String YYYY_MM_DD_HH_MM_SS_SSSSSS = "yyyy-MM-dd HH.mm.ss.SSSSSS";

	
 	 
 	
 	/**
 	 * Fichero de properties
 	 */
 	public static final String PROPERTIES_NAME = "deal";
	public static final String RUTA_LOGS = PropertiesReader.get("ruta.logs");
	
	 
 	 
 	/**
 	 * Constantes acceso MySQL
 	 * 
 	 */
	public static final String PROP_MySQL_URL = "mySql.connection.url";
	public static final String PROP_MySQL_USERNAME = "mySql.connection.username";
	public static final String PROP_MySQL_PWD = "mySql.connection.password";
	public static final String PROP_MySQL_DRIVER="COM.ibm.mySqlos390.sqlj.jdbc.MySQLSQLJDriver";  //mal
	
	/**
 	 * Mensajes de error
 	 */
 	public static final String MQ_CONNECTION_FAILED = "Connection Error";
	public static final String MENSAJE_ERROR_CONEXION = "Error conexion MySQL";
	
	 
 	
}
