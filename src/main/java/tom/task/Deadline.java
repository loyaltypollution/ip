package tom.task;

import java.time.LocalDate;

import tom.parser.Parser;

public class Deadline extends Task {
    
    protected LocalDate end;

    public Deadline(String description, LocalDate end) {
        super(description);
        this.end = end;
    }

    @Override
    public String toFileFormatString() {
        return String.format("D | %s | %s", getStatusIcon(), getDescription());
    }

    @Override
    public String toString() {
        String endString = Parser.dateToString(end);
        return String.format("[D]%s (by: %s)", super.toString(), endString);
    }
}
