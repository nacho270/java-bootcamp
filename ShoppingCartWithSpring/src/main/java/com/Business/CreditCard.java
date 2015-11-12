package com.Business;

import java.util.List;

public class CreditCard implements PayMode  {

	private String name = "creditCard";
	private int creditNumber;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	public double discount(List<Item> items, double totalPrice) {
		return (totalPrice*10)/100;
	}
	
	public String  toString(){
		return "CreditCard";
	}

	public ItemTransaccion SpecialItem(List<Item> items) {
		return null;
	}

}
