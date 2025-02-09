package tom.command;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * Represents a command to exit the application.
 */
public class ByeCommand extends Command {
    public ByeCommand() {
    }

    /**
     * Executes the command to exit the application.
     *
     * @param tasks   The task list.
     * @param ui      The UI for interacting with the user.
     * @param storage The storage for saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Exiting in a few seconds. Hope to see you again soon!");
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.schedule(new Runnable() {
            @Override
            public void run() {
                javafx.application.Platform.exit();
            }
        }, 3, TimeUnit.SECONDS);
    };

    /**
     * Indicates whether this command exits the application.
     *
     * @return true if this command exits the application, false otherwise.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
