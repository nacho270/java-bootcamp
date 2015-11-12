package com.Business;

import com.Services.ShoppingCart;

public class User {
	
	private String name;
	private String pass;
	private ShoppingCart sCart;
	
	public User(){}
	
	public User(String name, String pass){
		this.name=name;
		this.pass=pass;
	}
	
	
	public ShoppingCart getCart() {
		return sCart;
	}

	public void setCart(ShoppingCart sCart) {
		this.sCart = sCart;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toString(){
		return "name: "+this.name+" pass: "+this.pass;
	}
}
