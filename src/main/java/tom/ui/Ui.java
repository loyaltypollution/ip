package tom.ui;

/**
 * Handles the user interface for interacting with the user.
 */
public interface Ui {
    /**
     * Reads input from the user that matches the specified pattern.
     *
     * @param pattern The pattern to match the input against.
     * @return The input entered by the user that matches the pattern.
     */
    public String readPattern(String pattern);

    /**
     * Displays a message to the user.
     *
     * @param msg The message to be displayed.
     * @param args The arguments to be formatted into the message.
     */
    public void showMessage(String msg, Object ...args);
}
