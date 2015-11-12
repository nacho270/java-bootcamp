package com.Business;

public class Product implements Item {
	
	private double price;
	private String name;
	private String description;
	
	public Product(String name, double price){
		this.price = price;
		this.name = name;
		this.description = "";
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "Name Product: "+this.name+" Price: "+this.price;
	}

	public String getItemDetail() {
		return description;
	}

}
