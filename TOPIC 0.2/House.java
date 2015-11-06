public class House {
    private final int bedrooms;
    private final int livingrooms;
    private final int kitchens;
    private final int backyards;
    private final int bathrooms;

    private House(Builder builder){
        this.bedrooms = builder.bedrooms;
        this.livingrooms = builder.livingrooms;
        this.kitchens = builder.kitchens;
        this.backyards = builder.backyards;
        this.bathrooms = builder.bathrooms;
    }

    public static class Builder{
        private final int bedrooms;
        private int livingrooms = 0;
        private int kitchens = 0;
        private int backyards = 0;
        private int bathrooms = 0;

        public Builder(int bedrooms) {
            this.bedrooms = bedrooms;
        }

        public Builder addLivingRoom(){
            this.livingrooms++;
            return this;
        }

        public Builder addKitchen(){
            this.kitchens++;
            return this;
        }

        public Builder addBackyard(){
            this.backyards++;
            return this;
        }

        public Builder addBathroom(){
            this.bathrooms++;
            return this;
        }

        public House build(){
            return new House(this);
        }
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getLivingrooms() {
        return livingrooms;
    }

    public int getKitchens() {
        return kitchens;
    }

    public int getBackyards() {
        return backyards;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "bedrooms=" + bedrooms +
                ", livingrooms=" + livingrooms +
                ", kitchens=" + kitchens +
                ", backyards=" + backyards +
                ", bathrooms=" + bathrooms +
                '}';
    }
}
