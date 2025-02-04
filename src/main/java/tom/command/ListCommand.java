package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class ListCommand extends Command {
    public ListCommand() {}

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.printTaskList(ui);
    };

    @Override
    public boolean isExit() {
        return false;
    }
}
