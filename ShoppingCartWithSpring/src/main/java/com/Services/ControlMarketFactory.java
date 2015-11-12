package com.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.Business.Item;
import com.Business.Offer;
import com.Business.Product;
import com.Business.User;

@Component
public class ControlMarketFactory {
	
	public ControlMarketFactory() {
	
	}

	public List<Item> createItems(){
		List<Item> items =  new ArrayList<Item>();
		
		Product prod1 = new Product("ball", 20);
		Product prod2 = new Product("book", 30);
		Product prod3 = new Product("cel", 100);
		Product prod4 = new Product("orange", 20);
		items.add(prod1);
		items.add(prod2);
		items.add(prod3);
		items.add(prod4);
		
		Offer ord1 =  new Offer("offer1", 20);
		Offer ord2 =  new Offer("offer2", 70);
		ord1.add(prod3);
		items.add(ord1);
		items.add(ord2);
		return items;
	}
	
	public List<User> createUsers(){
		
		List<User> users = new ArrayList<User>(); 
		User user1 = new User("matias","12345");
		User user2 = new User("lucas","12345");
		User user3 = new User("brian","12345");
		User user4 = new User("agustina","12345");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		return users;
	}

}
