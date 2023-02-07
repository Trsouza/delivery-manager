package com.api.deliverymanager.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.UserRepository;
import com.api.deliverymanager.requests.UserRequest;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private PasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<User> findAllUsersPaged(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Transactional
    public void createUser(UserRequest userRequest){
        String pass = userRequest.getPassword();
        userRequest.setPassword(encoder.encode(pass));
        User user = modelMapper.map(userRequest, User.class);
        repository.save(user);
    }

}
