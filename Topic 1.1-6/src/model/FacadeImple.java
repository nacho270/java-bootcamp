package model;

import java.util.ArrayList;

import data.Cart;
import data.Data;
import data.DataFactory;
import data.Item;
import data.Offer;
import data.Transaction;
import data.payments.Cash;
import data.payments.CreditCard;
import data.payments.PayPal;
import data.payments.PaymentMethod;

public class FacadeImple implements Facade {

	Cart cart;
	ArrayList<Item> availableItems;

	Data dataAccs;

	public FacadeImple() {
		dataAccs = DataFactory.getDataAccsess();
		availableItems = dataAccs.getAvailableItems();
		cart = new Cart();
	}

	public void addItem(int index) {
		Item item = availableItems.get(index);
		cart.addItem(item);
	}

	public void removeItem(int index) {
		cart.removeItem(index);
	}

	public void buyCart(String name, int nextInt) {
		PaymentMethod payment = new CreditCard(name, nextInt, cart);
		doTransaction(payment);
	}

	public void buyCart(String email, String pwd) {
		PaymentMethod payment = new PayPal(email, pwd, cart);
		doTransaction(payment);

	}

	public void buyCart() {
		PaymentMethod payment = new Cash(cart);
		doTransaction(payment);
		cart = new Cart();
	}

	private void doTransaction(PaymentMethod payment) {
		Transaction trans = new Transaction(cart, payment);
		dataAccs.saveTransaction(trans);
	}

	public Cart getCart() {
		return cart;
	}

	public ArrayList<Item> getAvailableItems() {
		return availableItems;
	}

	@Override
	public void changeItem() {
		dataAccs.changeItem();

	}

}
