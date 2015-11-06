package discount;

import shopping.Item;
import shopping.Offer;

public class CreditCardDiscounter extends DiscountHandler {
    @Override
    public double applyDiscount(Offer offer) {
        if(offer.getPaymentMethod() instanceof CreditCardDiscounter){
            double price=0;
            for(Item item : offer.getItems()){
                price+=item.getPrice();
            }
            return 0.9*price;
        } else {
            if(successor!=null){
            return successor.applyDiscount(offer);} return 0;
        }
    }
}
