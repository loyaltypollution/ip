package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

import tom.task.Deadline;

public class DeadlineCommand extends Command {

    private String description;
    private String end;

    public DeadlineCommand(String description, String end) {
        this.description = description;
        this.end = end;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline task = new Deadline(description, end);
        tasks.addTask(task);
        ui.showMessage("added %s to tasklist (current size: %d)", task, tasks.size());
    };

    @Override
    public boolean isExit() {
        return false;
    }
}
