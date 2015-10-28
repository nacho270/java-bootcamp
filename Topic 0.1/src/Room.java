public abstract class Room {

	// abstract room, represents a room of a house (needs to be extended
	// into a specific type "Kitchen, Garage, etc")

	private double size;
	private int windows;

	public Room(double size, int windows) {
		this.size = size;
		this.windows = windows;
	}

	public String toString() {
		return "Size: " + size + ", Windows: " + windows;
	}

	// setters n getters
	public double getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWindows() {
		return windows;
	}

	public void setWindows(int windows) {
		this.windows = windows;
	}

}
