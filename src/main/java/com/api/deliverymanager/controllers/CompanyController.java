package com.api.deliverymanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.deliverymanager.models.Company;
import com.api.deliverymanager.services.CompanyService;

@RestController
@RequestMapping("/company")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class CompanyController {

	@Autowired
	private CompanyService service;

	@GetMapping
	public @ResponseBody List<Company> findAllCompanies() {
		return service.findAllCompanies();
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Company>> findAllCompaniesPaged(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllCompaniesPaged(pageable));
	}
}