package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Task implements Comparable<Task>{
    @JsonIgnore
    private static int lastId = 0;

    private String description;
    private int id;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum TaskStatus {
        TODO, IN_PROGRESS, DONE;
    }


    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @JsonCreator
    public Task(@JsonProperty("description") String description,
                @JsonProperty("id") int id,
                @JsonProperty("status") TaskStatus status,
                @JsonProperty("createdAt") LocalDateTime createdAt,
                @JsonProperty("updatedAt") LocalDateTime updatedAt) {
        this.description = description;
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static void setLastId(int id) {
        Task.lastId = id;
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public String toString() {
        return id + " " + description + " " + status + " " + createdAt + " " + updatedAt;
    }


}

