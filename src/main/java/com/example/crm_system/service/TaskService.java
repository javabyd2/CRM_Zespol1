package com.example.crm_system.service;

import com.example.crm_system.model.Task;
import com.example.crm_system.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        task.setDateCreated(new Timestamp(System.currentTimeMillis()));
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTasksById(Long id){
        return taskRepository.findById(id).get();
    }

    public void deleteTask(Long id){
        taskRepository.delete(getTasksById(id));
    }
}