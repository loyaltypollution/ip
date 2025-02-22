package tom.exception;

import java.util.regex.Pattern;

/**
 * Exception thrown when an input is invalid for a given regex.
 */
public class InvalidRegexException extends TomParseException {

    /**
     * Constructs an InvalidRegexException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InvalidRegexException(Pattern pattern, String input) {
        super(String.format(
            """
            Invalid input format, %s expected.
            %s received instead
            """,
            pattern.pattern(), input
        ));
    }

    @Override
    public boolean needPrompt() {
        return true;
    }
}
