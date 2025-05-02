package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineHandler {
    private final Pattern patternAdd = Pattern.compile("^add\\s+\"([^\"]+)\"$");
    private final Pattern patternUpdate = Pattern.compile("^update\\s+(\\d+)\\s+\"([^\"]+)\"$");
    private final Pattern patternDelete = Pattern.compile("^delete\\s+(\\d+)$");
    private final Pattern patternMarkInProgress = Pattern.compile("^mark-in-progress\\s+(\\d+)$");
    private final Pattern patternMarkDone = Pattern.compile("^mark-done\\s+(\\d+)$");
    private final Pattern patternListAll = Pattern.compile("^list$");
    private final Pattern patternListDone = Pattern.compile("^list\\s+done$");
    private final Pattern patternListTodo = Pattern.compile("^list\\s+todo$");
    private final Pattern patternListInProgress = Pattern.compile("^list\\s+in-progress$");

    TaskService taskService;
    TaskOutput taskOutput;

    public CommandLineHandler(TaskService taskService, TaskOutput taskOutput) {
        this.taskService = taskService;
        this.taskOutput = taskOutput;
    }

    public void processCommand(String input) {
        Matcher matcher;

        matcher = patternAdd.matcher(input);
        if (matcher.matches()) {
            String taskDescription = matcher.group(1);
            taskService.createTask(taskDescription);
        }

        matcher = patternUpdate.matcher(input);
        if (matcher.matches()) {
            int taskId = Integer.parseInt(matcher.group(1));
            String newDescription = matcher.group(2);
            taskService.updateTaskDescription(taskId, newDescription);
        }

        matcher = patternDelete.matcher(input);
        if (matcher.matches()) {
            int taskId = Integer.parseInt(matcher.group(1));
            taskService.deleteTaskById(taskId);
        }

        matcher = patternMarkInProgress.matcher(input);
        if (matcher.matches()) {
            int taskId = Integer.parseInt(matcher.group(1));
            taskService.updateTaskStatusById(taskId, Task.TaskStatus.IN_PROGRESS);
        }

        matcher = patternMarkDone.matcher(input);
        if (matcher.matches()) {
            int taskId = Integer.parseInt(matcher.group(1));
            taskService.updateTaskStatusById(taskId, Task.TaskStatus.DONE);
        }

        matcher = patternListAll.matcher(input);
        if (matcher.matches()) {
            taskOutput.printAllTasks();
        }

        matcher = patternListDone.matcher(input);
        if (matcher.matches()) {
            taskOutput.printTasksThatAreDone();
        }

        matcher = patternListTodo.matcher(input);
        if (matcher.matches()) {
            taskOutput.printTasksThatAreTodo();
        }

        matcher = patternListInProgress.matcher(input);
        if (matcher.matches()) {
            taskOutput.printTasksThatAreInProgress();
        }
    }

}
