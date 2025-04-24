package org.example;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class TaskTracker {
    public static void main( String[] args ) throws IOException {
        TaskManager taskManager = new TaskManager();
        TaskPrinter taskPrinter = new TaskPrinter(taskManager);

        taskPrinter.printAllTasks();
    }
}
