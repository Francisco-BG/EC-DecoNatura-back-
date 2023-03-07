package com.deconatura.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.deconatura.app.model.Address;

public interface IAddressRepository extends CrudRepository<Address,Integer>{
	List<Address> findAllByFkUserIdUserId(long userId);
}
