package app.model.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import app.model.data.payments.Payment;
import app.model.data.payments.PaymentStrategies;
import app.model.data.payments.PaymentStrategy;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iD;
	@NotNull
	private double payAmount;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Cart cart;
	@NotNull
	private String usuario;
	@NotNull
	private String payInfo;

	public Transaction(int paymentIndex, Cart cart, String user) {
		getPayment(paymentIndex, cart);
		usuario = user;
		this.cart = cart;
	}
	protected Transaction() {
		
	}

	void getPayment(int paymentIndex, Cart cart) {
		PaymentStrategy pStra;
		switch (paymentIndex) {
		case 0:
			pStra = PaymentStrategies.CASH.getStrategy();
			break;
		case 1:
			pStra = PaymentStrategies.PAYPAL.getStrategy();
			break;
		case 2:
			pStra = PaymentStrategies.CREDIT.getStrategy();
			break;
		default:
			pStra = null;
			break;
		}
		Payment payment = new Payment(pStra, cart);
		payAmount = payment.getAmountToPay();
		payInfo = payment.getPayInfo();
	}

	public String toString() {
		return "Transaction id: " + iD + "\n" + " Pago: " + "\n" + cart;
	}

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}
}
