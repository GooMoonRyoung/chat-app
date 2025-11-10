package com.chatapp.server.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from Java (Spring Boot) Backend!";
    }

    @GetMapping("/api/hello")
    public String helloChain() {
        return "Hello, From Angular -> Go -> Java Chain Works!";
    }
}
