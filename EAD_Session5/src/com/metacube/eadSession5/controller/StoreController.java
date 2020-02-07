package com.metacube.eadSession5.controller;

import com.metacube.eadSession5.facade.*;
import com.metacube.eadSession5.model.*;
import com.metacube.eadSession5.view.*;
import com.metacube.eadSession5.enums.Response;

public class StoreController {
	private static StoreController storeController;
	private ProductFacade productFacade;
	private UserFacade userFacade;
	private ShoppingCartFacade shoppingCartFacade;

	private StoreController() {
		productFacade = ProductFacade.getProductFacade();
		userFacade = UserFacade.getUserFacade();
		shoppingCartFacade = ShoppingCartFacade.getShoppingCartFacade(); 
	}

	public static StoreController getStoreController() {
		if (storeController == null) {
			storeController = new StoreController();
		}
		return storeController;
	}
	
	public View viewUser(int userId) {
		return new UserView(userFacade.getUser(userId));
	}
	
	public View viewAllUsers() {
		return new MultipleUsersView(userFacade.getAllUsers());
	}
	
	public View addUser(int userId, String name, String email) {
		User user = new User(userId, name, email);
		return new ResponseView(userFacade.addUser(user));
	}
	
	
	
	public View viewProduct(int productId) {
		return new ProductView(productFacade.getProduct(productId));
	}
	
	public View viewAllProducts() {
		return new MultipleProductsView(productFacade.getAllProducts());
	}
	
	public View addProduct(int productId, String name, String type, double price) {
		Product product = new Product(productId, name, type, price);
		return new ResponseView(productFacade.addProduct(product));
	}
}
