package com.api.deliverymanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {

	private Long id;
	private String name;
	private String email;
	private String cnpj;
	private String phone;
	private Boolean status;

}