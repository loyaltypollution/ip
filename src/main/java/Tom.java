import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import tom.command.Command;
import tom.parser.Parser;
import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * The main class for the Tom application.
 */
public class Tom extends Application {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /**
     * Constructs a Tom instance with the default file path.
     */
    public Tom() {
        this("./data/tom.txt");
    }

    /**
     * Constructs a Tom instance with the specified file path.
     *
     * @param filePath The file path for storing tasks.
     */
    public Tom(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
    }

    /**
     * The main method to run the Tom application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new Tom().run();
    }

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our scene
        stage.show(); // Render the stage.
    }

    /**
     * Runs the Tom application.
     */
    public void run() {
        ui.showWelcome();

        boolean isExit = false;
        while (!isExit) {
            String commandHead = ui.readCommand();
            Command c = Parser.parse(commandHead, ui);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        }
    }
}
