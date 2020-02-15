package com.metacube.eadSession5.facade;

import java.util.HashMap;
import java.util.Map;

import com.metacube.eadSession5.controller.StoreController;
import com.metacube.eadSession5.dao.ShoppingCartDao;
import com.metacube.eadSession5.enums.Response;
import com.metacube.eadSession5.model.Product;
import com.metacube.eadSession5.model.ShoppingCart;

public class ShoppingCartFacade {
	private static ShoppingCartFacade shoppingCartFacade;
	private ShoppingCartDao shoppingCartDao;

	private ShoppingCartFacade() {
		shoppingCartDao = ShoppingCartDao.getShoppingCartDao();
	}

	public static ShoppingCartFacade getShoppingCartFacade() {
		if (shoppingCartFacade == null) {
			shoppingCartFacade = new ShoppingCartFacade();
		}
		return shoppingCartFacade;
	}
	
	public Map<Product, Integer> getProductAndQuantityPairs(ShoppingCart shoppingCart) {
		StoreController storeController = StoreController.getStoreController();
		Map<Integer, Integer> productIdAndQuantityPairs = shoppingCart.getProductIdAndQuantityPairs();
		Map<Product, Integer> productAndQuantityPairs = new HashMap<Product, Integer>();
		for (Map.Entry<Integer, Integer> productIdAndQuantityPair: productIdAndQuantityPairs.entrySet()) {
			Product product = storeController.getProduct(productIdAndQuantityPair.getKey());
			int quantity = productIdAndQuantityPair.getValue();
			productAndQuantityPairs.put(product, quantity);
		}
		return productAndQuantityPairs;
	}

	public double calculateShoppingCartPrice(ShoppingCart shoppingCart) {
		StoreController storeController = StoreController.getStoreController();
		double totalPrice = 0;
		Map<Integer, Integer> productIdAndQuantityPairs = shoppingCart
				.getProductIdAndQuantityPairs();
		for (Map.Entry<Integer, Integer> productIdAndQuantity : productIdAndQuantityPairs
				.entrySet()) {
			int productId = productIdAndQuantity.getKey();
			Product product = storeController.getProduct(productId);
			double price = product.getPrice();
			int quantity = productIdAndQuantity.getValue();
			totalPrice += (price * quantity);
		}

		return totalPrice;
	}

	public Response addProductInShoppingCart(ShoppingCart shoppingCart,
			int productId) {
		return shoppingCartDao
				.addProductInShoppingCart(shoppingCart, productId, 1);
	}

	public Response addProductInShoppingCart(ShoppingCart shoppingCart,
			int productId, int quantity) {
		return shoppingCartDao.addProductInShoppingCart(shoppingCart,
				productId, quantity);
	}

	public Response updateProductQuantityInShoppingCart(
			ShoppingCart shoppingCart, int productId, int newQuantity) {
		return shoppingCartDao.updateProductQuantityInShoppingCart(
				shoppingCart, productId, newQuantity);
	}

	public Response deleteProductFromShoppingCart(ShoppingCart shoppingCart,
			int productId) {
		return shoppingCartDao.deleteProductFromShoppingCart(shoppingCart,
				productId);
	}

	public Response clearShoppinCart(ShoppingCart shoppingCart) {
		return shoppingCartDao.clearShoppingCart(shoppingCart);
	}
}
