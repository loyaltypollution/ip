package tom.task;

import java.time.LocalDate;

import tom.parser.Parser;

public class Event extends Task{
    
    protected LocalDate start;
    protected LocalDate end;

    public Event(String description, LocalDate start, LocalDate end) {
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
        String startString = Parser.dateToString(this.start);
        String endString = Parser.dateToString(this.end);
        return String.format("[E]%s (from: %s to: %s)", super.toString(), startString, endString);
    }
}
