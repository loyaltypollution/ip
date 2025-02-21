package tom.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import tom.ui.Ui;
import tom.command.LoadCommand;
import tom.exception.InvalidDateException;
import tom.exception.UnknownCommandException;

/**
 * Parses user input and converts it into commands.
 */
public class Parser {

    /**
     * Converts a string to a LocalDate object.
     *
     * @param string The string to be converted.
     * @return The LocalDate object.
     * @throws InvalidDateException if the string does not match the date
     *                                  pattern.
     */
    public static LocalDate stringToDate(String string) throws InvalidDateException {
        return stringToDate(string, "yyyy-MM-dd");
    }

    /**
     * Converts a string to a LocalDate object.
     *
     * @param string The string to be converted.
     * @param pattern The pattern of the date string.
     * @return The LocalDate object.
     * @throws InvalidDateException if the string does not match the date
     *                                  pattern.
     */
    public static LocalDate stringToDate(String string, String pattern) throws InvalidDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDate.parse(string, formatter);
        }
        catch (DateTimeParseException e) {
            String errorMsg = String.format("Date [%s] should be of '%s' form!", pattern, string);
            throw new InvalidDateException(errorMsg);
        }
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
        try {
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
            case "load":
                parser = new LoadCommandParser(ui);
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
                throw new UnknownCommandException(String.format(
                    "%s is an unknown command.", commandType
                ));
            }
        } catch (UnknownCommandException e) {
            return new ReportErrorCommandParser(ui, e);
        }

        return parser;
    }
}
