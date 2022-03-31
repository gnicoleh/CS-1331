/**
 * Bus Class.
 * A child of Vehicle.
 * This class represents a regular bus in your transportation network.
 * Contains 2 private instance variables.
 * Constains a 4-args constructor and a 2-args constructor.
 * It has a total of 9 methods broken down as follows:
 * - 3 methods inherited from Vehicle to be implemented by Car
 * - 2 overridden methods from Vehicle: equals() and toString()
 * - 2 pairs of getters and setters: location and stopsPerMile
 * @author gcanales6
 * @version 1.3
 */

public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * Super target constructor for a Bus object.
     * @param id String representing the Bus's identifier
     * @param numMiles int representing the number of miles the Bus has traveled
     * @param location String representing the route the Bus travels through
     * @param stopsPerMile int representing the number of stops per mile the Bus makes
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * 2-args cosntructor for the Bus object.
     * @param id String representing the Bus's identifier
     * @param location String representing the route the Bus travels through
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }

    @Override // from Vehicle
    /**
     * Implementation of abstract method from Vehicle.
     * @param distance int representing the distance to be traveled by the Bus
     * @return boolean representing if the Bus can travel the distance given
     */
    public boolean canDrive(int distance) {
        return ((distance >= 0) ? true : false);
    }

    @Override // from Vehicle
    /**
     * Implementation of abstract method from Vehicle.
     * @param distance int representing the distance to be traveled by the Bus
     * @return double representing the total cost of the trip
     */
    public double calculateCost(int distance) {
        double totalCost = -1;
        if (this.canDrive(distance)) {
            totalCost = (double) distance * 3 / this.stopsPerMile;
            return totalCost;
        } else {
            return totalCost;
        }
    }

    @Override // from Vehicle
    /**
     * Implementation of abstract method from Vehicle.
     * @param distance int representing the distance to be traveled by the Bus
     * @param passengers String[] representing the  names of the passengers to board the Bus
     * @return boolean representing if the passengers were successfully added to the Bus
     */
    public boolean addPassenger(int distance, String[] passengers) {
        if (this.canDrive(distance)) {
            int newPassengerCount = 0;
            for (int i = 0; i < this.passengers.length; i++) {
                if (newPassengerCount < passengers.length) {
                    if (this.passengers[i] == null) {
                        this.passengers[i] = passengers[newPassengerCount];
                        newPassengerCount++;
                    }
                } else {
                    break;
                }
            }
            this.setEarnings(this.getEarnings() + this.calculateCost(distance) * newPassengerCount);
            this.setNumMiles(this.getNumMiles() + distance);
            return true;
        } else {
            return false;
        }
    }

    @Override // from Vehicle
    /**
     * Overrides Vehicle equals().
     * @param other Obejct representing the Bus to be compared
     * @return boolean representing if the objects compared are equal
     */
    public boolean equals(Object other) {
        if (other instanceof Bus) {
            Bus otherBus = (Bus) other;
            return (super.equals(other)
                && this.location.equals(otherBus.location)
                && this.stopsPerMile == otherBus.stopsPerMile);
        } else {
            return false;
        }
    }

    @Override // from Vehicle
    /**
     * Overrides Vehicle toString().
     * @return String representing information about the Bus
     */
    public String toString() {
        return "Bus " + super.toString() + String.format(" This bus drives around"
            + " %s and makes %d stops per mile.", this.location, this.stopsPerMile);
    }

    /**
     * Getter for the location of the Bus.
     * @return String representing the current location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Getter for the stops per mile made by the Bus.
     * @return int representing the current number of stops per mile
     */
    public int getStopsPerMile() {
        return this.stopsPerMile;
    }

    /**
     * Setter for the location of the Bus.
     * @param location String representing the new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Setter for the stops per mile made by the Bus.
     * @param stopsPerMile int representing the new stops per mile
     */
    public void setStopsPerMile(int stopsPerMile) {
        this.stopsPerMile = stopsPerMile;
    }
}
