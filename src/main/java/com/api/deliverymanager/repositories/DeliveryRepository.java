package com.api.deliverymanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.deliverymanager.models.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

	List<Delivery> findAllByOrderByExpectedDeliveryDateAsc();
}

