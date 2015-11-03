package discount;

import payment.CashPayment;
import shopping.Item;
import shopping.Offer;

public class CashDiscounter extends DiscountHandler {
    @Override
    public double applyDiscount(Offer offer) {
        if(offer.getPaymentMethod() instanceof CashPayment){
            double price=0;
            double maxPrice = 0;
            boolean applyed = false;
            for(Item item : offer.getItems()){
                if(item.getPrice()>maxPrice) maxPrice = item.getPrice();
            }

            for(Item item : offer.getItems()){
                if(item.getPrice()==maxPrice&&!applyed){
                    price+=0.1*item.getPrice();
                    applyed = true;
                } else {
                    price+=item.getPrice();
                }
            }

            return price;
        } else {
            if(successor!=null){
            return successor.applyDiscount(offer);} return 0;
        }
    }
}
