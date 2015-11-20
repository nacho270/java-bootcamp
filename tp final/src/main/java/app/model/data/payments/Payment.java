package app.model.data.payments;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import app.model.data.Cart;

public class Payment {

	long iD;

	PaymentStrategy pStrategy;
	double amountToPay;

	protected Payment() {
	}

	public Payment(PaymentStrategy pStr, Cart cart) {
		pStrategy = pStr;
		setPaymentAmount(cart);
	}

	public void setPaymentStrategy(PaymentStrategy pStr) {
		this.pStrategy = pStr;
	}

	public void setPaymentAmount(Cart cart) {
		amountToPay = pStrategy.getPaymentAmount(cart);
	}

	public String toString() {
		return "$" + amountToPay;
	}

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	public PaymentStrategy getpStrategy() {
		return pStrategy;
	}

	public void setpStrategy(PaymentStrategy pStrategy) {
		this.pStrategy = pStrategy;
	}

	public double getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}

	public String getPayInfo() {
		return pStrategy.getInfo();
	}

}
