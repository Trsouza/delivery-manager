package com.api.deliverymanager.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name = "OM_EMPLOYEE")
@PrimaryKeyJoinColumn(name = "userId")
public class Employee extends User {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Column(nullable = false, length = 20)
	private String phone;
	
	@JsonIgnore
	@OrderBy("expectedDeliveryDate ASC")
	@OneToMany(mappedBy = "deliveryman", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Delivery> deliveries;
	
    //@NotNull(message = "Company cannot be null")
//    @ManyToOne 
//    private Company company;
	
    @Builder
    public Employee(final String cpf, final String phone, 
    				final Long id, final String name, 
    				final String email, final String password, 
    				final Boolean status, final List<String> roles ) {
        super(id, name, email, password, status, roles);
        this.cpf = cpf;
        this.phone = phone;
    }
}
