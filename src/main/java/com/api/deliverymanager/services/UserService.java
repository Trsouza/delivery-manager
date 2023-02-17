package com.api.deliverymanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.deliverymanager.dtos.UserDTO;
import com.api.deliverymanager.mapper.UserMapper;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper userMapper;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> users = repository.findAll();
		return users.stream().map(user -> userMapper.modelToDTO(user)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<User> findAllUsersPaged(Pageable pageable) {
		Page<User> users = repository.findAll(pageable);
		var x = users.getContent();
		return users;
//				(Page<UserDTO>) users.getContent().stream().map(user -> userMapper.modelToDTO(user)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public User findUserByEmail(String email) {
		return repository.findUserByEmail(email);
	}
	
	@Transactional
    public void createUser(User user){
        repository.save(user);
    }

}
