package com.gmm.fooWebProject.util;

public class Constantes {
	
	public static final String TRUE = "true";
	
	/**
	 * Patrones de fechas
	 */
	public static final String YYYY_MM_DD_T_HH_MM_SS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	public static final String YY_M_MDD_H_HMMSS_Z = "yyMMddHHmmssZ";
	public static final String EEE_D_MMM_YYYY_HH_MM_SS_Z = "EEE, d MMM yyyy HH:mm:ss Z";
	public static final String YYYYY_MMMMM_DD_GGG_HH_MM_AAA = "yyyyy.MMMMM.dd GGG hh:mm aaa";
	public static final String K_MM_A_Z = "K:mm a, z";
	public static final String HH_O_CLOCK_A_ZZZZ = "hh 'o''clock' a, zzzz";
	public static final String H_MM_A = "h:mm a";
	public static final String EEE_MMM_D_YY = "EEE, MMM d, ''yy";
	public static final String YYYY_MM_DD_G_AT_HH_MM_SS_Z = "yyyy.MM.dd G 'at' HH:mm:ss z";
	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String HH_MM_SS = "HH:mm:ss";
	
	/**
 	 * Constantes manejo de strings.
 	 */
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
	public static final String  PUNTOS = ":";
	
	public static final String VPR_APLIC_ID="VPR";
	public static final String CINCO_CEROS="00000";
	public static final String DEST_STERLING="STERLING";
	public static final String MSGTYPE_VPR="INV04";
	public static final String CENTRO_PROV="PROV";
 	
 	/**
 	 * Fichero de properties
 	 */
 	public static final String PROPERTIES_NAME = "sendAdjustmentsSynchronizer";
	
	
	/////////////////////////////////7
	// CONFIGURACIÓN JAVAMAIL
	public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	public static final String MAIL_STORE_PROTOCOL= "mail.store.protocol";
	public static final String INBOX = "INBOX";

	// SMTP
	public static final String SMTP = "smtp";	
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";	
	public static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";	
	public static final String MAIL_SMTP_PORT = "mail.smtp.port";	
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";	
	public static final String MAIL_SMTP_USER = "mail.smtp.user";	
	public static final String MAIL_SMTP_MAIL_SENDER = "mail.smtp.mail.sender";
	public static final String MAIL_SMTP_FROM = "mail.smtp.from";
	
	//GMAIL SMTP
	public static final String SMTP_GMAIL_COM = "smtp.gmail.com";
	
	
	//IMAP
	public static final String IMAPS = "imaps";
	public static final String MAIL_IMAPS_PORT = "mail.imaps.port";
	public static final String MAIL_IMAPS_STARTTLS_ENABLE = "mail.imaps.starttls.enable";
	
	//GMAIL IMAP
	public static final String IMAP_GMAIL_COM = "imap.gmail.com";
	
	
	// POP3 
	public static final String POP3 = "pop3";
	public static final String POP3S = "pop3s";
	public static final String MAIL_POP3_STARTTLS_ENABLE = "mail.pop3.starttls.enable";
	public static final String MAIL_POP3_PORT = "mail.pop3.port";
	public static final String MAIL_POP3_HOST = "mail.pop3.host";
	
	// GMAIL POP3
	public static final String POP_GMAIL_COM = "pop.gmail.com";

	//
	///////////////////////////////////////
	
	
	//////////////////////////////////////////////
	// BASES DE DATOS
	/**
 	 * Constantes acceso DB2
 	 * 
 	 */
	public static final String PROP_DB2_URL = "db2.connection.url";
	public static final String PROP_DB2_USERNAME = "db2.connection.username";
	public static final String PROP_DB2_PWD = "db2.connection.password";
	public static final String PROP_DB2_DRIVER="COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver";
	
	public static final String FLD_XBATCACT="XBATCACT";
	public static final String CEMPRESA_ECI="001";
	
	/**
 	 * Constantes acceso Oracle
 	 * 
 	 */
	public static final String PROP_ORACLE_URL = "oracle.connection.url";
	public static final String PROP_ORACLE_USERNAME = "oracle.connection.username";
	public static final String PROP_ORACLE_PWD = "oracle.connection.password";
	public static final String PROP_ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";

	public static final String RUTA_LOGS = "/logs";

}
