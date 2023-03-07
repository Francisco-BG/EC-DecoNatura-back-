package com.deconatura.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

	public static final int FIELD_MAX_LENGTH = 160;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idAddress;

    @Column( nullable = false)
    private String street;

    @Column( nullable = false)
    private String number;

    @Column( nullable = false)
    private String zipCode;

    @Column( nullable = false)
    private String state;

    @Column( nullable = false)
    private String city;


    @ManyToOne
    @JoinColumn(name="fk_user_id")
    private User fkUserId;

    public Address() {}
    

	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public User getFkUserId() {
		return fkUserId;
	}


	public int getIdAddress() {
		return idAddress;
	}
	    
    
}
