package com.api.deliverymanager.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class JWTObject {

	private String subject; //nome do usuario
    private Date issuedAt; //data de criação do token
    private Date expiration; // data de expiração do token
    private List<String> roles; //perfis de acesso   

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
    public void setRoles(String... roles){
        this.roles = Arrays.asList(roles);
    }
	    
}
