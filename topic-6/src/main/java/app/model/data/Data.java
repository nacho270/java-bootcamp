package app.model.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.model.data.payments.Cash;
import app.model.data.payments.CreditCard;
import app.model.data.payments.PayPal;
import app.model.data.payments.PaymentStrategy;

//class hecha para "simular" las neceisdades del facade suplantando ciertas funciones
@Component
public class Data {

	List<Transaction> transactionsMade;
	List<Item> availableItems;
	List<String> availablePayments;
	Cart cart;

	// hardcoded DATA
	public Data() {
		//transactions
		transactionsMade = new ArrayList<Transaction>();
		
		//payments
		availablePayments= new ArrayList<String>();
		availablePayments.add("PayPal");
		availablePayments.add("Cash");
		availablePayments.add("CreditCard");
		
		//some items
		availableItems = new ArrayList<Item>();
		availableItems.add(new Item("Pancho", 10));
		availableItems.add(new Item("Hamburguesa", 50));
		availableItems.add(new Item("Salmon", 100));
		availableItems.add(new Item("Papas Fritas", 100));
		availableItems.add(new Item("Pastel", 20));

		// some offers
		Offer off1 = new Offer("Combo Pancho&Fritas");
		off1.addItem(new Item("Pancho", 10));
		off1.addItem(new Item("Papas Fritas", 100));
		off1.applyDiscount(50);
		availableItems.add(off1);

		Offer off2 = new Offer("Combo Hamburguesa&Fritas");
		off2.addItem(new Item("Pancho", 10));
		off2.addItem(new Item("Papas Fritas", 100));
		off2.applyDiscount(40);
		availableItems.add(off2);
	}

	public List<Item> getAvailableItems() {
		return availableItems;
	}

	public void saveTransaction(Transaction trans) {
		transactionsMade.add(trans);
	}

	public void addItemIntoCart(int index) {
		Item itm = availableItems.get(index);
		cart.addItem(itm);

	}

	public void removeItemFromCart(int index) {
		cart.removeItem(index);
	}

	public Cart getCart() {
	return cart;
	}

	public List<String> getPayments() {
		return availablePayments;
		
	}

}
