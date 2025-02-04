package tom.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getDescription() {
        return description;
    }

    public boolean markDone() {
        boolean res = !isDone;
        isDone = true;
        return res;
    }

    public boolean markUndone() {
        boolean res = isDone;
        isDone = false;
        return res;
    }

    public String toFileFormatString() {
        return String.format("_ | %s | %s", getStatusIcon(), getDescription());
    }

    @Override
    public String toString() {
        return String.format("[%s] %s",  getStatusIcon(), getDescription());
    }
}