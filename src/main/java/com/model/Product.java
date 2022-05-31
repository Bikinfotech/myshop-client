package com.model;

public class Product {
	
	private String name;
	private Category category;
	private double price; 
	private double discount;
	
	public Product() {
		
	}

	public Product(String name, Category category, double price, double discount) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + ", discount=" + discount + "]";
	}	
	
}
