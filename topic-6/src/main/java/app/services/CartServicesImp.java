package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.Attendee;
import app.model.data.Cart;
import app.model.data.Data;
import app.model.data.Item;
import app.model.data.Transaction;
import app.model.data.payments.Payment;
import app.model.data.payments.PaymentStrategy;

@Service
public class CartServicesImp implements CartServices {

	@Autowired
	Data dataAcc;
	
	public void addItem(int index) {
		
		Item item = dataAcc.getAvailableItems().get(index);
		dataAcc.getCart().addItem(item);		
	}

	public void removeItem(int index) {
		dataAcc.getCart().removeItem(index);
		
	}

	public Cart getCart() {
		return dataAcc.getCart();
	}

	public List<Item> getAvailableItems() {
		return dataAcc.getAvailableItems();
		
	}

	public Transaction buyCart(PaymentStrategy pStrategy) {
		Cart cart = dataAcc.getCart();
		Payment payment= new Payment(pStrategy, cart);
		Transaction trans = new Transaction(cart,payment);
		dataAcc.saveTransaction(trans);
		return trans;
	}

	@Override
	public List<String> getAvailablePayments() {
			return dataAcc.getPayments();
	}

	
}
