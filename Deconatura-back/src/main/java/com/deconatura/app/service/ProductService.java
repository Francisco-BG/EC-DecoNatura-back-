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
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product newProduct) {
        if (!productExistsById(newProduct.getProducto()))
            throw new IllegalStateException("The product with id: " + newProduct.getIdProduct() +  " doesn't exist");

        Product product = getProductById(newProduct.getProducto());
        updateProduct(newProduct,product);

        productRepository.save(product);
        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public int deleteProductById(int productId) {
        Product product = getProductById(productId);
        productRepository.deleteById(productId);
        return productId;
    }

}
