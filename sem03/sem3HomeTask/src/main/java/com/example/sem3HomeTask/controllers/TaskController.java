package com.example.sem3HomeTask.controllers;


import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks") //localhost:8080/tasks
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    /**
     * Метод позволяет получить все задачи (методы класса DataProcessingService)
     * @return tasks - список задач
     */
    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Метод вызывает метод DataProcessingService для сортировки
     * пользователей по возрасту
     * @return лист пользователей,отсортированный по возрасту
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUserByAge() {
        return dataProcessingService
                .sortUsersByAge(dataProcessingService.getRepository()
                .getUsers());
    }

    //filterUsersByAge
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge (@PathVariable("age") int age) {
        return dataProcessingService
                .filterUsersByAge(dataProcessingService
                        .getRepository()
                        .getUsers(), age);
    }

    //calculateAverageAge
    @GetMapping("/calc")
    public Double calculateAverageAge() {
        return dataProcessingService
                .calculateAverageAge(dataProcessingService.getRepository().getUsers());
    }


}
