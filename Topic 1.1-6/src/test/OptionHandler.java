package test;

import java.util.Scanner;

import data.Item;
import model.Facade;

public class OptionHandler {

	public void handle(int optionSelected, Facade fac, Scanner scn) {

		switch (optionSelected) {
		case 0:// add item into the cart
			ConsoleOutput.showInsertNro();
			fac.addItem(scn.nextInt());
			break;
		case 1:// remove item from cart
			ConsoleOutput.showInsertNro();
			fac.removeItem(scn.nextInt());
			break;
		case 2:// buy everything that is in the cart
			buyCart(scn, fac);
			break;
		case 3:// buy everything that is in the cart
			fac.changeItem();
			break;
		default:
			break;
		}
	}

	private void buyCart(Scanner scn, Facade fac) {
		// 3 payment options to choose
		ConsoleOutput.showPaymentInfo();
		int option = scn.nextInt();
		if (option == 0) {
			String name = scn.next();
			int creditNumber = scn.nextInt();
			fac.buyCart(name, creditNumber);
		}
		if (option == 1) {
			String email = scn.next();
			String pwd = scn.next();
			fac.buyCart(email, pwd);
		}
		fac.buyCart();
	}
}
