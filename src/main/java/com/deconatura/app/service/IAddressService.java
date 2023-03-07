package com.deconatura.app.service;

import java.util.List;

import com.deconatura.app.model.Address;

public interface IAddressService {

	public List<Address> getAllAddresses();
	
	public Address getAddressById(int idAddress);
	
	public Address setAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public String deleteAddressById(int idAddress);

	List<Address> getAllAddressesByFkUserId1(long userId);
}
