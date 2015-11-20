package app.model.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

	// represents an item product, setters getters toString
	@Id
	private String name;
	@NotNull
	private double price;
	@NotNull
	private String category;
	@ManyToOne
	private Offer offer;

	protected Item() {
	}

	public Item(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "> " + category + "\t" + name + "\t" + price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
