package com.deconatura.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deconatura.app.model.Address;
import com.deconatura.app.service.IAddressService;

@RestController
@RequestMapping("api/addresses")
public class AddressController {
	
	@Autowired
	IAddressService addressService;
	
	@GetMapping 
	public List<Address> getAllAddresses(){
		return addressService.getAllAddresses();		
	}
	
	@GetMapping("{id}") 
	public ResponseEntity<?> getAddressById(@PathVariable("id") int idAddress) {
		try {
			return new ResponseEntity<Address>(
					addressService.getAddressById(idAddress), 
					HttpStatus.OK);													
		} catch (IllegalStateException e) {
			return new ResponseEntity<String>(e.getMessage() , HttpStatus.NOT_FOUND );
		}
	}
	
	@PostMapping("addresses")
    public ResponseEntity<?> setNewAddress(@RequestBody Address address) {
        try {
            return new ResponseEntity<Address>(
                    addressService.setAddress(address),
                    HttpStatus.CREATED);

        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST );
        }
	}
}
