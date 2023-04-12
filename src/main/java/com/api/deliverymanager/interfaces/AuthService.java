package com.api.deliverymanager.interfaces;

import com.api.deliverymanager.dtos.AuthResponseDTO;
import com.api.deliverymanager.requests.AuthRequest;

public interface AuthService {
	
	AuthResponseDTO authenticate(AuthRequest login);
}
