package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Product> findProductByProductBrand(String brand) {
        return productRepository.findProductByProductBrand(brand);
    }

    @Override
    public Optional<Product> findProductByCertification(String certification) {
        return productRepository.findProductByProductBrand(certification);
    }

    @Override
    public String deleteProductById(Long id) {
        productRepository.deleteById(id);
        return id + "has been deleted";
    }
}
