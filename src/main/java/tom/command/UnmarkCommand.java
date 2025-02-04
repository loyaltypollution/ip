package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class UnmarkCommand extends Command {
    
    private int position;

    public UnmarkCommand(int position) {
        this.position = position;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.markTask(position,false)) {
            ui.showMessage("unmarked in tasklist");
        }
        else {
            ui.showMessage("unable to unmark");
        }
    };

    @Override
    public boolean isExit() {
        return false;
    }

}
