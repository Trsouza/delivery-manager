package com.api.deliverymanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.deliverymanager.models.Deliveryman;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {

	
}

