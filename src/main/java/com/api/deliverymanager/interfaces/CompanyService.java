package com.api.deliverymanager.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.deliverymanager.dtos.CompanyDTO;
import com.api.deliverymanager.models.Company;
import com.api.deliverymanager.requests.CompanyRequest;

public interface CompanyService {
	
	List<Company> findAllCompanies();

	Page<Company> findAllCompaniesPaged(Pageable pageable);

    CompanyDTO createCompany(CompanyRequest d);

	Company verifyIfExists(Long id);
}
