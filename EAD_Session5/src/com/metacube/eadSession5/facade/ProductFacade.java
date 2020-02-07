package com.metacube.eadSession5.facade;

import java.util.Iterator;
import java.util.List;

import com.metacube.eadSession5.dao.ProductDao;
import com.metacube.eadSession5.enums.Response;
import com.metacube.eadSession5.model.Product;

public class ProductFacade {
	private static ProductFacade productFacade;
	private ProductDao productDao;
	
	private ProductFacade() {
		productDao = ProductDao.getProductDao();
	}
	
	public static ProductFacade getProductFacade() {
		if (productFacade == null) {
			productFacade = new ProductFacade();
		}
		return productFacade;
	}
	
	public Response addProduct(Product product) {
		return productDao.addProduct(product);
	}
	
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public Response deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}
	
	public boolean exists(int productId) {
		return productDao.exists(productId);
	}
	
	public Response updateProductId(int productId, int newProductId) {
		return productDao.updateproductId(productId, newProductId);
	}
	
	public Response updateProductName(int productId, String newName) {
		return productDao.updateProductName(productId, newName);
	}
	
	public Response updateProductType(int productId, String newType) {
		return productDao.updateProductType(productId, newType);
	}
	
	public Response updateProductPrice(int productId, double newPrice) {
		return productDao.updateProductPrice(productId, newPrice);
	}
	
	public List<Product> getProductByType(String type) {
		List<Product> products;
		if (type == null) {
			return null;
		}
		products = productDao.getAllProducts();
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (!product.getType().equals(type)) {
				iterator.remove();
			}
		}
		return products;
	}
}
