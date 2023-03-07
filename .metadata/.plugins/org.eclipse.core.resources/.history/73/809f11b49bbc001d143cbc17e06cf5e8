package com.deconatura.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deconatura.app.model.Address;
import com.deconatura.app.repository.IAddressRepository;

@Service
public class AddressService implements IAddressService{
	
	@Autowired
	IAddressRepository addressRepository;

	@Override
	public List<Address> getAllAddresses() {
		List<Address> allAddresses = (List<Address>) addressRepository.findAll();
		return allAddresses;
	}

	@Override
	public Address setAddress(Address address) {
		
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address newAddress) {
		Address address = getAddressById(newAddress.getIdAddress());
		address.setState( newAddress.getState() );
		address.setCity( newAddress.getCity() );
		address.setStreet( newAddress.getStreet() );
		address.setNumber( newAddress.getNumber() );
		address.setZipCode( newAddress.getZipCode() );
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddressById(int idAddress) {
		Address address = getAddressById( idAddress);
		addressRepository.delete(address);
		return "Se borró la dirección con id: " + idAddress;
	}

	@Override
	public Address getAddressById(int idAddress) {
		return addressRepository.findById(idAddress)
				.orElseThrow( ()-> 
				new IllegalStateException("Address does not exist with id: " + idAddress));
	}

	@Override
	public List<Address> getAllAddressesByFkUserId(int userId) {
		return addressRepository.findAllByFkUserIdUserId(userId);
	}
}
