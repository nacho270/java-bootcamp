package data.payments;

import data.Cart;

public class PayPal implements PaymentMethod {

	double cartPrice;

	public PayPal(String email, String pwd, Cart cart) {
		cartPrice = cart.getPrice();
		cartPrice -= cart.getCheapestItmPrice();
	}

	public double getPaymentAmount(double price) {
		return cartPrice;
	}

	public String toString() {
		return "PayPal / $" + cartPrice;
	}

}
