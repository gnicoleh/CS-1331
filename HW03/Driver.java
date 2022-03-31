/**
 * Driver Class.
 * Driver file for Vehicle, Car, and Bus classes.
 * Contains 4 Car objects and 4 Bus objects.
 * Only contains the main method.
 * @author gcanales6
 * @version 1.3
 */

public class Driver {
    /**
     * main method.
     * @param args String[] representing the contents of the main method
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------");
        System.out.println("---------------------- CAR TESTS ---------------------");
        System.out.println("------------------------------------------------------");
        String[] carpoolPassengers = new String[]{"Zach", "Nicole"};
        String[] moreCarPassengers = new String[]{"Helena", "Daniel", "Jackson", "Austin", "Luis"};
        String[] extraPassengers = new String[]{"Zach", "Helena", "Nicole", "Tristan"};
        Car car1 = new Car("Car 1", 1500, new String[10], 25, 13, 2500);
        Car car2 = new Car("Car 2", 750, 10000);
        Car car3 = new Car("Car", 3000, new String[7], 30, 0, 50000);
        Car car4 = new Car("Car", 3000, new String[7], 30, 0, 50000);
        System.out.println("BEFORE ANY METHOD CALL: EARNINGS\tNUM MILES");
        System.out.println("\tCAR 1: \t\t" + car1.getEarnings() + "\t\t" + car1.getNumMiles());
        System.out.println("\tCAR 2: \t\t" + car2.getEarnings() + "\t\t" + car2.getNumMiles());
        System.out.println("Passengers successfully added to Car 1: " + car1.addPassenger(500, extraPassengers));
        System.out.println("Passengers successfully added to Car 2: " + car2.addPassenger(-700, carpoolPassengers));
        System.out.println("1ST ADD PASSENGERS CALL: EARNINGS\tNUM MILES");
        System.out.println("\tCAR 1: \t\t" + car1.getEarnings() + "\t\t" + car1.getNumMiles());
        System.out.println("\tCAR 2: \t\t" + car2.getEarnings() + "\t\t" + car2.getNumMiles());
        System.out.println("Passengers successfully added to Car 1: " + car1.addPassenger(300, moreCarPassengers));
        System.out.println("Passengers successfully added to Car 2: " + car2.addPassenger(700, carpoolPassengers));
        System.out.println("2ND ADD PASSENGERS CALL: EARNINGS\tNUM MILES");
        System.out.println("\tCAR 1: \t\t" + car1.getEarnings() + "\t\t" + car1.getNumMiles());
        System.out.println("\tCAR 2: \t\t" + car2.getEarnings() + "\t\t" + car2.getNumMiles());
        String stringCar1 = car1.toString();
        String stringCar2 = car2.toString();
        System.out.println(stringCar1);
        System.out.println(stringCar2);
        System.out.println("Are car1 and car2 equal? " + car1.equals(car2));
        System.out.println("Are car3 and car4 equal? " + car3.equals(car4));

        System.out.println("------------------------------------------------------");
        System.out.println("---------------------- BUS TESTS ---------------------");
        System.out.println("------------------------------------------------------");
        String[] busPassengers = new String[]{"Terry", "Yakee", null, "General Tso's", null, null, "Porkchop", null,
            "Stir Fry", "Ramen", "Onigiri", "Sriracha", "Green Onions"};
        String[] morePassengers = new String[]{"Heather", "Alex", "Tom", "Juan", "Santiago", "Miguel", "Fernanda",
            "Helena", "Daniel", "Jackson", "Austin", "Luis"};
        Bus bus1 = new Bus("Bus 1", 1500, "Ocotepeque", 5);
        Bus bus2 = new Bus("Bus 2", "Druid Hills");
        Bus bus3 = new Bus("Bus", 7000, "The World", 3);
        Bus bus4 = new Bus("Bus", 7000, "The World", 3);
        System.out.println("BEFORE ANY METHOD CALL: EARNINGS\tNUM MILES");
        System.out.println("\tBUS 1: \t\t" + bus1.getEarnings() + "\t\t" + bus1.getNumMiles());
        System.out.println("\tBUS 2: \t\t" + bus2.getEarnings() + "\t\t" + bus2.getNumMiles());
        System.out.println("Passengers successfully added to Bus 1: " + bus1.addPassenger(500, busPassengers));
        System.out.println("Passengers successfully added to Bus 2: " + bus2.addPassenger(700, morePassengers));
        System.out.println("1ST ADD PASSENGERS CALL: EARNINGS\tNUM MILES");
        System.out.println("\tBUS 1: \t\t" + bus1.getEarnings() + "\t\t" + bus1.getNumMiles());
        System.out.println("\tBUS 2: \t\t" + bus2.getEarnings() + "\t\t" + bus2.getNumMiles());
        System.out.println("Passengers successfully added to Bus 1: " + bus1.addPassenger(300, morePassengers));
        System.out.println("Passengers successfully added to Bus 2: " + bus2.addPassenger(-500, morePassengers));
        System.out.println("2ND ADD PASSENGERS CALL: EARNINGS\tNUM MILES");
        System.out.println("\tBUS 1: \t\t" + bus1.getEarnings() + "\t\t" + bus1.getNumMiles());
        System.out.println("\tBUS 2: \t\t" + bus2.getEarnings() + "\t\t" + bus2.getNumMiles());
        String stringBus1 = bus1.toString();
        String stringBus2 = bus2.toString();
        System.out.println(stringBus1);
        System.out.println(stringBus2);
        System.out.println("Are bus1 and bus2 equal? " + bus1.equals(bus2));
        System.out.println("Are bus3 and bus4 equal? " + bus3.equals(bus4));
    }
}
