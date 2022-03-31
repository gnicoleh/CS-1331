/**
 * Dessert Class.
 * This class is the superclass for the dessert classes Cake and IceCream
 * @author gcanales6
 * @version 1.0
 */


public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;

    /**
     * 2-args constructor for Dessert. To be used by its children.
     * @param flavor String representing the flavor of the Dessert
     * @param sweetness double representing the sweetness of the Dessert
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }

    /**
     * No-args constructor for Dessert.
     */
    public Dessert() {
        this("vanilla", 25.0);
    }

    @Override
    public String toString() {
        return String.format("This is a %s dessert with a sweetness of %.2f.",
            this.flavor, this.sweetness);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dessert) {
            Dessert other = (Dessert) o;
            return (this.flavor.equals(other.flavor) && this.sweetness == other.sweetness);
        } else {
            return false;
        }
    }

    /**
     * Implementation of compareTo() from Comparable Interface.
     * @param other Dessert to be used in the comparison
     * @return int representing the results of the comparison
     */
    public int compareTo(Dessert other) {
        double sweeter = this.sweetness - other.sweetness;
        if (sweeter != 0) {
            return (int) sweeter;
        } else {
            return this.flavor.compareTo(other.flavor);
        }
    }

    /**
     * Getter for Flavor.
     * @return String representing the current flavor of the Dessert
     */
    public String getFlavor() {
        return this.flavor;
    }

    /**
     * Getter for Sweetness.
     * @return String representing the current sweetness of the Dessert
     */
    public double getSweetness() {
        return this.sweetness;
    }
}