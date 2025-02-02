package tom.task;

public class Deadline extends Task {
    
    protected String end;

    public Deadline(String description, String end) {
        super(description);
        this.end = end;
    }

    @Override
    public String toFileFormatString() {
        return String.format("D | %s | %s", this.getStatusIcon(), this.getDescription());
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), this.end);
    }
}
