package com.api.deliverymanager.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.deliverymanager.dtos.EmployeeDTO;
import com.api.deliverymanager.models.Employee;
import com.api.deliverymanager.requests.EmployeeRequest;

@Component
public class EmployeeMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeDTO modelToDTO(Employee employee) {
		return modelMapper.map(employee, EmployeeDTO.class);
	}

	public Employee requestToModel(EmployeeRequest employeeRequest) {
		return modelMapper.map(employeeRequest, Employee.class);
	}
	
	public EmployeeRequest modelToRequest(Employee employee) {
		return modelMapper.map(employee, EmployeeRequest.class);
	}

}
