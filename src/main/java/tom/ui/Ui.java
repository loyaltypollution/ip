package tom.ui;

/**
 * Handles the user interface for interacting with the user.
 */
public class Ui {

    private String internalBuffer = "";

    /**
     * Displays a message to the user.
     *
     * @param msg The message to be displayed.
     * @param args The arguments to be formatted into the message.
     */
    public void showMessage(String msg, Object ...args) {
        assert msg != null : "Message should not be null";
        // Format the message with the variadic arguments
        String outputMsg = String.format(msg, args);
        internalBuffer += outputMsg + "\n";
    }

    public String flush() {
        String tmp = internalBuffer;
        internalBuffer = "";
        return tmp;
    }
}
