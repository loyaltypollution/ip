package tom.parser;

import tom.command.Command;
import tom.command.ReportErrorCommand;
import tom.exception.TomException;
import tom.exception.TomParseException;
import tom.ui.Ui;

/**
 * Parser to ingest and parse Invalid command.
 */
public class ReportErrorCommandParser extends CommandParser {

    private TomException exception;

    /**
     * Constructs an InvalidCommandParser with the specified UI and exception.
     *
     * @param ui The UI for interacting with the user.
     * @param exception The exception that caused this parser to be used.
     */
    public ReportErrorCommandParser(Ui ui, TomException exception) {
        super("", ui);
        this.exception = exception;
    }

    @Override
    public void parseNext(String input) throws TomParseException {
    }

    @Override
    protected Command createCommand() {
        return new ReportErrorCommand(exception);
    }
}
