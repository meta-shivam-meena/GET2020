package com.metacube.eadSession5.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.metacube.eadSession5.enums.Response;
import com.metacube.eadSession5.model.Product;

public class ProductDao {
	private static ProductDao productDao;
	private Map<Integer, Product> productIdAndProductPairs;

	private ProductDao() {
		productIdAndProductPairs = new HashMap<Integer, Product>();
	}

	public static ProductDao getProductDao() {
		if (productDao == null) {
			productDao = new ProductDao();
		}
		return productDao;
	}

	public Product getProduct(int productId) {
		return productIdAndProductPairs.get(productId);
	}

	public List<Product> getProductByType(String type) {
		List<Product> products = new ArrayList<Product>(
				productIdAndProductPairs.values());
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (!product.getType().equals(type)) {
				iterator.remove();
			}
		}
		return products;
	}

	public List<Product> getAllProducts() {
		return new ArrayList<Product>(productIdAndProductPairs.values());
	}

	public Response addProduct(Product product) {
		if (product == null) {
			return Response.INVALID_USER;
		} else {
			if (productIdAndProductPairs.containsKey(product.getId())) {
				return Response.DUPLICATE_PRODUCT_ID;
			} else {
				productIdAndProductPairs.put(product.getId(), product);
				return Response.SUCCESS;
			}
		}
	}

	public Response updateproductId(int productId, int newProductId) {
		if (productIdAndProductPairs.containsKey(productId)) {
			if (productIdAndProductPairs.containsKey(newProductId)) {
				return Response.DUPLICATE_PRODUCT_ID;
			} else {
				Product product = productIdAndProductPairs.get(productId);
				productIdAndProductPairs.remove(productId);
				product.setId(newProductId);
				productIdAndProductPairs.put(newProductId, product);
				return Response.SUCCESS;
			}
		} else {
			return Response.PRODUCT_NOT_FOUND;
		}
	}

	public Response updateProductType(int productId, String newType) {
		if (productIdAndProductPairs.containsKey(productId)) {
			Product product = productIdAndProductPairs.get(productId);
			product.setType(newType);
			return Response.SUCCESS;
		} else {
			return Response.PRODUCT_NOT_FOUND;
		}
	}

	public Response updateProductName(int productId, String newName) {
		if (productIdAndProductPairs.containsKey(productId)) {
			Product product = productIdAndProductPairs.get(productId);
			product.setName(newName);
			return Response.SUCCESS;
		} else {
			return Response.PRODUCT_NOT_FOUND;
		}
	}

	public Response updateProductPrice(int productId, double newPrice) {
		if (productIdAndProductPairs.containsKey(productId)) {
			Product product = productIdAndProductPairs.get(productId);
			product.setPrice(newPrice);
			return Response.SUCCESS;
		} else {
			return Response.PRODUCT_NOT_FOUND;
		}
	}

	public Response deleteProduct(int productId) {
		if (productIdAndProductPairs.containsKey(productId)) {
			productIdAndProductPairs.remove(productId);
			return Response.SUCCESS;
		} else {
			return Response.PRODUCT_NOT_FOUND;
		}
	}

	public Response deleteAllProducts() {
		productIdAndProductPairs.clear();
		return Response.SUCCESS;
	}

	public boolean exists(int productId) {
		if (productIdAndProductPairs.containsKey(productId)) {
			return true;
		} else {
			return false;
		}
	}
}
