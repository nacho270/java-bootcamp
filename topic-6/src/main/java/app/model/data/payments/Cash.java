package app.model.data.payments;

import java.util.List;

import app.model.data.Cart;
import app.model.data.Item;

public class Cash implements PaymentStrategy {

	double cartPrice;// Associated cart price

	public double getPaymentAmount(Cart cart) {
		List<Item> items = cart.getItems();

		double higestPrice = 0;
		for (Item itm : items) {

			double price = itm.getPrice();
			if (higestPrice < price) {
				higestPrice = price;
			}
		}
		higestPrice *= 0.90;
		cartPrice = cart.getPrice() - higestPrice;
		return cartPrice;
	}

	public String toString() {
		return "Cash / $" + cartPrice;
	}

}
