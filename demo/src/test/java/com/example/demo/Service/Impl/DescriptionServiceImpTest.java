package com.example.demo.Service.Impl;

import com.example.demo.Entity.Description;
import com.example.demo.Service.DescriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class DescriptionServiceImpTest {


    @Autowired
    private DescriptionService descriptionService;

    @Test
    void createDescription() {

        Description description = new Description();

        description.setManufacturer("testManufacturer1");
        description.setModel("testModel1");
        System.out.println(description);
        descriptionService.createDescription(description);
        Assertions.assertEquals("testManufacturer1",description.getManufacturer());
    }

    @Test
    void save() {
    }

    @Test
    void findDescriptionByDescriptionId() {
    }

    @Test
    void findDescriptionByProductId() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteDescriptionByDescriptionId() {
    }

    @Test
    void findDescriptionByManufacturer() {
    }

    @Test
    void findDescriptionBySeries() {
    }

    @Test
    void findDescriptionByModel() {
    }
}