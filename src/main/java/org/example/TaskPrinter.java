package org.example;

import java.time.format.DateTimeFormatter;

public class TaskPrinter {
    TaskManager taskManager;
    DateTimeFormatter formatter;

    public TaskPrinter(TaskManager taskManager) {
        this.taskManager = taskManager;
        formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
    }

    public void printTaskById(int id) {
        System.out.printf("%2s | %-30s | %-11s | %-14s | %-14s\n",
                "ID", "Description", "Status", "Updated at", "Created at");
        System.out.println("-----------------------------------------------------------------------------------");
        Task task = taskManager.getTaskById(id);
        printTask(task);
    }

    public void printAllTasks() {
        System.out.printf("%2s | %-30s | %-11s | %-14s | %-14s\n",
                "ID", "Description", "Status", "Updated at", "Created at");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Task task: taskManager.getAllTasks()) {
            printTask(task);
        }
    }

    private void printTask(Task task) {
        String formatedUpdatedAt = formatter.format(task.getUpdatedAt());
        String formatedCreatedAt = formatter.format(task.getCreatedAt());
        System.out.printf("%-2d | %-30s | %-11s | %-14s | %-14s\n",
                task.getId(), task.getDescription(), task.getStatus(), formatedUpdatedAt, formatedCreatedAt);
    }
}
