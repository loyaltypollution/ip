package tom.parser;

import tom.command.Command;
import tom.command.EventCommand;
import tom.ui.Ui;

/**
 * Parser to ingest and parse Event command.
 */
public class EventCommandParser extends CommandParser {

    // regex for YYYY-MM-DD
    private static final String DATE_PATTERN = "\\d{4}\\-(?:0?[1-9]|1[012])\\-(?:0[1-9]|[12][0-9]|3[01])";

    /**
     * Constructs an EventCommandParser with the specified UI.
     *
     * @param ui The UI for interacting with the user.
     */
    public EventCommandParser(Ui ui) {
        super("event", ui);
        addPattern("(\\w+(?: +\\w+)*)?");
        addPattern(DATE_PATTERN);
        addPattern(DATE_PATTERN);
    }

    /**
     * Creates an EventCommand with the specified description, start date, and end date.
     *
     * @return The created EventCommand.
     */
    @Override
    protected Command createCommand() {
        String description = inputs.poll();
        String startDate = inputs.poll();
        String endDate = inputs.poll();
        return new EventCommand(description, Parser.stringToDate(startDate), Parser.stringToDate(endDate));
    }
}
