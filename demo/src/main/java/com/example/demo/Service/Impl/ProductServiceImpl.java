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
    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "Product " + id + " has been deleted.";
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
        return productRepository.findByProductBrand(brand).orElse(null);
    }

    @Override
    public List<Product> findByCertification(String certification) {
        return productRepository.findByCertification(certification).orElse(null);
    }

    @Override
    public List<Product> findByTechnicalDetailAirflowBetween(Integer para1, Integer para2) {
        return productRepository.findByTechnicalDetailAirflowBetween(para1, para2).orElse(null);
    }

    @Override
    public List<Product> findByTechnicalDetailPowerBetween(Integer para1, Integer para2) {
        return productRepository.findByTechnicalDetailPowerBetween(para1, para2).orElse(null);
    }

    @Override
    public List<Product> findByTechnicalDetailOperatingVoltageBetween(Integer para1, Integer para2) {
        return productRepository.findByTechnicalDetailOperatingVoltageBetween(para1, para2).orElse(null);
    }

    @Override
    public List<Product> findByTechnicalDetailFanSpeedBetween(Integer para1, Integer para2) {
        return productRepository.findByTechnicalDetailFanSpeedBetween(para1, para2).orElse(null);
    }

    @Override
    public List<Product> findByDescriptionManufacturer(String manufacturer) {
        return productRepository.findByDescriptionManufacturer(manufacturer).orElse(null);
    }

    @Override
    public List<Product> findByDescriptionSeries(String series) {
        return productRepository.findByDescriptionSeries(series).orElse(null);
    }

    @Override
    public List<Product> findByDescriptionModel(String model) {
        return productRepository.findByDescriptionModel(model).orElse(null);
    }

    @Override
    public List<Product> findByProductTypeType(String type) {
        return productRepository.findByProductTypeType(type).orElse(null);
    }

    @Override
    public List<Product> findByProductTypeApplication(String app) {
        return productRepository.findByProductTypeApplication(app).orElse(null);
    }

    @Override
    public List<Product> findByProductTypeMountingLocation(String location) {
        return productRepository.findByProductTypeMountingLocation(location).orElse(null);
    }

    @Override
    public List<Product> findByProductTypeAccessories(String accs) {
        return productRepository.findByProductTypeAccessories(accs).orElse(null);
    }

    @Override
    public List<Product> findByProductTypeModelYearBetween(Integer para1, Integer para2) {
        return productRepository.findByProductTypeModelYearBetween(para1, para2).orElse(null);
    }


}