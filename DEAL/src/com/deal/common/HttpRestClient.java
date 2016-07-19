package com.deal.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import sun.net.www.http.HttpClient;

public class HttpRestClient extends Object {

	private final String tag = this.getClass().getSimpleName();

	public URI mUrl; // "http://181.75.100.28:8084/PDAServer/GPSData"
	public int mHttp_RC = 0;
	public String mHttp_ReasonPhrase = "";
	public HttpEntity mEntityResultado = null;

	public HttpRestClient(String url) {
		mUrl = URI.create(url);
	}

	public HttpRestClient(URI url) {
		mUrl = url;
	}

	public String postData(ArrayList<BasicNameValuePair> nameValuePairs, int msTimeOut) {
		
		String resultado = null;

		byte[] buffer = postDataBin(nameValuePairs,msTimeOut);

		if ( buffer != null) {
			try {
				resultado = new String(buffer, "ISO-8859-1");	// A cap�n !!
			} catch (UnsupportedEncodingException e) {
				mHttp_RC = -1;
				mHttp_ReasonPhrase =  e.getMessage();
				System.out.println(  "***" + tag + "postData(): " + e.getMessage());
			} 
		}
		return resultado;
	}

	public byte[] postDataBin(ArrayList<BasicNameValuePair> nameValuePairs, int msTimeOut) {

		System.out.println(  ">>> " + tag + " postDataBin(): " + nameValuePairs.toString());

		byte[] resultado = null;

		//////////////////////////////////////////////////////////////////
		// HttpClient httpclient = new DefaultHttpClient();	// Deprecated !!
		//////////////////////////////////////////////////////////////////
		// Para Versi�n Apache 4.3:
		RequestConfig.Builder requestBuilder = RequestConfig
				.custom()
				.setSocketTimeout(msTimeOut)
				.setConnectTimeout(msTimeOut)
				.setConnectionRequestTimeout(msTimeOut)
				;

		HttpClientBuilder builder = HttpClientBuilder.create();     
		builder.setDefaultRequestConfig( requestBuilder.build() );
		CloseableHttpClient httpclient = builder.build();		
		//////////////////////////////////////////////////////////////////
		
		HttpPost httppost = new HttpPost(mUrl);

		try {

			httppost.setEntity( new UrlEncodedFormEntity(nameValuePairs) );
			HttpResponse response = httpclient.execute( httppost );

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {;}

			mHttp_RC           = response.getStatusLine().getStatusCode();
			mHttp_ReasonPhrase = response.getStatusLine().getReasonPhrase();
			mEntityResultado   = response.getEntity();

			System.out.println(  "<<< " + tag + " Http RC: " + mHttp_RC + " " + mUrl);

			if (mEntityResultado != null) {

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				mEntityResultado.writeTo(baos);
				resultado = baos.toByteArray();

//				System.out.println( "\n" + new String(resultado, "ISO-8859-1") + "\n" );

			}

		} catch (ClientProtocolException e) {
			mHttp_RC = -1;
			mHttp_ReasonPhrase =  e.getMessage();
			System.out.println(  "*** " + tag + " postData(): " + e.getMessage());
		} catch (IOException e) {
			mHttp_RC = -1;
			mHttp_ReasonPhrase =  e.getMessage();
			System.out.println(  "*** " + tag + " postData(): " + e.getMessage());
		}
		return resultado;
	}
}
