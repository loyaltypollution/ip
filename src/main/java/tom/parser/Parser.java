package tom.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tom.command.ByeCommand;
import tom.command.Command;
import tom.command.DeadlineCommand;
import tom.command.DeleteCommand;
import tom.command.EventCommand;
import tom.command.FindCommand;
import tom.command.ListCommand;
import tom.command.MarkCommand;
import tom.command.SaveCommand;
import tom.command.TodoCommand;
import tom.command.UnknownCommand;
import tom.command.UnmarkCommand;
import tom.ui.Ui;

/**
 * Parses user input and converts it into commands.
 */
public class Parser {

    private static final String DATE_PATTERN = "\\d{4}\\-(?:0?[1-9]|1[012])\\-(?:0[1-9]|[12][0-9]|3[01])";
    private static final String WORD_PATTERN = "\\w+(?: +\\w+)*";
    private static final String NUM_PATTERN = "\\d+";

    /**
     * Converts a string to a LocalDate object.
     *
     * @param string The string to be converted.
     * @return The LocalDate object.
     * @throws IllegalArgumentException if the string does not match the date
     *                                  pattern.
     */
    public static LocalDate stringToDate(String string) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(string, formatter);
    }

    /**
     * Converts a LocalDate object to a string.
     *
     * @param date The LocalDate object to be converted.
     * @return The string representation of the date.
     */
    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        return date.format(formatter);
    }

    /**
     * Parses the user input and returns the corresponding command.
     *
     * @param input The user input.
     * @param ui    The UI for interacting with the user.
     * @return The corresponding command.
     */
    public static Command parse(String input, Ui ui) {
        String[] inputComponents = input.split(" ", 2);

        switch (inputComponents[0]) {
        case "bye":
            return new ByeCommand();
        case "todo": {
            Pattern r = Pattern.compile(String.format("todo (%s)", WORD_PATTERN));
            Matcher m = r.matcher(input);
            if (!m.find()) {
                return new UnknownCommand();
            }
            String description = m.group(1);
            return new TodoCommand(description);
        }
        case "deadline": {
            Pattern r = Pattern.compile(String.format("deadline (%s) \\/by (%s)", WORD_PATTERN, DATE_PATTERN));
            Matcher m = r.matcher(input);
            if (!m.find()) {
                return new UnknownCommand();
            }
            String description = m.group(1);
            String endDate = m.group(2);
            return new DeadlineCommand(description, stringToDate(endDate));
        }
        case "event": {
            Pattern r = Pattern
                    .compile(String.format("event (%s) \\/from (%s) \\/to (%s)", WORD_PATTERN, DATE_PATTERN, DATE_PATTERN));
            Matcher m = r.matcher(input);
            if (!m.find()) {
                return new UnknownCommand();
            }
            String description = m.group(1);
            String startDate = m.group(2);
            String endDate = m.group(3);
            return new EventCommand(description, stringToDate(startDate), stringToDate(endDate));
        }
        case "list":
            return new ListCommand();
        case "mark": {
            Pattern r = Pattern.compile(String.format("mark (%s)", NUM_PATTERN));
            Matcher m = r.matcher(input);
            if (!m.find()) {
                return new UnknownCommand();
            }
            String index = m.group(1);
            return new MarkCommand(Integer.parseInt(index));
        }
        case "unmark": {
            Pattern r = Pattern.compile(String.format("unmark (%s)", NUM_PATTERN));
            Matcher m = r.matcher(input);
            if (!m.find()) {
                return new UnknownCommand();
            }
            String index = m.group(1);
            return new UnmarkCommand(Integer.parseInt(index));
        }
        case "delete": {
            Pattern r = Pattern.compile(String.format("delete (%s)", NUM_PATTERN));
            Matcher m = r.matcher(input);
            if (!m.find()) {
                return new UnknownCommand();
            }
            String index = m.group(1);
            return new DeleteCommand(Integer.parseInt(index));
        }
        case "save":
            return new SaveCommand();
        case "find": {
            Pattern r = Pattern.compile(String.format("find (%s)", WORD_PATTERN));
            Matcher m = r.matcher(input);
            if (!m.find()) {
                return new UnknownCommand();
            }
            String keyword = m.group(1);
            return new FindCommand(keyword);
        }
        default:
            return new UnknownCommand();
        }
    }
}
