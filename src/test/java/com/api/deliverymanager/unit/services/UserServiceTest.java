package com.api.deliverymanager.unit.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.deliverymanager.dtos.UserDTO;
import com.api.deliverymanager.mapper.UserMapper;
import com.api.deliverymanager.models.User;
import com.api.deliverymanager.repositories.UserRepository;
import com.api.deliverymanager.services.UserServiceImpl;

@Tag("unitTest")
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@InjectMocks // cria uma instância da classe e injeta nela os mocks marcados com as anotações @mock
	private UserServiceImpl service;	
	
    @Mock // cria uma implementação simulada para as classes que você precisa
    private UserRepository repository;
    
    @Mock
    private UserMapper userMapper;
    
    @Test
    void findAllTest() {
    	// Given
        List<User> userList = new ArrayList<>();
        var user = new User(1L, "John", "j@gmail.com", null, null, null);
        userList.add(user);
        
        List<UserDTO> expectedUserList = new ArrayList<>();
        var userDTO = new UserDTO(1L, "John", "j@gmail.com", null);
        expectedUserList.add(userDTO);

        // When
        when(repository.findAll()).thenReturn(userList);
        when(userMapper.modelToDTO(user)).thenReturn(userDTO);
        List<UserDTO> result = service.findAll();

        // Then      
        assertAll(
                () -> verify(repository).findAll(),
                () -> assertEquals(1, result.size()),
                () -> assertEquals("John", result.get(0).getName())
                
        );
    }
    
    @Test
    void findUserByEmailTest() {
    	var email = "j@gmail.com";
    	// Given
        var user = new User(1L, "John", email, null, null, null);
          
        // When
        when(repository.findUserByEmail(email)).thenReturn(user);
        User result = service.findUserByEmail(email);

        // Then      
        assertAll(
                () -> verify(repository).findUserByEmail(email),
                () -> assertEquals("John", result.getName())
                
        );
    }

}
