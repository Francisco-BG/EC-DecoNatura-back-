package com.deconatura.app.service;

import com.deconatura.app.model.User;


public interface IUserService {
	
	public User getUserById(long id);
	public User getUserByName(String name);
	public User getUserByEmail(String email);
	public User getUserByPhone(String phone);
	public User setUser(User user);
	//public String setUser(User user);
}
