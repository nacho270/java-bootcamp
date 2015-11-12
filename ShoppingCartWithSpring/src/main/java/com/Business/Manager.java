package com.Business;

import java.util.Date;

public class Manager implements Observer {
	
	private StringBuffer mails;
	
	public Manager(){
		this.mails = new StringBuffer("### Mails ###\n");
	}
	
	public Date  getSystemDate(){
		return new Date();
	}
	public void doUpdate(String data) {
		String lowerString = data.toLowerCase();
		if(lowerString.equals("product") ){
			this.mails.append("A new product was made at "+getSystemDate() );
		}
		if( lowerString.equals("transaction")){
			this.mails.append("New Transaction was  made at "+getSystemDate());
		}
	}
	
	public void showMails() {
		System.out.println(this.mails);
	}
}
