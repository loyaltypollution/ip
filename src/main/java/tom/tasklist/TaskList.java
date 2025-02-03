package tom.tasklist;

import java.util.ArrayList;

import tom.task.Task;
import tom.ui.Ui;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public void printTaskList(Ui ui) {
        int counter = 1;
        for (Task task : tasks) {
            ui.showMessage(" %d %s", counter++, task);
        }
    }
}
