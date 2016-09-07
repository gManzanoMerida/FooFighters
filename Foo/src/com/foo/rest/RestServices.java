package com.foo.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;


public class RestServices {
	
	public static VentaEnProcesoRS getOperacionVentaEnProceso(VentaEnProcesoRQ ventaEnProcesoRQ){
		
		VentaEnProcesoRS respuesta = null;
		Gson gson = new Gson();
		
		String request = gson.toJson(ventaEnProcesoRQ);
		
		StringBuffer jsonEntrada = new StringBuffer("");
		jsonEntrada.append(request);
				
		String urlServicio ="";
		URL url;
		try {
			url = new URL(urlServicio); 
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

			String timeOutServicioVeP = "10000";
			//Establecemos el TimeOut(en milisegundos) para la respuesta del servicio REST...
			conexion.setReadTimeout(Integer.parseInt(timeOutServicioVeP));
			conexion.setDoOutput(true);
			conexion.setRequestMethod("POST");
			conexion.setRequestProperty("Content-Type", "application/json");
			
			//Invocamos al servicio REST...
			OutputStream os = conexion.getOutputStream();
			os.write(jsonEntrada.toString().getBytes()); 
			os.flush();
			
			//Comprobamos el estado de la conexion, por si hay algun error...
			if (conexion.getResponseCode()!= HttpURLConnection.HTTP_OK && conexion.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conexion.getResponseCode());
			}
			
			//Obtenemos la respuesta del servicio REST...
			BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream())); 
			StringBuffer output = new StringBuffer();
			output.append(br.readLine());

			//Cerramos la conexion...
			conexion.disconnect();

			//Transformamos la respuesta del servicio REST, de formato JSON a un bean de JAVA, para poder procesarla...
			respuesta = gson.fromJson(output.toString(), VentaEnProcesoRS.class);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return respuesta;
		
	}

}
