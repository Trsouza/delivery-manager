package com.api.deliverymanager.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.deliverymanager.dtos.UserDTO;
import com.api.deliverymanager.models.User;

public interface UserService {
    
	List<UserDTO> findAll();
    
    Page<User> findAllUsersPaged(Pageable pageable);
    
    User findUserByEmail(String email);


}
