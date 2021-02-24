package com.hiddenleaf.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class GenericPostHTTP {

	public static String postData(String postURL, String requestdata, Properties configProp, StringBuffer queryParam ) {
		String	responseStr = "";

		HttpURLConnection conn = null;
		int responseCode = 500;
		try {

			URL obj = new URL(postURL);
			conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("User-Agent", "Interfaces");
			System.out.println(" Request Data "+requestdata);

			
			conn.setDoOutput(true);
			conn.setDoInput(true);


			BufferedOutputStream out = new BufferedOutputStream(conn.getOutputStream());
			out.write(requestdata.getBytes());
			out.flush();

			 responseCode = conn.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {

				String line;
				// File responseFile = new File(response.toString());
				InputStreamReader response = new InputStreamReader(conn.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(response);  
				while ((line = bufferedReader.readLine()) != null) {
					responseStr = responseStr + line;
				} 
			}
			else {
				String line;
				// File responseFile = new File(response.toString());
				InputStreamReader response = new InputStreamReader(conn.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(response);  
				while ((line = bufferedReader.readLine()) != null) {
					responseStr = responseStr + line;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseCode+":"+responseStr;
	}
	
	
	public static String putData(String postURL, String requestdata, Properties configProp, StringBuffer queryParam ) {
		String	responseStr = "";

		HttpURLConnection conn = null;
		int responseCode = 500;
		try {

			URL obj = new URL(postURL);
			conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestProperty("Content-Type", "application/json");

			conn.setRequestMethod("PUT");
			conn.setDoOutput(true);
			conn.setDoInput(true);


			BufferedOutputStream out = new BufferedOutputStream(conn.getOutputStream());
			out.write(requestdata.getBytes());
			out.flush();

			 responseCode = conn.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {

				String line;
				// File responseFile = new File(response.toString());
				InputStreamReader response = new InputStreamReader(conn.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(response);  
				while ((line = bufferedReader.readLine()) != null) {
					responseStr = responseStr + line;
				} 
			}
			else {
				String line;
				// File responseFile = new File(response.toString());
				InputStreamReader response = new InputStreamReader(conn.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(response);  
				while ((line = bufferedReader.readLine()) != null) {
					responseStr = responseStr + line;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseCode+":"+responseStr;
	}
	
	
	public static void main(String[] args) {
		
		GenericPostHTTP gpht = new GenericPostHTTP();
		System.out.println(gpht.postData("http://tulipgateway.iloads.in/token/authenticate", "{\"visibilityUrl\":\"http://tulipgateway.iloads.in/api/visibility/api/import/importOrder\",\"AuthUrl\":\"http://tulipgateway.iloads.in/token/authenticate\",\"password\":\"IN00002\",\"userName\":\"IN00002\"}", null, null));
	}

}

