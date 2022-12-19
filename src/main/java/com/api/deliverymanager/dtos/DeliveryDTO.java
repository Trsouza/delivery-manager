package com.api.deliverymanager.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDTO {

	@NotBlank(message= "expectedDeliveryDate cannot be null")
	private LocalDateTime expectedDeliveryDate;
}
