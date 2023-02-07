package com.api.deliverymanager.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AuthRequest {


	@NotBlank(message= "Email cannot be null")
	private String email;

	@NotBlank(message= "Password cannot be null")
	private String password;
	
}
