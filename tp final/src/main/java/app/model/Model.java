package app.model;

import java.util.List;

import org.springframework.stereotype.Component;

import app.model.data.Cart;
import app.model.data.Item;
import app.model.data.Transaction;
import app.model.data.User;

public interface Model {

	List<Item> getAvailableItems();

	List<String> getPayments();

	void addItem(int index, User usr);

	Cart getCart(User usr);

	Transaction buyCart(int paymentIndex, User usr);

	List<Item> getItemsCategory(String category);

	List<Item> getAvailableName(String name);

	boolean registerUser(User usr);

	boolean loginUser(User usr);

	void removeItem(int index, User usr);

	List<Transaction> getUserTransactions(User usr);

}
