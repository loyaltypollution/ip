import tom.command.Command;
import tom.parser.Parser;
import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * The main class for the Tom application.
 */
public class Tom {
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
