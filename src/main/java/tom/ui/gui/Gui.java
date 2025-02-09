package tom.ui.gui;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import tom.ui.Ui;

/**
 * Handles the user interface for interacting with the user.
 */
public class Gui implements Ui {

    private Image tomImg;
    private VBox dialogContainer;

    public Gui(Image tomImg, VBox dialogContainer) {
        this.tomImg = tomImg;
        this.dialogContainer = dialogContainer;
    }

    /**
     * Reads input from the user that matches the specified pattern.
     *
     * @param pattern The pattern to match the input against.
     * @return The input entered by the user that matches the pattern.
     */
    public String readPattern(String pattern) {
        return "placeholder";
    }

    /**
     * Displays a message to the user.
     *
     * @param msg  The message to be displayed.
     * @param args The arguments to be formatted into the message.
     */
    public void showMessage(String msg, Object... args) {
        String response = String.format(msg, args);
        dialogContainer.getChildren().addAll(DialogBox.getTomDialog(response, tomImg));
    }
}
