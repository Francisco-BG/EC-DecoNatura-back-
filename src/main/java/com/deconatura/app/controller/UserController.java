package com.deconatura.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deconatura.app.model.User;
import com.deconatura.app.service.IUserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("{id}")
	public User getUserById(@PathVariable("id") long userId) {
		return userService.getUserById(userId);
	} 
	
	@PostMapping()
	public String setUser(@RequestBody User user) {
		System.out.println("recibí " + user);
		return userService.setUser(user); 
	}
}