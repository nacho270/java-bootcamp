package implementations;

import hospital.HospitalFloor;
import src.FloorBuilder;

public class CheapBuilder implements FloorBuilder{
	
	// a builder that constructs an HospitalFloor, set its properties and return it

	private HospitalFloor hf;
	
	public CheapBuilder(){
		makeNewFloor();
	}
	
	public void makeNewFloor(){
		hf=new HospitalFloor();
	}
	
	public void buildWaitingRoom() {
		int random = (int) (Math.random()*10);
		switch (random) {
		case 0:case 1:case 2:case 3:
			hf.setWaitingRoom("small waiting room with poor light");
			break;
		case 4:case 5:case 6:case 7:	
			hf.setWaitingRoom("bad smelling waiting room");
		default:
			hf.setWaitingRoom("big waiting room, ugly paint");
			break;
		}
		
	}

	@Override
	public void buildPatientRoom() {
		int random = (int) (Math.random()*10);
		switch (random) {
		case 0:case 1:case 2:case 3:
			hf.setPatientRoom("small room");
			break;
		case 4:case 5:case 6:case 7:	
			hf.setPatientRoom("room without tv");
		default:
			hf.setPatientRoom("room without windows");
			break;
		}
		
	}

	@Override
	public void setEquipment() {
		int random = (int) (Math.random()*10);
		switch (random) {
		case 0:case 1:case 2:case 3:
			hf.setEquipment("poor quality equipment");
			break;
		case 4:case 5:case 6:case 7:	
			hf.setEquipment("2nd hand equipment");
		default:
			hf.setEquipment("2nd hand equipment");
			break;
		}
		
	}
	
	public HospitalFloor getHospitalFloor(){
		return hf;
	}

}
