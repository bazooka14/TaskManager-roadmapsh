package org.example;
import java.util.*;

/**
 * Hello world!
 *
 */
public class TaskTrackerApplication {
    public static void main( String[] args ) {
        TaskRepository taskRepository = new TaskRepository("tasks.json");
        TaskService taskService = new TaskService(taskRepository.getFileWithTasks(), taskRepository.getTasks());
        TaskOutput taskOutput = new TaskOutput(taskRepository.getTasks());
        CommandLineHandler commandLineHandler = new CommandLineHandler(taskService, taskOutput);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("task-cli ");
            String userInput = sc.nextLine();
            if (userInput.equals("exit")) {
                break;
            } else {
                commandLineHandler.processCommand(userInput);
            }
        }
    }

}
