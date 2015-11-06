package payment;

public class CreditCardPayment implements PaymentMethod {

    private final String name;
    private final String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean pay(double amount,int identifier) {
        return true;
    }
}
