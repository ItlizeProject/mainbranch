package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long > {
    Optional<Product> findProductByProductBrand(String productBrand);
    Optional<Product> findProductByCertification(String certification);
}
