```markdown
https://roadmap.sh/projects/task-tracker
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


```markdown
# Task CLI Tracker

A simple command-line task tracker built as part of the [roadmap.sh](https://roadmap.sh) project. This tool allows users to manage tasks directly from the terminal — add, update, delete, mark progress, and list tasks by status.

## Features

- Add new tasks  
- Update existing tasks  
- Delete tasks  
- Mark tasks as in-progress or done  
- List all tasks  
- Filter tasks by status: `todo`, `in-progress`, `done`

## Usage

### Add a New Task
``
task-cli add "Buy groceries"
# Output: Task added successfully (ID: 1)
```

### Update a Task
```bash
task-cli update 1 "Buy groceries and cook dinner"
```

### Delete a Task
```bash
task-cli delete 1
```

### Mark Task as In Progress
```bash
task-cli mark-in-progress 1
```

### Mark Task as Done
```bash
task-cli mark-done 1
```

### List All Tasks
```bash
task-cli list
```

### List Tasks by Status
```bash
task-cli list todo
task-cli list in-progress
task-cli list done
```

## Installation

To run the project from source, you'll need to clone the repository and build it using Maven.

### Prerequisites

- Java 8 or higher
- Maven 3.x or higher

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/bazooka14/TaskManager-roadmapsh
   cd TaskManager-roadmapsh
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Once the build is successful, you can run the application using Maven:
   ```bash
   mvn exec:java
   ```

### Running Specific Goals

If you want to run a specific goal or test the CLI functionality, you can use the following Maven commands:

- To compile the project:
  ```bash
  mvn compile
  ```

## License

This project is open-source and available under the [MIT License](LICENSE).

---
