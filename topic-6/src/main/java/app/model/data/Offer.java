package app.model.data;

import java.util.ArrayList;

public class Offer extends Item {

	// represents an offer, includes items.

	private ArrayList<Item> itemsInOffer;
	private int discount;

	public Offer(String name) {
		super(name, 0);
		itemsInOffer = new ArrayList<Item>();
		discount = 0;
	}

	public String toString() {
		String ret = super.toString() + "\n\n";
		for (Item itm : itemsInOffer) {
			ret += "\t>" + itm.toString() + "\n";
		}
		return ret;
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}

	public double getPrice() {
		return super.getPrice();
	}

	public void setPrice(double price) {
		super.setPrice(price);
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
		double price = itm.getPrice();
		price -= (price / 100) * discount;
		itm.setPrice(price);
		setPrice(getPrice() + price);
		itemsInOffer.add(itm);
	}

}
