package com.example.catalogservice;

import com.example.catalogservice.config.AppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final AppConfig config;

    HomeController(AppConfig config) {
        this.config = config;

    }
    @GetMapping("/")
    public String home() {
        return config.getGreeting();
    }
}
