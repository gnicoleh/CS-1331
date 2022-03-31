/**
 * PaperProduct Class
 * Parent class for PhotoPaper and Discounted Paper.
 * Contains 3 priivate instance variables and 2 private static variables.
 * All constructors have parameters.
 * 4 constructors are established, including a deep copy constructor.
 * 4 public methods, 4 getters, and 1 setter compliment the class.
 * Null Pointer Exception checked for each of the 4 methods.
 * @author gcanales6
 * @version 1.0
 */

public class PaperProduct {
    private final String name;
    private int numberOfSheets;
    private final double weightOfUnitSheet;
    private static int totalProductsToShip = 10;
    public static final double COST_PER_GRAM = 0.025;

    /**
     * Target constructor for PaperProduct. Target for deep copy constructor.
     * @param name String describing the type of paper to be ordered
     * @param numberOfSheets int describing the number of sheets to be ordered
     * @param weightOfUnitSheet double describing the weight of each sheet to be ordered
     */
    public PaperProduct(String name, int numberOfSheets, double weightOfUnitSheet) {
        if (name == null || name.isEmpty()) {
            this.name = "A4";
        } else {
            this.name = name;
        }
        if (numberOfSheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = numberOfSheets;
        }
        if (weightOfUnitSheet < 0) {
            this.weightOfUnitSheet = 0.25;
        } else {
            this.weightOfUnitSheet = weightOfUnitSheet;
        }
    }

    /**
     * 2-args constructor for PaperProduct.
     * @param name String describing the type of paper to be ordered
     * @param numberOfSheets int describing the number of sheets to be ordered
     */
    public PaperProduct(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25);
    }

    /**
     * 1-args constructor for PaperProduct.
     * @param name String describing the type of paper to be ordered
     */
    public PaperProduct(String name) {
        this(name, 500, 0.25);
    }

    /**
     * Deep copy constructor for an instance of PaperProduct.
     * @param otherProduct PaperProduct object to be copied
     */
    public PaperProduct(PaperProduct otherProduct) {
        this(otherProduct.getName(), otherProduct.getNumberOfSheets(), otherProduct.getWeightOfUnitSheet());
    }

    /**
     * totalWeight method to calculate the total weight of a PaperProduct object.
     * @return total weight of the given PaperProduct object
     */
    public double totalWeight() {
        double totalWeight = 0;
        if (this != null) {
            totalWeight = this.getNumberOfSheets() * this.getWeightOfUnitSheet();
        }
        return totalWeight;
    }

    /**
     * totalCost method to calculate the total cost per weight of a PaperProduct object.
     * @return total cost per weight of the given PaperProduct object
     */
    public double totalCost() {
        double totalCost = 0;
        if (this != null) {
            totalCost = this.totalWeight() * COST_PER_GRAM;
        }
        return totalCost;
    }

    /**
     * paperString method creates a string detailing the amount of grams of a given
     * and the total cost per weight of the given PaperProduct object.
     * @return the string detailing the information calculated
     */
    public String paperString() {
        String str = null;
        if (this != null) {
            str = String.format("%.2fg of %s for $%.2f",
                this.totalWeight(), this.getName(), this.totalCost());
        }
        return str;
    }

    /**
     * ship method creates a string depending on the current value of totalProductsToShip.
     * @param companyName a string containing the name of the company who placed the order
     * @return a string detailing if the shipment was started or if the Warehouse is empty
     */
    public String ship(String companyName) {
        String str = null;
        if (this != null) {
            if (totalProductsToShip > 0) {
                str = "Shipped " + this.paperString() + " to " + companyName + ".";
                totalProductsToShip -= 1;
            } else if (totalProductsToShip == 0) {
                str = "Cannot ship any items, Warehouse is empty!";
            }
        }
        return str;
    }

    /**
     * Getter for the name of the given PaperProduct object.
     * @return current name of the PaperProduct object (cannot be empty/null)
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the number of sheets ordered of the given PaperProduct.
     * @return current number of paper sheets (positive integer)
     */
    public int getNumberOfSheets() {
        return this.numberOfSheets;
    }

    /**
     * Getter for the weight of unit sheet of the given PaperProduct object.
     * @return current weight of one sheet of the specified paper (positive double)
     */
    public double getWeightOfUnitSheet() {
        return this.weightOfUnitSheet;
    }

    /**
     * Getter for the total of paper products that can be shipped to a company.
     * @return current total of products that can be shipped (positive integer)
     */
    public static int getTotalProductsToShip() {
        return totalProductsToShip;
    }

    /**
     * Setter for the number of sheets of a PaperProduct instance.
     * @param numberOfSheets new number of sheets of given PaperProduct (must be a positve integer)
     */
    public void setNumberOfSheets(int numberOfSheets) {
        if (numberOfSheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = numberOfSheets;
        }
    }
}