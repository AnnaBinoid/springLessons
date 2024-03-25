package com.example.sem04hometask.controllers;

import com.example.sem04hometask.domain.User;
import com.example.sem04hometask.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users",
                userService.getAllUsers());
        return "users.html";
    }


    @PostMapping("/users")
    public String addUser(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users",
                userService.getAllUsers());
        return "users";
    }
}
