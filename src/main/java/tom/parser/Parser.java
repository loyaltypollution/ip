package tom.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import tom.ui.Ui;

/**
 * Parses user input and converts it into commands.
 */
public class Parser {

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
     * @param commandType The command type.
     * @param ui    The UI for interacting with the user.
     * @return The corresponding command.
     */
    public static CommandParser findParser(String commandType, Ui ui) {
        CommandParser parser;
        switch (commandType) {
        case "bye":
            parser = new ByeCommandParser(ui);
            break;
        case "todo":
            parser = new TodoCommandParser(ui);
            break;
        case "deadline":
            parser = new DeadlineCommandParser(ui);
            break;
        case "event":
            parser = new EventCommandParser(ui);
            break;
        case "list":
            parser = new ListCommandParser(ui);
            break;
        case "mark":
            parser = new MarkUnmarkCommandParser(true, ui);
            break;
        case "unmark":
            parser = new MarkUnmarkCommandParser(false, ui);
            break;
        case "delete":
            parser = new DeleteCommandParser(ui);
            break;
        case "save":
            parser = new SaveCommandParser(ui);
            break;
        case "find":
            parser = new FindCommandParser(ui);
            break;
        default:
            parser = new UnknownCommandParser(ui);
            break;
        }

        return parser;
    }
}
