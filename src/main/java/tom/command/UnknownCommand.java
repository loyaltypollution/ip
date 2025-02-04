package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class UnknownCommand extends Command {

    public UnknownCommand() {
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Command format not recognized.");
    };

    @Override
    public boolean isExit() {
        return false;
    }
}
