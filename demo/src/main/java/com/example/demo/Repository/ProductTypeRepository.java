package com.example.demo.Repository;

import com.example.demo.Entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.*;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    //    Optional<ProductType> findProductTypeByProductTypeId(Integer id);
    //Optional<ProductType> findBy(Integer id);//find by primary key

    Optional<ProductType> findByProduct(Integer id);

    Optional<List<ProductType>> findByApplication(String application);

    Optional<List<ProductType>> findByType(String type);

    Optional<List<ProductType>> findByMountingLocation(String mountingLocation);

    Optional<List<ProductType>> findByAccessories(String accessories);

    Optional<List<ProductType>> findByModelYear(Date modelYear);
}