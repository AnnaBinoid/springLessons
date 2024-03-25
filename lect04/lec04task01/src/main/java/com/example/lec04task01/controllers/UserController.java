package com.example.lec04task01.controllers;

import com.example.lec04task01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * Внедряем зависимость, чтобы можно было
     * брать информацию с Service
     * и подставлять её в Controller.
     */
    @Autowired
    private UserService userService;

    /**
     * Метод для возврата списка "users" из папки "templates"
     */
    @GetMapping
    public String ListUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    /**
     * Метод для поиска пользователя по id
     * @param id - передаем в запросе URL id пользователя
     * @param model - внедрение класса Model, чтобы положить определенные значения
     * @return
     */

    @GetMapping ("/{id}")
    public String getUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "userProfile";
    }
}
