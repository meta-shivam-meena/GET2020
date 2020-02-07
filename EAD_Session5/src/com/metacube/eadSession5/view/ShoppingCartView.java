package com.metacube.eadSession5.view;

import java.util.Map;

import com.metacube.eadSession5.model.Product;

public class ShoppingCartView implements View {
	private Map<Product, Integer> productAndQuantityPairs;
	private double totalPrice;

	public ShoppingCartView(Map<Product, Integer> productAndQuantityPairs,
			double totalPrice) {
		this.productAndQuantityPairs = productAndQuantityPairs;
		this.totalPrice = totalPrice;
	}

	public void view() {
		System.out.println();
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println(String.format("%-20s -30s -20s", "Product Id",
				"Name", "Price"));
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (Map.Entry<Product, Integer> productAndQuantityPair : productAndQuantityPairs
				.entrySet()) {
			Product product = productAndQuantityPair.getKey();
			int id = product.getId();
			double price = product.getPrice();
			int quantity = productAndQuantityPair.getValue();
			System.out.println(String.format("%-20s %-30s %-20s", id, quantity,
					price));
		}
		System.out.println(String.format("%-20s %-20s", "Total Price",
				totalPrice));
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}