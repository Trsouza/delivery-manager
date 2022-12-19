package com.api.deliverymanager.dtos;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.deliverymanager.models.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	@Size(max = 100)
	@NotBlank(message= "Name cannot be null")
	private String name;
	
	@Size(max = 100)
	@NotBlank(message= "Email cannot be null")
	private String email;

	@Size(max = 20)
	@NotBlank(message= "Password cannot be null")
	private String password;
	
	@NotNull(message= "Role cannot be null")
	private Set<Role> roles;
}
