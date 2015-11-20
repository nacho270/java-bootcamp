package app.model.data.payments;

import java.util.ArrayList;
import java.util.List;

import app.model.data.Cart;
import app.model.data.Item;

public enum PaymentStrategies {

	CASH(new PaymentStrategy() {
		String info;

		@Override
		public double getPaymentAmount(Cart cart) {
			List<Item> items = cart.getItems();

			double higestPrice = 0;
			Item higestItem = null;
			for (Item itm : items) {
				double price = itm.getPrice();
				if (higestPrice < price) {
					higestPrice = price;
					higestItem = itm;
				}

			}
			higestPrice *= 0.10;
			this.info = "Item mas caro 90% desc! / " + higestItem;
			return higestPrice;
		}

		@Override
		public String getInfo() {
			return info;
		}
	}), PAYPAL(new PaymentStrategy() {
		String info;

		@Override
		public double getPaymentAmount(Cart cart) {

			Item lowestItem = null;
			double lowestPrice = 0;
			for (Item itm : cart.getItems()) {
				if (lowestItem == null) {
					lowestItem = itm;
					lowestPrice = itm.getPrice();
				}
				if (lowestPrice > itm.getPrice()) {
					lowestItem = itm;
					lowestPrice = itm.getPrice();
				}

				this.info = "Item mas barato gratis! / " + lowestItem;
			}
			return cart.getPrice() - lowestPrice;

		}

		@Override
		public String getInfo() {
			return info;
		}

	}), CREDIT(new PaymentStrategy() {

		@Override
		public double getPaymentAmount(Cart cart) {
			double price = cart.getPrice();
			return price -= (price / 100) * 10;

		}

		@Override
		public String getInfo() {
			return "PAYMETHOD: CREDITO / 10% DESC AL TOTAL";
		}

	});

	PaymentStrategy ps;

	private PaymentStrategies(PaymentStrategy ps) {
		this.ps = ps;
	}

	public PaymentStrategy getStrategy() {
		return ps;
	}
}
