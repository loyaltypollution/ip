package tom.command;

import java.time.LocalDate;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

import tom.task.Event;

public class EventCommand extends Command {

    private String description;
    private LocalDate start;
    private LocalDate end;

    public EventCommand(String description, LocalDate start, LocalDate end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event task = new Event(description, start, end);
        tasks.addTask(task);
        ui.showMessage("added %s to tasklist (current size: %d)", task, tasks.size());
    };

    @Override
    public boolean isExit() {
        return false;
    }
}
