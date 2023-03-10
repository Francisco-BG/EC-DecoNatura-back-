package com.deconatura.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable("id") long userId) {
		return userService.getUserById(userId);
	} 
	
	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable("email") String email){
		return userService.getUserByEmail(email);
	}

	/*@PostMapping()
	public String setUser(@RequestBody User user) {
		System.out.println("recibí " + user);
		return "0"; 
	}*/
	
	@PostMapping()
    public ResponseEntity<?> setNewUser(@RequestBody User user) {
        try {
        	System.out.println(user+" guardado.");
            return new ResponseEntity<User>(
                    userService.setUser(user),
                    HttpStatus.CREATED);

        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST );
        }
	}
}
