import java.util.Scanner;

public class Tom {
    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        int taskCount = 0;

        String logo = "___________             \n"
                + "\\__    ___/___   _____  \n"
                + "  |    | /  _ \\ /     \\ \n"
                + "  |    |(  <_> )  Y Y  \\\n"
                + "  |____| \\____/|__|_|  /\n"
                + "                     \\/ \n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");

        Scanner inputBuffer = new Scanner(System.in);
        boolean continueReading = true;
        while (continueReading) {
            String userInput = inputBuffer.next();
            switch (userInput) {
                case "bye":
                    continueReading = false;
                    break;
                case "list":
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println(" " + (i + 1) + ". " + tasks[i]);
                    }
                    break;
                case "mark": {
                    int taskNum = inputBuffer.nextInt();
                    if (taskNum >= taskCount) {
                        String errMsg = String.format("Wrong index! There are only %d tasks!", taskCount);
                        System.out.println(errMsg);
                        break;
                    }
                    Task modifyTask = tasks[taskNum - 1];
                    if (modifyTask.markDone()) {
                        System.out.println("Nice! I've marked this task as done:\n  " + modifyTask);
                    } else {
                        System.out.println("No change: this task is already marked as done:\n  " + modifyTask);                        
                    }
                    break;
                }
                    
                case "unmark": {
                    int taskNum = inputBuffer.nextInt();
                    if (taskNum >= taskCount) {
                        String errMsg = String.format("Wrong index! There are only %d tasks!", taskCount);
                        System.out.println(errMsg);
                        break;
                    }
                    Task modifyTask = tasks[taskNum - 1];
                    if (modifyTask.markUndone()) {
                        System.out.println("Nice! I've marked this task as done:\n  " + modifyTask);
                    } else {
                        System.out.println("No change: this task is already marked as done:\n  " + modifyTask);                        
                    }
                    break;    
                }

                default:
                    
                    if (taskCount < 100) {
                        tasks[taskCount] = new Task(userInput);
                        taskCount++;
                        System.out.println(" added: " + userInput);
                    } else {
                        System.out.println(" Task list is full! Cannot add more tasks.");
                    }
            }
        }
        inputBuffer.close();

        System.out.println("Bye. Hope to see you again soon!");
    }
}
