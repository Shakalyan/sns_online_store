package com.sns.online_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/auth/login")
    public String login(@RequestParam(value = "error", required = false) Boolean error,
                        @RequestParam(value = "logout", required = false) Boolean logout) {
        return "login";
    }

    @GetMapping("/")
    public String getMain() {
        return "main";
    }

    @GetMapping("/auth/registration")
    public String registration() {
        return "registration";
    }

}
