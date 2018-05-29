package com.publiclockerclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class OrderConfirm {
	private String apiKey, orderNumber, lockerID;

	private OrderConfirm(String apiKey, String orderNumber, String lockerID) {
		super();
		this.apiKey = apiKey;
		this.orderNumber = orderNumber;
		this.lockerID = lockerID;
	}

	public String post() {
		URL url = null;
		HttpURLConnection conn = null;
		String rs = null;
		DataOutputStream out = null;
		BufferedReader br = null;

		try {
			url = new URL("http://127.0.0.1:8080/PublicLockerServer/OrderConfirmServlet");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			conn = (HttpURLConnection) url.openConnection();
			try {
				conn.setRequestMethod("POST");
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);

			conn.connect();

			out = new DataOutputStream(conn.getOutputStream());
			Gson gson = new Gson();
			Map<String, String> map = new HashMap<String, String>();
			map.put("apiKey", apiKey);
			map.put("orderNumber", orderNumber);
			map.put("lockerID", lockerID);

			System.out.println(map);
			// json
			// format:{"apiKey":"apiKey1","orderNumber":"orderNumber1","packageType":0,"packageQty":2,"zipcode":[91001,91002]}

			out.writeBytes(gson.toJson(map));

			out.flush();

			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			rs = sb.toString();

		} catch (

		IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}

		}
		return rs;

	}
}
