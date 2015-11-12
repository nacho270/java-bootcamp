package com.Business;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

	private PayMode paymode;
	private int id;
	private List<Item> items;
	private ItemTransaccion itemTran;
	private double finalPrice;
	
	public Transaction(){
		this.items = new ArrayList<Item>();
	}
	
	public Transaction(PayMode paymode, List<Item> items, int id){
		this.items = items;
		this.paymode = paymode;
		this.id=id;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public ItemTransaccion getItemTran() {
		return itemTran;
	}

	public void setItemTran(ItemTransaccion itemTran) {
		this.itemTran = itemTran;
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
		return "Paymode: "+this.paymode+" id: "+this.id+" finalPrice="+this.finalPrice
				+" ItemTran:"+this.itemTran;
	}
	
	public void processTransaction(){
		this.finalPrice =  this.getTotalPrice(items) - this.getPaymode().discount(items, this.getTotalPrice(items));
		this.itemTran = this.paymode.SpecialItem(items);
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
