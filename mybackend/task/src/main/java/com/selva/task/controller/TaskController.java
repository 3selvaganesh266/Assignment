package com.selva.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.selva.task.model.Task;
import java.util.List;
import com.selva.task.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

   @PostMapping
    public Task createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(
                taskRequest.getUserId(),
                taskRequest.getTaskName(),
                taskRequest.getAssignedByHrName(),
                taskRequest.getDeadline(),
                taskRequest.getStatus()
        );
    }


    // Retrieve a task by its ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Retrieve all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Retrieve all tasks for a specific user
    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    // Update a task by its ID
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, 
                           @RequestParam String taskName, 
                           @RequestParam String assignedByHrName, 
                           @RequestParam String deadline, 
                           @RequestParam String status) {
        return taskService.updateTask(id, taskName, assignedByHrName, deadline, status);
    }

    // Delete a task by its ID
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    // Retrieve tasks by status
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }
}
