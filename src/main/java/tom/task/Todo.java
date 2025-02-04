package tom.task;

public class Todo extends Task {
    
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toFileFormatString() {
        return String.format("T | %s | %s", this.getStatusIcon(), this.getDescription());
    }
    
    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
