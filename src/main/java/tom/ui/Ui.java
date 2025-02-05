package tom.ui;

import java.util.Scanner;

/**
 * Handles the user interface for interacting with the user.
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructs a Ui instance.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads a command from the user.
     *
     * @return The command entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Reads input from the user that matches the specified pattern.
     *
     * @param pattern The pattern to match the input against.
     * @return The input entered by the user that matches the pattern.
     */
    public String readPattern(String pattern) {
        String inp = scanner.nextLine();
        while (!inp.matches(pattern)) {
            showMessage("Invalid format!");
            inp = scanner.nextLine();
        }
        return inp;
    }

    /**
     * Closes the scanner.
     */
    public void closeBuffer() {
        scanner.close();
    }

    /**
     * Displays a welcome message to the user.
     */
    public void showWelcome() {
        String logo = "___________             \n"
                + "\\__    ___/___   _____  \n"
                + "  |    | /  _ \\ /     \\ \n"
                + "  |    |(  <_> )  Y Y  \\\n"
                + "  |____| \\____/|__|_|  /\n"
                + "                     \\/ ";
        String msg = String.format("Hello from\n%s\nWhat can I do for you?", logo);
        showMessage(msg);
    }

    /**
     * Displays a message to the user.
     *
     * @param msg The message to be displayed.
     * @param args The arguments to be formatted into the message.
     */
    public void showMessage(String msg, Object ...args) {
        // Format the message with the variadic arguments
        String outputMsg = String.format(msg, args);
        System.out.println(outputMsg);
    }
}
