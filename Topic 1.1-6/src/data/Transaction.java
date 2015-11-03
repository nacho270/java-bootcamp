package data;

import data.payments.PaymentMethod;

public class Transaction {
	
	//represents a transaction after the client decided what to buy
	// and the payment method

	private static long currentTransactionID = 0;
	private long transactionID;
	private PaymentMethod payMeth;
	private Cart cart;

	public Transaction(Cart cart, PaymentMethod payMeth) {
		this.cart = cart;
		this.payMeth = payMeth;
		transactionID = currentTransactionID;
		currentTransactionID++;
	}

	public String toString() {
		return "Transaction id: " + transactionID + " Pago: " + payMeth + "\n" + cart;
	}

}
