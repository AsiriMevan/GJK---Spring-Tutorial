package com.gjk.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

    @GetMapping("/getMessage")
    public String getMessage() {
        return "Welcome to gain java knowledge";
    }
}
