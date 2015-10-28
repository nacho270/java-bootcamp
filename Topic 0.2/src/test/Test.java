package test;

import factory.Factory;
import hospital.Hospital;
import src.Director;
import src.FloorBuilder;

public class Test {
public static void main(String[] args) {
	
	
	FloorBuilder builder = (FloorBuilder) Factory.getBuilderInstance();
	Director dir = new Director(builder,6);
	dir.construct();
	Hospital hospital = dir.getHospital();
	System.out.println(hospital);
}
	
	
}
