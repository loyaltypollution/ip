package tom.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import tom.command.Command;
import tom.command.ListCommand;
import tom.command.MarkCommand;
import tom.command.UnmarkCommand;
import tom.command.SaveCommand;
import tom.command.TodoCommand;
import tom.command.DeadlineCommand;
import tom.command.EventCommand;
import tom.command.UnknownCommand;
import tom.command.DeleteCommand;
import tom.command.ByeCommand;

import tom.ui.Ui;

public class Parser {

    private static final String DATE_PATTERN = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

    public static LocalDate stringToDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(string, formatter);
    }

    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        return date.format(formatter);
    }

    public static Command parse(String commandHead, Ui ui) {
        String[] inputComponents = commandHead.split(" ", 2);

        switch (inputComponents[0]) {
        case "bye":
            return new ByeCommand();
        case "todo": {
            ui.showMessage("Provide task description: ");
            String description = ui.readPattern("\\w+");
            return new TodoCommand(description);
        }
        case "deadline": {
            ui.showMessage("Provide task description: ");
            String description = ui.readPattern("\\w+");
            ui.showMessage("Provide task end time: ");
            String endString = ui.readPattern(DATE_PATTERN);
            LocalDate end = stringToDate(endString);
            return new DeadlineCommand(description, end);
        }
        case "event": {
            ui.showMessage("Provide task description: ");
            String description = ui.readPattern("\\w+");
            ui.showMessage("Provide task start time: ");
            String startString = ui.readPattern(DATE_PATTERN);
            LocalDate start = stringToDate(startString);
            ui.showMessage("Provide task end time: ");
            String endString = ui.readPattern(DATE_PATTERN);
            LocalDate end = stringToDate(endString);
            return new EventCommand(description, start, end);
        }
        case "list":
            return new ListCommand();
        case "mark": {
            ui.showMessage("Indicate which item: ");
            String num = ui.readPattern("\\d+");
            // due to regex, we know that num is a number
            Integer position = Integer.parseInt(num);
            return new MarkCommand(position);
        }
        case "unmark": {
            ui.showMessage("Indicate which item: ");
            String num = ui.readPattern("\\d+");
            // due to regex, we know that num is a number
            Integer position = Integer.parseInt(num);
            return new UnmarkCommand(position);
        }
        case "delete": {
            ui.showMessage("Indicate which item: ");
            String num = ui.readPattern("\\d+");
            // due to regex, we know that num is a number
            Integer position = Integer.parseInt(num);
            return new DeleteCommand(position);
        }
        case "save":
            return new SaveCommand();
        default:
            return new UnknownCommand();
        }
    }
}