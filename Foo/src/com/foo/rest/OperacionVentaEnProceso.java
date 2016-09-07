package com.foo.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class OperacionVentaEnProceso extends Thread {
	
	/**
     * Servicio Rest VeP
     */

//    ## Servicio Rest VeP - DES
//    servicioRestVeP=http://serviciosvep.des.eci.geci/serviciosvep/rest/2_0/mediosPagoOper//
//    ## Servicio Rest VeP - PRE
//    #servicioRestVeP=http://serviciosvep.pre.eci.geci/serviciosvep/rest/2_0/mediosPagoOper
    public static final String URL_SERVICIO_REST_VEP = PropertiesReader.get("servicioRestVeP");
	
	private static final String LOGNAME = "es.eci.servicios.sksm0016.service.OperacionVentaEnProceso";

//	protected static Logging logging = null;

//	static {
//		logging = LoggingFactory.getLogging(Constantes.NOMBRE_PROPERTIES);
//	}

	private VentaEnProcesoRQ ventaEnProcesoRQ = null;
	private VentaEnProcesoRS ventaEnProcesoRS = null;
	private String error = null;
	
	public OperacionVentaEnProceso(VentaEnProcesoRQ ventaEnProcesoRQ) {
		this.ventaEnProcesoRQ = ventaEnProcesoRQ;
	}

	public void run() {

		this.ventaEnProcesoRS = getOperacionVentaEnProceso(this.ventaEnProcesoRQ);

	}

	private VentaEnProcesoRS getOperacionVentaEnProceso(VentaEnProcesoRQ ventaEnProcesoRQ) {

		VentaEnProcesoRS respuesta = null;
		Gson gson = new Gson();

		String request = gson.toJson(ventaEnProcesoRQ);

		StringBuffer jsonEntrada = new StringBuffer("");
		jsonEntrada.append(request);
		
//		if (logging.isTrazaEnabled(LOGNAME)){
//			logging.traza(LOGNAME, "getOperacionVentaEnProceso::JSON de Entrada:"+jsonEntrada.toString());
//		}

		// Creamos el JSON, a partir de los parÃ¡metros de entrada, para invocar
		// el servicio REST...
		// StringBuffer jsonEntrada = new StringBuffer("");
		// jsonEntrada.append(" {\"fecha\": \"20160215\", \"empresa\": \"005\", \"centro\": \"0373\", \"terminal\": \"0686\", \"transaccion\": \"0808\", \"hora\": \"103910\", \"tipoPeticion\": \"0\", \"cobroDiferido\": \"S\", \"moneda\": \"004\"}");

		// Creamos la conexiÃ³n al servicio REST...
		// La URL se define en serviciosgper.properties...
		String urlServicio = Constantes.URL_SERVICIO_REST_VEP;
		URL url;
		try {
			url = new URL(urlServicio);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

			// Establecemos el TimeOut(en milisegundos) para la respuesta del
			// servicio REST...
			conexion.setReadTimeout(Integer.parseInt(Constantes.TIME_OUT));

			conexion.setDoOutput(true);
			conexion.setRequestMethod(Constantes.POST);
			conexion.setRequestProperty(Constantes.CONTENT_TYPE, Constantes.APPLICATION_JSON);
			//

			// Invocamos al servicio REST...
			OutputStream os = conexion.getOutputStream();
			os.write(jsonEntrada.toString().getBytes());
			os.flush();

			// Comprobamos el estado de la conexión, por si hay alún error...
			if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK
					&& conexion.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				this.error=""+conexion.getResponseCode();
				throw new RuntimeException("Failed : HTTP error code : " + conexion.getResponseCode());
			}

			// Obtenemos la respuesta del servicio REST...
			BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			StringBuffer output = new StringBuffer();
			output.append(br.readLine());

			// Cerramos la conexion...
			conexion.disconnect();

			// Transformamos la respuesta del servicio REST, de formato JSON a
			// un bean de JAVA, para poder procesarla...
			respuesta = gson.fromJson(output.toString(), VentaEnProcesoRS.class);
//			if (logging.isTrazaEnabled(LOGNAME)){
//				logging.traza(LOGNAME, "getOperacionVentaEnProceso::JSON de salida:"+output.toString());
//			}
		} catch (MalformedURLException e) {
			this.error += e.toString();
			e.printStackTrace();
			System.out.println(e);
//			if (logging.isTrazaEnabled(LOGNAME)){
//				logging.traza(LOGNAME, "getOperacionVentaEnProceso:: MalformedURLException: "+e);
//			}
		} catch (IOException e) {
			this.error += e.toString();
			e.printStackTrace();
			System.out.println(e);
//			if (logging.isTrazaEnabled(LOGNAME)){
//				logging.traza(LOGNAME, "getOperacionVentaEnProceso:: IOException: "+e);
//			}
		} finally {
			synchronized (this) {
				this.notify();	
			}
			
		}

		return respuesta;
	}

	public VentaEnProcesoRQ getVentaEnProcesoRQ() {
		return ventaEnProcesoRQ;
	}
	
	public void setVentaEnProcesoRQ(VentaEnProcesoRQ ventaEnProcesoRQ) {
		this.ventaEnProcesoRQ = ventaEnProcesoRQ;
	}

	public VentaEnProcesoRS getVentaEnProcesoRS() {
		return ventaEnProcesoRS;
	}

	public void setVentaEnProcesoRS(VentaEnProcesoRS ventaEnProcesoRS) {
		this.ventaEnProcesoRS = ventaEnProcesoRS;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
//	public static void main(String[] args) {
//
//		System.out.println("Empieza TEST de JSON Operación Venta en Proceso");
//
//		VentaEnProcesoRQ request = new VentaEnProcesoRQ();
//		request.setFecha("20160215");
//		request.setEmpresa("005");
//		request.setCentro("0373");
//		request.setTerminal("0686");
//		request.setTransaccion("0808");
//		request.setHora("103910");
//		request.setTipoPeticion("0");
//		request.setCobroDiferido("S");
//		request.setMoneda("004");
//		
////		VentaEnProcesoRQ request1 = new VentaEnProcesoRQ();
////		request1.setFecha("20160215");
////		request1.setEmpresa("005");
////		request1.setCentro("0373");
////		request1.setTerminal("0686");
////		request1.setTransaccion("0808");
////		request1.setHora("103910");
////		request1.setTipoPeticion("0");
////		request1.setCobroDiferido("S");
////		request1.setMoneda("004");
//		
////		try {
//			OperacionVentaEnProceso proceso = new OperacionVentaEnProceso(request);
//			proceso.start();
//			proceso.run();
//			
////			OperacionVentaEnProceso proceso2 = new OperacionVentaEnProceso(request);
////			proceso2.start();
////			proceso2.run();
//	
//			VentaEnProcesoRS response = null;
////			VentaEnProcesoRS response2 = null;
//			boolean ok = false;
////			, ok1 = false,ok2 = false;
//			while (!ok) {
//				if (proceso.getVentaEnProcesoRS() != null) {
//					response = proceso.getVentaEnProcesoRS();
////					ok1 = true;
//					System.out.println(response.toString());
//				}
//				if (proceso.getError() != null) { 
////					ok1 = true;
//					System.out.println("Error:" + proceso.getError());
//				}
////				if (proceso2.getVentaEnProcesoRS() != null) {
////					Thread.sleep(1);
////					response2 = proceso2.getVentaEnProcesoRS();
////					ok2 = true;
////					System.out.println(response2.toString());
////				}
//				
////				if (ok1 && ok2) 
//					ok=true; 
//	
//			}
//		
////		 } catch (InterruptedException e) {
////					// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//
////		System.out.println(response.toString());
//
//	}

}
