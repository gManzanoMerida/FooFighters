package com.deal.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class ClienteHttp_buffered extends Object {

	private final String tag = this.getClass().getSimpleName();

	public URL mUrl = null;
	public int mHttp_RC = 0;
	public String mHttp_ReasonPhrase = "";

	public ClienteHttp_buffered(URL url) {
		mUrl = url;
	}

	public ClienteHttp_buffered(String url) {
		try { mUrl = new URL(url); } catch (MalformedURLException e) {;}
	}

	public boolean descargaFichero_buffered(ArrayList<BasicNameValuePair> nameValuePairs, String nomFicheroLocalCompleto) {

//		Log.i(TAG,"descargaFichero_buffered()");
		boolean resultado = false;

		FileOutputStream fos = null;
		byte[] postData = null;
		byte[] recBuffer = new byte[65536];

		try {
			postData = new UrlEncodedFormEntity(nameValuePairs).toString().getBytes();
		} catch (UnsupportedEncodingException e2) {;}

//		StringBuilder postDataBuilder = new StringBuilder(); 
//		try { postDataBuilder.append("M="); postDataBuilder.append(URLEncoder.encode("005", "UTF8")); } catch (UnsupportedEncodingException e1) {;}
//		postData = postDataBuilder.toString().getBytes();

		HttpURLConnection urlConnection = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			urlConnection = (HttpURLConnection) mUrl.openConnection();

			// El Method por defecto es "GET".

//			if ( postData != null && postData.length > 0 ) {
//				urlConnection.setDoOutput(true);		// Se supone que esto pone el method a "POST"...
//				urlConnection.setRequestMethod("POST");	// Por si acaso...
//				urlConnection.setRequestProperty( "Content-Length", Integer.toString(postData.length) );
//				urlConnection.setChunkedStreamingMode ( postData.length );
//				urlConnection.setUseCaches(false);			
//				out = new BufferedOutputStream(urlConnection.getOutputStream());
//				out.write( postData );
//			}

			// Respira un momentito...coge aire.
			try { Thread.sleep(100); } catch (InterruptedException e) {;}

			/////////////////////////////////////
			// Crear fichero de salida:
			File file = new File( nomFicheroLocalCompleto );
			file.delete();
			/////////////////////////////////////

			// Descargar y grabar poco a poco...
			in = new BufferedInputStream(urlConnection.getInputStream());
			fos = new FileOutputStream(file);

			file.createNewFile();
			int total = 0;
			int c = in.read(recBuffer);
			while ( c > 0 ) {
				fos.write( recBuffer,0,c );
				total += c;
//				Log.v(TAG,"<--- recibidos: " + c + " bytes. ACUM: " + total);
				c = in.read(recBuffer);
			}
//			Log.v(TAG,"<--- " + total + " TOTAL.");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if ( in  != null) { try {  in.close(); } catch (IOException e) {;} }
			if ( out != null) { try { out.close(); } catch (IOException e) {;} }
			if ( urlConnection != null ) { urlConnection.disconnect(); }
			if ( fos != null ) {
				try {
					fos.flush();
				} catch (IOException e) {;}
				try {
					fos.close();
					resultado = true;
				} catch (IOException e) {;}
			}
		}

		return resultado;
	}

}
