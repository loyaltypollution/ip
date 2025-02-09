package tom.ui;

public class Gui implements Ui {

    private final MainWindow MainWindow;

    public Gui(MainWindow MainWindow) {
        this.MainWindow = MainWindow;
    }

    public void showMessage(String msg, Object ...args) {
        // Format the message with the variadic arguments
        String outputMsg = String.format(msg, args);
        MainWindow.addTomDialog(outputMsg);
    }

}
