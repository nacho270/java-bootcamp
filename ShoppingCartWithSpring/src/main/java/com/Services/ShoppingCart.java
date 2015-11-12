package com.Services;
import java.util.ArrayList;
import java.util.List;

import com.Business.*;

public class ShoppingCart {

	private List<Item> items;
	
	public ShoppingCart() {
		this.items = new ArrayList<Item>();
	}
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
