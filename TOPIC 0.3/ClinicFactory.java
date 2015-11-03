public class ClinicFactory extends HospitalFactory{
    @Override
    public Hospital getHospital(String type) {
        if(type.equals("local")){ return new LocalClinic();}
        else { return new AmbulanceClinic();}
    }
}
