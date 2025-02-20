package tom.ui;

import java.util.function.Consumer;

/**
 * Abstracts the user interface for interacting with the user.
 */
public interface Ui {

    public void showMessage(String msg, Object ...args);

    public void promptForInput(String promptMsg, Consumer<String> onInputReceived);

    public void findWindow(int key);
}
