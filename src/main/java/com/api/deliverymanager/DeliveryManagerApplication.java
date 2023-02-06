package com.api.deliverymanager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.UserRepository;

@SpringBootApplication
public class DeliveryManagerApplication implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DeliveryManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Logger logger = Logger.getLogger(DeliveryManagerApplication.class.getName());

		try {

			User user1 = new User();
			user1.setName("Administrador");
			user1.setEmail("adm@gmail.com");
			user1.setPassword(passwordEncoder.encode("123"));
			user1.setRoles(List.of("ADM","USER"));

			User user2 = new User();
			user2.setName("Usuário");
			user2.setEmail("user@gmail.com");
			user2.setPassword(passwordEncoder.encode("123"));
			user2.setRoles(List.of("USER"));
			
			List<User> users = List.of(user1, user2);
			List<User> result = this.userRepo.saveAll(users);

			result.forEach(r -> 
				logger.log(Level.INFO, "{0}. Criado com sucesso!", r)
			);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
