package com.deconatura.app.service;

import com.deconatura.app.model.Product;

import java.util.List;


public interface IProductService {

    List<Product> findAll();

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    Product saveProduct(Product product);

    int deleteProductById(int productId);

    Boolean productExistsById(int id);

    Product getProductById(int id);

}
