package com.deconatura.app.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.deconatura.app.model.Carrito;

public interface ICarritoRepository extends CrudRepository<Carrito,Long>{
    List<Carrito> findAll();
    Carrito findById(long ind); 
    List<Carrito> findAllByFkCarritoIdCarritoId(long productoId);
}