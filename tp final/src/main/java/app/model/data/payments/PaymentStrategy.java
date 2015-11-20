package app.model.data.payments;

import javax.persistence.Entity;

import app.model.data.Cart;

public interface PaymentStrategy {

	public double getPaymentAmount(Cart cart);

	public String getInfo();
}
