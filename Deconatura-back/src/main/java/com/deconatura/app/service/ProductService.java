package com.deconatura.app.service;

import com.deconatura.app.model.Product;
import com.deconatura.app.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;
    
    
    @Override
    public List<Product> getAllProducts() {
    	List<Product> allProducts = productRepository.findAll();
    	return allProducts;
    }
    
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean productExistsById(int id) {
		return productRepository.existsById(id);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public Product setProduct(Product product) {
		return productRepository.save(product);
	}


	@Override
	public Product updateProduct(Product newProduct) {
		Product product = getProductById(newProduct.getId());
		product.setCategoria(newProduct.getCategoria());
		product.setImagen(newProduct.getImagen());
		product.setPrecio(newProduct.getPrecio());
		product.setProducto(newProduct.getProducto());
		product.setStock(newProduct.getStock());
		product.setSubcategoria(newProduct.getSubcategoria());
		return productRepository.save(product);
	}

	@Override
	public int deleteProductById(int productId) {
		Product product = getProductById(productId);
		productRepository.delete(product);
		return productId;
	}


}
