package org.example;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TaskManager {
    private final ObjectMapper mapper;
    private File fileWithTasks;
    private List<Task> tasks;


    public TaskManager(File fileWithTasks, List<Task> tasks) {
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.fileWithTasks = fileWithTasks;
        this.tasks = tasks;
    }


    public void createTask(String taskDescriptiom) {
        try {
            Task task = new Task(taskDescriptiom);
            tasks.add(task);
            mapper.writerWithDefaultPrettyPrinter().writeValue(fileWithTasks, tasks);
            System.out.printf("Task added successfully (ID: %d)\n", task.getId());
        }
        catch (IOException e) {
            System.out.println("Error creating task: " + e.getMessage());
        }
    }

    public void updateTaskDescription(int id, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                try {
                    task.setDescription(newDescription);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(fileWithTasks, tasks);
                    System.out.println("Task updated successfully");
                } catch (IOException e) {
                    System.out.println("Filed to update task");
                }
                return;
            }
        }
        System.out.println("No such task");
    }

    public void updateTaskStatusById(int id, Task.TaskStatus taskStatus) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                try {
                    task.setStatus(taskStatus);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(fileWithTasks, tasks);
                    System.out.println("Task status updated successfully");
                } catch (IOException e) {
                    System.out.println("Filed to update task status");
                }
                return;
            }
        }
        System.out.println("No such task");
    }

    public void deleteTaskById(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                try {
                    tasks.remove(task);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(fileWithTasks, tasks);
                    System.out.println("Task deleted successfully");
                } catch (IOException e) {
                    System.out.println("Filed to delete task");
                }
                return;
            }
        }
        System.out.println("No such task");
    }
}
