/**
 * Golden Ticket Class
 * Contains 2 private instance variables.
 * 2 constructors are established. All constructors have parameters.
 * 2 getters and 2 setters compliment the class.
 * @author gcanales6
 * @version 1.0
 */

public class GoldenTicket {
    private String catchphrase;
    private double discount;

    /**
     * Constructor for a GoldenTicker object.
     * @param catchphrase String representing the catchphrase printed on the ticket
     * @param discount double representing the discount offered by the ticket
     */
    public GoldenTicket(String catchphrase, double discount) {
        if (catchphrase == null || catchphrase.isEmpty()) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
        if (discount > 0 && discount <= 25) {
            this.discount = discount;
        } else {
            this.discount = 15.0;
        }
    }

    /**
     *  * ticketString method creates a string detailing the amount of the discount
     * and the catchphrase printed on it.
     * @return the string detailing the information of the golden ticket
     */
    public String ticketString() {
        String str = String.format("Golden Ticket with a %.2f%% discount! %s",
            this.getDiscount(), this.getCatchphrase());
        return str;
    }

    /**
     * Getter for the catchphrase printed on the GoldenTicket object.
     * @return a String representing the catchphrase for the golden ticket
     */
    public String getCatchphrase() {
        return this.catchphrase;
    }

    /**
     * Getter for the discount to be printed on the GoldenTicket object.
     * @return a double representing the discount on the golden ticket
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * Setter for the catchphrase of the GoldenTicket object
     * (If new catchphrase is empty/null it defualts to "Congrats!").
     * @param catchphrase new catchphrase of the golden ticket
     */
    public void setCatchphrase(String catchphrase) {
        if (catchphrase == null || catchphrase.isEmpty()) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
    }

    /**
     * Setter for the discount of the GoldenTicket object (range (0, 25], else, defaults to 15.0).
     * @param discount new discount to be printed on the golden ticket
     */
    public void setDiscount(double discount) {
        if (discount > 0 && discount <= 25) {
            this.discount = discount;
        } else {
            this.discount = 15.0;
        }
    }
}
