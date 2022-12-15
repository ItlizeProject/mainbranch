package com.example.demo.Service;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;

import java.util.*;
public interface DescriptionService {
    //abstract methods
    Description createDescription(Description description);

    Description findDescriptionByDescriptionId(Integer id);

    Description findDescriptionByProductId(Integer id);

    List<Description> findAll();

    String deleteDescriptionByDescriptionId(Integer id);


    List<Description> findDescriptionByManufacturer(String manufacturer);

    List<Description> findDescriptionBySeries(String series);
    List<Description> findDescriptionByModel(String model);






}