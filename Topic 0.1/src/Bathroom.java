public class Bathroom extends Room {

	private boolean hasBathtub;

	public Bathroom(double size, int windows, boolean hasBathtub) {
		super(size, windows);
		this.hasBathtub = hasBathtub;
	}

	public boolean isHasBathtub() {
		return hasBathtub;
	}

	public void setHasBathtub(boolean hasBathtub) {
		this.hasBathtub = hasBathtub;
	}

	public String toString() {

		return "Bathroom: " + super.toString() + " Bathtub: " + (hasBathtub ? "YES" : "NO");
	}
}
