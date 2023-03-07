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

import com.deconatura.app.model.Carrito;
import com.deconatura.app.service.ICarritoService;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {
    @Autowired
    ICarritoService carritoService;

    @GetMapping
    public List<Carrito> getAllCarritos(){
        return carritoService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCarritoById(@PathVariable("id") int idCarrito){
        try {
            return new ResponseEntity<Carrito>(carritoService.getCarritoById(idCarrito),
             HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> setCarrito(@RequestBody Carrito carrito){
        try {
            return new ResponseEntity<Carrito>(
                carritoService.setCarrito(carrito),
             HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
