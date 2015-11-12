package com.Business;

import java.util.List;


public class Paypal  implements PayMode {
	
	private String name = "Paypal";
	private String email;
	private String pass;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String  toString(){
		return "I�m Paypal";
	}

	public double discount(List<Item> items, double totalPrice) {
		return cheapesItem(items).getPrice();
	}
	
	public Item cheapesItem(List<Item> items){
		Item cheapstItem = null;
		double min = 999999999;
		for (Item item : items) {
			if(item.getPrice() <= min){
				cheapstItem = item;
				min=item.getPrice();
			}
		}
		return cheapstItem;
	}

	public ItemTransaccion SpecialItem(List<Item> items) {
		Item originalItem = this.cheapesItem(items);
		return new ItemTransaccion(originalItem.getName(),0);
	}
}
