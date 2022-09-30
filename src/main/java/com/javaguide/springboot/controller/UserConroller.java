package com.javaguide.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguide.springboot.entity.User;
import com.javaguide.springboot.exception.ResourceNotFoundException;
import com.javaguide.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserConroller {
	
	@Autowired
	private UserRepository userRepository;
	
	// get all users api
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	//get user by id

  	@GetMapping("/{id}")	
	public User getUserById(@PathVariable(value="id")long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id:"+userId));
	}
	
	
	//create user
	//update user
	// delete by user id

}
