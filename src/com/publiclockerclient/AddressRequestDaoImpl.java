package com.publiclockerclient;

public class AddressRequestDaoImpl implements AddressRequestDao {

	@Override
	public String LockerAddressRequest(String apiKey, String orderNumber, int packageLength, int packageWidth,
			int packageHeight, int packageQty, int[] zipcode) {
		int packageType = packageTypeSelector(packageLength, packageWidth, packageHeight);

		if (packageType != 0) {

		} else {
			return "errorMessage: Yourpackage is too large.";
		}

		return null;
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
		}
		if (packageLength <= 16 && packageWidth <= 12 && packageHeight <= 10) {
			packageType = 2;
		}
		if (packageLength <= 16 && packageWidth <= 16 && packageHeight <= 14) {
			packageType = 3;
		}

		return 0;
	}

}
