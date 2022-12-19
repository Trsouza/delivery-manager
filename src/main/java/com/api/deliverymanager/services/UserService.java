package com.api.deliverymanager.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.deliverymanager.dtos.UserDTO;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<User> findAllUsersPaged(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Transactional
	public User save(UserDTO userDTO) {
		// verificar se já tem um email igual
		User user = modelMapper.map(userDTO, User.class);
		return repository.save(user);
	}

}
