package com.metacube.eadSession5.view;

import com.metacube.eadSession5.model.Product;

public class ProductView implements View {
	private Product product;
	
	public ProductView(Product product) {
		this.product = product;
	}
	
	public void view() {
		System.out.println();
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println(String.format("%-20s %-30s", "Id:", product.getId()));
		System.out.println(String.format("%-20s %-30s", "Type:", product.getType()));
		System.out.println(String.format("%-20s %-30s", "Name:", product.getName()));
		System.out.println(String.format("%-20s %-30s", "Price:", product.getPrice()));
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}