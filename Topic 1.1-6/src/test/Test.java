package test;

import java.util.ArrayList;
import java.util.Scanner;

import model.Facade;
import model.FacadeImple;
import data.Cart;
import data.Item;
import data.Offer;

public class Test {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		Facade fac = new FacadeImple();
		OptionHandler opHand = new OptionHandler();

		while (true) {
			// get offers, available items and the cart

			ArrayList<Item> avaItms = fac.getAvailableItems();
			Cart myCart = fac.getCart();
			// show them and also show option menu
			ConsoleOutput.show(avaItms, myCart);
			ConsoleOutput.showMenu();
			// wait for option to be chosen
			opHand.handle(scn.nextInt(), fac, scn);
		}
	}

}
