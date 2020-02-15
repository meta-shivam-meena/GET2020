package com.metacube.eadSession5.facade;

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
	
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}
	
	public List<Product> getProductByType(String type) {
		return productDao.getProductByType(type);
	}
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public Response addProduct(Product product) {
		return productDao.addProduct(product);
	}
	
	public Response updateProductId(int productId, int newProductId) {
		return productDao.updateproductId(productId, newProductId);
	}
	
	public Response updateProductType(int productId, String newType) {
		return productDao.updateProductType(productId, newType);
	}
	
	public Response updateProductName(int productId, String newName) {
		return productDao.updateProductName(productId, newName);
	}
	
	public Response updateProductPrice(int productId, double newPrice) {
		return productDao.updateProductPrice(productId, newPrice);
	}
	
	public Response deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}
	
	public Response deleteAllProducts() {
		return productDao.deleteAllProducts();
	}
	
	public boolean exists(int productId) {
		return productDao.exists(productId);
	}
}
