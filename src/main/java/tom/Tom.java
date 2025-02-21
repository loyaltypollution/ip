package tom;

import java.util.LinkedList;
import java.util.Queue;

import tom.command.Command;
import tom.command.PromptCommand;
import tom.parser.CommandParser;
import tom.parser.Parser;
import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

/**
 * The main class for the Tom application.
 */
public class Tom {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;
    private Queue<Command> commandQueue;

    /**
     * Constructs a Tom instance with the default file path.
     */
    public Tom(Ui ui) {
        this("./data/tom.txt", ui);
    }

    /**
     * Constructs a Tom instance with the specified file path.
     *
     * @param filePath The file path for storing tasks.
     * @param ui The ui Tom will communicate with.
     */
    public Tom(String filePath, Ui ui) {
        this.ui = ui;
        storage = new Storage(filePath);
        tasks = new TaskList();
        commandQueue = new LinkedList<>();
    }

    /**
     * Handles user input by parsing and executing the corresponding command.
     * If the command requires additional input, it prompts the user accordingly.
     *
     * @param input The user input.
     */
    public void handleUserInput(String input) {
        String[] inputComponents = input.split(" ", 2);
        String commandType = inputComponents[0];
        String commandArgs = inputComponents.length > 1 ? inputComponents[1] : null;

        CommandParser commandParser = Parser.findParser(commandType, ui);
        handleUserInput(commandArgs, commandParser);
    }

    /**
     * Handles user input by parsing and executing the corresponding command.
     * If the command requires additional input, it prompts the user accordingly.
     *
     * @param input The user input.
     * @param commandParser The parser that will parse given input.
     */
    public void handleUserInput(String input, CommandParser commandParser) {
        if (input != null) {
            commandParser.parseNext(input);
        }

        Command nextCommand;
        if (!commandParser.isComplete()) {
            String promptMsg = commandParser.getPromptMsg();
            nextCommand = new PromptCommand(promptMsg, (String newInput)->handleUserInput(newInput, commandParser));
        } else {
            nextCommand = commandParser.produceCommand();
        }

        nextCommand.setId(commandParser.getId());
        addCommand(nextCommand);
        executeCommands();
    }

    /**
     * Adds a command to the queue.
     *
     * @param command The command to be added.
     */
    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    /**
     * Executes all commands in the queue.
     */
    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute(tasks, ui, storage);
        }
    }
}
