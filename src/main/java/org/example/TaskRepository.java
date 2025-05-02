package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.*;

    public class TaskRepository {
    @Getter
    private File fileWithTasks;

    @Getter
    private List<Task> tasks;

    private ObjectMapper mapper;

    public TaskRepository(String fileName) {
        fileWithTasks = new File(fileName);
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        if (fileWithTasks.exists() && fileWithTasks.length() > 0) {
            try {
                tasks = new ArrayList<>(Arrays.asList(mapper.readValue(fileWithTasks, Task[].class)));
                Collections.sort(tasks);
                Task.setLastId(tasks.get(tasks.size() - 1).getId());
            } catch (IOException e) {
                System.out.println("Filed to read tasks from file");
            }
        } else {
            tasks = new ArrayList<>();
        }
    }

}
