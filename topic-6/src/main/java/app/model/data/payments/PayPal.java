package app.model.data.payments;

import java.util.List;

import app.model.data.Cart;
import app.model.data.Item;

public class PayPal implements PaymentStrategy {

	double cartPrice;

	public PayPal(String email, String pwd, Cart cart) {
		
	}

	public double getPaymentAmount(Cart cart) {
		List<Item> items = cart.getItems();
		double lowestPrice = 0;
		for (Item itm : items) {

			double price = itm.getPrice();
			if (lowestPrice > price) {
				lowestPrice = price;
			}
		}
		cartPrice = cart.getPrice() - lowestPrice;
		return cartPrice;
	}

	public String toString() {
		return "PayPal / $" + cartPrice;
	}

}
