package com.security.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "home"; // maps to home.html
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "hello"; // maps to hello.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // maps to login.html
    }
}