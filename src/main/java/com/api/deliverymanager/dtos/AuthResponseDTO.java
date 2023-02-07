package com.api.deliverymanager.dtos;

import lombok.Data;

@Data
public class AuthResponseDTO {

    private String token;
	private UserDTO user;
}
