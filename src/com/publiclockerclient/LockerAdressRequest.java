package com.publiclockerclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LockerAdressRequest {
	/**
	 * How to use this API interface: insert correct API key from Public Locker
	 * Administrator: String APIkey= "";
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */

	String requestLockerAddress(String apiKey, String orderNumber, int packageType, int packageQty, int[] zipcode) {
		String result = null;
		AddressRequest_VO addressRequest = new AddressRequest_VO(apiKey, orderNumber, packageType, packageQty, zipcode);

		// Map<String, Object> requestInfo = new HashMap<String,Object>();
		// requestInfo.put("apiKey", apiKey);
		// requestInfo.put("zipcode", zipcode);
		// requestInfo.put("packageLength", packageLength);
		// requestInfo.put("packageWidth", packageWidth);
		// requestInfo.put("packageHeight", packageHeight);

		result = post(addressRequest);
		// JsonObject jsonobj = new JsonObject();
		// jsonobj.

		return result;

	}

	private String post(AddressRequest_VO addressRequest) {
		URL url = null;
		HttpURLConnection conn = null;
		String rs = null;
		try {
			url = new URL("http://127.0.0.1:8080/PublicLockerServer");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			conn.connect();
			if (addressRequest != null) {
				DataOutputStream out = new DataOutputStream(conn.getOutputStream());
				Gson gson = new Gson();
				String sendInfo = gson.toJson(addressRequest);
				out.writeBytes(sendInfo);
				out.flush();

				InputStream in = conn.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				StringBuffer sb = new StringBuffer();
				String str = null;
				while ((str = br.readLine()) != null) {
					sb.append(str);
				}
				rs = sb.toString();
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
		return rs;

	}
}
