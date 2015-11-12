package com.Business;


import java.util.List;

public class Cash implements PayMode {
	
	private String name = "Cash";
	private int porcentage = 90;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPorcentage() {
		return porcentage;
	}

	public void setPorcentage(int porcentage) {
		this.porcentage = porcentage;
	}

	public double discount(List<Item> items, double totalPrice) {
		double priceItem = this.getMostExpensiveItem(items).getPrice();
		return this.getDiscount(priceItem);
		
	}
	
	public String  toString(){
		return "cash";
	}
	
	public Item getMostExpensiveItem( List<Item> items){

		Item itemExpensive = null;
		double max = 0;
		for (Item item : items) {
			if(item.getPrice() >= max){
				itemExpensive = item;
				max = item.getPrice();
			}
		}
		return itemExpensive;
	}

	public double getDiscount(double price){
		return (this.porcentage *price)/100;
	}
	public ItemTransaccion SpecialItem(List<Item> items) {
		Item item = this.getMostExpensiveItem(items);
		double newPrice = item.getPrice()-getDiscount(item.getPrice());
		return new ItemTransaccion(item.getName(),newPrice);
	}

}
