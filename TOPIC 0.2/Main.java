public class Main {

    public static void main(String[] args) {
        House homeSweetHome = new House.Builder(3).addBathroom().addKitchen().addLivingRoom().addLivingRoom().build();
        System.out.println(homeSweetHome);
    }
}
