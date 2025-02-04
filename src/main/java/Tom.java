import tom.tasklist.TaskList;
import tom.command.Command;
import tom.parser.Parser;
import tom.storage.Storage;
import tom.ui.Ui;

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
            String commandHead = ui.readCommand();
            Command c = Parser.parse(commandHead, ui);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        }
    }    
}
