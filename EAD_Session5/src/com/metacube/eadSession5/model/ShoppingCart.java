package com.metacube.eadSession5.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private Map<Integer, Integer> productIdAndQuantityPairs;

	public ShoppingCart() {
		productIdAndQuantityPairs = new HashMap<Integer, Integer>();
	}

	public Map<Integer, Integer> getProductIdAndQuantityPairs() {
		return productIdAndQuantityPairs;
	}
}
