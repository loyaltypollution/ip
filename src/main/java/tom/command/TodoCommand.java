package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

import tom.task.Todo;

public class TodoCommand extends Command {

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo task = new Todo(description);
        tasks.addTask(task);
    };

    @Override
    public boolean isExit() {
        return false;
    }
}
