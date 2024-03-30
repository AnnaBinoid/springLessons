package com.example.s05hwTaskManager.services;

import com.example.s05hwTaskManager.domain.Task;
import com.example.s05hwTaskManager.domain.TaskStatus;
import com.example.s05hwTaskManager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public List<Task> findByStatus(TaskStatus taskStatus) {
        return taskRepository.findByStatus(taskStatus);
    }

    public Task updateTaskStatus(Long id, Task task){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()) {
            Task task1 = optionalTask.get();
            task1.setStatus(task.getStatus());
            return taskRepository.save(task1);
        }
        else {
            throw new IllegalArgumentException("Task wasn't found by this id.");
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
