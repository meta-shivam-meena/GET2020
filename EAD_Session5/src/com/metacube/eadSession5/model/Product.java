package com.metacube.eadSession5.model;

public class Product {
	private int id;
	private String type;
	private String name;
	private double price;
	
	public Product(int id, String type, String name, double price) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
