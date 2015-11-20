package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.model.data.Cart;
import app.model.data.Item;
import app.model.data.ItemDao;
import app.model.data.Offer;
import app.model.data.OfferDao;
import app.model.data.Transaction;
import app.model.data.TransactionDao;
import app.model.data.User;
import app.model.data.UserDao;
import app.model.data.payments.PaymentStrategies;

@Component
public class ModelImp implements Model {

	Map<User, Cart> sessionCarts;
	List<Item> availableItems;

	@Autowired
	UserDao userDao;
	@Autowired
	ItemDao itemDao;
	@Autowired
	OfferDao offerDao;
	@Autowired
	TransactionDao transDao;

	@Override
	// OK
	public List<Item> getAvailableItems() {
		return availableItems;
	}

	@Override
	public List<String> getPayments() {
		ArrayList<String> payments = new ArrayList<String>();
		for (PaymentStrategies p : PaymentStrategies.values()) {
			payments.add(p.toString());
		}
		return payments;
	}

	@Override
	public List<Item> getItemsCategory(String category) {
		ArrayList<Item> byCategory = new ArrayList<Item>();
		for (Item itm : availableItems) {
			if (itm.getCategory().equals(category.toUpperCase())) {
				byCategory.add(itm);
			}
		}
		return byCategory;
	}

	@Override
	public List<Item> getAvailableName(String name) {
		ArrayList<Item> byName = new ArrayList<Item>();
		for (Item itm : availableItems) {
			if (itm.getName().contains(name.toUpperCase())) {
				byName.add(itm);
			}
		}
		return byName;
	}

	@Override
	public boolean registerUser(User usr) {

		if (userDao.findByUsr(usr.getUsr()) == null) {
			userDao.save(usr);
			return true;
		}
		return false;
	}

	@Override
	public boolean loginUser(User usr) {

		User dbUser = userDao.findByUsr(usr.getUsr());
		if (usr.getPwd().equals(dbUser.getPwd())) {

			if (availableItems == null) {
				availableItems = itemDao.findAll();
			}
			if (sessionCarts == null) {
				sessionCarts = new HashMap<User, Cart>();
			}
			sessionCarts.put(dbUser, new Cart());
			
			for(Item itm : availableItems){
				System.out.println(itm);
			}
			
			
			
			return true;
		}
		return false;
	}

	@Override
	public void addItem(int index, User usr) {
		Cart cart = getCartByUser(usr);
		cart.addItem(availableItems.get(index));
	}

	@Override
	public Cart getCart(User usr) {
		return getCartByUser(usr);
	}

	@Override
	public Transaction buyCart(int paymentIndex, User usr) {
		Cart cart = getCartByUser(usr);
		Transaction trans = new Transaction(paymentIndex, cart, usr.getUsr());
		transDao.save(trans);
		
		return trans;
	}

	@Override
	public void removeItem(int index, User usr) {
		Cart cart = sessionCarts.get(getCartByUser(usr));
		cart.removeItem(index);
	}

	@Override
	public List<Transaction> getUserTransactions(User usr) {
		return transDao.findByUsuario(usr.getUsr());
	}

	private Cart getCartByUser(User usr) {
		User hashUser = null;
		for (User u : sessionCarts.keySet()) {
			if (u.equals(usr)) {
				hashUser = u;
			}
		}
		return sessionCarts.get(hashUser);
	}
	private void removeCartByUser(User usr) {
		User hashUser = null;
		for (User u : sessionCarts.keySet()) {
			if (u.equals(usr)) {
				hashUser = u;
			}
		}
		sessionCarts.remove(hashUser);
	}

}
