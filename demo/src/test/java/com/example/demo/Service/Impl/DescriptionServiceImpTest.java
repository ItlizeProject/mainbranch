package com.example.demo.Service.Impl;

import com.example.demo.Entity.Description;
import com.example.demo.Service.DescriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class DescriptionServiceImpTest {
    @Autowired
    private DescriptionService descriptionService;//Q:why don't use DescriptionServiceImp descriptionServiceImp;? how to name it,object?

    @Test
    void createDescription() {
        Description description = new Description();
        description.setManufacturer("testManufacturer2");
        description.setModel("testModel2");
        System.out.println(description.toString());
        descriptionService.createDescription(description);//database save the description object and create a tuple in db
        Assertions.assertEquals(descriptionService.findDescriptionByDescriptionId(18).getManufacturer(), description.getManufacturer());
    }


    @Test
    void findDescriptionByDescriptionId() {
        Description res = descriptionService.findDescriptionByDescriptionId(1);
        Assertions.assertEquals("Description{descriptionId=1, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}", res.toString());
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
        List<Description> list = descriptionService.findDescriptionByManufacturer("testManufacturer2");
        System.out.println(list.toString());
        Assertions.assertEquals("[Description{descriptionId=18, manufacturer='testManufacturer2', series='null', model='testModel2', product=null}]", list.toString());
    }

    @Test
    void findDescriptionBySeries() {
    }

    @Test
    void findDescriptionByModel() {
    }
}