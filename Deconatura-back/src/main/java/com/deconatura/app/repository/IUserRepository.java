package com.deconatura.app.repository;

import org.springframework.data.repository.CrudRepository;
import com.deconatura.app.entity.User;

public interface IUserRepository extends CrudRepository<User,Long>{
	
	User findById(long id);
	User findByName(String name);
	User findByEmail(String email);
	User findByPhone(String phone);
	
}
