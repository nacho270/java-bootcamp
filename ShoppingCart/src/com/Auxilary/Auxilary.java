package com.Auxilary;

import java.util.List;

import com.Domain.Item;

public class Auxilary {
	
	public double getTotal(List<Item> items){
		
		double total = 0;
		for (Item item : items) {
			total += item.getPrice();
			
		}
		return total;
	}

}
