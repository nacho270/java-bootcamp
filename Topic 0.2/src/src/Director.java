package src;

import hospital.Hospital;

public class Director {
	
	//takes a builder and follows some steps to build 
	//HospitalFloors and finally build an Hospital
	
	FloorBuilder builder;
	Hospital hospital;
	int floors;

	public Director(FloorBuilder builder, int floors) {
		hospital= new Hospital();
		this.builder=builder;
		this.floors=floors;
	}
	
	public void construct(){
		for (int i = 0; i < floors; i++) {
			builder.makeNewFloor();
			builder.buildPatientRoom();
			builder.buildWaitingRoom();
			builder.setEquipment();
			hospital.addFloor(builder.getHospitalFloor());
		}
		hospital.enableHospital();
	}
	
	public Hospital getHospital(){
		return hospital;
	}

}
