package com.example.demo.Service;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProductType;

import java.util.*;

public interface ProductTypeService {
    ProductType createProductType(ProductType productType);

    ProductType findProductTypeByProductTypeId(Integer id);

    ProductType findProductTypeByProduct(Product product);

    List<ProductType> findAll();

    String deleteProductTypeByProductTypeId(Integer id);

    List<ProductType> findProductTypeByApplication(String application);

    List<ProductType> findProductTypeByType(String type);

    List<ProductType> findProductTypeByMountingLocation(String mountingLocation);

    List<ProductType> findProductTypeByAccessories(String accessories);

    List<ProductType> findProductTypeByModelYear(Integer modelYear);

}