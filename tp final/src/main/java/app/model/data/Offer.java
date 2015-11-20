package app.model.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Offer extends Item {

	// represents an offer, includes items.

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "item_items_in_offer", joinColumns = @JoinColumn(name = "offer"), inverseJoinColumns = @JoinColumn(name = "name"))
	private List<Item> itemsInOffer;

	public void setItemsInOffer(List<Item> itemsInOffer) {
		this.itemsInOffer = itemsInOffer;
	}

	@NotNull
	private int discount;

	public Offer() {
	}

	public Offer(String name) {
		super(name, 0, "DESCUENTO");
		discount = 0;
	}

	@Override
	public String toString() {
		String ret = super.toString() + "\n\n";
		for (Item itm : itemsInOffer) {
			ret += "\t>" + itm.toString() + "\n";
		}
		return ret;
	}

	public void applyDiscount(int discount) {
		this.discount = discount;
		double newOfferPrice = 0;

		for (Item itm : itemsInOffer) {
			double price = itm.getPrice();
			price -= (price / 100) * discount;
			itm.setPrice(price);
			newOfferPrice += price;
		}
		setPrice(newOfferPrice);
	}

	public void addItem(Item itm) {
		if (itemsInOffer == null) {
			itemsInOffer = new ArrayList<Item>();
		}
		double price = itm.getPrice();
		price -= (price / 100) * discount;
		itm.setPrice(price);
		setPrice(getPrice() + price);
		itemsInOffer.add(itm);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public double getPrice() {
		return super.getPrice();
	}

	@Override
	public void setPrice(double price) {
		super.setPrice(price);
	}

	public List<Item> getItemsInOffer() {
		return itemsInOffer;
	}

	public void setItemsInOffer(ArrayList<Item> itemsInOffer) {
		this.itemsInOffer = itemsInOffer;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
