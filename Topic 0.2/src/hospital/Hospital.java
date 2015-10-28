package hospital;

import java.util.ArrayList;
import java.util.HashMap;


public class Hospital {
	
	//basic class that contains many HospitalFloors
	//and some methods to set and retrive them

	private ArrayList<HospitalFloor> floors;
	private boolean enabledByGoverment=false;
	
	public Hospital() {
		floors=new ArrayList<HospitalFloor>();
	}

	public void addFloor(HospitalFloor hf){
		floors.add(hf);
	}
	
	public void enableHospital(){
		enabledByGoverment=true;
	}
	
	@Override
	public String toString() {
		
		String ret = "Hospital: \n";
		for (int i = 0; i < floors.size(); i++) {
			ret += "Piso "+i+":\n";
			ret += (floors.get(i));
			ret += "\n";
		}
		return ret;
	}
	
}
