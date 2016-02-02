package com.gmm.fooWebProject.util;


public class ReceptorThread extends Thread {

	private static boolean blnFin;
	private static long lngLatencia;

	/**
	 * Constructor for ReceptorThread
	 */
	public ReceptorThread() { 
		blnFin = false;
//		lngLatencia = 1000 * 60 * 60; // --> una hora
		lngLatencia = 1000 * 2; // --> 2 segundos
	}

	/**
	 * Inicia el Thread Realiza la llamada al bucle principal infinito que
	 * mantiene al Thread consultando cada hora si la base de datos está conectada	 */
	@Override
	public void run() {
		try {
			iniciarLatencia( );
		} catch (Exception e) {
			System.out.println("SendAdjustmentsSynchronizer::ReceptorThread::run::"+e);
		}
	}

	/**
	 * Metodo principal del Thread para comprobar si la conexion a db oracle sigue abierta
	 */
	private void iniciarLatencia() {		 
		try {			 
			while (!blnFin) {
				sleep(lngLatencia);
				OracleConnection.connection = OracleConnection.getConnection();
			}
		} catch (InterruptedException e) {
			 System.out.println("SendAdjustmentsSynchronizer::ReceptorThread::iniciarLatencia::"+e);
			 
		}

	}

	 

	/**
	 * Detiene la ejecucion del Thread de integracion de pedidos, y elimina la
	 * instacia de la clase del atributo de la misma.
	 */
	public static void detieneThread() {
		blnFin = true;
//		instance = null;
	} 

	/**
	 * Gets the blnFin
	 * 
	 * @return Returns a boolean
	 */
	public static boolean getBlnFin() {
		return blnFin;
	} 

	
	public static void main(String[] args) { 
		ReceptorThread rt = new ReceptorThread(); 
		rt.run();
	}
	 
}
