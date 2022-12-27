package com.example.demo.Service.Impl;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;
    @Test
    void createProduct() {
        Product productA = new Product();
        productA.setProductBrand("brandA");
        productService.createProduct(productA);

        Assertions.assertEquals("brandA",productA.getProductBrand());
    }

    @Test
    void findAllProduct() {
        Product productB = new Product("brandB", "cerB");
        productService.createProduct(productB);
        Product productC = new Product("brandC", "cerC");
        productService.createProduct(productC);
        Product productD = new Product("brandD", "cerD");
        productService.createProduct(productD);
        List<Product> productList= new ArrayList<>();
        productList.add(productB);
        productList.add(productC);
        productList.add(productD);

        Assertions.assertEquals(productList, productService.findAllProduct());
    }

    @Test
    void findProductById() {
        Product productE = new Product("brandE", "cerE");
        productService.createProduct(productE);
        Assertions.assertEquals(productE.getCertification(), productService.findProductById(1).getCertification());
    }

    @Test
    void findProductByProductBrand() {
        Product productF =  new Product("brandF", "cerF");
        Product productG =  new Product("brandF", "cerG");
        productService.createProduct(productF);
        productService.createProduct(productG);
        List<Product> productList = new ArrayList<>();
        productList.add(productG);
        productList.add(productF);
        Assertions.assertEquals(productList, productService.findProductByProductBrand("brandF"));
    }

    @Test
    void findProductByCertification() {
        Product productH =  new Product("brandH", "cerH");
        productService.createProduct(productH);
        Assertions.assertEquals(productH, productService.findByCertification("cerH"));
    }

    @Test
    void deleteProductById() {
        Product productI = new Product("brandI", "cerI" );
        productService.createProduct(productI);
        productService.deleteProductById(1);
        Assertions.assertNull(productService.findProductById(1));
    }
}