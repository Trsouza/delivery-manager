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
	
	public EmployeeDTO modelToDTO(Employee deliveryman) {
		return modelMapper.map(deliveryman, EmployeeDTO.class);
	}

	public Employee requestToModel(EmployeeRequest deliverymanRequest) {
		return modelMapper.map(deliverymanRequest, Employee.class);
	}
	
	public EmployeeRequest ModelToRequest(Employee deliveryman) {
		return modelMapper.map(deliveryman, EmployeeRequest.class);
	}

}
