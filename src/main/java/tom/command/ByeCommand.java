package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class ByeCommand extends Command {
    public ByeCommand() {
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Bye. Hope to see you again soon!");
        ui.closeBuffer();
    };

    @Override
    public boolean isExit() {
        return true;
    }
}
