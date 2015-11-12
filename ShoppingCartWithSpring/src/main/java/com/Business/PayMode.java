package com.Business;

import java.util.List;

public interface PayMode {

	public double discount(List<Item> items, double totalPrice);
	public ItemTransaccion SpecialItem(List<Item> items);
}
