package com.api.deliverymanager.requests;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {

	@Size(max = 150)
	@NotBlank(message= "Name cannot be null")
	private String name;
	
	@Size(max = 100)
	@NotBlank(message= "Email cannot be null")
	private String email;

	@Size(max = 20)
	@NotBlank(message= "Password cannot be null")
	private String password;
	
	@Size(max = 20)
	@NotBlank(message= "Password cannot be null")
	private String phone;
	
	@Size(max = 11)
	@NotBlank(message= "Cpf cannot be null")
	private String cpf;
		
//	@NotNull(message= "Role cannot be null")
//	private Set<Role> roles;
	
	@NotNull(message= "Role cannot be null")
	private List<String> roles;
}
