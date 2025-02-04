package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class MarkCommand extends Command {
    private int position;
    public MarkCommand(int position) {
        this.position = position;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.markTask(position, true)) {
            ui.showMessage("marked in tasklist");
        }
        else {
            ui.showMessage("unable to mark");
        }
    };

    @Override
    public boolean isExit() {
        return false;
    }

}
