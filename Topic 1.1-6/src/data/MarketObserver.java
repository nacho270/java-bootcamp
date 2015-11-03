package data;

public class MarketObserver {

	static int observerID = 0;
	int ID;

	public MarketObserver() {
		ID = observerID;
		observerID++;
	}

	public void doNotify(Transaction trans) {
		System.out.println("mail sent to Market Manager Nº" + ID + "\n" + trans);

	}

	public void doNotify(Item item) {
		System.out.println("mail sent to Market Manager Nº" + ID + "\n" + "modified item: \n" + item);

	}
}
