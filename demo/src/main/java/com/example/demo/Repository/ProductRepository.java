package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<List<Product>> findByProductBrand(String productBrand);
    Optional<List<Product>> findByCertification(String certification);

    //Technical Detail
    Optional<List<Product>> findByTechnicalDetailAirflowBetween(Integer para1, Integer para2);
    Optional<List<Product>> findByTechnicalDetailPowerBetween(Integer para1, Integer para2);
    Optional<List<Product>> findByTechnicalDetailOperatingVoltageBetween(Integer para1, Integer para2);
    Optional<List<Product>> findByTechnicalDetailFanSpeedBetween(Integer para1, Integer para2);

    //Description
    Optional<List<Product>> findByDescriptionManufacturer(String manufacturer);
    Optional<List<Product>> findByDescriptionSeries(String series);
    Optional<List<Product>> findByDescriptionModel(String model);

    //Product Type
    Optional<List<Product>> findByProductTypeType(String type);
    Optional<List<Product>> findByProductTypeApplication(String app);
    Optional<List<Product>> findByProductTypeMountingLocation(String location);
    Optional<List<Product>> findByProductTypeAccessories(String accs);
    Optional<List<Product>> findByProductTypeModelYearBetween(Integer para1, Integer para2);
}