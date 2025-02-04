package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class SaveCommand extends Command {
    public SaveCommand() {}

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (storage.saveFile(tasks)) {
            ui.showMessage("Successfully saved tasklist file!");
        }
    };

    @Override
    public boolean isExit() {
        return false;
    }
}
