/**
 * ItemNotContainedException Class.
 * Checked Exception
 * @author gcanales6
 * @version 1.0
 */

public class ItemNotContainedException extends Exception {
    /**
     * 1-arg constructor for the custom exception.
     * @param item String representing the missing item
     */
    public ItemNotContainedException(String item) {
        super(item + " not sold in this vending machine.");
    }
}