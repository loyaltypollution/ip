package tom.tasklist;

import java.util.ArrayList;
import java.util.Iterator;

import tom.task.Task;
import tom.ui.Ui;

public class TaskList implements Iterable<Task> {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }
    
    @Override
    public Iterator<Task> iterator(){
        return tasks.iterator();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public boolean removeTask(int position) {
        if (0 >= position || position > this.tasks.size()) {
            return false;
        }
        this.tasks.remove(position - 1);
        return true;
    }

    public int size() {
        return this.tasks.size();
    }

    public void printTaskList(Ui ui) {
        int counter = 1;
        for (Task task : this.tasks) {
            ui.showMessage(" %d %s", counter++, task);
        }
    }

    public boolean markTask(int position, boolean done) {
        if (0 >= position || position > this.tasks.size()) {
            return false;
        }
        Task task = this.tasks.get(position - 1);
        if (done) {
            return task.markDone();
        }
        else {
            return task.markUndone();
        }
    }
}
