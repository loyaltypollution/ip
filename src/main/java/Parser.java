import tom.command.Command;
import tom.command.ListCommand;
import tom.command.TodoCommand;
import tom.ui.Ui;
import tom.command.ByeCommand;

public class Parser {
    public static Command parse(String commandHead, Ui ui) {
        String[] inputComponents = commandHead.split(" ", 2);

        switch (inputComponents[0]) {
            case "bye":
                return new ByeCommand();
            case "todo":
                ui.showMessage("Provide task description: ");
                String description = ui.readLine();
                return new TodoCommand(description);
            case "list":
                return new ListCommand();
            case "mark":
            case "unmark":
                break;

        }
        return null;
    }
}