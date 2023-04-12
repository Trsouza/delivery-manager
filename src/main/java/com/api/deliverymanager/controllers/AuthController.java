package com.api.deliverymanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.deliverymanager.requests.AuthRequest;
import com.api.deliverymanager.services.AuthServiceImpl;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
	
    @Autowired
    private AuthServiceImpl service;
    
    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody @Valid AuthRequest login){
    	return ResponseEntity.status(HttpStatus.OK).body(service.authenticate(login));        
    }
}