package com.example.sem07hwSpringSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class appControllers {

    /**
     * Домашняя страница.
     * @return представление домашней страницы.
     */
    @GetMapping("/")
    public String home() {return "home";}

    /**
     * Публичная страница.
     * @return представление публичной страницы.
     */
    @GetMapping("/public-data")
    public String userPage(){return "public-page";}

    /**
     * Приватная страница.
     * @return представление приватной страницы.
     */
    @GetMapping("/private-data")
    public String adminPage(){return "private-data";}

    /**
     * Страница отказа в доступе.
     * @return представление отказа в доступе.
     */
    @GetMapping("/access denied")
    public String accessDenied() {return "access-denied";}

    /**
     * Аутентификация пользователя.
     * @return представление аутентификации.
     */
    @GetMapping("/login")
    public String auth() {return "login-page";}
}
