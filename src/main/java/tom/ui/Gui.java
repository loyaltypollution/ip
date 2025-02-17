package tom.ui;

/**
 * Handles the graphical user interface with the user.
 */
public class Gui implements Ui {

    private final MainWindow mainWindow;

    public Gui(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * Displays a formatted message in the main window.
     *
     * @param msg  The message template to be formatted.
     * @param args The arguments to be used in the message template.
     */
    public void showMessage(String msg, Object... args) {
        // Format the message with the variadic arguments
        String outputMsg = String.format(msg, args);
        mainWindow.addTomDialog(outputMsg);
    }

}
