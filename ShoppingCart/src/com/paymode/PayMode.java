package com.paymode;

import java.util.List;

import com.Domain.Item;

public interface PayMode {

	public String toString();
	public double discount(List<Item> items);
}
