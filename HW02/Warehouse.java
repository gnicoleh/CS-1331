/**
 * Warehouse Class
 * Driver file for PaperProduct, PhotoPaper, DiscountedPaper, and GoldenTicket classes.
 * Contains 5 PaperProduct objects, 5 PhotoPaper objects, 2 GoldenTicket objects
 * and 5 DIscountedPaper objects. Each object created has different arguments.
 * 11 helper methods compliment the class. No getters and setters.
 * A REQUIRED TESTS segment and a OWN TESTS CASES segment were created to test
 * the different methods, getters, and setters of the classes mentioned above.
 * @author gcanales6
 * @version 1.0
 */

public class Warehouse {
    /**
     * main class of this driver file.
     * @param args String[] representing the contents of the class
     */
    public static void main(String[] args) {
        // Creating PaperProduct objects. Last object is a copy
        PaperProduct product1 = new PaperProduct("Product 1", 250, 0.60);
        PaperProduct product2 = new PaperProduct(null, 700);
        PaperProduct product3 = new PaperProduct("Product 3");
        PaperProduct product4 = null;
        PaperProduct productCopy = new PaperProduct(product1);

        // Creating PhotoPaper objects. Last object is a copy
        PhotoPaper photo1 = new PhotoPaper("Photo 1", -200, 2.15, 100);
        PhotoPaper photo2 = new PhotoPaper("Photo 2", 500);
        PhotoPaper photo3 = new PhotoPaper("Photo 3");
        PhotoPaper photo4 = null;
        PhotoPaper photoCopy = new PhotoPaper(photo1);

        // Creating GoldenTicket objects
        GoldenTicket ticket1 = new GoldenTicket("Dattebayo!", 23);
        GoldenTicket ticket2 = null;

        // Creating DiscountedPaper objects. Last object is a copy
        DiscountedPaper paper1 = new DiscountedPaper("Paper 1", 357, 1.30, 0, ticket1);
        DiscountedPaper paper2 = new DiscountedPaper("Paper 2", 0);
        DiscountedPaper paper3 = new DiscountedPaper("Paper 3");
        DiscountedPaper paper4 = null;
        DiscountedPaper paperCopy = new DiscountedPaper(paper1);

        // ************ REQUIRED TESTS *************

        System.out.println("***********************************************");
        System.out.println("------- BEFORE SETTERS HAVE BEEN CALLED -------");
        System.out.println("***********************************************");
        printStatsForProducts(product1, product2, product3, product4, productCopy);
        printStatsForPhotos(photo1, photo2, photo3, photo4, photoCopy);
        printStatsForTickets(ticket1, ticket2);
        printStatsForPapers(paper1, paper2, paper3, paper4, paperCopy);
        System.out.println("**********************************************************");
        System.out.println("--------------------- MODIFICATION LOG -------------------");
        System.out.println("**********************************************************");
        System.out.println("************* SET PRODUCT COPY NUMSHEETS TO 333 **********");
        productCopy.setNumberOfSheets(333);
        System.out.println("************* SET PRODUCT 1 NUMSHEETS TO -1 **************");
        product1.setNumberOfSheets(-1);
        System.out.println("************* SET PHOTO COPY GLOSSINESS TO 200 ***********");
        photoCopy.setGlossiness(200);
        System.out.println("************* SET PHOTO 1 GLOSSINESS TO 30 ***************");
        photo1.setGlossiness(30);
        System.out.println("************* SET PHOTO 1 NUMSHEETS TO 100 ***************");
        photo1.setNumberOfSheets(100);
        System.out.println("************* SET PAPER COPY NUMSHEETS TO 499 ************");
        paperCopy.setNumberOfSheets(499);
        System.out.println("************* SET PAPER COPY OG DISCOUNT TO 10 ***********");
        paperCopy.setDiscount(10);
        System.out.println("************* SET PAPER COPY TICKET DISCOUNT TO 0 ********");
        paperCopy.getTicket().setDiscount(0);
        System.out.println("************* SET PAPER 1 NUMSHEETS TO 123 ***************");
        paper1.setNumberOfSheets(123);
        System.out.println("************* SET PAPER 1 OG DISCOUNT TO 13 **************");
        paper1.setDiscount(13);
        System.out.println("************* SET PAPER COPY CATCHPHRASE TO \"Sup\" ******");
        paperCopy.getTicket().setCatchphrase("Sup");
        System.out.println("************* SET PAPER 1 CATCHPHRASE TO \"Hello!\" ******");
        paper1.getTicket().setCatchphrase("Hello!");
        System.out.println("************* SET PAPER 2 TICKET TO TICKET 1 *************");
        paper2.setTicket(ticket1);
        System.out.println("************* SET PAPER 2 TICKETDISCOUNT TO 50 ***********");
        paper2.getTicket().setDiscount(50.0);
        System.out.println("**********************************************");
        System.out.println("------- AFTER SETTERS HAVE BEEN CALLED -------");
        System.out.println("**********************************************");
        printStatsForProducts(product1, product2, product3, product4, productCopy);
        printStatsForPhotos(photo1, photo2, photo3, photo4, photoCopy);
        printStatsForPapers(paper1, paper2, paper3, paper4, paperCopy);
        System.out.println("************************************************");
        System.out.println("------------ GOLDEN TICKET OBJECTS -------------");
        System.out.println("************************************************");
        System.out.println("Ticket1 catchphrase should be \"Hello!\": ---> " + ticket1.getCatchphrase());
        ticket1.setCatchphrase("");
        System.out.println("Ticket1 catchphrase should be \"Congrats!\": ---> " + ticket1.getCatchphrase());
        ticket1.setCatchphrase("New catchphrase!");
        System.out.println("Ticket1 catchphrase should be \"New catchphrase!\": ---> " + ticket1.getCatchphrase());
        System.out.println("*************************************************************");
        System.out.println("--------CALLING SHIPPING METHODS AND PRINTING RESULTS--------");
        System.out.println("*************************************************************");
        System.out.println("Total products to ship BEFORE shipping: " + PaperProduct.getTotalProductsToShip());
        printProductShip(product1, product2, product3, productCopy);
        printPhotoShip(photo1, photo2, photo3, photoCopy);
        printPaperShip(paper1, paper2, paper3, paperCopy);
        System.out.println("***************************************************************");
        System.out.println("------- CALLING BOTHERACCOUNTING() AND PRINTING RESULTS -------");
        System.out.println("***************************************************************");
        System.out.println("***********************");
        System.out.println("------- PAPER 1 -------");
        System.out.println("***********************");
        System.out.println(paper1.botherAccounting());
        System.out.println("***********************");
        System.out.println("------- PAPER 2 -------");
        System.out.println("***********************");
        System.out.println(paper2.botherAccounting());
        System.out.println("***********************");
        System.out.println("------- PAPER 3 -------");
        System.out.println("***********************");
        System.out.println(paper3.botherAccounting());
        System.out.println("------ PAPER 4 IS NULL -----"); //PAPER4 IS NULL, SO DECIDED NOT TO CALL METHOD
        System.out.println("**************************");
        System.out.println("------- PAPER COPY -------");
        System.out.println("**************************");
        System.out.println(paperCopy.botherAccounting());


        // ************ OWN TESTS CASES *************

        System.out.println("******************************************");
        System.out.println("------------ OWN TESTS CASES -------------");
        System.out.println("******************************************");
        DiscountedPaper paper = new DiscountedPaper("Name", -300, -1.33, 51.0, ticket1);
        System.out.println("Discount should be 15.0: ---> " + paper.getDiscount());
        System.out.printf("Cost after discount: %.2f\n", paper.discountedCost());
        System.out.println(paper.shipDiscounted("companyName"));
        System.out.println(paper.botherAccounting());
    }

    // *************** HELPER METHODS ****************

    /**
     * stringProductStats method creates a string detailing the attributes of a PaperProduct object.
     * @param product PaperProduct to be used to call the required methods
     * @return a String detailing the product information
     */
    private static String stringProductStats(PaperProduct product) {
        String str = null;
        if (product != null) {
            str = String.format("Name: %s\tNumSheets: %d\tWeight: %.2f",
                product.getName(), product.getNumberOfSheets(), product.getWeightOfUnitSheet());
        } else {
            str = "This product object is null";
        }
        return str;
    }

    /**
     * stringPhotoStats method creates a string detailing the attributes of a PhotoPaper object.
     * @param photo PhotoPaper to be used to call the required methods
     * @return a String detailing the photo information
     */
    private static String stringPhotoStats(PhotoPaper photo) {
        String str = null;
        if (photo != null) {
            str = String.format("Name: %s\tNumSheets: %d\tWeight: %.2f\tGlossiness: %.2f",
                photo.getName(), photo.getNumberOfSheets(), photo.getWeightOfUnitSheet(), photo.getGlossiness());
        } else {
            str = "This photo object is null";
        }
        return str;
    }

    /**
     * stringTicketStats method creates a string detailing the attributes of a GoldenTicket object.
     * @param ticket GoldenTicket to be used to call the required methods
     * @return a String detailing the ticket information
     */
    private static String stringTicketStats(GoldenTicket ticket) {
        String str = null;
        if (ticket != null) {
            str = String.format("Catchphrase: %s\tDiscount: %.2f",
                ticket.getCatchphrase(), ticket.getDiscount());
        } else {
            str = "This ticket object is null";
        }
        return str;
    }

    /**
     * stringPaperStats method creates a string detailing the attributes of a DiscountedPaper object.
     * @param paper DiscountedPaper to be used to call the required methods
     * @return a String containing the paper information
     */
    private static String stringPaperStats(DiscountedPaper paper) {
        String str = null;
        if (paper != null) {
            str = String.format("Name: %s\tNumSheets: %d\tWeight: %.2f\tOGDiscount: %.2f",
                paper.getName(), paper.getNumberOfSheets(), paper.getWeightOfUnitSheet(), paper.getDiscount());
            if (paper.getTicket() != null) {
                str += String.format("\tCatchphrase: %s\tTicDiscount: %.2f",
                    paper.getTicket().getCatchphrase(), paper.getTicket().getDiscount());
            } else {
                str += "\tThis ticket object is null";
            }
        }  else {
            str = "This paper object is null";
        }
        return str;
    }

    /**
     * printStatsForProducts method prints the information returned by stringProductStats() method.
     * @param product1 PaperProduct used to call the required method
     * @param product2 PaperProduct used to call the required method
     * @param product3 PaperProduct used to call the required method
     * @param product4 PaperProduct used to call the required method
     * @param productCopy PaperProduct used to call the required method
     */
    private static void printStatsForProducts(PaperProduct product1, PaperProduct product2, PaperProduct product3,
        PaperProduct product4, PaperProduct productCopy) {
        System.out.println("***********************************************");
        System.out.println("------------ PRODUCTPAPER OBJECTS -------------");
        System.out.println("***********************************************");
        System.out.printf("Product1:     %s\n", stringProductStats(product1));
        System.out.printf("Product2:     %s\n", stringProductStats(product2));
        System.out.printf("Product3:     %s\n", stringProductStats(product3));
        System.out.printf("Product4:     %s\n", stringProductStats(product4));
        System.out.printf("Product Copy: %s\n", stringProductStats(productCopy));
    }

    /**
     * printStatsForPhotos method prints the information returned by stringPhotoStats() method.
     * @param photo1 PhotoPaper used to call the required method
     * @param photo2 PhotoPaper used to call the required method
     * @param photo3 PhotoPaper used to call the required method
     * @param photo4 PhotoPaper used to call the required method
     * @param photoCopy PhotoPaper used to call the required method
     */
    private static void printStatsForPhotos(PhotoPaper photo1, PhotoPaper photo2, PhotoPaper photo3,
        PhotoPaper photo4, PhotoPaper photoCopy) {
        System.out.println("*********************************************");
        System.out.println("------------ PHOTOPAPER OBJECTS -------------");
        System.out.println("*********************************************");
        System.out.printf("Photo1:     %s\n", stringPhotoStats(photo1));
        System.out.printf("Photo2:     %s\n", stringPhotoStats(photo2));
        System.out.printf("Photo3:     %s\n", stringPhotoStats(photo3));
        System.out.printf("Photo4:     %s\n", stringPhotoStats(photo4));
        System.out.printf("Photo Copy: %s\n", stringPhotoStats(photoCopy));
    }

    /**
     * printStatsForTickets method prints the information returned by stringTicketStats() method.
     * @param ticket1 GoldenTicket used to call the required method
     * @param ticket2 GoldenTicket used to call the required method
     */
    private static void printStatsForTickets(GoldenTicket ticket1, GoldenTicket ticket2) {
        System.out.println("************************************************");
        System.out.println("------------ GOLDEN TICKET OBJECTS -------------");
        System.out.println("************************************************");
        System.out.printf("Ticket1: %s\n", stringTicketStats(ticket1));
        System.out.printf("Ticket2: %s\n", stringTicketStats(ticket2));
    }

    /**
     * printStatsForPapers method prints the information returned by stringPaperStats() method.
     * @param paper1 DiscountedPaper used to call the required method
     * @param paper2 DiscountedPaper used to call the required method
     * @param paper3 DiscountedPaper used to call the required method
     * @param paper4 DiscountedPaper used to call the required method
     * @param paperCopy DiscountedPaper used to call the required method
     */
    private static void printStatsForPapers(DiscountedPaper paper1, DiscountedPaper paper2,
        DiscountedPaper paper3, DiscountedPaper paper4, DiscountedPaper paperCopy) {
        System.out.println("**************************************************");
        System.out.println("------------ DISCOUNTEDPAPER OBJECTS -------------");
        System.out.println("**************************************************");
        System.out.printf("Paper1:     %s\n", stringPaperStats(paper1));
        System.out.printf("Paper2:     %s\n", stringPaperStats(paper2));
        System.out.printf("Paper3:     %s\n", stringPaperStats(paper3));
        System.out.printf("Paper4:     %s\n", stringPaperStats(paper4));
        System.out.printf("Paper Copy: %s\n", stringPaperStats(paperCopy));
    }

    /**
     * printProductShip method prints the shipping information of each PaperProduct.
     * @param product1 PaperProduct used to call the required method
     * @param product2 PaperProduct used to call the required method
     * @param product3 PaperProduct used to call the required method
     * @param productCopy PaperProduct used to call the required method
     */
    private static void printProductShip(PaperProduct product1, PaperProduct product2,
        PaperProduct product3, PaperProduct productCopy) {
        System.out.println("***********************************************");
        System.out.println("------------ PRODUCTPAPER OBJECTS -------------");
        System.out.println("***********************************************");
        System.out.println(product1.ship("Staples"));
        System.out.println("Total products to ship AFTER 1st shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(product2.ship("Staples"));
        System.out.println("Total products to ship AFTER 2nd shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(product3.ship("Staples"));
        System.out.println("Total products to ship AFTER 3th shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(productCopy.ship("Staples"));
        System.out.println("Total products to ship AFTER 4th shipment: " + PaperProduct.getTotalProductsToShip());
    }

    /**
     * printPhotoShip method prints the shipping information of each PhotoProduct.
     * @param photo1 PhotoPaper used to call the required method
     * @param photo2 PhotoPaper used to call the required method
     * @param photo3 PhotoPaper used to call the required method
     * @param photoCopy PhotoPaper used to call the required method
     */
    private static void printPhotoShip(PhotoPaper photo1, PhotoPaper photo2,
        PhotoPaper photo3, PhotoPaper photoCopy) {
        System.out.println("*********************************************");
        System.out.println("------------ PHOTOPAPER OBJECTS -------------");
        System.out.println("*********************************************");
        System.out.println(photo1.shipPhoto("Barnes and Noble"));
        System.out.println("Total products to ship AFTER 5th shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(photo2.shipPhoto("Barnes and Noble"));
        System.out.println("Total products to ship AFTER 6th shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(photo3.shipPhoto("Barnes and Noble"));
        System.out.println("Total products to ship AFTER 7th shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(photoCopy.shipPhoto("Barnes and Noble"));
        System.out.println("Total products to ship AFTER 8th shipment: " + PaperProduct.getTotalProductsToShip());
    }

    /**
     * printPaperShip method prints the shipping information of each DiscountedPaper.
     * @param paper1 DiscountedPaper used to call the required method
     * @param paper2 DiscountedPaper used to call the required method
     * @param paper3 DiscountedPaper used to call the required method
     * @param paperCopy DiscountedPaper used to call the required method
     */
    private static void printPaperShip(DiscountedPaper paper1, DiscountedPaper paper2,
        DiscountedPaper paper3, DiscountedPaper paperCopy) {
        System.out.println("**************************************************");
        System.out.println("------------ DISCOUNTEDPAPER OBJECTS -------------");
        System.out.println("**************************************************");
        System.out.println(paper1.shipDiscounted("Office Depot"));
        System.out.println("Total products to ship AFTER 9th shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(paper2.shipDiscounted("Office Depot"));
        System.out.println("Total products to ship AFTER 10th shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(paper3.shipDiscounted("Office Depot"));
        System.out.println("Total products to ship AFTER 11th shipment: " + PaperProduct.getTotalProductsToShip());
        System.out.println(paperCopy.shipDiscounted("Office Depot"));
        System.out.println("Total products to ship AFTER 12th shipment: " + PaperProduct.getTotalProductsToShip());
    }
}
