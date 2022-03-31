/**
 * DiscountedPaper Subclass
 * Child of PaperProduct
 * Contains 2 private instance variables.
 * 4 constructors are established, including a deep copy constructor.
 * All constructors have parameters.
 * 3 public methods, 2 getters, and 2 setters compliment the class.
 * Null Pointer Exception checked for each of the 3 methods.
 * @author gcanales6
 * @version 1.0
 */

public class DiscountedPaper extends PaperProduct {
    private double discount;
    private GoldenTicket ticket;

    /**
     * Super constructor for an object of the DiscountedPaper subclass. Target for deep copy constructor.
     * @param name String representing the type of photo paper
     * @param numberOfSheets int representing the number of sheets to be ordered
     * @param weightOfUnitSheet double representing the weight of a single sheet
     * @param discount double representing the discount offered by the ticket
     * @param ticket GoldenTicket object detailing the ticket information
     */
    public DiscountedPaper(String name, int numberOfSheets, double weightOfUnitSheet, double discount,
        GoldenTicket ticket) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (discount > 0 && discount <= 50) {
            this.discount = discount;
        } else {
            this.discount = 15.0;
        }
        this.ticket = ticket;
    }

    /**
     * 2-args constructor for a DiscountedPaper object.
     * @param name String representing the type of photo paper
     * @param numberOfSheets int representing the number of sheets to be ordered
     */
    public DiscountedPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets);
        this.discount = 15.0;
        this.ticket = null;
    }

    /**
     * 1-args constructor for a DiscountedPaper.
     * @param name String representing the type of photo paper
     */
    public DiscountedPaper(String name) {
        super(name);
        this.discount = 15.0;
        this.ticket = null;
    }

    /**
     * Deep copy constructor for a DiscountedObject.
     * @param otherPaper DiscountedObejcts containing all the behaviors to copy.
     */
    public DiscountedPaper(DiscountedPaper otherPaper) {
        this(otherPaper.getName(), otherPaper.getNumberOfSheets(), otherPaper.getWeightOfUnitSheet(),
            otherPaper.getDiscount(), otherPaper.getTicket());
        this.ticket = new GoldenTicket(otherPaper.getTicket().getCatchphrase(),
            otherPaper.getTicket().getDiscount());
    }

    /**
     * discountedCost method to calculate the total cost after the original discount
     * and the golden ticket discount have been applied.
     * @return the double representing the total cost after the discounts
     */
    public double discountedCost() {
        double costAfterDiscount = 0;
        if (this != null) {
            costAfterDiscount = this.totalCost() - this.totalCost() * this.getDiscount() / 100.0;
            if (this.getTicket() != null) {
                costAfterDiscount -= costAfterDiscount * this.getTicket().getDiscount() / 100.0;
            }
        }
        return costAfterDiscount;
    }

    /**
     * shipDiscounted method creates a string depending on the current value of totalProductsToShip.
     * @param companyName a string containing the name of the company who placed the order
     * @return a string detailing if the shipment was started or if the Warehouse is empty
     */
    public String shipDiscounted(String companyName) {
        String str = null;
        if (this != null) {
            if (getTotalProductsToShip() > 0) {
                str = String.format("%s The total cost after the discount is %.2f.",
                    super.ship(companyName), this.discountedCost());
            } else if (getTotalProductsToShip() == 0) {
                str = String.format("%s The total cost after the discount is %.2f.",
                    super.ship(companyName), this.discountedCost());
            }
        }
        return str;
    }

    /**
     * botherAccounting method creates a string detailing the paper, discount, and golden
     * ticket information to the Accounting Department.
     * @return a string detailing the order information
     */
    public String botherAccounting() {
        String str = null;
        if (this != null) {
            str = String.format("Discounted Paper Product:\nOriginal Cost: %.2f\nFinal Cost: %.2f\n"
                + "Original Discount: %.2f%%\n",
                super.totalCost(), this.discountedCost(), this.getDiscount());
            if (this.getTicket() == null) {
                str += "Golden Ticket Discount: 0%";
            } else {
                str += String.format("Golden Ticket Discount: %.2f%%", this.getTicket().getDiscount());
            }
        }
        return str;
    }

    /**
     * Getter for the original discount to be applied (!= golden ticket discount).
     * @return the original discount to be applied to the order
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * Getter for the ticket, an instance of GoldenTicket.
     * @return the ticket, a GoldenTicket object
     */
    public GoldenTicket getTicket() {
        return this.ticket;
    }

    /**
     * Setter for the original discount to be applied (!= golden ticket discount).
     * @param discount new discount to be applied
     */
    public void setDiscount(double discount) {
        if (discount > 0 && discount <= 50) {
            this.discount = discount;
        } else {
            this.discount = 15.0;
        }
    }

    /**
     * Setter for the ticket, an instance of GoldenTicket.
     * @param ticket new golden ticket object
     */
    public void setTicket(GoldenTicket ticket) {
        this.ticket = ticket;
    }
}
