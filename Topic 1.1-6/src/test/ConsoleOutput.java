package test;

import java.util.ArrayList;

import data.Cart;
import data.Item;
import data.Offer;

public class ConsoleOutput {

	public static void showMenu() {
		System.out.println("\n\n<<<<Shopping Cart Menu:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n" + "0) Add item\n" + "1) Remove item\n"
				+ "2) Buy \n\n" + "Store Admin\n" + "3) Add new item\n");
	}

	public static void show(ArrayList<Item> avaItms, Cart myCart) {
		System.out.println("<<<<Items a la venta:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		int i=0;
		for (Item itm : avaItms) {
			System.out.println(i+") "+itm);
			i++;
		}
		System.out.println(myCart);

	}

	public static void showPaymentInfo() {
		System.out.println("Select Payment: \n\n" + "0) Credit Card (Name & CC Number needed)\n" + "1) PayPal (email & pwd needed)\n"
				+ "2) Cash (nothing needed)\n");
	}

	public static void showInsertNro() {
		System.out.println("insert item number");
	}
}
