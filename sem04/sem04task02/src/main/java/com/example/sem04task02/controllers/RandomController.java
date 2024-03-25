package com.example.sem04task02.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {


    @Value("${data.parameter.min:25}")
    private Integer minDefault;

    @Value("${data.parameter.max:100}")
    private Integer maxDefault;


    @GetMapping("/random/{min}/{max}")
    public String getRandomNumber(@PathVariable("min") int min,
                                  @PathVariable("max") int max,
                                  Model model) {
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("min_default", minDefault);
        model.addAttribute("max_default", maxDefault);
        model.addAttribute("number",
                new Random().nextInt(min, max+1));
        return "random";
    }

    @GetMapping("/random")
    public String getRandom(@RequestParam("min") Integer min,
                            @RequestParam("max") Integer max,
                            Model model){
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number",
                new Random().nextInt(min, max + 1));
        return "random";
    }
}
