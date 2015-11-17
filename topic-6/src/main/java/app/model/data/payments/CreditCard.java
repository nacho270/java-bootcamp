package app.model.data.payments;

import app.model.data.Cart;

public class CreditCard implements PaymentStrategy {

	double cartPrice;// Associated cart price

	public double getPaymentAmount(Cart cart) {
		cartPrice = cart.getPrice() * 1.10;
		return cartPrice;
	}

	public String toString() {
		return "Credit Card / $" + cartPrice;
	}

}
