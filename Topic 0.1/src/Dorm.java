public class Dorm extends Room {

	private int beds;

	public Dorm(double size, int windows, int beds) {
		super(size, windows);
		this.beds = beds;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public String toString() {

		return "Dorm: " + super.toString() + " Beds: " + beds;
	}
}
