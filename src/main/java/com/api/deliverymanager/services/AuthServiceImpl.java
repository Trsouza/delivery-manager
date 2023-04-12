package com.api.deliverymanager.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.deliverymanager.dtos.AuthResponseDTO;
import com.api.deliverymanager.exceptions.GenericException;
import com.api.deliverymanager.interfaces.AuthService;
import com.api.deliverymanager.mapper.UserMapper;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.requests.AuthRequest;
import com.api.deliverymanager.security.configs.JWTCreator;
import com.api.deliverymanager.security.configs.JWTObject;
import com.api.deliverymanager.security.configs.SecurityConfig;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserServiceImpl userService;
	
    @Autowired
    private PasswordEncoder encoder;
    
	@Autowired
	private UserMapper userMapper;

	public AuthResponseDTO authenticate(AuthRequest login){
		
		User user = userService.findUserByEmail(login.getEmail());
	    if(user!=null) {
	        boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
	        if (!passwordOk) {
	            throw new GenericException("Senha inválida para o login: " + login.getEmail());
	        }
	        
	        AuthResponseDTO response = new AuthResponseDTO();
	        var userResponse = userMapper.modelToDTO(user);
	        response.setUser(userResponse);
	
	        JWTObject jwtObject = new JWTObject();
	        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
	        jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
	        jwtObject.setRoles(user.getRoles());
	        response.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
	        return response;
	    }else {
	        throw new GenericException("Usuário ou senha inválidos");
	    }
	}
}
