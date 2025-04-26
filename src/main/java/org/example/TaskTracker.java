package org.example;
import java.util.*;

/**
 * Hello world!
 *
 */
public class TaskTracker {
    public static void main( String[] args ) {
        TaskLoader taskLoader = new TaskLoader("tasks.json");
        TaskManager taskManager = new TaskManager(taskLoader.getFileWithTasks(), taskLoader.getTasks());
        TaskPrinter taskPrinter = new TaskPrinter(taskLoader.getTasks());
        CommandLineHandler commandLineHandler = new CommandLineHandler(taskManager, taskPrinter);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("task-cli ");
            String userInput = sc.nextLine();
            commandLineHandler.processCommand(userInput);
        }
    }

}
