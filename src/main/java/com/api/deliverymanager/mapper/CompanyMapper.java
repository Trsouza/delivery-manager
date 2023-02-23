package com.api.deliverymanager.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.deliverymanager.dtos.CompanyDTO;
import com.api.deliverymanager.models.Company;
import com.api.deliverymanager.requests.CompanyRequest;

@Component
public class CompanyMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CompanyDTO modelToDTO(Company company) {
		return modelMapper.map(company, CompanyDTO.class);
	}

	public Company requestToModel(CompanyRequest companyRequest) {
		return modelMapper.map(companyRequest, Company.class);
	}
	
	public CompanyRequest modelToRequest(Company company) {
		return modelMapper.map(company, CompanyRequest.class);
	}

}
