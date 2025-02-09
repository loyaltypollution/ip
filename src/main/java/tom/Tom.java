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
    public Tom() {
        this("./data/tom.txt");
    }

    /**
     * Constructs a Tom instance with the specified file path.
     *
     * @param filePath The file path for storing tasks.
     */
    public Tom(String filePath) {
        storage = new Storage(filePath);
        tasks = new TaskList();
    }

    public void setUi(Ui ui) {
        this.ui = ui;
    }

    public void getResponse(String commandHead) {
        Command c = Parser.parse(commandHead, ui);
        c.execute(tasks, ui, storage);
    }
}
