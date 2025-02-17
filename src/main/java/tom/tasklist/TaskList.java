package tom.tasklist;

import java.util.ArrayList;
import java.util.Iterator;

import tom.task.Task;

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
    public Iterator<Task> iterator() {
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
        if (!isValidPosition(position)) {
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
        return this.tasks.size();
    }

    /**
     * Finds and returns a new TaskList containing tasks that match the specified
     * keyword.
     *
     * @param keyword The keyword to search for in the tasks.
     * @return A new TaskList containing tasks that match the specified keyword.
     */
    public TaskList findTasks(String keyword) {
        TaskList foundTasks = new TaskList();
        for (Task task : this.tasks) {
            if (task.matchKeyword(keyword)) {
                foundTasks.addTask(task);
            }
        }
        return foundTasks;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A multiline string in the format " itemCount task".
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int itemCount = 1;
        for (Task task : tasks) {
            result.append(String.format(" %d %s\n", itemCount++, task));
        }
        return result.toString();
    }

    /**
     * Marks a task as done or not done at the specified position.
     *
     * @param position The position of the task to be marked (1-based index).
     * @param done     true to mark the task as done, false to mark it as not done.
     * @return true if the task was marked successfully, false otherwise.
     */
    public boolean markTask(int position, boolean done) {
        if (!isValidPosition(position)) {
            return false;
        }
        Task task = tasks.get(position - 1);
        if (done) {
            return task.markDone();
        } else {
            return task.markUndone();
        }
    }

    /**
     * Checks if the given position is valid within the task list.
     *
     * @param position The position to check (1-based index).
     * @return true if the position is valid, false otherwise.
     */
    private boolean isValidPosition(int position) {
        return 0 < position && position <= tasks.size();
    }
}
