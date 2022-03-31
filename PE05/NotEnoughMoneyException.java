/**
 * NotEnoughMoneyException Class.
 * Unchecked Exception
 * @author gcanales6
 * @version 1.0
 */

public class NotEnoughMoneyException extends RuntimeException {
    /**
     * no-args constructor for the custom exception.
     */
    public NotEnoughMoneyException() {
        super("Item not vended. Insufficient funds.");
    }
}
