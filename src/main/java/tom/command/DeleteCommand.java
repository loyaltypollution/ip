package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    private int position;

    /**
     * Constructs a DeleteCommand with the specified position.
     *
     * @param position The position of the task to be deleted (1-based index).
     */
    public DeleteCommand(int position) {
        this.position = position;
    }

    /**
     * Executes the command to delete a task from the task list.
     *
     * @param tasks The task list.
     * @param ui The UI for interacting with the user.
     * @param storage The storage for saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.removeTask(position)) {
            ui.showMessage(id, "deleted from tasklist");
        } else {
            ui.showMessage(id, "unable to delete");
        }
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
