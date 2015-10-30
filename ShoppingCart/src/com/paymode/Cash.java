package com.paymode;


import java.util.List;

import com.Auxilary.Auxilary;
import com.Domain.Item;

public class Cash extends Auxilary implements PayMode {

	public double discount(List<Item> items) {
		double priceItem = this.getMostExpensiveItem(items).getPrice();
		return (90*priceItem)/100;
		
	}
	
	public String  toString(){
		return "I´m Cash";
	}
	
	public Item getMostExpensiveItem( List<Item> items){
		//try with lambda expressions
		
		Item itemExpensive = null;
		double max = 0;
		for (Item item : items) {
			if(item.getPrice() >= max){
				itemExpensive = item;
				max = item.getPrice();
			}
		}
		return itemExpensive;
		
	}

}
