package com.example.demo.Service;

import com.example.demo.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> findAllProduct();
    Product findProductById(Integer id);
    Optional<Product> findProductByProductBrand(String brand);
    Optional<Product> findProductByCertification(String certification);
    void deleteProductById(Integer id);

}
