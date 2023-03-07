package com.deconatura.app.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity

public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nombre;

	
	@Column(nullable = false)
	private String imagen;

	@Column(nullable = false)
	private String categoria;

	@Column(nullable = false)
	private String subcategoria;

	@Column(nullable = false)
	private int precio;
	
	@Column(nullable = false)
	private int stock;

	@ManyToMany(mappedBy = "product")
	private List<Carrito> carritos = new ArrayList<>();

	public Product() {}

	public String getProducto() {
		return nombre;
	}

	public void setProducto(String producto) {
		this.nombre = producto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}
	
}