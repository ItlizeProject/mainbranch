package com.example.demo.Service.Impl;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Test
    void createProduct() {
        Product productA = new Product();
        productA.setProductBrand("brandA");
        System.out.println(productA);
        productService.createProduct(productA);
        Assertions.assertEquals("brandA",productA.getProductBrand());
    }


    @Test
    void findAllProduct() {
    }

    @Test
    void findProductById() {
    }

    @Test
    void findProductByProductBrand() {
    }

    @Test
    void findProductByCertification() {
    }

    @Test
    void deleteProductById() {
    }
}