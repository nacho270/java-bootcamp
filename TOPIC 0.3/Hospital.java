public class Hospital {

    protected int operatingRooms;
    protected int waitingRooms;
    protected int wards;
    protected int therapistCabinets;
    protected int restrooms;

    protected Hospital(HospitalBuilder builder){
        this.operatingRooms = builder.operatingRooms;
        this.waitingRooms = builder.waitingRooms;
        this.wards = builder.wards;
        this.therapistCabinets = builder.therapistCabinets;
        this.restrooms = builder.restrooms;
    }

    public Hospital() {
        int operatingRooms=0;
        int waitingRooms=0;
        int wards=0;
        int therapistCabinets=0;
        int restrooms=0;
    }

    public static class HospitalBuilder{
        int operatingRooms;
        int waitingRooms;
        int wards;
        int therapistCabinets;
        int restrooms;

        public HospitalBuilder(){
            operatingRooms=0;
            waitingRooms=0;
            wards=0;
            therapistCabinets=0;
            restrooms=0;
        }

        public HospitalBuilder addOperatingRoom(){
            this.operatingRooms++;
            return this;
        }

        public HospitalBuilder addWaitingRoom(){
            this.waitingRooms++;
            return this;
        }

        public HospitalBuilder addWard(){
            this.wards++;
            return this;
        }

        public HospitalBuilder addTherapistCabinet(){
            this.therapistCabinets++;
            return this;
        }

        public HospitalBuilder addRestroom(){
            this.restrooms++;
            return this;
        }

        public Hospital build(){
            return new Hospital(this);
        }

    }

    @Override
    public String toString() {
        return "Hospital{" +
                "operatingRooms=" + operatingRooms +
                ", waitingRooms=" + waitingRooms +
                ", wards=" + wards +
                ", therapistCabinets=" + therapistCabinets +
                ", restrooms=" + restrooms +
                '}';
    }

    public int getOperatingRooms() {
        return operatingRooms;
    }

    public void setOperatingRooms(int operatingRooms) {
        this.operatingRooms = operatingRooms;
    }

    public int getWaitingRooms() {
        return waitingRooms;
    }

    public void setWaitingRooms(int waitingRooms) {
        this.waitingRooms = waitingRooms;
    }

    public int getWards() {
        return wards;
    }

    public void setWards(int wards) {
        this.wards = wards;
    }

    public int getTherapistCabinets() {
        return therapistCabinets;
    }

    public void setTherapistCabinets(int therapistCabinets) {
        this.therapistCabinets = therapistCabinets;
    }

    public int getRestrooms() {
        return restrooms;
    }

    public void setRestrooms(int restrooms) {
        this.restrooms = restrooms;
    }
}
