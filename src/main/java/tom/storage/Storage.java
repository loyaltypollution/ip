package tom.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tom.task.Task;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void saveFile() {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter taskWriter = new BufferedWriter(new FileWriter(filePath));
            String tasksText = "";
            taskWriter.write(tasksText);
            taskWriter.close();
        } catch (IOException e) {
            System.out.println("Error caught with message: " + e.getMessage());
        }
        System.out.println("Successfully saved file to " + filePath);
    }
}
