import tom.command.Command;
import tom.command.TodoCommand;
import tom.ui.Ui;
import tom.command.ByeCommand;

public class Parser {
    public static Command parse(String fullCommand, Ui ui) {
        String[] inputComponents = fullCommand.split(" ", 2);

        switch (inputComponents[0]) {
            case "bye":
                return new ByeCommand();
            case "todo":
                ui.showMessage("Provide task description: ");
                String description = ui.waitLine();
                return new TodoCommand(description);
            case "list":
            case "mark":
            case "unmark":
                break;

        }
        return null;
    }
}