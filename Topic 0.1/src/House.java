import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class House extends Terrain {

	private HashMap<Integer, ArrayList<Room>> houseFloors;

	public House(double d, String address, int zipCode, int floors) {
		super(d, address, zipCode);
		createFloors(floors);
	}

	// initialize HashMap(floors) and ArrayList(rooms)
	private void createFloors(int floors) {
		houseFloors = new HashMap<Integer, ArrayList<Room>>();
		for (int i = 0; i <= floors; i++) {
			houseFloors.put(i, new ArrayList<Room>());
		}
	}

	// adding a room into a specific floor
	public void addRoom(Room room, int floor) {
		houseFloors.get(floor).add(room);
	}

	public String toString() {

		String houseInfo = super.toString() + "House Info:\n";

		for (int i = 0; i < houseFloors.size(); i++) {
			houseInfo += "Floor " + i + "\n";
			for (int j = 0; j < houseFloors.get(i).size(); j++) {
				houseInfo += houseFloors.get(i).get(j).toString() + "\n";
			}
			houseInfo += "\n";
		}
		return houseInfo;
	}

}
