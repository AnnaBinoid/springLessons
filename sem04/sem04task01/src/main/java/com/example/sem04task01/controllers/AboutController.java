package com.example.sem04task01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping
    public String about(){
        return "about";
    }
}
