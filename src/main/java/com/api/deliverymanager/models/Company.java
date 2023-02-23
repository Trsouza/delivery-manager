package com.api.deliverymanager.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OM_COMPANY")
@PrimaryKeyJoinColumn(name = "userId")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@Column(nullable = false, length = 20)
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Delivery> orders;
    
//	@JsonIgnore
//	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	private List<Deliveryman> couriers;
	
    @Builder
    public Company(final String cnpj, final String phone, 
    				final Long id, final String name, 
    				final String email, final String password, 
    				final Boolean status, final List<String> roles ) {
        super(id, name, email, password, status, roles);
        this.cnpj = cnpj;
        this.phone = phone;
    }
}
