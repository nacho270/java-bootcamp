package discount;

import shopping.Offer;

public abstract class DiscountHandler {
    DiscountHandler successor;

    public void setSuccessor(DiscountHandler successor) {
        this.successor = successor;
    }

    public abstract double applyDiscount(Offer offer);
}
