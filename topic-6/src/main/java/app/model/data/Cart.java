package app.model.data;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	// Cart - contains, adds and removes items from cart

	private List<Item> items;

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

	public List<Item> getItems() {
		return items;
	}

}
