/**
 * PhotoPaper Subclass
 * Child of PaperProduct
 * Contains 1 private instance variable.
 * 4 constructors are established, including a deep copy constructor.
 * All constructors have parameters.
 * 2 public methods, 1 getter, and 1 setter compliment the class.
 * Null Pointer Exception checked for each of the 2 methods.
 * @author gcanales6
 * @version 1.0
 */

public class PhotoPaper extends PaperProduct {
    private double glossiness;

    /**
     * Super constructor for an object of the PhotoPaper subclass. Target for deep copy constructor.
     * @param name String representing the type of photo paper
     * @param numberOfSheets int representing the number of sheets to be ordered
     * @param weightOfUnitSheet double representing the weight of a single sheet
     * @param glossiness double representing the amount of glossiness a given photo paper has
     */
    public PhotoPaper(String name, int numberOfSheets, double weightOfUnitSheet, double glossiness) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (glossiness >= 0 && glossiness <= 100) {
            this.glossiness = glossiness;
        } else {
            this.glossiness = 70;
        }
    }

    /**
     * 2-args constructor for a PhotoPaper object.
     * @param name String representing the type of photo paper
     * @param numberOfSheets int representing the number of sheets to be ordered
     */
    public PhotoPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets);
        this.glossiness = 70;
    }

    /**
     * 1-args constructor for a PhotoPaper object.
     * @param name String representing the type of photo paper
     */
    public PhotoPaper(String name) {
        super(name);
        this.glossiness = 70;
    }

    /**
     * Deep copy constructor for an instance of PhotoPaper.
     * @param otherPhoto PhotoPaper object to be copied (child of PaperProduct)
     */
    public PhotoPaper(PhotoPaper otherPhoto) {
        this(otherPhoto.getName(), otherPhoto.getNumberOfSheets(), otherPhoto.getWeightOfUnitSheet(),
            otherPhoto.getGlossiness());
    }

    /**
     * photoString method that provides details about the photo paper's attributes.
     * @return a string detailing the information of the object
     */
    public String photoString() {
        String str = null;
        if (this != null) {
            str = String.format("%.2f%% glossy and %s", this.getGlossiness(), super.paperString());
        }
        return str;
    }

    /**
     * shipPhoto method creates a string depending on the current value of totalProductsToShip.
     * @param companyName a string containing the name of the company who placed the order
     * @return a string detailing if the shipment was started or if the Warehouse is empty
     */
    public String shipPhoto(String companyName) {
        String str = null;
        if (this != null) {
            if (getTotalProductsToShip() > 0) {
                str = String.format("Paper is %.2f%% glossy. %s",
                    this.getGlossiness(), super.ship(companyName));
            } else if (getTotalProductsToShip() == 0) {
                str = String.format("Paper is %.2f%% glossy. %s",
                    this.getGlossiness(), super.ship(companyName));
            }
        }
        return str;
    }

    /**
     * Getter for the glossiness of a PhotoPaper object.
     * @return the amount of glossiness of the paper
     */
    public double getGlossiness() {
        return this.glossiness;
    }

    /**
     * Setter for the glossiness of a PhotoPaper object (range [0, 100] else, defaults to 70).
     * @param glossiness new amount of glossiness of the photo paper
     */
    public void setGlossiness(double glossiness) {
        if (glossiness >= 0 && glossiness <= 100) {
            this.glossiness = glossiness;
        } else {
            this.glossiness = 70;
        }
    }
}
