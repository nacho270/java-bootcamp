package payment;

public class CashPayment implements PaymentMethod{

    @Override
    public boolean pay(double amount,int identifier) {
        return true;
    }
}
