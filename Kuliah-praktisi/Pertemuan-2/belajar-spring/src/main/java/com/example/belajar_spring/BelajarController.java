package com.example.belajar_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BelajarController {

    @GetMapping("/")
    public String showIndex () {
        return "welcome";
    }
}
