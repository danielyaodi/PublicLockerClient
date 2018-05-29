package com.publiclockerclient;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ClientDemo {

	public static void main(String[] args) {
		// apiKey, orderNumber, packageLength, packageWidth, packageHeight packageQty,
		// zipcode
		String apiKey = "apiKey1";
		String orderNumber = "orderNumber1";
		int packageLength = 5;
		int packageWidth = 5;
		int packageHeight = 5;
		int packageQty = 2;
		int[] zipCode = { 91001, 91002 };
		String lockerID = "lockerID-1";

		String res = new LockerAddressRequest(apiKey, orderNumber, packageLength, packageWidth, packageHeight,
				packageQty, zipCode).post();
		System.out.println(res);
		// Map<String,String> codeMap = new
		// OrderConfirm(apiKey,orderNumber,lockerID).post();

	}

}
