package com.api.deliverymanager.interfaces;

import com.api.deliverymanager.dtos.EmployeeDTO;
import com.api.deliverymanager.models.Employee;
import com.api.deliverymanager.requests.EmployeeRequest;

public interface EmployeeService {
	
    EmployeeDTO createEmployee(EmployeeRequest d);
	
	Employee verifyIfExists(Long id);
}
