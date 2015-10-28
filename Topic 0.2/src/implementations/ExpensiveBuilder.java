package implementations;

import hospital.HospitalFloor;
import src.FloorBuilder;

// a builder that constructs an HospitalFloor, set its properties and return it

public class ExpensiveBuilder implements FloorBuilder{

	private HospitalFloor hf;
	
	public ExpensiveBuilder(){
		makeNewFloor();
	}
	
	public void makeNewFloor(){
		hf=new HospitalFloor();
	}
	
	public void buildWaitingRoom() {
		int random = (int) (Math.random()*10);
		switch (random) {
		case 0:case 1:case 2:case 3:
			hf.setWaitingRoom("very big waiting rooms");
			break;
		case 4:case 5:case 6:case 7:	
			hf.setWaitingRoom("great view and a lot of windows");
		default:
			hf.setWaitingRoom("waiting room with tv");
			break;
		}
		
	}

	@Override
	public void buildPatientRoom() {
		int random = (int) (Math.random()*10);
		switch (random) {
		case 0:case 1:case 2:case 3:
			hf.setPatientRoom("big room");
			break;
		case 4:case 5:case 6:case 7:	
			hf.setPatientRoom("room with 60\" tv");
		default:
			hf.setPatientRoom("room with great view");
			break;
		}
		
	}

	@Override
	public void setEquipment() {
		int random = (int) (Math.random()*10);
		switch (random) {
		case 0:case 1:case 2:case 3:
			hf.setEquipment("last technology equipment");
			break;
		case 4:case 5:case 6:case 7:	
			hf.setEquipment("1st hand equipment");
		default:
			hf.setEquipment("1st hand equipment");
			break;
		}
		
	}
	public HospitalFloor getHospitalFloor(){
		return hf;
	}

}
