package com.api.deliverymanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.deliverymanager.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User u where u.email= :email")
	User findUserByEmail(String email);
	
}

