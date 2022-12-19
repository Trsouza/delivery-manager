package com.api.deliverymanager.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "OM_DELIVERYMAN")
public class Deliveryman implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, length = 11)
	private Long cpf;
	
	@JsonIgnore
	@OrderBy("expectedDeliveryDate ASC")
	@OneToMany(mappedBy = "deliveryman", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Delivery> deliveries;
	
    @NotNull(message = "Company cannot be null")
    @ManyToOne 
    private Company company;
	
}
