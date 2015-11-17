package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.data.Cart;
import app.model.data.Data;
import app.model.data.Item;
import app.model.data.Transaction;
import app.model.data.payments.PaymentStrategy;
import app.services.CartServices;

@RestController
public class Controller {

	@Autowired
	CartServices services;
	
	// public CartServicesImp() {
	// dataAccs = DataFactory.getDataAccsess();
	// }
 
	@RequestMapping(value = "/additem",method = RequestMethod.POST)
	public void addItem(@RequestBody int index) {
		services.addItem(index);
	}
	
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	public void removeItemFromCart(@RequestBody int index) {
		services.removeItem(index);
	}

	@RequestMapping(value = "/buycart",method = RequestMethod.POST)
	public Transaction buyCart(@RequestBody PaymentStrategy pStrategy) {
		return services.buyCart(pStrategy);
	}

	@RequestMapping(value = "/getcart",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart getCart() {
		return services.getCart();
	}

	@RequestMapping(value="/getitems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAvailableItems() {
		return services.getAvailableItems();
	}

	@RequestMapping(value="/paymentmetods",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getPaymentOptions() {
		System.out.println(services.getAvailablePayments());
		return services.getAvailablePayments();
		
	}

}
