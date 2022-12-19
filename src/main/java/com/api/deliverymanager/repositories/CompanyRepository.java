package com.api.deliverymanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.deliverymanager.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	
}

