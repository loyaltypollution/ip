package tom.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tom.task.Task;
import tom.tasklist.TaskList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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
