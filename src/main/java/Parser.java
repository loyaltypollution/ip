import tom.command.Command;
import tom.command.ListCommand;
import tom.command.MarkCommand;
import tom.command.UnmarkCommand;
import tom.command.SaveCommand;
import tom.command.TodoCommand;
import tom.command.DeadlineCommand;
import tom.command.EventCommand;
import tom.command.UnknownCommand;
import tom.command.ByeCommand;

import tom.ui.Ui;

public class Parser {
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
                String end = ui.readPattern("\\w+");
                return new DeadlineCommand(description, end);
            }
            case "event": {
                ui.showMessage("Provide task description: ");
                String description = ui.readPattern("\\w+");
                ui.showMessage("Provide task start time: ");
                String start = ui.readPattern("\\w+");
                ui.showMessage("Provide task end time: ");
                String end = ui.readPattern("\\w+");
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
            case "save":
                return new SaveCommand();
            default:
                return new UnknownCommand();
        }
    }
}