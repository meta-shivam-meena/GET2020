package com.metacube.eadSession5.facade;

import com.metacube.eadSession5.dao.ShoppingCartDao;
import com.metacube.eadSession5.enums.Response;
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

	public Response addProductInShoppingCart(ShoppingCart shoppingCart,
			int productId) {
		return shoppingCartDao
				.addProductInShoppingCart(shoppingCart, productId);
	}

	public Response addProductInShoppingCart(ShoppingCart shoppingCart,
			int productId, int quantity) {
		return shoppingCartDao.addProductInShoppingCart(shoppingCart, productId, quantity);
	}
	
	public Response updateProductQuantityInShoppingCart(ShoppingCart shoppingCart, int productId, int newQuantity) {
		return shoppingCartDao.updateProductQuantityInShoppingCart(shoppingCart, productId, newQuantity);
	}
	
	public Response deleteProductFromShoppingCart(ShoppingCart shoppingCart, int productId) {
		return shoppingCartDao.deleteProductFromShoppingCart(shoppingCart, productId);
	}
	
	public Response clearShoppinCart(ShoppingCart shoppingCart) {
		return shoppingCartDao.clearShoppingCart(shoppingCart);
	}
}
