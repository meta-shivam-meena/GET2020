package com.metacube.eadSession5.view;

public class SelectCustomerOperationView implements View {
	
	public void view(){
		System.out.println();
		
		System.out.println("Customer Operations");
		
		System.out.println("1. View Profile");
		System.out.println("2. Update Id");
		System.out.println("3. Update Name");
		System.out.println("4. Update Email");
		
		System.out.println();
		
		System.out.println("5. View Product By Id");
		System.out.println("6. View Product By Type");
		System.out.println("7. View All Products");
		
		System.out.println();
		
		System.out.println("8. Add Product In Shopping Cart");
		System.out.println("9. Add Product With Quantity In Shopping Cart");
		System.out.println("10. Update Product Quantity In Shopping Cart");
		System.out.println("11. Delete Product From Shopping Cart");
		System.out.println("12. Clear Shopping Cart");
		System.out.println("13. View Shopping Cart");
		System.out.println("0. Exit");
		
		System.out.println();
		
		System.out.print("Select Operation: ");
	}
	
	public static void main(String[] args) {
		SelectCustomerOperationView view = new SelectCustomerOperationView();
		view.view();
	}
}
