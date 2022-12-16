package com.example.demo.Service.Impl;
//modified by Victoria
import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProductType;
import com.example.demo.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.ProductTypeRepository;

import java.util.*;

@Service
public class ProductTypeServiceImp implements ProductTypeService {

    @Autowired
    private ProductTypeRepository repository;

    @Override
    public ProductType createProductType(ProductType productType) {//我自己定义的接口里的abstract method
        return repository.save(productType);//我在repository里让jpa帮忙实现的method
    }

    @Override
    public ProductType findProductTypeByProductTypeId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProductType findProductTypeByProduct(Product product) {
        return repository.findByProduct(product).orElse(null);
    }

    @Override
    public List<ProductType> findAll() {
        return repository.findAll();
    }

    @Override
    public String deleteProductTypeByProductTypeId(Integer id) {
        repository.deleteById(id);
        return id.toString();
    }

    //find by Application, Type, Accessories, ModelYear
    @Override
    public List<ProductType> findProductTypeByApplication(String application) {
        return repository.findByApplication(application).orElse(null);
    }

    @Override
    public List<ProductType> findProductTypeByType(String type) {
        return repository.findByType(type).orElse(null);
    }

    @Override
    public List<ProductType> findProductTypeByMountingLocation(String mountingLocation) {
        return repository.findByMountingLocation(mountingLocation).orElse(null);
    }

    @Override
    public List<ProductType> findProductTypeByAccessories(String accessories) {
        return repository.findByAccessories(accessories).orElse(null);
    }

    @Override
    public List<ProductType> findProductTypeByModelYear(Integer modelYear) {//Date
        return repository.findByModelYear(modelYear).orElse(null);
    }
}