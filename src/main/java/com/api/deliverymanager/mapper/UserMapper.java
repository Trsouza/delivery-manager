package com.api.deliverymanager.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.deliverymanager.dtos.UserDTO;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.requests.EmployeeRequest;

@Component
public class UserMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO modelToDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

	public User requestToModel(EmployeeRequest userRequest) {
		return modelMapper.map(userRequest, User.class);
	}
	
	public EmployeeRequest ModelToRequest(User user) {
		return modelMapper.map(user, EmployeeRequest.class);
	}

}
