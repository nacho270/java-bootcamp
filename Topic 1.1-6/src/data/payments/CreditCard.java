package data.payments;

import data.Cart;

public class CreditCard implements PaymentMethod {

	double cartPrice;// Associated cart price

	public CreditCard(String name, int nextInt, Cart cart) {
		cartPrice = cart.getPrice() * 1.10;
	}

	public double getPaymentAmount(double price) {
		return cartPrice;
	}

	public String toString() {
		return "Credit Card / $" + cartPrice;
	}

}
