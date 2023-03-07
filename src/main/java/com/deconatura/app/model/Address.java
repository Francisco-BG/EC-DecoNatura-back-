package com.deconatura.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="envio")
public class Address {

	public static final int FIELD_MAX_LENGTH = 160;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idAddress;
	
    @Column(name="direccion", nullable = false)
    private String address;

    @Column(name="codio_postal", nullable = false)
    private String zipCode;
    
    @Column(name="estado", nullable = false)
    private String state;

    @Column(name="municipio", nullable = false)
    private String municipio;

    @Column(name="precio_envio", nullable = false)
    private Integer precio;

    @ManyToOne
    @JoinColumn(name="fk_user_id")
    private User fkUserId;

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public User getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(User fkUserId) {
		this.fkUserId = fkUserId;
	}
    
}
