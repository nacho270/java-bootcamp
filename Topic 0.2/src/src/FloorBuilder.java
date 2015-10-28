package src;

import hospital.HospitalFloor;

public interface FloorBuilder {

	void buildWaitingRoom();
	void buildPatientRoom();
	void setEquipment();
	HospitalFloor getHospitalFloor();
	void makeNewFloor();
}
