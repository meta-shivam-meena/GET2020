package com.metacube.eadSession5.controller;

import java.util.Map;
import java.util.Scanner;

import com.metacube.eadSession5.enums.Response;
import com.metacube.eadSession5.facade.*;
import com.metacube.eadSession5.model.*;
import com.metacube.eadSession5.view.*;

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
	
	/* UserFacade Operations */
	
	public View viewUserById(int userId) {
		return new UserView(userFacade.getUser(userId));
	}
	
	public View viewAllUsers() {
		return new MultipleUsersView(userFacade.getAllUsers());
	}
	
	public View addUser(int userId, String name, String email) {
		User user = new User(userId, name, email);
		return new ResponseView(userFacade.addUser(user));
	}
	
	public View updateUserId(int userId, int newUserId) {
		return new ResponseView(userFacade.updateUserId(userId, newUserId));
	}
	
	public View updateUserName(int userId, String newName) {
		return new ResponseView(userFacade.updateUserName(userId, newName));
	}
	
	public View updateUserEmail(int userId, String newEmail) {
		return new ResponseView(userFacade.updateUserEmail(userId, newEmail));
	}
	
	public View deleteUser(int userId) {
		return new ResponseView(userFacade.deleteUser(userId));
	}
	
	public View deleteAllUsers() {
		return new ResponseView(userFacade.deleteAllUsers());
	}
	
	/* ProductFacade Operations */
	
	public View viewProduct(int productId) {
		return new ProductView(productFacade.getProduct(productId));
	}
	
	public View viewProductByType(String type) {
		return new MultipleProductsView(productFacade.getProductByType(type));
	}
	
	public View viewAllProducts() {
		return new MultipleProductsView(productFacade.getAllProducts());
	}
	
	public Product getProduct(int productId) {
		return productFacade.getProduct(productId);
	}
	
	public View addProduct(int productId, String type, String name, double price) {
		Product product = new Product(productId, type, name, price);
		return new ResponseView(productFacade.addProduct(product));
	}
	
	public View updateProductId(int productId, int newProductId) {
		return new ResponseView(productFacade.updateProductId(productId, newProductId));
	}
	
	public View updateProductType(int productId, String newType) {
		return new ResponseView(productFacade.updateProductType(productId, newType));
	}
	
	public View updateProductName(int productId, String newName) {
		return new ResponseView(productFacade.updateProductName(productId, newName));
	}
	
	public View updateProductPrice(int productId, double newPrice) {
		return new ResponseView(productFacade.updateProductPrice(productId, newPrice));
	}
	
	public View deleteProduct(int productId) {
		return new ResponseView(productFacade.deleteProduct(productId));
	}
	
	public View deleteAllProducts() {
		return new ResponseView(productFacade.deleteAllProducts());
	}
	
	/* ShoppingCartFacade Operations */
	
	public View viewShoppingCart(int userId) {
		User user = userFacade.getUser(userId);
		ShoppingCart shoppingCart = user.getShoppingCart();
		Map<Product, Integer> productAndQuantityPairs = shoppingCartFacade.getProductAndQuantityPairs(shoppingCart);
		double totalPrice = shoppingCartFacade.calculateShoppingCartPrice(shoppingCart);
		return new ShoppingCartView(productAndQuantityPairs, totalPrice);
	}
	
	public View addProductInShoppingCart(int userId, int productId) {
		User user = userFacade.getUser(userId);
		ShoppingCart shoppingCart = user.getShoppingCart();
		return new ResponseView(shoppingCartFacade.addProductInShoppingCart(shoppingCart, productId));
	}
	
	public View addProductWithQuantityInShoppingCart(int userId, int productId, int quantity) {
		User user = userFacade.getUser(userId);
		ShoppingCart shoppingCart = user.getShoppingCart();
		return new ResponseView(shoppingCartFacade.addProductInShoppingCart(shoppingCart, productId, quantity));
	}
	
	public View updateProductQuantityInShoppingCart(int userId, int productId, int newQuantity) {
		User user = userFacade.getUser(userId);
		ShoppingCart shoppingCart = user.getShoppingCart();
		return new ResponseView(shoppingCartFacade.updateProductQuantityInShoppingCart(shoppingCart, productId, newQuantity));
	}
	
	public View deleteProductFromShoppingCart(int userId, int productId) {
		User user = userFacade.getUser(userId);
		ShoppingCart shoppingCart = user.getShoppingCart();
		return new ResponseView(shoppingCartFacade.deleteProductFromShoppingCart(shoppingCart, productId));
	}
	
	public View clearShoppingCart(int userId) {
		User user = userFacade.getUser(userId);
		ShoppingCart shoppingCart = user.getShoppingCart();
		return new ResponseView(shoppingCartFacade.clearShoppinCart(shoppingCart));
	}
	
	// View methods
	
	public View enterProductId() {
		return new EnterProductIdView();
	}
	
	public View enterProductName() {
		return new EnterProductNameView();
	}
	
	public View enterProductPrice() {
		return new EnterProductPriceView();
	}
	
	public View enterProductType() {
		return new EnterProductTypeView();
	}
	
	public View enterUserEmail() {
		return new EnterUserEmailView();
	}
	
	public View enterUserId() {
		return new EnterUserIdView();
	}
	
	public View enterUserName() {
		return new EnterUserNameView();
	}
	
	public View selectCustomerOperation() {
		return new SelectCustomerOperationView();
	}
	
	public View selectCustomerType() {
		return new SelectCustomerTypeView();
	}
	
	public View selectStoreManagerOperation() {
		return new SelectStoreManagerOperationView();
	}
	
	public View selectUserType() {
		return new SelectUserTypeView();
	}
	
	public void init() {
		Scanner scanner = new Scanner(System.in);
		View deleteProductView = new DeleteProductView();
		View updateProductView = new UpdateProductView();
		View updateQuantityView = new UpdateQuantityView();
		View addProductView = new AddProductView();
		View enterQuantityView = new EnterQuantityView();
		View enterNewProductIdView = new EnterNewProductIdView();
		View enterNewProductNameView = new EnterNewProductNameView();
		View enterNewProductPriceView = new EnterNewProductPriceView();
		View enterNewProductTypeView = new EnterNewProductTypeView();
		View enterNewUserEmailView = new EnterNewUserEmailView();
		View enterNewUserIdView = new EnterNewUserIdView();
		View enterNewUserNameView = new EnterNewUserNameView();
		View enterProductIdView = new EnterProductIdView();
		View enterProductTypeView = new EnterProductTypeView();
		View enterProductNameView = new EnterProductNameView();
		View enterProductPriceView = new EnterProductPriceView();
		View enterUserEmailView = new EnterUserEmailView();
		View enterUserIdView = new EnterUserIdView();
		View enterUserNameView = new EnterUserNameView();
		View selectCustomerOperationView = new SelectCustomerOperationView();
		View selectCustomerTypeView = new SelectCustomerTypeView();
		View selectStoreManagerOperationView = new SelectStoreManagerOperationView();
		View selectUserTypeView = new SelectUserTypeView();
		home: while (true) {
			try {
				selectUserTypeView.view();
				int userType = scanner.nextInt();
				switch (userType) {
				case 1:
					int storeManagerOperation = 0;
					while (true) {
						selectStoreManagerOperationView.view();
						storeManagerOperation = scanner.nextInt();
						switch (storeManagerOperation) {
						case 1:
						{
							enterProductIdView.view();
							int productId = scanner.nextInt();
							viewProduct(productId).view();
						}
							break;
						case 2:
						{
							enterProductTypeView.view();
							String productType = scanner.next();
							viewProductByType(productType).view();
						}
							break;
						case 3:
						{
							viewAllProducts().view();
						}
							break;
						case 4:
						{
							enterProductIdView.view();
							int productId = scanner.nextInt();
							enterProductTypeView.view();
							String type = scanner.next();
							enterProductNameView.view();
							String name = scanner.next();
							enterProductPriceView.view();
							double price = scanner.nextDouble();
							addProduct(productId, type, name, price).view();
						}
							break;
						case 5:
						{
							enterProductIdView.view();
							int productId = scanner.nextInt();
							enterNewProductIdView.view();
							int newProductId = scanner.nextInt();
							updateProductId(productId, newProductId).view();
						}
							break;
						case 6:
						{
							enterProductIdView.view();
							int productId = scanner.nextInt();
							enterNewProductTypeView.view();
							String newType = scanner.next();
							updateProductType(productId, newType).view();
						}
							break;
						case 7:
						{
							enterProductIdView.view();
							int productId = scanner.nextInt();
							enterNewProductNameView.view();
							String newName = scanner.next();
							updateProductName(productId, newName).view();
						}
							break;
						case 8:
						{
							enterProductIdView.view();
							int productId = scanner.nextInt();
							enterNewProductPriceView.view();
							double newPrice = scanner.nextDouble();
							updateProductPrice(productId, newPrice).view();
						}
							break;
						case 9:
						{
							enterProductIdView.view();
							int productId = scanner.nextInt();
							deleteProduct(productId).view();
						}
							break;
						case 10:
						{
							deleteAllProducts().view();
						}
							break;
						case 11:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							viewUserById(userId).view();
						}
							break;
						case 12:
						{
							viewAllUsers().view();
						}
							break;
						case 13:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							enterUserNameView.view();
							String name = scanner.next();
							enterUserEmailView.view();
							String email = scanner.next();
							addUser(userId, name, email).view();;
						}
							break;
						case 14:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							enterNewUserIdView.view();
							int newUserId = scanner.nextInt();
							updateUserId(userId, newUserId).view();
						}
							break;
						case 15:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							enterNewUserNameView.view();
							String newName = scanner.next();
							updateUserName(userId, newName).view();
						}
							break;
						case 16:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							enterNewUserEmailView.view();
							String newEmail = scanner.next();
							updateUserEmail(userId, newEmail).view();
						}
							break;
						case 17:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							deleteUser(userId).view();
						}
							break;
						case 19:
						{
							deleteAllUsers().view();
						}
							break;
						case 0:
							continue home;
						default:
							new ResponseView(Response.INVALID_INPUT).view();
							break;
						}
					}
				case 2:
					customerTypeHome: while (true) {
						selectCustomerTypeView.view();
						int customerType = scanner.nextInt();
						switch(customerType) {
						case 1:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							enterUserNameView.view();
							String name = scanner.next();
							enterUserEmailView.view();
							String email = scanner.next();
							addUser(userId, name, email).view();
							continue customerTypeHome;
						}
						case 2:
						{
							enterUserIdView.view();
							int userId = scanner.nextInt();
							while (true) {
								selectCustomerOperationView.view();
								int customerOperation = scanner.nextInt();
								switch (customerOperation) {
								case 1:
								{
									viewUserById(userId).view();;
								}
									break;
								case 2:
								{
									enterNewUserIdView.view();
									int newUserId = scanner.nextInt();
									updateUserId(userId, newUserId).view();
								}
									break;
								case 3:
								{
									enterNewUserNameView.view();
									String newName = scanner.next();
									updateUserName(userId, newName).view();
								}
									break;
								case 4:
								{
									enterNewUserEmailView.view();
									String newEmail = scanner.next();
									updateUserEmail(userId, newEmail).view();
								}
									break;
								case 5:
								{
									enterProductIdView.view();
									int productId = scanner.nextInt();
									viewProduct(productId).view();
								}
									break;
								case 6:
								{
									enterProductTypeView.view();
									String type = scanner.next();
									viewProductByType(type).view();
								}
									break;
								case 7:
								{
									viewAllProducts().view();
								}
									break;
								case 8:
								{
									viewAllProducts().view();
									addProductView.view();
									int productId = scanner.nextInt();
									addProductInShoppingCart(userId, productId).view();
								}
									break;
								case 9:
								{
									viewAllProducts().view();
									addProductView.view();
									int productId = scanner.nextInt();
									enterQuantityView.view();
									int quantity = scanner.nextInt();
									addProductWithQuantityInShoppingCart(userId, productId, quantity).view();
								}
									break;
								case 10:
								{
									viewShoppingCart(userId);
									updateProductView.view();
									int productId = scanner.nextInt();
									updateQuantityView.view();
									int newQuantity = scanner.nextInt();
									updateProductQuantityInShoppingCart(userId, productId, newQuantity).view();
								}
									break;
								case 11:
								{
									viewShoppingCart(userId);
									deleteProductView.view();
									int productId = scanner.nextInt();
									deleteProductFromShoppingCart(userId, productId).view();
								}
									break;
								case 12:
								{
									clearShoppingCart(userId).view();
								}
									break;
								case 13:
								{
									viewShoppingCart(userId).view();
								}
								case 0:
									continue home;
								default:
									new ResponseView(Response.INVALID_INPUT).view();	
								}
							}
						}
						case 0:
							break home;
						default:
							new ResponseView(Response.INVALID_INPUT).view();
						}
					}
				case 0:
					break home;
				default:
					new ResponseView(Response.INVALID_INPUT).view();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				new ResponseView(Response.INVALID_OPTION).view();
				init();
			}
		}
		scanner.close();
	}
}
