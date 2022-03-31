/**
 * InvalidCourseException Class.
 * Unchecked Extension
 * @author gcanales6
 * @version 1.3
 */

public class InvalidCourseException extends RuntimeException {
    /**
     * 1-arg constructor for the custom exception.
     * @param message String representing the message to display
     */
    public InvalidCourseException(String message) {
        super(message);
    }

    /**
     * no-args constructor for the custom exception.
     */
    public InvalidCourseException() {
        super("Invalid course type!");
    }
}
