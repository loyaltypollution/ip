package tom.command;

import java.time.LocalDate;

import tom.storage.Storage;
import tom.task.Event;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * Represents a command to add an event task to the task list.
 */
public class EventCommand extends Command {

    private String description;
    private LocalDate start;
    private LocalDate end;

    /**
     * Constructs an EventCommand with the specified description, start date, and end date.
     *
     * @param description The description of the task.
     * @param start The start date of the event.
     * @param end The end date of the event.
     */
    public EventCommand(String description, LocalDate start, LocalDate end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    /**
     * Executes the command to add an event task to the task list.
     *
     * @param tasks The task list.
     * @param ui The UI for interacting with the user.
     * @param storage The storage for saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event task = new Event(description, start, end);
        tasks.addTask(task);
        ui.showMessage(id, "added %s to tasklist (current size: %d)", task, tasks.size());
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
