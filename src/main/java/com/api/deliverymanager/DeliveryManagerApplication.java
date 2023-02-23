package com.api.deliverymanager;

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

import com.api.deliverymanager.models.Company;
import com.api.deliverymanager.models.Employee;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.CompanyRepository;
import com.api.deliverymanager.repositories.EmployeeRepository;
import com.api.deliverymanager.repositories.UserRepository;
import com.api.deliverymanager.utils.Constant;

@SpringBootApplication
public class DeliveryManagerApplication implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
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

			User adm = new User();
			adm.setName("Administrador");
			adm.setEmail("adm@gmail.com");
			adm.setStatus(true);
			adm.setPassword(passwordEncoder.encode("123"));
			adm.setRoles(List.of(Constant.ROLE_ADM, Constant.ROLE_EMPLOYEE, Constant.ROLE_COMPANY));
			
			var ad = userRepo.saveAndFlush(adm);
			logger.log(Level.INFO, "{0}. Criado com sucesso!", ad);
			
			Company company = new Company();
			company.setPhone("88992968500");
			company.setCnpj("83336461000167");
			company.setName("Empresa");
			company.setEmail("empresa@gmail.com");
			company.setStatus(true);
			company.setPassword(passwordEncoder.encode("123"));
			company.setRoles(List.of(Constant.ROLE_COMPANY));
			
			var comp = companyRepo.saveAndFlush(company);
			logger.log(Level.INFO, "{0}. Criado com sucesso!", comp);
			
			Employee employee = new Employee();
			employee.setPhone("88996968596");
			employee.setCpf("56024378009");
			employee.setName("Funcionário");
			employee.setEmail("user@gmail.com");
			employee.setStatus(true);
			employee.setPassword(passwordEncoder.encode("123"));
			employee.setRoles(List.of(Constant.ROLE_EMPLOYEE));
			
			var emp = employeeRepo.saveAndFlush(employee);
			logger.log(Level.INFO, "{0}. Criado com sucesso!", emp);
			
			
//			List<User> users = List.of(user1, user3);
//			List<User> result = userRepo.saveAll(users);

//			result.forEach(r -> 
//				logger.log(Level.INFO, "{0}. Criado com sucesso!", r)
//			);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
