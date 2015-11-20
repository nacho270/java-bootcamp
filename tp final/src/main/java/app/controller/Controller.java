package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.data.Cart;
import app.model.data.Item;
import app.model.data.Transaction;
import app.model.data.User;
import app.services.CartServices;
import app.services.LoginServices;

@RestController
public class Controller {

	@Autowired
	CartServices servCart;
	@Autowired
	LoginServices servLogin;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		boolean register = servLogin.registerUser(user);
		if (register == true) {
			return "Registration Successful";
		}
		return "Registration Failed";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String loginUser(@RequestBody User user) {
		boolean login = servLogin.loginUser(user);
		if (login == true) {
			return "Login Successful";
		}
		return "Login Failed";
	}

	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public void addItem(@RequestBody ClientRequest req) {
		servCart.addItem(req.optionSelected, req.usr);

	}

	@RequestMapping(value = "/removeitem", method = RequestMethod.POST)
	public void removeItemFromCart(@RequestBody ClientRequest req) {
		servCart.removeItem(req.optionSelected, req.usr);

	}

	@RequestMapping(value = "/buycart", method = RequestMethod.POST)
	public Transaction buyCart(@RequestBody ClientRequest req) {

		return servCart.buyCart(req.optionSelected, req.usr);

	}

	@RequestMapping(value = "/getcart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart getCart(@RequestBody User usr) {
		return servCart.getCart(usr);

	}

	@RequestMapping(value = "/getitems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAvailableItems() {
		return servCart.getAvailableItems();
	}

	@RequestMapping(value = "/getitems/search/category/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getItemsCategory(@PathVariable String category) {
		return servCart.getItemsCategory(category);
	}

	@RequestMapping(value = "/getitems/search/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAvailableName(@PathVariable String name) {
		return servCart.getAvailableName(name);
	}

	@RequestMapping(value = "/paymentmethods", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getPaymentOptions() {
		return servCart.getAvailablePayments();

	}

	@RequestMapping(value = "/gettransactions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getTransactions(@RequestBody User usr) {
		return servCart.getUserTransactions(usr);

	}

}
