package tom.task;

public class Event extends Task{
    
    protected String start;
    protected String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toFileFormatString() {
        return String.format("E | %s | %s", this.getStatusIcon(), this.getDescription());
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.start, this.end);
    }
}
