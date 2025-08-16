package com.selva.task.controller;

public class TaskRequest {
    private Long userId;
    private String taskName;
    private String assignedByHrName;
    private String deadline;
    private String status;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getAssignedByHrName() {
        return assignedByHrName;
    }
    public void setAssignedByHrName(String assignedByHrName) {
        this.assignedByHrName = assignedByHrName;
    }
    public String getDeadline() {
        return deadline;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Getters and Setters
}
