package com.api.deliverymanager.interfaces;

import java.util.List;

import com.api.deliverymanager.models.Delivery;

public interface DeliveryService {
	
	public List<Delivery> findAll();
	
	public List<Delivery> findAllByOrderByExpectedDeliveryDateAsc();

}
