package com.api.deliverymanager.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.deliverymanager.dtos.LoginDTO;
import com.api.deliverymanager.dtos.SessaoDTO;
import com.api.deliverymanager.exceptions.GenericException;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.UserRepository;
import com.api.deliverymanager.security.configs.JWTCreator;
import com.api.deliverymanager.security.configs.JWTObject;
import com.api.deliverymanager.security.configs.SecurityConfig;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository repository;
	
    @Autowired
    private PasswordEncoder encoder;

	public SessaoDTO logar(LoginDTO login){
		
		User user = repository.findUserByEmail(login.getEmail());
	    if(user!=null) {
	        boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
	        if (!passwordOk) {
	            throw new GenericException("Senha inválida para o login: " + login.getEmail());
	        }
	        //Estamos enviando um objeto Sessão para retornar mais informações do usuário
	        SessaoDTO sessao = new SessaoDTO();
	        sessao.setLogin(user.getEmail());
	
	        JWTObject jwtObject = new JWTObject();
	        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
	        jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
	        jwtObject.setRoles(user.getRoles());
	        sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
	        return sessao;
	    }else {
	        throw new GenericException("Usuário ou senha inválidos");
	    }
	}
}
