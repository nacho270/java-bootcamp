package hospital;
import java.util.ArrayList;


public class HospitalFloor {
	
	//basic class that contains 3 types of rooms and its properties
	
	private String patientRoom;
	private String waitingRoom;
	private String equipment;
	
	public String getPatientRoom() {
		return patientRoom;
	}
	public void setPatientRoom(String patientRoom) {
		this.patientRoom = patientRoom;
	}
	public String getWaitingRoom() {
		return waitingRoom;
	}
	public void setWaitingRoom(String waitingRoom) {
		this.waitingRoom = waitingRoom;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		String ret="Waiting Rooms: "+waitingRoom+"\n"
				+ "Patient Rooms: "+patientRoom+"\n"
				+ "Equipment: "+equipment+"\n";
		
		return ret;
			
	}
	
	
}
