import java.util.Scanner;

public class Tom {
    public static void main(String[] args) {
        String[] tasks = new String[100];
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
                default:
                    if (taskCount < 100) {
                        tasks[taskCount] = userInput;
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
