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
            String userInput = sc.nextLine();
            commandLineHandler.processCommand(userInput);
        }
    }


}
