package tom.exception;

/**
 * Exception thrown when an unknown command is encountered.
 */
public class UnknownCommandException extends TomException {

    /**
     * Constructs an UnknownCommandException with the specified detail message.
     *
     * @param message The detail message.
     */
    public UnknownCommandException(String message) {
        super(message);
    }
}
