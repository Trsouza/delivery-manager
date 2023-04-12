package com.api.deliverymanager.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.deliverymanager.dtos.EmployeeDTO;
import com.api.deliverymanager.interfaces.EmployeeService;
import com.api.deliverymanager.mapper.EmployeeMapper;
import com.api.deliverymanager.models.Employee;
import com.api.deliverymanager.repositories.EmployeeRepository;
import com.api.deliverymanager.requests.EmployeeRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Transactional
    public EmployeeDTO createEmployee(EmployeeRequest d){
		
        Employee deliveryman = employeeMapper.requestToModel(d);
        deliveryman.setPassword(passwordEncoder.encode(d.getPassword()));
        deliveryman.setStatus(true);
		
		return employeeMapper.modelToDTO(repository.saveAndFlush(deliveryman));
		
    }

	public Employee verifyIfExists(Long id) throws ObjectNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Employee"));
	}
}
