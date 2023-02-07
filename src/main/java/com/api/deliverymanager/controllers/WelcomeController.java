package com.api.deliverymanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    @GetMapping("/role-user")
    public String users() {
        return "Authorized user";
    }
    @GetMapping("/role-adm")
    public String managers() {
        return "Authorized adm";
    }
}