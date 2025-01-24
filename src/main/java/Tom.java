import java.util.Scanner;

public class Tom {
    public static void main(String[] args) {
        String logo = "___________             \n"
                    + "\\__    ___/___   _____  \n"
                    + "  |    | /  _ \\ /     \\ \n"
                    + "  |    |(  <_> )  Y Y  \\\n"
                    + "  |____| \\____/|__|_|  /\n"
                    + "                     \\/ \n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");

        Scanner inputBuffer = new Scanner(System.in);
        while (true) {
            String userInput = inputBuffer.nextLine();
            if (userInput.equals("bye")) {
                break;
            }
            System.out.println(userInput);
        }
        inputBuffer.close();

        System.out.println("Bye. Hope to see you again soon!");
    }
}


