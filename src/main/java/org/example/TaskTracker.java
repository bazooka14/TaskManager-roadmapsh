package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class TaskTracker {
    public static void main( String[] args ) {
        TaskManager taskManager = new TaskManager();
        TaskPrinter taskPrinter = new TaskPrinter(taskManager);
        CommandLineHandler commandLineHandler = new CommandLineHandler(taskManager, taskPrinter);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("task-cli ");
            String userInput = sc.nextLine();
            commandLineHandler.processCommand(userInput);
        }
    }


}
