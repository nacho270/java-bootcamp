package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Model;
import app.model.data.Cart;
import app.model.data.Item;
import app.model.data.Transaction;
import app.model.data.User;

@Service
public class CartServicesImp implements CartServices {

	@Autowired
	Model model;

	@Override
	public List<Item> getAvailableItems() {
		return model.getAvailableItems();
	}

	@Override
	public List<String> getAvailablePayments() {
		return model.getPayments();
	}

	@Override
	public List<Item> getItemsCategory(String category) {
		return model.getItemsCategory(category);
	}

	@Override
	public List<Item> getAvailableName(String name) {
		return model.getAvailableName(name);

	}

	@Override
	public void addItem(int index, User usr) {
		model.addItem(index, usr);

	}

	@Override
	public void removeItem(int index, User usr) {
		model.removeItem(index, usr);

	}

	@Override
	public Transaction buyCart(int paymentIndex, User usr) {
		return model.buyCart(paymentIndex, usr);

	}

	@Override
	public Cart getCart(User usr) {
		return model.getCart(usr);
	}

	@Override
	public List<Transaction> getUserTransactions(User usr) {
		return model.getUserTransactions(usr);

	}

}
