package com.example.s05hwTaskManager.controller;

import com.example.s05hwTaskManager.domain.Task;
import com.example.s05hwTaskManager.domain.TaskStatus;
import com.example.s05hwTaskManager.services.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    /**
     * Добавление задачи.
     * @return задача.
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){

        return taskService.addTask(task);
    }

    /**
     * Получения списка всех задач.
     * @return список задач.
     */
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    /**
     * Получение всех задач с определенным статусом.
     * @param status - статус, по которому осуществляется фильтрация.
     * @return список задач с заданным статусом.
     */
    @GetMapping("/task_status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.findByStatus(status);
    }

    /**
     * Изменение статуса задачи.
     * @param id - айди задачи, статус которой надо изменить.
     * @param task - задача, которую надо изменить.
     * @return задача с измененным статусом.
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTaskStatus(id, task);
    }

    /**
     * Удаление задачи из листа задач по id.
     * @param id- id искомой задачи.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
