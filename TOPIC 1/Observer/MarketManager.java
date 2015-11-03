package Observer;

public class MarketManager implements MarketObserver {
    private String name;

    public MarketManager(String name) {
        this.name = name;
    }


    @Override
    public void doUpdate(String type, Object object) {
        System.out.println("manager "+name+" was notified about "+type);
    }
}
