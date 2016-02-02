package com.gmm.fooWebProject.util;

import java.sql.ResultSet;
import java.sql.SQLException;

 

public class ReceptorThread_1 extends Thread {

	private static boolean blnFin;
	private static long lngDormir;
	private static long lngLatencia;
	private static String strOnError;
	private static ReceptorThread_1 instance;

	/**
	 * Constructor for ReceptorThread
	 */
	private ReceptorThread_1() {
		blnFin = false;
		lngDormir = 0;
//		lngLatencia = Long.parseLong(AplicacionBean.getLatencia("Receptor"), 10);
		strOnError = "";
	}

	/**
	 * Inicia el Thread Realiza la llamada al bucle principal infinito que
	 * mantiene al Thread consultando cada ciertos segundos la comprobacion que
	 * provoca la ejecucion de la clase llamada
	 */
	public void run() {
		try {

			iniciarLatencia();

		} catch ( Exception a2nde) {
			 
			// finaliza la ejecucion del Thread
		}
	}

	/**
	 * Metodo principal del Thread para la funcionalidad de lectura de mensajes
	 * de la cola MQ. Mantiene un bucle infinito mientras existe la instancia de
	 * la clase, que cada x segundos consulta si existen mensajes que leer de
	 * MQ. Contiene la captura final de las excepciones que recoge la clase:
	 * <ul>
	 * <li>InterruptedException. Detiene la ejecucion del Thread
	 * <li>A2NDException. Continua la ejecucion del Thread
	 * <li>Exception. Continua la ejecucion del Thread
	 * </ul>
	 * Al estar la clase constantemente en ejecucion, solo graba incidencia en
	 * el fichero de log si es distinta de la anterior que se ha producido. El
	 * atributo strOnError mantiene el texto de la ultima incidencia.
	 */
	private void iniciarLatencia()   {

//		GestionIncidencias.getRootLogger().info(
//				"Se inicia la latencia del receptor de mensajes MQ");
//		long lgEspera = accesoOracle();
//		try {
//			sleep(lgEspera);
//			GestionIncidencias
//					.getRootLogger()
//					.info("Se inicia la latencia del receptor de mensajes MQ despues del lapso de tiempo impuesto");
//			while (!blnFin) {
//				try {
//					realizarComprobacion();
//				} catch (A2NDException a2nde) {
//					if (!strOnError.equals(a2nde.getDescripcion())) {
//						GestionIncidencias.getRootLogger().error(
//								NegocioGeneralClass.getAplicationTrace(a2nde));
//						NegocioGeneralClass
//								.procesaIncidencia(a2nde, "Receptor");
//					}
//					strOnError = a2nde.getDescripcion();
//					// continua la ejecucion del Thread
//				} catch (Exception e) {
//					A2NDException excep = new A2NDException();
//					excep.setCodigoError("00001");
//					excep.setPeticion("1");
//					excep.setLocalizador1("n0141.apl2nd");
//					excep.setLocalizador2("gestionMQ");
//					excep.setLocalizador3("ReceptorThread");
//					excep.setLocalizador4("iniciarLatencia");
//					excep.setLocalizador5("");
//					excep.setLocalizador6("");
//					excep.setDescripcion(e.toString());
//					if (!strOnError.equals(e.toString())) {
//						GestionIncidencias.getRootLogger().error(
//								NegocioGeneralClass.getAplicationTrace(e));
//						NegocioGeneralClass
//								.procesaIncidencia(excep, "Receptor");
//					}
//					strOnError = e.toString();
//					// continua la ejecucion del Thread
//				} finally {
//					try {
//						if (lngDormir > 0) {
//							sleep(lngDormir);
//							lngDormir = 0;
//						} else {
//							sleep(lngLatencia);
//						}
//					} catch (InterruptedException ie) {
//						GestionIncidencias.getRootLogger().error(
//								NegocioGeneralClass.getAplicationTrace(ie));
//						A2NDException excep = new A2NDException();
//						excep.setCodigoError("00001");
//						excep.setPeticion("1");
//						excep.setLocalizador1("n0141.apl2nd");
//						excep.setLocalizador2("gestionMQ");
//						excep.setLocalizador3("ReceptorThread");
//						excep.setLocalizador4("iniciarLatencia");
//						excep.setLocalizador5("");
//						excep.setLocalizador6("");
//						excep.setDescripcion(ie.getMessage());
//						throw excep;
//						// finaliza la ejecucion del Thread
//					}
//				}
//			}
//		} catch (InterruptedException ie) {
//			GestionIncidencias.getRootLogger().error(
//					NegocioGeneralClass.getAplicationTrace(ie));
//			A2NDException excep = new A2NDException();
//			excep.setCodigoError("00001");
//			excep.setPeticion("1");
//			excep.setLocalizador1("n0141.apl2nd");
//			excep.setLocalizador2("gestionMQ");
//			excep.setLocalizador3("ReceptorThread");
//			excep.setLocalizador4("iniciarLaten2");
//			excep.setLocalizador5("");
//			excep.setLocalizador6("");
//			excep.setDescripcion(ie.getMessage());
//			throw excep;
//			// finaliza la ejecucion del Thread
//		}

	}

	/**
	 * 
	 * Ejecuta el proceso de recuperacion de mensajes de la cola MQ y su
	 * tratamiento si existen
	 * 
	 */
	private void realizarComprobacion()   {
//		try {
//
//			ReceptorMQ.ejecutar();
//
//		} catch (A2NDException e) {
//			e.setLocalizador1("ReceptorThread");
//			throw e;
//		} catch (Exception e) {
//			A2NDException excep = new A2NDException();
//			excep.setCodigoError("00001");
//			excep.setPeticion("1");
//			excep.setLocalizador1("n0141.apl2nd");
//			excep.setLocalizador2("gestionMQ");
//			excep.setLocalizador3("ReceptorThread");
//			excep.setLocalizador4("realizaComprobacion");
//			excep.setLocalizador5("");
//			excep.setLocalizador6("");
//			excep.setDescripcion(e.toString());
//			throw excep;
//		}
	}

	/**
	 * Detiene la ejecucion del Thread de integracion de pedidos, y elimina la
	 * instacia de la clase del atributo de la misma.
	 */
	public static void detieneThread() {
		blnFin = true;
		instance = null;
	}

	/**
	 * Establece la latencia del Thread con el parametros pasado como argumento,
	 * para su siguiente vez. Luego se reestablece el parametro general.
	 * 
	 * @param elngDormir
	 *            The lngDormir to set
	 */
	public static void dormir(long elngDormir) {
		lngDormir = elngDormir;
	}

	/**
	 * Crea un objeto del tipo ReceptorThread como atributo de la clase si no
	 * existe y lo arranca, y si existe y esta parado, lo arranca.
	 */
	public static boolean  iniciaThread() {
		// Si no está creado
		if (instance == null) {
			instance = new ReceptorThread_1();
			instance.start();
		} else if (instance != null) {
			// Si no está arrancado
			if (!getEstado()) {
				instance.start();
			}
		}

		return getEstado();
	}

	/**
	 * Devuelve el estado del Thread contenido en la instacia de la clase
	 * instance. Devuelve true si esta vivo, y false si no.
	 * 
	 * @return boolean - estado del thread
	 */
	public static boolean getEstado() {
		if (instance != null) {
			return instance.isAlive();
		} else {
			return false;
		}
	}

	/**
	 * Gets the blnFin
	 * 
	 * @return Returns a boolean
	 */
	public static boolean getBlnFin() {
		return blnFin;
	}

	/**
	 * Gets the lngDormir
	 * 
	 * @return Returns a long
	 */
	public static long getLngDormir() {
		return lngDormir;
	}

	/**
	 * Método que accede a oracle para ver que está levantado se incluye debido
	 * a que está dando problemas el primear acceso a la base de datos cuando se
	 * arranca la aplicación.
	 */
	public long accesoOracle()   {
		long lgEspera = 300000;
//		String strEspera = "";
//		String strSQL = "";
//		Jade jade = null;
//		try {
//			strSQL = "SELECT CREGISTR FROM " + OracleInfo.getOwner()
//					+ "T8941700 WHERE CTIPREGS='THR'";
//			jade = new Jade(DataHelper.CFG_FILENAME);
//			jade.abrirConexion(OracleInfo.getDbURL(), OracleInfo.getUserid(),
//					OracleInfo.getPassword(), 0);
//
//			if (GestionIncidencias.getRootLogger().isDebugEnabled()) {
//				GestionIncidencias.getRootLogger().debug(
//						"accesoOracle::" + strSQL + "::");
//			}
//
//			ResultSet resultado = jade.procesarSelectSql(strSQL, 0);
//			if (resultado.next()) {
//				try {
//					strEspera = (resultado.getString(1)).trim();
//					lgEspera = (long) Integer.parseInt(strEspera);
//				} catch (Exception e) {
//					GestionIncidencias.getRootLogger().error(
//							"Error de parseo accesoOracle::" + strEspera + "::"
//									+ e.getMessage());
//				}
//			}
//			resultado.close();
//			return lgEspera;
//		} catch (SQLException e) {
//			GestionIncidencias.getRootLogger().error(
//					"Error en accesoOracle::" + e.getErrorCode() + " QUERY:"
//							+ strSQL);
//			A2NDException excep = new A2NDException();
//			excep.setCodigoError("00001");
//			excep.setPeticion("1");
//			excep.setLocalizador1("");
//			excep.setLocalizador2("envios.gestionMQ");
//			excep.setLocalizador3("ReceptorThread");
//			excep.setLocalizador4("accesoOracle");
//			excep.setLocalizador5("CodeError:" + e.getErrorCode());
//			excep.setLocalizador6("");
//			excep.setDescripcion(e.getMessage() + " QUERY:" + strSQL);
//			throw excep;
//		} catch (Exception e) {
//			GestionIncidencias.getRootLogger().error(
//					"Error en accesoOracle::" + e.getMessage());
//			A2NDException excep = new A2NDException();
//			excep.setCodigoError("00001");
//			excep.setPeticion("1");
//			excep.setLocalizador1("");
//			excep.setLocalizador2("envios.gestionMQ");
//			excep.setLocalizador3("ReceptorThread");
//			excep.setLocalizador4("accesoOracle");
//			excep.setLocalizador5("");
//			excep.setLocalizador6("ErrorGenerico");
//			excep.setDescripcion(e.getMessage());
//			throw excep;
//		} finally {
//			if (jade != null) {
//				jade.cerrarConexion(0);
//			}
//		}
		return lgEspera;
	}
	
}