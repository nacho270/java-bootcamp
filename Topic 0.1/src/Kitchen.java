public class Kitchen extends Room {

	private boolean dinnerTable;

	public Kitchen(double size, int windows, boolean dinnerTable) {
		super(size, windows);
		this.dinnerTable = dinnerTable;
	}

	public boolean isDinnerTable() {
		return dinnerTable;
	}

	public void setDinnerTable(boolean dinnerTable) {
		this.dinnerTable = dinnerTable;
	}

	public String toString() {

		return "Kitchen: " + super.toString() + " Dinner Table: " + (dinnerTable ? "YES" : "NO");
	}
}
