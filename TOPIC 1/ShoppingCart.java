import Observer.MarketObservable;
import Observer.MarketObserver;
import discount.CashDiscounter;
import discount.CreditCardDiscounter;
import discount.DiscountHandler;
import discount.PaypalDiscounter;
import shopping.Item;
import shopping.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ShoppingCart implements MarketObservable {
    public static AtomicInteger transactionIdentifiers;
    private List<Item> itemList;
    private List<Offer> offers;
    private ArrayList<MarketObserver> observers;
    private double balance;
    private DiscountHandler discount;

    public ShoppingCart() {
        itemList = new ArrayList<>();
        transactionIdentifiers = new AtomicInteger(0);
        observers = new ArrayList<>();
        balance = 0;
        discount = setUpDiscount();
    }

    public void addItem(Item item){
        itemList.add(item);
        doNotify("new item",item);
    }

    public void addOffer(Offer offer){
        offers.add(offer);
        doNotify("new offer",offer);
    }

    public void changePrice(Item item,double newPrice){
        item.setPrice(newPrice);
        doNotify("price was changed",item);
    }

    public void processPayment(Offer offer){
        double price = discount.applyDiscount(offer);
        if(offer.getPaymentMethod().pay(price,transactionIdentifiers.incrementAndGet())){
            doNotify("new transaction was made",offer);
            offer.setPaid();
            this.balance+=price;
        }
    }

    private DiscountHandler setUpDiscount(){
        CashDiscounter cashDiscounter = new CashDiscounter();
        CreditCardDiscounter creditCardDiscounter = new CreditCardDiscounter();
        PaypalDiscounter paypalDiscounter = new PaypalDiscounter();
        creditCardDiscounter.setSuccessor(paypalDiscounter);
        cashDiscounter.setSuccessor(creditCardDiscounter);
        return cashDiscounter;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "itemList=" + itemList +
                '}';
    }


    @Override
    public void addObserver(MarketObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MarketObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void doNotify(String type,Object o) {
        for(MarketObserver observer:observers) observer.doUpdate(type,o);
    }
}
