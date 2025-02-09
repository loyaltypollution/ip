package tom;

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
    public Tom(Ui ui) {
        this("./data/tom.txt", ui);
    }

    /**
     * Constructs a Tom instance with the specified file path.
     *
     * @param filePath The file path for storing tasks.
     * @param ui The ui Tom will communicate with.
     */
    public Tom(String filePath, Ui ui) {
        this.ui = ui;
        storage = new Storage(filePath);
        tasks = new TaskList();
    }
   
    /**
     * Handles user input by parsing and executing the corresponding command.
     *
     * @param input The user input.
     */
    public void handleUserInput(String input) {
        Command c = Parser.parse(input, ui);
        c.execute(tasks, ui, storage);
    }
}
