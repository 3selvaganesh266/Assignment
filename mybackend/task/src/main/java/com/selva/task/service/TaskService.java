package com.selva.task.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.selva.task.model.Task;
import com.selva.task.repo.TaskRepository;

import java.util.List;
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Long userId, String taskName, String assignedByHrName, String deadline, String status) {
        if (userId == null || taskName == null || assignedByHrName == null || deadline == null || status == null) {
            throw new IllegalArgumentException("All task fields must be provided");
        }
        Task task = new Task();
        task.setId(userId);
        task.setTaskName(taskName);
        task.setAssignedByHrName(assignedByHrName);
        task.setDeadline(deadline);
        task.setStatus(status);
        return taskRepository.save(task);
    }
     
 


    public Task createTask(Task task) {
        if (task.getId() == null) {
            // Handle the case where the ID is null
            throw new IllegalArgumentException("Task ID must not be null");
        }
        return taskRepository.save(task);
    }
    
    // Retrieve a task by its ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    // Retrieve all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Retrieve all tasks for a specific user
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    // Update a task by its ID
    public Task updateTask(Long id, String taskName, String assignedByHrName, String deadline, String status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTaskName(taskName);
        task.setAssignedByHrName(assignedByHrName);
        task.setDeadline(deadline);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    // Delete a task by its ID
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }

    // Retrieve tasks by status
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
