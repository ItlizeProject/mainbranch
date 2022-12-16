package com.example.demo.Service;

import com.example.demo.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> findAllProduct();
    Product findProductById(Integer id);
    List<Product> findProductByProductBrand(String brand);
    List<Product> findByCertification(String certification);
    String deleteProductById(Integer id);

}