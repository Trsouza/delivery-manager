package com.api.deliverymanager.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.deliverymanager.dtos.UserDTO;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.requests.UserRequest;

@Component
public class UserMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO modelToDTO(User animal) {
		return modelMapper.map(animal, UserDTO.class);
	}

	public User requestToModel(UserRequest animalRequest) {
		return modelMapper.map(animalRequest, User.class);
	}
	
	public UserRequest ModelToRequest(User animal) {
		return modelMapper.map(animal, UserRequest.class);
	}

}
