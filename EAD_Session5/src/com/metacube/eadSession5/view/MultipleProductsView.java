package com.metacube.eadSession5.view;

import java.util.List;

import com.metacube.eadSession5.model.Product;

public class MultipleProductsView implements View {
	private List<Product> products;

	public MultipleProductsView(List<Product> products) {
		this.products = products;
	}

	public void view() {
		System.out.println();
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.println(String.format("%-20s %-30s %-30s", "Product Code",
				"Name", "Price"));
		
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (Product product : products) {
			System.out.println(String.format("%-20s %-30s %-30s",
					product.getId(), product.getName(),
					product.getPrice()));
		}
		
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
