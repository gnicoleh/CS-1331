/**
 *
 * Cake Class.
 * This class extends the Dessert class.
 * This class describes a certain kind of dessert that Bo can pick: cakes.
 * @author gcanales6
 * @version 1.0
 */

public class Cake extends Dessert {
    private String frosting;

    /**
     * 3-args constructor for Cake.
     * @param flavor String representing the flavor of the Cake
     * @param sweetness double representing the sweetness of the Cake
     * @param frosting String representing the flavor of the frosting of the Cake
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }

    /**
     * 1-args constructor for Cake.
     * @param flavor String representing the flavor of the Cake
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }

    @Override
    public String toString() {
        return String.format("This is a %s cake with a %s frosting and has a sweetness of %.2f",
            this.getFlavor(), this.frosting, this.getSweetness());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cake) {
            Cake other = (Cake) o;
            return (super.equals(o) && this.frosting.equals(other.frosting));
        } else {
            return false;
        }
    }
}
