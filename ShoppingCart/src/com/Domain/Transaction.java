package com.Domain;

import java.util.ArrayList;
import java.util.List;
import com.paymode.PayMode;

public class Transaction {

	private static int initialId = 0;
	private PayMode paymode;
	private int id;
	private List<Item> items;
	
	public Transaction(){
		this.id = initialId++;
		this.items = new ArrayList<Item>();
	}
	
	public Transaction(PayMode paymode, List<Item> items){
		this.items = items;
		this.paymode = paymode;
		this.id = initialId++;
	}

	public PayMode getPaymode() {
		return paymode;
	}
	public void setPaymode(PayMode paymode) {
		this.paymode = paymode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public String toString(){
		return "Paymode: "+this.paymode+" id: "+this.id+" finalPrice="+this.getFinalPrice();
	}

	public double getFinalPrice(){
		return this.getTotalPrice(items) - this.getPaymode().discount(items);
	}
	
	public double getTotalPrice(List<Item> items){
		//double total = this.items.stream().mapToDouble(item->item.getPrice());
		double total=0;
		for (Item item : items) {
			total += item.getPrice();
		}
		return total;
	}
}
