package com.metacube.eadSession5.view;

public class SelectStoreManagerOperationView implements View {
	
	public void view() {
		System.out.println();
		
		System.out.println("Store Manager Operations");
		
		System.out.println();
		
		System.out.println("1. View Product By Id");
		System.out.println("2. View Product By Type");
		System.out.println("3. View All Products");
		System.out.println("4. Add Product");
		System.out.println("5. Update Product Id");
		System.out.println("6. Update Product Type");
		System.out.println("7. Update Product Name");
		System.out.println("8. Update Product Price");
		System.out.println("9. Delete Product");
		System.out.println("10. Delete All Products");
		
		System.out.println();
		
		System.out.println("11. View User By Id");
		System.out.println("12. View All Users");
		System.out.println("13. Add User");
		System.out.println("14. Update User Id");
		System.out.println("15. Update User Name");
		System.out.println("16. Update User Email");
		System.out.println("17. Delete User");
		System.out.println("18. Delete All Users");
		System.out.println("19. Home");
		System.out.println("0. Exit");
		
		System.out.println();
		
		System.out.print("Select an operation: ");
	}
	
	public static void main(String[] args) {
		SelectStoreManagerOperationView view = new SelectStoreManagerOperationView();
		view.view();
	}
}
