package com.publiclockerclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LockerAddressRequest {
	int packageType = 0;
	AddressRequest_VO addressRequest;

	LockerAddressRequest(String apiKey, String orderNumber, int packageLength, int packageWidth, int packageHeight,
			int packageQty, int[] zipcode) {
		super();
		this.packageType = packageTypeSelector(packageLength, packageWidth, packageHeight);
		this.addressRequest = new AddressRequest_VO(apiKey, orderNumber, packageType, packageQty, zipcode);

	}

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
	public String post() {
		return send(addressRequest);
	}

	private int packageTypeSelector(int packageLength, int packageWidth, int packageHeight) {
		/**
		 * define 4 types cellbox, length=cell depth,width=cell width,height=cell
		 * height; cell type 1: 16"x8"x6" type2: 16"x 12"x 10" type3: 16" x 16" x14"
		 * 
		 */
		int packageType = 0;
		if (packageLength <= 16 && packageWidth <= 8 && packageHeight <= 6) {
			packageType = 1;
		} else if (packageLength <= 16 && packageWidth <= 12 && packageHeight <= 10) {
			packageType = 2;
		} else if (packageLength <= 16 && packageWidth <= 16 && packageHeight <= 14) {
			packageType = 3;
		}

		return 0;
	}

	private String send(AddressRequest_VO addressRequest) {
		URL url = null;
		HttpURLConnection conn = null;
		String rs = null;
		DataOutputStream out=null;
		BufferedReader br=null;

		try {
			url = new URL("http://127.0.0.1:8080/PublicLockerServer/LockerRequestServlet");
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
			if (addressRequest != null) {
				 out= new DataOutputStream(conn.getOutputStream());
				Gson gson = new Gson();
				String sendInfo = gson.toJson(addressRequest);
				System.out.println(sendInfo);
				// json
				// format:{"apiKey":"apiKey1","orderNumber":"orderNumber1","packageType":0,"packageQty":2,"zipcode":[91001,91002]}

				out.writeBytes(sendInfo);

				out.flush();

				 br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String str = null;
				while ((str = br.readLine()) != null) {
					sb.append(str);
				}
				rs = sb.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.disconnect();
			}
			 
				
			 
		}
		
		return rs;

	}
}