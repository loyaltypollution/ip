package tom.parser;

import tom.command.Command;
import tom.command.UnknownCommand;
import tom.ui.Ui;

/**
 * Parser to ingest and parse Unknown command.
 */
public class UnknownCommandParser extends CommandParser {

    public UnknownCommandParser(Ui ui) {
        super("", ui);
    }

    @Override
    protected Command createCommand() {
        return new UnknownCommand();
    }
}
