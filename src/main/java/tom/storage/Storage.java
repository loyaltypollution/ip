package tom.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tom.task.Task;
import tom.tasklist.TaskList;

/**
 * Handles the storage of tasks to a file.
 */
public class Storage {
    private String filePath;

    /**
     * Constructs a Storage instance with the specified file path.
     *
     * @param filePath The file path for storing tasks.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the tasks to the file.
     *
     * @param tasks The list of tasks to be saved.
     * @return true if the tasks were saved successfully, false otherwise.
     */
    public boolean saveFile(TaskList tasks) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter taskWriter = new BufferedWriter(new FileWriter(filePath));
            String tasksText = "";
            for (Task task : tasks) {
                tasksText += task.toFileFormatString();
            }
            taskWriter.write(tasksText);
            taskWriter.close();
        } catch (IOException e) {
            System.out.println("Error caught with message: " + e.getMessage());
            return false;
        }
        return true;
    }
}
