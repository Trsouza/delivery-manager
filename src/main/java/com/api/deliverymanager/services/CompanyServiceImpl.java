package com.api.deliverymanager.services;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.deliverymanager.dtos.CompanyDTO;
import com.api.deliverymanager.interfaces.CompanyService;
import com.api.deliverymanager.mapper.CompanyMapper;
import com.api.deliverymanager.models.Company;
import com.api.deliverymanager.repositories.CompanyRepository;
import com.api.deliverymanager.requests.CompanyRequest;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository repository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Transactional(readOnly = true)
	public List<Company> findAllCompanies() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Company> findAllCompaniesPaged(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Transactional
    public CompanyDTO createCompany(CompanyRequest d){
		
        Company company = companyMapper.requestToModel(d);
        company.setPassword(passwordEncoder.encode(d.getPassword()));
        company.setStatus(true);
		
		return companyMapper.modelToDTO(repository.saveAndFlush(company));
		
    }

	public Company verifyIfExists(Long id) throws ObjectNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Company"));
	}
}
