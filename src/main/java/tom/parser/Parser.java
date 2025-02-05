package tom.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private static final String DATE_PATTERN = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
    private static final String WORD_PATTERN = "^\\w+( +\\w+)*$";

    /**
     * Converts a string to a LocalDate object.
     *
     * @param string The string to be converted.
     * @return The LocalDate object.
     * @throws IllegalArgumentException if the string does not match the date pattern.
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
     * @param commandHead The user input.
     * @param ui The UI for interacting with the user.
     * @return The corresponding command.
     */
    public static Command parse(String commandHead, Ui ui) {
        String[] inputComponents = commandHead.split(" ", 2);

        switch (inputComponents[0]) {
        case "bye":
            return new ByeCommand();
        case "todo": {
            ui.showMessage("Provide task description: ");
            String description = ui.readPattern(WORD_PATTERN);
            return new TodoCommand(description);
        }
        case "deadline": {
            ui.showMessage("Provide task description: ");
            String description = ui.readPattern(WORD_PATTERN);
            ui.showMessage("Provide end date (yyyy-MM-dd): ");
            String endDate = ui.readPattern(DATE_PATTERN);
            return new DeadlineCommand(description, stringToDate(endDate));
        }
        case "event": {
            ui.showMessage("Provide task description: ");
            String description = ui.readPattern(WORD_PATTERN);
            ui.showMessage("Provide start date (yyyy-MM-dd): ");
            String startDate = ui.readPattern(DATE_PATTERN);
            ui.showMessage("Provide end date (yyyy-MM-dd): ");
            String endDate = ui.readPattern(DATE_PATTERN);
            return new EventCommand(description, stringToDate(startDate), stringToDate(endDate));
        }
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(Integer.parseInt(inputComponents[1]));
        case "unmark":
            return new UnmarkCommand(Integer.parseInt(inputComponents[1]));
        case "delete":
            return new DeleteCommand(Integer.parseInt(inputComponents[1]));
        case "save":
            return new SaveCommand();
        case "find": {
            ui.showMessage("Provide task keyword: ");
            String keyword = ui.readPattern("\\w+");
            return new FindCommand(keyword);
        }
        default:
            return new UnknownCommand();
        }
    }
}
