package com.Business;

public class ItemTransaccion {

	private String name;
	private double price;
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
	
	public ItemTransaccion(String name, double price){
		this.name =  name;
		this.price= price;
	}
	
	public String toString(){
		return "NameItem: "+this.name+" price: "+this.price;
	}
}
