package com.ControlMarket;

import java.util.ArrayList;
import java.util.List;

import com.Domain.Item;
import com.Domain.Product;
import com.Domain.Transaction;
import com.paymode.PayMode;

public class ControlMarket {

	private List<Item> items; 
	private List<Transaction> transactions;
	
	
	public ControlMarket(List<Item> items){
		this.transactions = new ArrayList<Transaction>();
		this.items=items;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void showTransactions(){
		for (Transaction tran: this.transactions) {
			System.out.println(tran);
			}
		}
	public void showItems(){
		for (Item	item: this.items) {
			System.out.println(item);
			}
		}
	
	public Item getItemByName(String name){
		for (Item item : this.items) {
			if(name.equals(item.getName())){
				return item;
			}
		}
		return null;
	}
	
	public String getItemDetailBy(String name){
		return this.getItemByName(name).getItemDetail();
	}
	
	public void createTransaction(List<Item> items,PayMode paymode){
		Transaction tran = new Transaction(paymode, items);
		this.transactions.add(tran);
	}
	public void createProduct(String name, double price){
			Product prod = new Product(name, price);
			this.items.add(prod);	
		}
}

	
	

