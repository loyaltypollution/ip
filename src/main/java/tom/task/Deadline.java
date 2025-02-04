package tom.task;

import tom.parser.Parser;
import java.time.LocalDate;

/**
 * Represents an deadline task with a end date.
 */
public class Deadline extends Task {
    
    protected LocalDate end;

    /**
     * Constructs a Deadline task with the specified description and end date.
     *
     * @param description The description of the task.
     * @param end The end date of the task.
     */
    public Deadline(String description, LocalDate end) {
        super(description);
        this.end = end;
    }

    /**
     * Returns a string representation of the task in file format.
     *
     * @return A string in the format "D | statusIcon | description".
     */
    @Override
    public String toFileFormatString() {
        return String.format("D | %s | %s", this.getStatusIcon(), this.getDescription());
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string in the format "[D][statusIcon] description (by: endDate)".
     */
    @Override
    public String toString() {
        String endString = Parser.dateToString(this.end);
        return String.format("[D]%s (by: %s)", super.toString(), endString);
    }
}
