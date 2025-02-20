package tom.ui;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Handles the graphical user interface with the user.
 */
public class Gui implements Ui {

    private final MainWindow mainWindow;
    private HashMap<Integer, DialogBox> objectMap = new HashMap<>();
    private int windowKey;

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
        String outputMsg = String.format(msg, args);
        DialogBox box = objectMap.get(windowKey);
        box.setText(outputMsg);
    }

    @Override
    public void promptForInput(String promptMsg, Consumer<String> onInputReceived) {
        DialogBox box = objectMap.get(windowKey);
        box.setText(promptMsg);

        onInputReceived.accept("task thing");
    }

    @Override
    public void findWindow(int key) {
        objectMap.computeIfAbsent(key, obj -> mainWindow.addTomDialog(""));
        windowKey = key;
    }
}
