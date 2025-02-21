package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * Represents a command that is not recognized.
 */
public class UnknownCommand extends Command {

    /**
     * Executes the command to notify the user that the command is not recognized.
     *
     * @param tasks The task list.
     * @param ui The UI for interacting with the user.
     * @param storage The storage for saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage(id, "Command format not recognized.");
    };

    /**
     * Indicates whether this command exits the application.
     *
     * @return false as this command does not exit the application.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
