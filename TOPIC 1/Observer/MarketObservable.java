package Observer;

public interface MarketObservable {
    public void addObserver(MarketObserver observer);

    public void removeObserver(MarketObserver observer);

    public void doNotify(String type,Object o);

}
