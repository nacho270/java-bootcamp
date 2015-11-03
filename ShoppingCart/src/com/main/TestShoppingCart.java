package com.main;


import java.util.ArrayList;
import java.util.List;
import com.ControlMarket.ControlMarket;
import com.Domain.Item;
import com.Domain.Offer;
import com.Domain.Product;
import com.Manager.Manager;
import com.view.ControlView;
import com.view.View;

public class TestShoppingCart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Item> items = createItems();
		Manager manager = new Manager();
		ControlMarket controlMarket = new ControlMarket(items);
		ControlView controlView= new ControlView(controlMarket,manager);
		View view = new View(controlView);
		view.Initial();
 		
	}
	
	public static List<Item> createItems(){
		
		List<Item> items = new ArrayList<Item>();
		
		Offer offer1 = new Offer("offer1",20);
		Offer offer2 = new Offer("offer2",40);
		Offer offer3 = new Offer("offer3",2);
		
		Product prod1 = new Product("pizza", 30);
		Product prod2 = new Product("apple", 5);
		Product prod3 = new Product("orange", 4);
		Product prod4 = new Product("meat", 90);
		Product prod5 = new Product("bread", 2);
	
		offer1.add(prod1);
		offer1.add(prod2);
		
		offer2.add(offer3);
		
		items.add(offer1);
		items.add(offer2);
		items.add(offer3);
		items.add(prod1);
		items.add(prod2);
		items.add(prod3);
		items.add(prod4);
		items.add(prod5);
		
		return items;
	}
}
