/**
 * Vehicle Class.
 * Abstract parent of Car and Bus.
 * This class represents any vehicle to get around the city.
 * Contains 4 instance variables, 2 private and 2 protected.
 * Contains a 3-args constructor and a 2-args constructor.
 * It has a total of 10 methods broken down as follows:
 * - 3 abstract methods
 * - 1 concrete method
 * - 2 overridden methods: equals() and toString()
 * - 2 pairs of getters and setters: earnings and numMiles
 * @author gcanales6
 * @version 1.3
 */

public abstract class Vehicle {
    private final String id;
    private double earnings;
    protected int numMiles;
    protected String[] passengers;

    /**
     * Target constructor to be used by any child of Vehicle.
     * @param id String representing the Vehicle's identifier
     * @param numMiles int representing the number of miles the Vehicle has traveled
     * @param passengers String[] representing the  names of the passengers aboard the Vehicle
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers = passengers;
        this.earnings = 0;
    }

    /**
     * 2-args constructor for any child of Vehicle.
     * @param id String representing the Vehicle's identifier
     * @param passengers String[] representing the  names of the passengers aboard the Vehicle
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /**
     * Abstract method to be implemented by any child of Vehicle.
     * @param distance int representing the distance to be traveled by the Vehicle
     * @return boolean representing if the Vehicle can travel the distance given
     */
    public abstract boolean canDrive(int distance);

    /**
     * Abstract method to be implemented by any child of Vehicle.
     * @param distance int representing the distance to be traveled by the Vehicle
     * @return double representing the total cost of the trip
     */
    public abstract double calculateCost(int distance);

    /**
     * Abtract method to be implemented by any child of Vehicle.
     * @param distance int representing the distance to be traveled by the Vehicle
     * @param newPassengers String[] representing the  names of the passengers to board the Vehicle
     * @return boolean representing if the passengers were successfully added to the Vehicle
     */
    public abstract boolean addPassenger(int distance, String[] newPassengers);

    /**
     * Increases numMiles and earnings if the Vehicle can drive the distance given.
     * @param distance int representing the distance to be traveled by the Vehicle
     */
    public void chargeRide(int distance) {
        this.setNumMiles(this.getNumMiles() + distance);
        this.setEarnings(this.getEarnings() + this.calculateCost(distance));
    }

    /**
     * Overrides Object equals(Object o).
     * @param other Object representing the Vehicle object to be evaluated
     * @return boolean representing if the comparison was true or false
     */
    public boolean equals(Object other) {
        if (other instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) other;
            return (this.id.equals(vehicle.id)
                && this.numMiles == vehicle.numMiles);
        } else {
            return false;
        }
    }

    /**
     * Overrides Object toString().
     * @return String representing information about the Vehicle
     */
    public String toString() {
        return String.format("%s has driven %d miles and has earned %.2f dollars.",
            this.id, this.numMiles, this.earnings);
    }

    /**
     * Getter for the earnings of a Vehicle.
     * @return current value for earnings
     */
    public double getEarnings() {
        return this.earnings;
    }

    /**
     * Getter for the number of miles a Vehicle has travled thus far.
     * @return current value for numMiles
     */
    public int getNumMiles() {
        return this.numMiles;
    }

    /**
     * Setter for the earnings of a Vehicle.
     * @param earnings double representing the new value for earnings
     */
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    /**
     * Setter for the number of miles a Vehicle has traveled thus far.
     * @param numMiles int representing the new value for numMiles
     */
    public void setNumMiles(int numMiles) {
        this.numMiles = numMiles;
    }
}