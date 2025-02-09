package tom.tasklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tom.task.Task;
import tom.task.Todo;

public class TaskListTest {
    private TaskList taskList;
    private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
        task1 = new Todo("Task 1");
        task2 = new Todo("Task 2");
    }

    @Test
    public void constructor_initializesEmptyList() {
        assertEquals(0, taskList.size());
    }

    @Test
    public void addTask_increasesSize() {
        taskList.addTask(task1);
        assertEquals(1, taskList.size());
    }

    @Test
    public void removeTask_decreasesSize() {
        taskList.addTask(task1);
        taskList.addTask(task2);
        assertTrue(taskList.removeTask(1));
        assertEquals(1, taskList.size());
    }

    @Test
    public void removeTask_invalidPosition_returnsFalse() {
        taskList.addTask(task1);
        assertFalse(taskList.removeTask(0));
        assertFalse(taskList.removeTask(2));
    }

    @Test
    public void markTask_done() {
        taskList.addTask(task1);
        assertTrue(taskList.markTask(1, true));
        assertEquals("X", task1.getStatusIcon());
    }

    @Test
    public void markTask_undone() {
        taskList.addTask(task1);
        taskList.markTask(1, true);
        assertTrue(taskList.markTask(1, false));
        assertEquals(" ", task1.getStatusIcon());
    }
}
