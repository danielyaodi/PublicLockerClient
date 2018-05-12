package com.publiclockerclient;

interface AddressRequestDao {
	String LockerAddressRequest(String apiKey, String orderNumber, int packageLength, int packageWidth,
			int packageHeight, int packageQty, int[] zipcode);
}
