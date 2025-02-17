package tom.task;

import tom.parser.WordMatch;

/**
 * Represents a task with a description and a status indicating whether it is done.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task with the specified description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "X" if the task is done, otherwise " ".
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Returns the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Marks the task as done.
     *
     * @return true if the task was not already marked as done, false otherwise.
     */
    public boolean markDone() {
        boolean res = !isDone;
        isDone = true;
        return res;
    }

    /**
     * Checks if the task description contains the specified keyword.
     *
     * @param keyword The keyword to search for in the task description.
     * @return true if the keyword is found in the description, false otherwise.
     */
    public boolean matchKeyword(String keyword) {
        int threshold = 2; // Maximum allowed edit distance

        for (String word : description.split("\\s+")) {
            if (WordMatch.levenshteinDistance(word.toLowerCase(), keyword.toLowerCase()) <= threshold) {
                return true;
            }
        }
        return false;
    }

    /**
     * Marks the task as not done.
     *
     * @return true if the task was marked as done, false otherwise.
     */
    public boolean markUndone() {
        boolean res = isDone;
        isDone = false;
        return res;
    }

    /**
     * Returns a string representation of the task in file format.
     *
     * @return A string in the format "_ | statusIcon | description".
     */
    public String toFileFormatString() {
        return String.format("_ | %s | %s", getStatusIcon(), getDescription());
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), getDescription());
    }
}
