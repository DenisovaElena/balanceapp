package ru.example.balanceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "profile";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
