package com.api.deliverymanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.deliverymanager.requests.EmployeeRequest;
import com.api.deliverymanager.services.DeliverymanService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private DeliverymanService service;
	
	@PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(userRequest));
    }
	
}