package app.services;

import java.util.List;

import app.model.data.Cart;
import app.model.data.Item;
import app.model.data.Transaction;
import app.model.data.User;
import app.model.data.payments.Payment;
import app.model.data.payments.PaymentStrategy;

public interface CartServices {

	void addItem(int index, User usr);

	void removeItem(int index, User usr);

	Cart getCart(User usr);

	List<Item> getAvailableItems();

	List<String> getAvailablePayments();

	Transaction buyCart(int paymentIndex, User usr);

	List<Transaction> getUserTransactions(User usr);

	List<Item> getItemsCategory(String category);

	List<Item> getAvailableName(String name);

}
