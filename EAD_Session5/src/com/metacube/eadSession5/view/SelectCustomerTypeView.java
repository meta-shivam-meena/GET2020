package com.metacube.eadSession5.view;

public class SelectCustomerTypeView implements View {
	
	public void view() {
		System.out.println();
		System.out.println("1. New Customer");
		System.out.println("2. Existing Customer");
		System.out.println("3. Exit");
		System.out.print("Select customer type: ");
	}
}
