package shopping;

import discount.DiscountHandler;
import payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Offer {
    PaymentMethod paymentMethod;
    List<Item> items;
    List<Offer> offers;
    boolean paid;

    public Offer() {
        items = new ArrayList<>();
        offers = new ArrayList<>();
        paid = false;
    }


    public Offer(List<Item> items) {
        this.items = items;
        paid= false;
    }

    public Offer(List<Item> items, List<Offer> offers) {
        this.items = items;
        this.offers = offers;
        paid = false;
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setPaid(){
        this.paid=true;
    }


    @Override
    public String toString() {
        String toReturn = "Offer{" +
                "items \n";
        for(Item item:items){
            toReturn+=item;
            toReturn+="\n";
        }
        toReturn+="offers\n";
        for(Offer offer: offers){
            toReturn+=offer;
            toReturn+="\n";
        }
        toReturn += '}';
        return toReturn;
    }
}
