package com.paymode;

import java.util.List;

import com.Auxilary.Auxilary;
import com.Domain.Item;

public class CreditCard extends Auxilary implements PayMode  {

	private String name;
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

	public double discount(List<Item> items) {
		return (super.getTotal(items)*10)/100;
	}
	
	public String  toString(){
		return "I´m CreditNumber";
	}

}
