import java.util.ArrayList;

/**
 * VendingMachine Class.
 * This class represents a vending machine filleld with items.
 * Contains 2 private instance variables.
 * Contains a 2-args constructor.
 * Has a total of 4 methods, including a main method.
 * @author gcanales6
 * @version 1.0
 */

public class VendingMachine {
    private ArrayList<String> itemsContained;
    private int cost;

    /**
     * 2-args constructor for VendingMachine.
     * @param itemsContained String list containing the items to be sold
     * @param cost int describing the cost of any item
     */
    public VendingMachine(ArrayList<String> itemsContained, int cost) {
        this.itemsContained = itemsContained;
        this.cost = cost;
    }

    /**
     * checkIfItemsSold() method checks if all the items in itemsBought are in the VendingMachine.
     * @param itemsBought String list of items to find
     * @throws ItemNotContainedException custom exception thrown when an item in not found
     */
    public void checkIfItemsSold(ArrayList<String> itemsBought) throws ItemNotContainedException {
        for (int i = 0; i < itemsBought.size(); i++) {
            boolean found = false;
            for (int j = 0; j < this.itemsContained.size(); j++) {
                if (itemsBought.get(i).equals(this.itemsContained.get(j))) {
                    j = this.itemsContained.size();
                    found = true;
                }
            }
            if (!found) {
                throw new ItemNotContainedException(itemsBought.get(i));
            }
        }
    }

    /**
     * buyItem() method removes an item from the VendingMachine if it's presents and money > cost.
     * @param item String representing the item to buy and remove from VendingMachine if bought
     * @param money int representing the amount of money introduced into the VendingMachine
     * @throws ItemNotContainedException custom exception thrown when an item in not found
     */
    public void buyItem(String item, int money) throws ItemNotContainedException, NotEnoughMoneyException {
        int itemPresent = this.itemsContained.indexOf(item);
        if (itemPresent == -1) {
            throw new ItemNotContainedException(item);
        } else {
            if (money < cost) {
                throw new NotEnoughMoneyException();
            } else {
                this.itemsContained.remove(item);
            }
        }
    }

    /**
     * removeAbsentItems() method holds any items present within both String lists.
     * @param items String list representing the list to be compared
     * @return String list with all the items present in both String lists
     */
    public ArrayList<String> removeAbsentItems(ArrayList<String> items) {
        ArrayList<String> removedAbsent = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            int itemPresent = this.itemsContained.indexOf(items.get(i));
            if (itemPresent != -1) {
                removedAbsent.add(items.get(i));
            }
        }
        return removedAbsent;
    }

    /**
     * main method.
     * @param args String[] describing the contents of the main method
     * @throws ItemNotContainedException custom exception thrown when an item in not found
     */
    public static void main(String[] args) throws ItemNotContainedException {
        ArrayList<String> vendingItems = new ArrayList<>() {
            {
                add("Generic Cheese Chips");
                add("Generic Spicy Chips");
                add("Generic Nuts Mix");
                add("Generic Cookies");
                add("Generic Soda");
                add("Generic Water");
            }
        };
        VendingMachine myVendingMachine = new VendingMachine(vendingItems, 5);
        System.out.println("------------ 1ST TRY-CATCH BLOCKS ----------");
        try {
            myVendingMachine.checkIfItemsSold(vendingItems);
            ArrayList<String> otherVendingMachine = myVendingMachine.removeAbsentItems(vendingItems);
            myVendingMachine.itemsContained.forEach((item) -> System.out.println(item));
            myVendingMachine.buyItem("Generic Water", 10);
            System.out.println("-------- AFTER BUYING GENERIC WATER-------");
            myVendingMachine.itemsContained.forEach((item) -> System.out.println(item));
            myVendingMachine.checkIfItemsSold(vendingItems);
            otherVendingMachine = myVendingMachine.removeAbsentItems(vendingItems);
            otherVendingMachine.add("Generic Water");
            myVendingMachine.checkIfItemsSold(otherVendingMachine);
        } catch (ItemNotContainedException incex) {
            System.out.println(incex.getMessage());
        } catch (NotEnoughMoneyException nemex) {
            System.out.println(nemex.getMessage());
        } finally {
            System.out.println("Took stock of the vending machine!");
        }
        System.out.println("------------ 2ND TRY-CATCH BLOCKS ----------");
        try {
            myVendingMachine.checkIfItemsSold(vendingItems);
            ArrayList<String> otherVendingMachine = myVendingMachine.removeAbsentItems(vendingItems);
            myVendingMachine.itemsContained.add("Generic Energy Drink");
            myVendingMachine.buyItem("Generic Spicy Chips", 10);
            myVendingMachine.itemsContained.forEach((item) -> System.out.println(item));
            myVendingMachine.buyItem("Generic Nuts Mix", 4);
            myVendingMachine.checkIfItemsSold(otherVendingMachine);
        } catch (ItemNotContainedException incex) {
            System.out.println(incex.getMessage());
        } catch (NotEnoughMoneyException nemex) {
            System.out.println(nemex.getMessage());
        } finally {
            System.out.println("Took stock of the vending machine!");
        }
    }
}
