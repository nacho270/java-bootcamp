public class AbstractFactory {
    public HospitalFactory getFactory(String type){
        if(type.equals("clinic")) return new ClinicFactory();
        else {return new InfirmaryFactory();}
    }
}
