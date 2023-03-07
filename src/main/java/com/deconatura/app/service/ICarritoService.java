package com.deconatura.app.service;

import java.util.List;

import com.deconatura.app.model.Carrito;

public interface ICarritoService {
    List<Carrito> findAll();

    public Carrito getCarritoById(int idCarrito);
	
	public Carrito setCarrito(Carrito carrito);
	
	public Carrito updateCarrito(Carrito carrito);
	
	public String deleteCarritoById(int idcarrito);

	List<Carrito> getAllProductsByFkProducId(long userId);
}
