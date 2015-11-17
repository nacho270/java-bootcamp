package app.services;

import java.util.List;

import app.model.data.Cart;
import app.model.data.Item;
import app.model.data.Transaction;
import app.model.data.payments.Payment;
import app.model.data.payments.PaymentStrategy;

public interface CartServices {

	
	void addItem(int item);

	void removeItem(int item);

	Cart getCart();

	List<Item> getAvailableItems();

	List<String> getAvailablePayments();

	Transaction buyCart(PaymentStrategy pStrategy);
	
	

}
