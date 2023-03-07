package com.deconatura.app.controller;

import com.deconatura.app.model.Product;
import com.deconatura.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    IProductService productService;


    @GetMapping("/catalogo") //localhost:8080/catalogo
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    
    @PostMapping("/catalogo")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);

    }

    @PutMapping("/catalogo")
    public Product updateProduct(@RequestBody Product newDataProduct){
        return productService.updateProduct(newDataProduct);
    }

    //Delete mapping
    @DeleteMapping("/catalogo/{productId}")
    public ResponseEntity<?> deleteProductoById(@PathVariable("productId") int productId){
        try {
            return new ResponseEntity<Integer>(
                    productService.deleteProductById(productId),
                    HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage() , HttpStatus.NOT_FOUND );
        }
    }

}
