package com.api.deliverymanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.deliverymanager.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}

