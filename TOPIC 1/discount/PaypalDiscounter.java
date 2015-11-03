package discount;

import payment.CashPayment;
import payment.PaypalPayment;
import shopping.Item;
import shopping.Offer;

public class PaypalDiscounter extends DiscountHandler {
    @Override
    public double applyDiscount(Offer offer) {
        if(offer.getPaymentMethod() instanceof PaypalPayment){
            double price=0;
            double minPrice = 0;
            boolean applyed = false;
            for(Item item : offer.getItems()){
                if(item.getPrice()<minPrice||minPrice==0) minPrice = item.getPrice();
            }

            for(Item item : offer.getItems()){
                if(item.getPrice()==minPrice&&!applyed){
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
