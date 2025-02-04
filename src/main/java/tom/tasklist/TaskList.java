package tom.tasklist;

import java.util.ArrayList;
import java.util.Iterator;

import tom.task.Task;
import tom.ui.Ui;

public class TaskList implements Iterable<Task> {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }
    
    @Override
    public Iterator<Task> iterator(){
        return tasks.iterator();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean removeTask(int position) {
        if (0 >= position || position > tasks.size()) {
            return false;
        }
        tasks.remove(position - 1);
        return true;
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

    public boolean markTask(int position, boolean done) {
        if (0 >= position || position > tasks.size()) {
            return false;
        }
        Task task = tasks.get(position - 1);
        if (done) {
            return task.markDone();
        }
        else {
            return task.markUndone();
        }
    }
}
