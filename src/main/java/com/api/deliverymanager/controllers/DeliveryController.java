package com.api.deliverymanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.deliverymanager.models.Delivery;
import com.api.deliverymanager.services.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	private DeliveryService service;

	@GetMapping
	public @ResponseBody List<Delivery> findAllOrders() {
		return service.findAll();
	}
	
	@GetMapping("/sorted-by-date")
	public @ResponseBody List<Delivery> findAllByOrderByExpectedDeliveryDateAsc() {
		return service.findAllByOrderByExpectedDeliveryDateAsc();
	}
}