package com.security.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello, Public!";
    }

    @GetMapping("/user/hello")
    public String userHello() {
        return "Hello, User!";
    }

    @GetMapping("/admin/hello")
    public String adminHello() {
        return "Hello, Admin!";
    }
}

