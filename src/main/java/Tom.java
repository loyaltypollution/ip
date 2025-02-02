import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tom {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>(100);

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
            String userInput = inputBuffer.nextLine();
            List<String> inputComponents = Arrays.asList(userInput.split(" "));
            String command = inputComponents.get(0);

            switch (command) {
                case "bye":
                    continueReading = false;
                    break;
                case "list":
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(" " + (i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case "mark": {
                    int taskNum;
                    try {
                        taskNum = Integer.parseInt(inputComponents.get(1));
                    } catch (NumberFormatException e) {
                        System.out.println("instruction format is mark [int] please leave an integer");
                        break;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("instruction format is mark [int]");
                        break;
                    }

                    if (taskNum <= 0 || taskNum > tasks.size()) {
                        String errMsg = String.format("Wrong index! There are only %d tasks!", tasks.size());
                        System.out.println(errMsg);
                        break;
                    }
                    Task modifyTask = tasks.get(taskNum - 1);
                    if (modifyTask.markDone()) {
                        System.out.println("Nice! I've marked this task as done:\n  " + modifyTask);
                    } else {
                        System.out.println("No change: this task is already marked as done:\n  " + modifyTask);                        
                    }
                    break;
                }
                    
                case "unmark": {
                    int taskNum;
                    try {
                        taskNum = Integer.parseInt(inputComponents.get(1));
                    } catch (NumberFormatException e) {
                        System.out.println("instruction format is mark [int] please leave an integer");
                        break;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("instruction format is mark [int]");
                        break;
                    }
                    if (taskNum <= 0 || taskNum > tasks.size()) {
                        String errMsg = String.format("Wrong index! There are only %d tasks!", tasks.size());
                        System.out.println(errMsg);
                        break;
                    }
                    Task modifyTask = tasks.get(taskNum - 1);
                    if (modifyTask.markUndone()) {
                        System.out.println("Nice! I've marked this task as done:\n  " + modifyTask);
                    } else {
                        System.out.println("No change: this task is already marked as done:\n  " + modifyTask);                        
                    }
                    break;    
                }

                case "todo": {
                    if (tasks.size() < 100) {
                        tasks.add(new Todo(String.join(" ", inputComponents)));
                        System.out.println(" added: " + userInput);
                    } else {
                        System.out.println(" Task list is full! Cannot add more tasks.");
                    }
                    break;
                }
                case "deadline": {
                    if (tasks.size() < 100) {
                        int deadlinePos = inputComponents.indexOf("/by") + 1;
                        List<String> fromString = inputComponents.subList(deadlinePos, inputComponents.size());
                        String deadline = String.join(" ", fromString);
                        tasks.add(new Deadline(userInput, deadline));
                        System.out.println(" added: " + userInput);
                    } else {
                        System.out.println(" Task list is full! Cannot add more tasks.");
                    }
                    break;
                }
                case "event": {
                    if (tasks.size() < 100) {
                        int fromPos = inputComponents.indexOf("/from") + 1;
                        int toPos = inputComponents.indexOf("/to") + 1;
                        List<String> fromString = inputComponents.subList(fromPos, toPos);
                        String start = String.join(" ", fromString);
                        List<String> toString = inputComponents.subList(toPos, inputComponents.size());
                        String end = String.join(" ", toString);
                        tasks.add(new Event(userInput, start, end));
                        System.out.println(" added: " + userInput);
                    } else {
                        System.out.println(" Task list is full! Cannot add more tasks.");
                    }                    
                    break;
                }

                case "delete":
                    System.err.println("not implemented");
                    break;

                default:
                    
                    if (tasks.size() < 100) {
                        tasks.add(new Task(userInput));
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
