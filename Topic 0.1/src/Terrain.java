public class Terrain {

	// represents a plain terrain without any building in it

	private double size;
	private String address;
	private int zipCode;

	public Terrain(double d, String address, int zipCode) {
		this.size = d;
		this.address = address;
		this.zipCode = zipCode;

	}

	public double getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String toString() {
		return "Terrain info: \n" + "Address: " + address + "\n" + "Zip Code: " + zipCode + "\n" + "Size: " + size + "\n\n";
	}

}
