package com.api.deliverymanager.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.deliverymanager.interfaces.DeliveryService;
import com.api.deliverymanager.models.Delivery;
import com.api.deliverymanager.repositories.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryRepository repository;
	
	@Transactional(readOnly = true)
	public List<Delivery> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Delivery> findAllByOrderByExpectedDeliveryDateAsc() {
		return repository.findAllByOrderByExpectedDeliveryDateAsc();
	}

}
