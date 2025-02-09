package tom.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import tom.Tom;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Tom tom;

    private Image userImg = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image tomImg = new Image(this.getClass().getResourceAsStream("/images/DaTom.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Tom instance */
    public void setTom(Tom t) {
        tom = t;
        tom.setUi(new Gui(tomImg, dialogContainer));
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        dialogContainer.getChildren().addAll(DialogBox.getTomDialog(input, userImg));

        tom.getResponse(input);
        userInput.clear();
    }
}
