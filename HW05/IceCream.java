/**
 * IceCream Class.
 * This class extends the Dessert class.
 * This class describes a certain kind of dessert that Bob can pick: ice cream.
 * @author gcanales6
 * @version 1.0
 */

public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;

    /**
     * 4-args constructo for IceCream.
     * @param flavor String representing the flavor of the IceCream
     * @param sweetness double representing the sweetness of the IceCream
     * @param scoops int representing the number of scoops of the IceCream
     * @param cone boolean representing the presence of a waffle cone on the IceCream
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * 2-args constructor for IceCream.
     * @param scoops int representing the number of scoops of the IceCream
     * @param cone boolean representing the presence of the waffle cone on the IceCream
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }

    /**
     * No-args constructor for IceCream.
     */
    public IceCream() {
        this("vanilla", 45.0, 1, false);
    }

    @Override
    public String toString() {
        String hasCone = this.cone ? "has" : "does not have";
        return String.format("This is a %s ice cream with %d scoops and %s a cone.",
            this.getFlavor(), this.scoops, hasCone);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IceCream) {
            IceCream other = (IceCream) o;
            return (super.equals(o) && this.scoops == other.scoops && this.cone == other.cone);
        } else {
            return false;
        }
    }
}
