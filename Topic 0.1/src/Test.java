public class Test {
	public static void main(String[] args) {

		// create a house, add some rooms and then show trough console the info
		// of the house
		House myHouse = new House(500.40, "Phalama 342", 1307, 1);
		myHouse.addRoom(new Kitchen(145.60, 3, true), 0);
		myHouse.addRoom(new Bathroom(100.50, 1, false), 0);
		myHouse.addRoom(new Dorm(100.50, 2, 2), 1);
		myHouse.addRoom(new Dorm(50.50, 3, 2), 1);
		myHouse.addRoom(new Dorm(80.50, 2, 1), 1);
		System.out.println(myHouse);

	}
}
