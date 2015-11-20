package app.model.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long iD;
	// Cart - contains, adds and removes items from cart
	@ElementCollection
	private List<Item> items;

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

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
