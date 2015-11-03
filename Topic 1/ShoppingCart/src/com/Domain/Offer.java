package com.Domain;

import java.util.ArrayList;
import java.util.List;

public class Offer implements Item{
	
	private List<Item> items;
	private String name;
	private double price;
	
	public Offer(String name, double price){
		this.items = new ArrayList<Item>();
		this.name=name;
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(Item item) {
		this.items.add(item);
	}

	public void remove(Offer item) {
		this.items.remove(item);
	}

	public String toString(){
		return "Name Offer:"+this.name+" price:"+this.price+"\n";
	}
	
	public String getItemDetail(){
		StringBuilder text = new StringBuilder();
		text.append("Name Offer:"+this.name+" price:"+this.price+"\n");
		for (Item item : this.items) {
			text.append("Items: \n");
			text.append(item+"\n");
		}
		text.append("#########################");
		return text.toString();
	}
	

}
