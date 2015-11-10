package com.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View{
	private ControlView controlView;
	private Scanner input;
	
	public View(ControlView controlView){
		this.controlView=controlView;
		this.input= new Scanner(System.in);
	}
	
	public void menu(){
		System.out.println("Menu\n");
		System.out.println("Choose a number\n");
		System.out.println("1 - ShowItems\n");
		System.out.println("2 - Buy Items \n");
		System.out.println("3 - Show Transactions made\n");
		System.out.println("4 - Show offerDetail \n");
		System.out.println("5 - Show Manager´s mails \n");
		System.out.println("6 - Add a new Item \n");
		System.out.println("End with 0\n");
	}  
	
	public void Initial(){
		this.menu();	
		double optionSelected = this.getInputNumber();
		while(!(optionSelected == 0)){
			this.action(optionSelected);
			optionSelected = this.getInputNumber();
			System.out.println("");
		}
	}
	
	public void action(double number){
		switch ((int)number) {
		case 1:
			this.controlView.showItems();
			break;
		case 2:
			this.BuyView();
			break;
		case 3:
			this.controlView.showTransactions();
			break;
		case 4:
			this.ShowOfferDetail();
			break;
		case 5:
			this.controlView.showMails();
			break;
		case 6:
			this.addNewProduct();
			break;
		default:
			System.out.println("Choose a correct Number\n");
			break;
		}
	}
	
	
	public void BuyView(){
		System.out.println("Buy\n");
		this.controlView.createTransaction(this.getItems(),this.getPayMode());
		System.out.println("A Transaction was made\n");
	}
		
	public List<String> getItems(){
		List<String> itemsNames = new ArrayList<String>();
		String input="y";
			
		while(!(input.equals("n"))){		
			System.out.println("Select the Item by name\n");
			String name = this.getInputString();
			itemsNames .add(name);
			System.out.println("buy another Item? (y/n)");
			input = this.getInputString();
		}
		return itemsNames;
	} 
		
	public String getPayMode(){
		System.out.println("Choose Paymode(paypal/creditcard/cash)\n");
		return this.getInputString();
	}
		
	public double getInputNumber(){
		return Double.parseDouble(this.input.next());
	}
		
	public String getInputString(){
		return this.input.next();
	}
	
	public void ShowOfferDetail(){
		System.out.println("Offer Detail");
		System.out.println("Choose the order by name\n");
		String offer = getInputString();
		System.out.println(this.controlView.ShowOfferDetail(offer));
	}
	
	public void addNewProduct(){
		System.out.println("New Product");
		System.out.println("Enter the product name\n");
		String name = this.getInputString();
		System.out.println("Enter the product price\n");
		double price = this.getInputNumber();
		this.controlView.createProduct(name,price);
		System.out.println("The product was created\n");
	}
		
}


