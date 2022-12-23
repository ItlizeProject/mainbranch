package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    String deleteProductById(Integer id);
    List<Product> findAllProduct();
    Product findProductById(Integer id);
    List<Product> findProductByProductBrand(String brand);
    List<Product> findByCertification(String certification);

    //Technical Details
    List<Product> findByTechnicalDetailAirflowBetween(Integer para1, Integer para2);
    List<Product> findByTechnicalDetailPowerBetween(Integer para1, Integer para2);
    List<Product> findByTechnicalDetailOperatingVoltageBetween(Integer para1, Integer para2);
    List<Product> findByTechnicalDetailFanSpeedBetween(Integer para1, Integer para2);

    //Description
    List<Product> findByDescriptionManufacturer(String manufacturer);
    List<Product> findByDescriptionSeries(String series);
    List<Product> findByDescriptionModel(String model);

    //Product Type
    List<Product> findByProductTypeType(String type);
    List<Product> findByProductTypeApplication(String app);
    List<Product> findByProductTypeMountingLocation(String location);
    List<Product> findByProductTypeAccessories(String accs);
    List<Product> findByProductTypeModelYearBetween(Integer para1, Integer para2);
}