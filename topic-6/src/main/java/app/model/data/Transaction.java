package app.model.data;

import app.model.data.payments.Payment;

public class Transaction {

	// represents a transaction after the client decided what to buy
	// and the payment method

	private static long currentTransactionID = 0;
	private long transactionID;
	private Payment payMeth;
	private Cart cart;

	public Transaction(Cart cart, Payment payMeth) {
		this.cart = cart;
		this.payMeth = payMeth;
		transactionID = currentTransactionID;
		currentTransactionID++;
	}

	public String toString() {
		return "Transaction id: " + transactionID + "\n" +" Pago: " + payMeth + "\n" + cart;
	}

}
