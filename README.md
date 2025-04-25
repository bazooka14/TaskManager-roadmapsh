Вот содержимое `README.md` в виде одного готового файла:

```markdown
# Task CLI Tracker

A simple command-line task tracker built as part of the [roadmap.sh](https://roadmap.sh) project.
This tool allows users to manage tasks directly from the terminal — add, update, delete, mark progress, and list tasks by status.

## Features

- Add new tasks  
- Update existing tasks  
- Delete tasks  
- Mark tasks as in-progress or done  
- List all tasks  
- Filter tasks by status: `todo`, `in-progress`, `done`

```
## Usage

### Add a New Task
```
task-cli add "Buy groceries"
```

### Update a Task
```
task-cli update 1 "Buy groceries and cook dinner"
```

### Delete a Task
```
task-cli delete 1
```

### Mark Task as In Progress
```
task-cli mark-in-progress 1
```

### Mark Task as Done
```
task-cli mark-done 1
```

### List All Tasks
```
task-cli list
```

### List Tasks by Status
```
task-cli list todo
task-cli list in-progress
task-cli list done
```

