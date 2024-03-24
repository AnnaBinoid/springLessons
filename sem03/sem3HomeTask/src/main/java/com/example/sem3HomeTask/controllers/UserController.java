package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")//localhost:8080/users
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService()
                .getRepository()
                .getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService()
                .getRepository()
                .getUsers()
                .add(user);
        return "User added from body!";

        //Cannot invoke "com.example.sem3HomeTask.services.DataProcessingService.getRepository()"
        // because the return value of "com.example.sem3HomeTask.services.RegistrationService.getDataProcessingService()" is null
    }

}
