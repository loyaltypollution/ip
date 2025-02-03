package tom.tasklist;

import java.util.ArrayList;

import tom.task.Task;

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
}
