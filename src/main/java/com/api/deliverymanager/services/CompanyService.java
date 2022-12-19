package com.api.deliverymanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.deliverymanager.models.Company;
import com.api.deliverymanager.repositories.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository repository;
	
	@Transactional(readOnly = true)
	public List<Company> findAllCompanies() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Company> findAllCompaniesPaged(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
