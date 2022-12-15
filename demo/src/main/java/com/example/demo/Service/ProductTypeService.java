package com.example.demo.Service;

import com.example.demo.Entity.ProductType;

import java.util.*;

public interface ProductTypeService {
    ProductType createProductType(ProductType productType);

    ProductType findProductTypeByProductId(Integer id);

    List<ProductType> findAll(ProductType type);

    String deleteProductTypeByProductTypeId(Integer id);

    List<ProductType> findProductTypeByApplication(String application);

    List<ProductType> findProductTypeByType(String type);

    List<ProductType> findProductTypeByMountingLocation(String mountingLocation);

    List<ProductType> findProductTypeByAccessories(String accessories);

    List<ProductType> findProductTypeByModelYear(Date modelYear);

}