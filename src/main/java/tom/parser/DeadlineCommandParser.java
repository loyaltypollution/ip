package tom.parser;

import tom.command.Command;
import tom.command.DeadlineCommand;
import tom.ui.Ui;

/**
 * Parser to ingest and parse Deadline command.
 */
public class DeadlineCommandParser extends CommandParser {

    private static final String DATE_PATTERN = "\\d{4}\\-(?:0?[1-9]|1[012])\\-(?:0[1-9]|[12][0-9]|3[01])";

    /**
     * Constructs a DeadlineCommandParser with the specified UI.
     *
     * @param ui The UI for interacting with the user.
     */
    public DeadlineCommandParser(Ui ui) {
        super("deadline", ui);
        addPattern("(\\w+(?: +\\w+)*)?");
        addPattern(DATE_PATTERN);
    }

    /**
     * Creates a DeadlineCommand with the specified description and end date.
     *
     * @return The created DeadlineCommand.
     */
    @Override
    protected Command createCommand() {
        String description = inputs.poll();
        String endDate = inputs.poll();
        return new DeadlineCommand(description, Parser.stringToDate(endDate));
    }
}
