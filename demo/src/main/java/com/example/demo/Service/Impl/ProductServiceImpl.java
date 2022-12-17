package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findProductByProductBrand(String brand) {
        return (List<Product>) productRepository.findByProductBrand(brand).orElse(null);
    }

    @Override
    public List<Product> findByCertification(String certification) {
        return (List<Product>) productRepository.findProductByCertification(certification).orElse(null);
    }

    @Override
    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "Product " + id + " has been deleted.";
    }
}