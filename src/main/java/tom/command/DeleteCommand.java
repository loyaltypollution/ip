package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class DeleteCommand extends Command {
    private int position;

    public DeleteCommand(int position) {
        this.position = position;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.removeTask(position)) {
            ui.showMessage("deleted from tasklist");
        } else {
            ui.showMessage("unable to delete");
        }
    };

    @Override
    public boolean isExit() {
        return false;
    }

}
