package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductBrand(String productBrand);
    Optional<Product> findProductByCertification(String certification);
}