package tom.exception;

/**
 * Exception thrown when an invalid date is encountered.
 */
public class InvalidDateException extends TomParseException {

    /**
     * Constructs an InvalidDateException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InvalidDateException(String message) {
        super(message);
    }
}
