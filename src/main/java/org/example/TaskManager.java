package org.example;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TaskManager {
    private final File file;
    private final ObjectMapper mapper;
    private List<Task> tasks;


    public TaskManager() {
        file = new File("tasks.json");
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        if (file.exists() && file.length() > 0) {
            try {
                tasks = new ArrayList<>(Arrays.asList(mapper.readValue(file, Task[].class)));
                Collections.sort(tasks);
                Task.setLastId(tasks.get(tasks.size() - 1).getId());
            } catch (IOException e) {
                System.out.println("Filed to read tasks from file");
            }
        } else {
            tasks = new ArrayList<>();
        }
    }


    public void createTask(String taskDescriptiom) {
        try {
            Task task = new Task(taskDescriptiom);
            tasks.add(task);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, tasks);
            System.out.printf("Task added successfully (ID: %d)\n", task.getId());
        }
        catch (IOException e) {
            System.out.println("Error creating task: " + e.getMessage());
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void updateTaskDescription(int id, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                try {
                    task.setDescription(newDescription);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(file, tasks);
                    System.out.println("Task updated successfully");
                    break;
                } catch (IOException e) {
                    System.out.println("Filed to update task");
                }
            }
        }
        System.out.println("No such task");
    }

    public void updateTaskStatusById(int id, Task.TaskStatus taskStatus) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                try {
                    task.setStatus(taskStatus);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(file, tasks);
                    System.out.println("Task status updated successfully");
                    break;
                } catch (IOException e) {
                    System.out.println("Filed to update task status");
                }
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
                    mapper.writerWithDefaultPrettyPrinter().writeValue(file, tasks);
                    System.out.println("Task deleted successfully");
                    break;
                } catch (IOException e) {
                    System.out.println("Filed to delete task");
                }
            }
        }
        System.out.println("No such task");
    }
}
