package com.view;

import java.util.ArrayList;
import java.util.List;
import com.ControlMarket.ControlMarket;
import com.Domain.Item;
import com.Observer.ObservedSubject;
import com.Observer.Observer;
import com.paymode.Cash;
import com.paymode.CreditCard;
import com.paymode.PayMode;
import com.paymode.Paypal;

public class ControlView implements ObservedSubject{

	private ControlMarket controlMarket;
	private List<Observer> observers;
	

	public ControlView(ControlMarket controlMarket,Observer obs){
		this.controlMarket=controlMarket;
		this.observers = new ArrayList<Observer>();
		this.observers.add(obs);
	}
	
	public void createTransaction(List<String> names, String paymode){
		this.controlMarket.createTransaction(MapList(names),getPaymodeBy(paymode));
		this.notifyObservers("transaction");
	}
		
	public List<Item> MapList(List<String> names){
		List<Item> items = new ArrayList<Item>();
		for (String name : names) {
			items.add(this.controlMarket.getItemByName(name));
		}
		return items;
	}
	
	public PayMode getPaymodeBy(String paymode){
		
		String loweCasePaymode = paymode.toLowerCase();
		if("cash".equals(loweCasePaymode)){
		return new Cash();	
		}
		if("creditcard".equals(loweCasePaymode)){
			return new CreditCard();
		}
		if("paypal".equals(loweCasePaymode)){
			return new Paypal(); 
		}
		return null;
	}
	
	public void showItems(){
		controlMarket.showItems();
	}
	
	public void showTransactions(){
		this.controlMarket.showTransactions();
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer); 
	}

	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}
	
	public void showMails() {
		this.observers.get(0).showMails();
	}
	
	public String ShowOfferDetail(String name){
		return this.controlMarket.getItemDetailBy(name);
	}
	
	public void createProduct(String name, double price){
		this.controlMarket.createProduct(name,price);
		this.notifyObservers("product");
	}

	public void notifyObservers(String data) {
		for (Observer observer : this.observers) {
			observer.doUpdate(data);
		}
	}

}
