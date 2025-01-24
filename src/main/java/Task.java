public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getDescription() {
        return description;
    }

    public boolean markDone() {
        boolean res = !this.isDone;
        this.isDone = true;
        return res;
    }

    public boolean markUndone() {
        boolean res = this.isDone;
        this.isDone = false;
        return res;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s",  this.getStatusIcon(), this.getDescription());
    }
}