package tom.command;

import tom.storage.Storage;
import tom.tasklist.TaskList;
import tom.ui.Ui;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList matchedTasks = tasks.findTasks(keyword);
        ui.showMessage("Here are the matching tasks in your list:");
        
        // Let the ListCommand handle the printing of the matched tasks
        new ListCommand().execute(matchedTasks, ui, storage);
    };

    @Override
    public boolean isExit() {
        return false;
    }
}
