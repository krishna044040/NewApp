package com.krs.realtimeproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsSender {

	public String sendSms(String uname,String phone,String pass) {
		try {
			// Construct data
			String apiKey = "apikey=" + "MMtbeFRgxv0-S8uqYXf81LcSIxyuCrUVLDaLJy7OrE";
			String message = "&message=" + "Hii "+uname+",Thank you for registering your password is: "+pass;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "91"+phone;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			System.out.println("status");
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println(stringBuffer.toString());
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
