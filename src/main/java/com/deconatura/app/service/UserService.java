package com.deconatura.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deconatura.app.model.User;
import com.deconatura.app.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	
	
	@Autowired
	IUserRepository userRepository;	
	
	@Override
	public User getUserById(long user_id) {
		// TODO Auto-generated method stub
		return userRepository.findById(user_id);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByName(name);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User getUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return userRepository.findByPhone(phone);
	}

	/*@Override
	public User setUser(User user) {
		
		userRepository.save(user);
		// 
		return "Usuario guardado con éxito.";
	}*/
	public User setUser(User user) {
        /*if ( existUserByEmail(user.getEmail() ) )
            throw new IllegalStateException("The user already exists with email: " + usuario.getEmail());
        else if ( usuario.getEmail().length() > 150 )
            throw new IllegalStateException("Email length is greater than: " + 150);*/

        return userRepository.save(user);
	}
}
