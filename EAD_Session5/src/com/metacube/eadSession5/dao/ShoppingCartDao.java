package com.metacube.eadSession5.dao;

import java.util.Map;

import com.metacube.eadSession5.enums.Response;
import com.metacube.eadSession5.facade.ProductFacade;
import com.metacube.eadSession5.model.ShoppingCart;

public class ShoppingCartDao {
	private static ShoppingCartDao shoppingCartDao;

	private ShoppingCartDao() {

	}

	public static ShoppingCartDao getShoppingCartDao() {
		if (shoppingCartDao == null) {
			shoppingCartDao = new ShoppingCartDao();
		}
		return shoppingCartDao;
	}

	public Response addProductInShoppingCart(ShoppingCart shoppingCart,
			int productId) {
		return addProductInShoppingCart(shoppingCart, productId, 1);
	}

	public Response addProductInShoppingCart(ShoppingCart shoppingCart,
			int productId, int quantity) {
		ProductFacade productFacade;
		if (shoppingCart == null) {
			return Response.SHOPPING_CART_NOT_FOUND;
		} else {
			if (quantity < 1) {
				return Response.INVALID_QUANTITY;
			} else {
				productFacade = ProductFacade.getProductFacade();
				if (productFacade.exists(productId)) {
					Map<Integer, Integer> productIdAndQuantityPairs = shoppingCart
							.getProductIdAndQuantityPairs();
					productIdAndQuantityPairs
							.put(productId,
									productIdAndQuantityPairs.get(productId)
											+ quantity);
					return Response.SUCCESS;
				} else {
					return Response.PRODUCT_NOT_FOUND;
				}
			}
		}
	}

	public Response updateProductQuantityInShoppingCart(
			ShoppingCart shoppingCart, int productId, int newQuantity) {
		if (shoppingCart == null) {
			return Response.SHOPPING_CART_NOT_FOUND;
		} else {
			if (newQuantity < 1) {
				return Response.INVALID_QUANTITY;
			} else {
				if (shoppingCart.getProductIdAndQuantityPairs().containsKey(
						productId)) {
					shoppingCart.getProductIdAndQuantityPairs().remove(productId);
				}
				return addProductInShoppingCart(shoppingCart, productId, newQuantity);
			}
		}
	}

	public Response deleteProductFromShoppingCart(ShoppingCart shoppingCart,
			int productId) {
		if (shoppingCart == null) {
			return Response.INVALID_SHOPPING_CART;
		} else {
			if (shoppingCart.getProductIdAndQuantityPairs().containsKey(productId)) {
				shoppingCart.getProductIdAndQuantityPairs().remove(productId);
				return Response.SUCCESS;
			} else {
				return Response.PRODUCT_NOT_FOUND;
			}
		}
	}
	
	public Response clearShoppingCart(ShoppingCart shoppingCart) {
		if (shoppingCart == null) {
			return Response.INVALID_SHOPPING_CART;
		} else {
			shoppingCart.getProductIdAndQuantityPairs().clear();
			return Response.SUCCESS;
		}
	}
}
