package tom.command;

import java.time.LocalDate;

import tom.storage.Storage;
import tom.task.Deadline;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * Represents a command to add a deadline task to the task list.
 */
public class DeadlineCommand extends Command {

    private String description;
    private LocalDate end;

    /**
     * Constructs a DeadlineCommand with the specified description and end date.
     *
     * @param description The description of the task.
     * @param end The end date of the task.
     */
    public DeadlineCommand(String description, LocalDate end) {
        this.description = description;
        this.end = end;
    }

    /**
     * Executes the command to add a deadline task to the task list.
     *
     * @param tasks The task list.
     * @param ui The UI for interacting with the user.
     * @param storage The storage for saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline task = new Deadline(description, end);
        tasks.addTask(task);
        ui.showMessage("added %s to tasklist (current size: %d)", task, tasks.size());
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
