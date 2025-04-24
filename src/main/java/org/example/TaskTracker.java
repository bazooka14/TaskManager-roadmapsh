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
        Task task = new Task("Купить хлеб в магазине");
        Task task2 = new Task("Купить хлеб в магазине2");

        taskManager.createTask(task);
        taskManager.createTask(task2);
        System.out.println();
    }
}
