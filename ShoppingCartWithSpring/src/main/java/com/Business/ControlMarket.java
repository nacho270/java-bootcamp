package com.Business;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.Services.ControlMarketFactory;

@Component
@ComponentScan("com.Services")
public class ControlMarket implements ObservedSubject {
	
	@Autowired
	private ControlMarketFactory factory;
	
	private static int idsTrans=0;
	private List<Item> items; 
	private List<Transaction> transactions;
	private List<User> users;
	private List<Observer> observers;
	
	public ControlMarket(){

	}
	
	
	@PostConstruct
	public void Init(){
		this.items = factory.createItems();
		this.users =factory.createUsers();
		this.transactions=new ArrayList<Transaction>();
	}
	
	public ControlMarketFactory getFactory() {
		return factory;
	}
	public void setFactory(ControlMarketFactory factory) {
		this.factory = factory;
	}
	
	public static int getIdsTrans() {
		return idsTrans;
	}


	public static void setIdsTrans(int idsTrans) {
		ControlMarket.idsTrans = idsTrans;
	}


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public StringBuilder showItems(){
		StringBuilder itemsString = new StringBuilder();
		for (Item	item: this.items) {
			itemsString.append(item+"\n");
			}
		return itemsString;
		}
	
	public Item getItemByName(String name){
		for (Item item : this.items) {
			if(name.equals(item.getName())){
				return item;
			}
		}
		return null;
	}
	

	public Transaction createTransaction(User user,PayMode paymode){
		int id = idsTrans++;
		Transaction tran = new Transaction(paymode, user.getCart().getItems(),id);
		tran.processTransaction();
		this.transactions.add(tran);
		return tran;
	}
	
	public void createProduct(String name, double price){
			Product prod = new Product(name, price);
			this.items.add(prod);	
		}
	
	public boolean exist(User user){
		for (User user1 : this.users) {
			if(compareUser(user1,user)){
				return true;
			}
		}
		return false;
	}
	
	public boolean compareUser(User user1, User user2){
		return user1.getName().equals(user2.getName()) && 
			   user1.getPass().equals(user2.getPass());
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	public void notifyObservers(String data) {
		for (Observer observer : observers) {
			observer.doUpdate(data);
		}
	}

	public void showMails() {
		
	}	
}

	
	

