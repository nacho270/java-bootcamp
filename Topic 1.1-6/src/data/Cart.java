package data;

import java.util.ArrayList;

public class Cart {

	// Cart - contains, adds and removes items from cart

	private ArrayList<Item> items;

	public Cart() {
		items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		items.add(item);

	}

	public String toString() {
		if (items.isEmpty()) {
			return "<<<<El carrito esta vacio>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
		}
		String ret = "<<<<Mi Carrito>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n";
		for (Item item : items) {
			ret += item.toString() + "\n";
		}
		return ret;
	}

	public void removeItem(int index) {
		items.remove(index);

	}

	public double getPrice() {
		double retPrice = 0;
		for (Item itm : items) {
			retPrice += itm.getPrice();
		}
		return retPrice;

	}

	public double getMostExpensiveItmPrice() {
		double higestPrice = 0;
		for (Item itm : items) {

			double price = itm.getPrice();
			if (higestPrice < price) {
				higestPrice = price;
			}
		}
		return higestPrice;
	}

	public double getCheapestItmPrice() {
		double lowestPrice = 0;
		for (Item itm : items) {

			double price = itm.getPrice();
			if (lowestPrice > price) {
				lowestPrice = price;
			}
		}
		return lowestPrice;
	}

}
