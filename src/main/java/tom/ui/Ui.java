package tom.ui;

import java.util.Scanner;

public class Ui {
    Scanner inputBuffer;

    public Ui() {
        this.inputBuffer = new Scanner(System.in);
    }

    public String readLine() {
        return inputBuffer.nextLine();
    }

    public void closeBuffer() {
        inputBuffer.close();
    }

    public void showWelcome() {
        String logo = "___________             \n"
                + "\\__    ___/___   _____  \n"
                + "  |    | /  _ \\ /     \\ \n"
                + "  |    |(  <_> )  Y Y  \\\n"
                + "  |____| \\____/|__|_|  /\n"
                + "                     \\/ ";
        String msg = String.format("Hello from\n%s\nWhat can I do for you?", logo);
        this.showMessage(msg);
    }

    public void showMessage(String msg, Object ...args) {
        String outputMsg = String.format(msg, args);
        System.out.println(outputMsg);
    }
}
