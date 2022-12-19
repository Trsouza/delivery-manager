package com.api.deliverymanager.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "OM_DELIVERY")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Delivery implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private LocalDateTime deliveryDate;
	private LocalDateTime sendDate;
	private LocalDateTime firstTry;
	private LocalDateTime secondTry;
	private LocalDateTime expectedDeliveryDate;
	
    @NotNull(message = "Company cannot be null")
    @ManyToOne 
    private Company company;
    
    @NotNull(message = "Deliveryman cannot be null")
    @ManyToOne 
    private Deliveryman deliveryman;
	
}
