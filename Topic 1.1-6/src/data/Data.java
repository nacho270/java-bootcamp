package data;

import java.util.ArrayList;

//class hecha para "simular" las neceisdades del facade suplantando ciertas funciones
public class Data implements MarketObsSubjet {

	ArrayList<Transaction> transactionsMade;
	ArrayList<MarketObserver> mktObs;
	ArrayList<Item> availableItems;

	// hardcoded DATA
	public Data() {
		transactionsMade = new ArrayList<Transaction>();
		mktObs = new ArrayList<MarketObserver>();
		mktObs.add(new MarketObserver());
		mktObs.add(new MarketObserver());

		availableItems = new ArrayList<Item>();

		availableItems.add(new Item("Pancho", 10));
		availableItems.add(new Item("Hamburguesa", 50));
		availableItems.add(new Item("Salmon", 100));
		availableItems.add(new Item("Papas Fritas", 100));

		// some offers
		Offer off1 = new Offer("Combo Pancho&Fritas");
		off1.addItem(new Item("Pancho", 10));
		off1.addItem(new Item("Papas Fritas", 100));
		off1.applyDiscount(50);
		availableItems.add(off1);

		Offer off2 = new Offer("Combo Hamburguesa&Fritas");
		off2.addItem(new Item("Pancho", 10));
		off2.addItem(new Item("Papas Fritas", 100));
		off2.applyDiscount(40);
		availableItems.add(off2);
	}

	public ArrayList<Item> getAvailableItems() {
		return availableItems;
	}

	public void saveTransaction(Transaction trans) {
		transactionsMade.add(trans);
		doNotify(trans);

	}

	public void addObserver(MarketObserver mktObs) {
		this.mktObs.add(mktObs);
	}

	public void removeObserver(MarketObserver mktObs) {
		this.mktObs.remove(mktObs);

	}

	public void doNotify(Transaction trans) {
		for (MarketObserver mktObs : mktObs) {
			mktObs.doNotify(trans);
		}
	}

	public void changeItem() {
		for (MarketObserver mktObs : mktObs) {
			mktObs.doNotify(new Item("Alfajor", Math.random() * 10));
		}
	}

}
