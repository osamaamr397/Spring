package com.global.hr.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employee {
    @GetMapping("/name")
    public String getName(){
        return "hello bitches";
    }
}
