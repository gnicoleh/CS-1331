/**
 * Car Class.
 * A child of Vehicle.
 * This class represents a regular car in your transportation network.
 * Contains 3 private instance variables.
 * Contains a 6-arg constructor, a 3-arg constructor, and a 1-arg constructor.
 * It has a total of 11 methods broken down as follows:
 * - 3 methods inherited from Vehicle to be implemented by Car
 * - 2 overridden methods from Vehicle: equals() and toString()
 * - 3 pairs of getters and setters: rate, fees, and maxNumMiles
 * @author gcanales6
 * @version 1.3
 */

public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;

    /**
     * Super target constructor for a Car object.
     * @param id String representing the Car's identifier
     * @param numMiles int representing the number of miles the Car has traveled
     * @param passengers String[] representing the  names of the passengers aboard the Car
     * @param rate double representing the cost of dollars per mile of the Car
     * @param fees double representing a flat one-time charge for using the Car
     * @param maxNumMiles int representing the maximum number of miles a Car can ever travel
     */
    public Car(String id, int numMiles, String[] passengers, double rate,
        double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /**
     * 3-args conctructor for a Car object.
     * @param id String representing the Car's identifier
     * @param numMiles int representing the number of miles the Car has traveled
     * @param maxNumMiles int representing the maximum number of miles a Car can ever travel
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10, 15, maxNumMiles);
    }

    /**
     * 1-args constructor for a Car object.
     * @param id String representing the vehicle's identifier
     */
    public Car(String id) {
        this(id, 0, new String[4], 10, 15, 200);
    }

    @Override // from Vehicle
    /**
     * Implementation of abstract method from Vehicle.
     * @param distance int representing the distance to be traveled by the Car
     * @return boolean representing if the Car can travel the distance given
     */
    public boolean canDrive(int distance) {
        return (distance >= 0 && this.maxNumMiles - this.numMiles >= distance);
    }

    @Override // from Vehicle
    /**
     * Implementation of abstract method from Vehicle.
     * @param distance int representing the distance to be traveled by the Car
     * @return double representing the total cost of the trip
     */
    public double calculateCost(int distance) {
        double totalCost = -1;
        if (distance >= 0 && this.canDrive(distance)) {
            totalCost = (double) distance * rate + fees;
            return totalCost;
        } else {
            return totalCost;
        }
    }

    @Override // from Vehicle
    /**
     * Implementation of abstract method from Vehicle.
     * @param distance int representing the distance to be traveled by the Car
     * @param passengers String[] representing the  names of the passengers to board the Car
     * @return boolean representing if the passengers were successfully added to the Car
     */
    public boolean addPassenger(int distance, String[] passengers) {
        int emptySeats = 0;
        for (String s : this.passengers) {
            if (s == null) {
                emptySeats++;
            }
        }
        int newPassengerCount = 0;
        if (passengers.length <= emptySeats && this.canDrive(distance)) {
            for (int i = 0; i < passengers.length; i++) {
                if (this.passengers[i] == null) {
                    this.passengers[i] = passengers[newPassengerCount];
                    newPassengerCount++;
                }
            }
            this.chargeRide(distance);
            return true;
        } else {
            return false;
        }
    }

    @Override // from Vehicle
    /**
     * Overrides Vehicle equals().
     * @param other Obejct representing the Car to be compared
     * @return boolean representing if the objects compared are equal
     */
    public boolean equals(Object other) {
        if (other instanceof Car) {
            Car otherCar = (Car) other;
            return (super.equals(other)
                && this.rate == otherCar.rate && this.fees == otherCar.fees
                && this.maxNumMiles == otherCar.maxNumMiles);
        } else {
            return false;
        }
    }

    @Override // from Vehicle
    /**
     * Overrides Vehicle toString().
     * @return String representing information about the Car
     */
    public String toString() {
        return "Car " + super.toString() + String.format(" It can only drive %d miles. "
            + "It costs %.2f dollars per mile and there is a one-time fee of %.2f dollars.",
            this.maxNumMiles, this.rate, this.fees);
    }

    /**
     * Getter for the rate the Car charges.
     * @return double representing the rate amount
     */
    public double getRate() {
        return this.rate;
    }
    /**
     * Getter for the fees the Car charges.
     * @return double representing the fees amount
     */

    public double getFees() {
        return this.fees;
    }

    /**
     * Getter for the maximum number of miles a Car can ever travel.
     * @return int representing the maximum number of miles
     */
    public int getMaxNumMiles() {
        return this.maxNumMiles;
    }

    /**
     * Setter for the rate of a Car.
     * @param rate double representing the new rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Setter for the fees of a Car.
     * @param fees double representing the new fees
     */
    public void setFees(double fees) {
        this.fees = fees;
    }

    /**
     * Setter for the maximum number of miles a Car can ever travel.
     * @param maxNumMiles int representing the new maximum number of miles
     */
    public void setMaxNumMiles(int maxNumMiles) {
        this.maxNumMiles = maxNumMiles;
    }
}
