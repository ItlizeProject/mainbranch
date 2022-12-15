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
        description.setManufacturer("testManufacturer3");
        description.setModel("testModel3");
        description.setSeries("series3");
        System.out.println(description.toString());
        descriptionService.createDescription(description);//database save the description object and create a tuple in db
        Assertions.assertEquals(descriptionService.findDescriptionByDescriptionId(19).getManufacturer(), description.getManufacturer());
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
        List<Description> res = descriptionService.findAll();
//        System.out.println(res.toString());
        Assertions.assertEquals("[Description{descriptionId=2, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=3, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=4, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=5, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=6, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=7, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=8, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=9, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=10, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=11, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=12, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=13, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=14, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=15, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=16, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=17, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}, " +
                "Description{descriptionId=18, manufacturer='testManufacturer2', series='null', model='testModel2', product=null}, " +
                "Description{descriptionId=19, manufacturer='testManufacturer3', series='series3', model='testModel3', product=null}]", res.toString());


    }

    @Test
    void deleteDescriptionByDescriptionId() {//test it
        descriptionService.deleteDescriptionByDescriptionId(3);
        System.out.println("The line with id =" + 3 + "has been removed");

    }

    @Test
    void findDescriptionByManufacturer() {
        List<Description> list = descriptionService.findDescriptionByManufacturer("testManufacturer3");
        System.out.println(list.toString());
        Assertions.assertEquals("[Description{descriptionId=19, manufacturer='testManufacturer3', series='series3', model='testModel3', product=null}]", list.toString());
    }

    @Test
    void findDescriptionBySeries() {
        List<Description> list = descriptionService.findDescriptionBySeries("series3");
        System.out.println(list.toString());
        Assertions.assertEquals("[Description{descriptionId=19, manufacturer='testManufacturer3', series='series3', model='testModel3', product=null}]", list.toString());
    }

    @Test
    void findDescriptionByModel() {
        List<Description> list = descriptionService.findDescriptionByModel("testModel3");
        System.out.println(list.toString());
        Assertions.assertEquals("[Description{descriptionId=19, manufacturer='testManufacturer3', series='series3', model='testModel3', product=null}]", list.toString());
    }
}