package data;

public class DataFactory {

	private static Data data;

	public static Data getDataAccsess() {
		if (data == null) {
			data = new Data();
		}
		return data;
	}
}
