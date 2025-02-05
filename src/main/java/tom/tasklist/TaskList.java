package tom.tasklist;

import java.util.ArrayList;
import java.util.Iterator;

import tom.task.Task;
import tom.ui.Ui;

/**
 * Represents a list of tasks.
 */
public class TaskList implements Iterable<Task> {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<Task>();
    }
    
    /**
     * Returns an iterator over the tasks in this list.
     *
     * @return An iterator over the tasks in this list.
     */
    @Override
    public Iterator<Task> iterator(){
        return tasks.iterator();
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes a task from the list at the specified position.
     *
     * @param position The position of the task to be removed (1-based index).
     * @return true if the task was removed successfully, false otherwise.
     */
    public boolean removeTask(int position) {
        if (0 >= position || position > tasks.size()) {
            return false;
        }
        tasks.remove(position - 1);
        return true;
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks in the list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Prints the list of tasks using the specified UI.
     *
     * @param ui The UI to be used for printing the tasks.
     */
    public void printTaskList(Ui ui) {
        int counter = 1;
        for (Task task : tasks) {
            ui.showMessage(" %d %s", counter++, task);
        }
    }

    /**
     * Marks a task as done or not done at the specified position.
     *
     * @param position The position of the task to be marked (1-based index).
     * @param done true to mark the task as done, false to mark it as not done.
     * @return true if the task was marked successfully, false otherwise.
     */
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
