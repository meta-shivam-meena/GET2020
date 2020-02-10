package com.metacube.eadSession5.client;

import com.metacube.eadSession5.controller.StoreController;

public class StoreClient {

	public static void main(String[] args) {
		StoreController storeController = StoreController.getStoreController();
		storeController.init();
	}
}