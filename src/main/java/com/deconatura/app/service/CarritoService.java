package com.deconatura.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deconatura.app.model.Carrito;
import com.deconatura.app.repository.ICarritoRepository;

public class CarritoService implements ICarritoService{

    @Autowired
    ICarritoRepository carritoRepository;

    @Override
    public List<Carrito> findAll() {
        List<Carrito> allCarritos = carritoRepository.findAll(); 
        return allCarritos;
    }

    @Override
    public Carrito getCarritoById(int idCarrito) {
        return carritoRepository.findById(idCarrito);
    }

    @Override
    public Carrito setCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito updateCarrito(Carrito address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCarrito'");
    }

    @Override
    public String deleteCarritoById(int idAddress) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCarritoById'");
    }

    @Override
    public List<Carrito> getAllProductsByFkProducId(long userId) {
        return carritoRepository.findAllByFkCarritoIdCarritoId(userId);
    }
    
}
