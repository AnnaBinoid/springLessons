package com.example.sem3example2REST.helloController;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/chao")
    public String chao() {
        return "Chao!";
    }
}
