package app.model.data.payments;

import app.model.data.Cart;

public interface PaymentStrategy {

	public double getPaymentAmount(Cart cart);
}
