package data;

public interface MarketObsSubjet {

	public void addObserver(MarketObserver mktObs);

	public void removeObserver(MarketObserver mktObs);

	public void doNotify(Transaction trans);

}
