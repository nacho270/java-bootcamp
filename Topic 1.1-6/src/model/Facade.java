package model;

import java.util.ArrayList;

import data.Cart;
import data.Item;
import data.Offer;

public interface Facade {

	// client
	void addItem(int item);

	void removeItem(int item);

	void buyCart(String name, int nextInt);

	Cart getCart();

	ArrayList<Item> getAvailableItems();

	void changeItem();

	void buyCart(String email, String pwd);

	void buyCart();

}
