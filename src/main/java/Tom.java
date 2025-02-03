import tom.tasklist.TaskList;
import tom.command.Command;
import tom.storage.Storage;
import tom.ui.Ui;

import tom.task.Task;
import tom.task.Deadline;
import tom.task.Event;
import tom.task.Todo;

public class Tom {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Tom() {
        this("./data/tom.txt");
    }

    public Tom(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.tasks = new TaskList();
    }

    public static void main(String[] args) {
        new Tom().run();
    }

    public void run() {
        ui.showWelcome();

        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            Command c = Parser.parse(fullCommand, ui);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        }
    }    
}
