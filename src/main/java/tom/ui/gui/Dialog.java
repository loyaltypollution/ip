package tom.ui.gui;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Represents a dialog box consisting of an ImageView to represent the speaker's face
 * and a label containing text from the speaker.
 */
public class Dialog extends VBox {
    @FXML
    private Label dialog;
    @FXML
    private TextField userInput;

    public Dialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/Dialog.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setText(String text) {
        dialog.setText(text);
    }

    public void removeInput() {
        this.getChildren().remove(userInput);
    }

    @FXML
    private void handleUserInput() {
        removeInput();
    }

}
