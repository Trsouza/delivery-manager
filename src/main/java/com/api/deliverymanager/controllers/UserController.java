package com.api.deliverymanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.deliverymanager.dtos.UserDTO;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.security.CheckSecurity;
import com.api.deliverymanager.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	@CheckSecurity.CanAccessOnlyAuthorityAdministrator
	@GetMapping
	public @ResponseBody List<UserDTO> findAllUsers() {
		return service.findAll();
	}
	
//  @PostMapping
//  public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO user){
////      if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
////          return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
////      }
////      if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
////          return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
////      }
////      if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
////          return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
////      }
//      //var parkingSpotModel = new ParkingSpotModel();
//      //BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
//      //parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
//      return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
//  }
  
	@CheckSecurity.CanAccessOnlyAuthorityAdministrator
	@GetMapping("/pageable")
	public ResponseEntity<Page<User>> findAllUsersPaged(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllUsersPaged(pageable));
	}
}