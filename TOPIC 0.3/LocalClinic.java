public class LocalClinic extends Hospital {

    protected LocalClinic(HospitalBuilder builder) {
        super(builder);
    }

    public LocalClinic(){
        this.waitingRooms = 2;
        this.wards = 2;
    }
}
