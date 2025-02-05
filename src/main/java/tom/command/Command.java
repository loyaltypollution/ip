package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * Represents an abstract command in the application.
 */
public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public abstract boolean isExit();
}
