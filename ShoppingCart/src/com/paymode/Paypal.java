package com.paymode;

import java.util.List;

import com.Domain.Item;

public class Paypal  implements PayMode {
	
	private String email;
	private String pass;
	
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

	public int discount() {
		System.out.println("paypal´s discount");
		return 0;
	}
	
	public String  toString(){
		return "I´m Paypal";
	}

	public double discount(List<Item> items) {
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
}
