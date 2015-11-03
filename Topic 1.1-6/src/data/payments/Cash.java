package data.payments;

import data.Cart;

public class Cash implements PaymentMethod {

	double cartPrice;// Associated cart price

	public Cash(Cart cart) {
		cartPrice = cart.getPrice();
		cartPrice -= cart.getMostExpensiveItmPrice() * 0.90;
	}

	@Override
	public double getPaymentAmount(double price) {
		return cartPrice;
	}

	public String toString() {
		return "Cash / $" + cartPrice;
	}

}
