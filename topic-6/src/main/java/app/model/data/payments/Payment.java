package app.model.data.payments;

import app.model.data.Cart;

public class Payment {

	PaymentStrategy pStrategy;
	Cart cart;

	public Payment(PaymentStrategy pStr,Cart cart){
		pStrategy=pStr;
		this.cart=cart;
	}
	public void setPaymentStrategy(PaymentStrategy pStr) {
		this.pStrategy = pStr;
	}

	public double getPaymentAmount() {
		return pStrategy.getPaymentAmount(cart);
	}
	
	public String toString(){
		return "$"+getPaymentAmount();
	}
}
