package tom.ui;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public String readPattern(String pattern) {
        String inp = scanner.nextLine();
        while (!inp.matches(pattern)) {
            showMessage("Invalid format!");
            inp = scanner.nextLine();
        }
        return inp;
    }

    public void closeBuffer() {
        scanner.close();
    }

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

    public void showMessage(String msg, Object ...args) {
        String outputMsg = String.format(msg, args);
        System.out.println(outputMsg);
    }
}
