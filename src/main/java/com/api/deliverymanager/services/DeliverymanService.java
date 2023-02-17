package com.api.deliverymanager.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.deliverymanager.dtos.EmployeeDTO;
import com.api.deliverymanager.mapper.EmployeeMapper;
import com.api.deliverymanager.models.Employee;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.EmployeeRepository;
import com.api.deliverymanager.requests.EmployeeRequest;

@Service
public class DeliverymanService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Transactional
    public EmployeeDTO createEmployee(EmployeeRequest d){
	
        User user = User.builder() 
				.name(d.getName())
				.email(d.getEmail())
				.roles(d.getRoles())
				.password(passwordEncoder.encode(d.getPassword()))
				.build();
		userService.createUser(user);
		
        Employee deliveryman = employeeMapper.requestToModel(d);
		
		return employeeMapper.modelToDTO(repository.save(deliveryman));
    }

	private Employee verifyIfExists(Long id) throws ObjectNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Form"));
	}
}
