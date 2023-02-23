package com.api.deliverymanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.deliverymanager.security.CheckSecurity;
@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    
    @CheckSecurity.CanAccessAnyAuthority
    @GetMapping("/role-user")
    public String users() {
        return "Authorized user";
    }
    
    @CheckSecurity.CanAccessOnlyAuthorityAdministrator
    @GetMapping("/role-adm")
    public String managers() {
        return "Authorized adm";
    }
}