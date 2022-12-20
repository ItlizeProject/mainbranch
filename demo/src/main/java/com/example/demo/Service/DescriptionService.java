package com.example.demo.Service;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;

import java.util.*;

//Service Layer
public interface DescriptionService {
    //abstract methods
    Description createDescription(Description description);

    Description findDescriptionByDescriptionId(Integer id);

    Description findDescriptionByProduct(Product product);

    List<Description> findAll();

    String deleteDescriptionByDescriptionId(Integer id);


    List<Description> findDescriptionByManufacturer(String manufacturer);

    List<Description> findDescriptionBySeries(String series);
    List<Description> findDescriptionByModel(String model);






}
