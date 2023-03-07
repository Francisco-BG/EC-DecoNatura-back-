package com.deconatura.app.service;

import java.util.List;

import com.deconatura.app.model.Address;

public interface IAddressService {

	public List<Address> getAllAddresses();
	
	public Address setAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public String deleteAddressById(int idAddress);

	public Address getAddressById(int idAddress);
	
	//public List<Address> getAllAddressesByFkUserId(int userId);
}
