package com.api.deliverymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.deliverymanager.dtos.LoginDTO;
import com.api.deliverymanager.services.LoginService;

@RestController
public class LoginController {
	
    @Autowired
    private LoginService service;
    
    @PostMapping("/login")
    public ResponseEntity<Object> logar(@RequestBody LoginDTO login){
    	return ResponseEntity.status(HttpStatus.OK).body(service.logar(login));        
    }
}